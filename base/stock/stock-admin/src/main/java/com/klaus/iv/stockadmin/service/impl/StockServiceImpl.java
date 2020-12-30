package com.klaus.iv.stockadmin.service.impl;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import com.klaus.iv.commonjpa.service.impl.BaseServiceImpl;
import com.klaus.iv.stockadmin.converter.StockDtoConverter;
import com.klaus.iv.stockadmin.converter.StockVoConverter;
import com.klaus.iv.stockadmin.po.YiStock;
import com.klaus.iv.stockadmin.repo.StockRepo;
import com.klaus.iv.stockadmin.service.StockService;
import com.klaus.iv.stockapi.dto.StockDto;
import com.klaus.iv.stockapi.qo.StockQo;
import com.klaus.iv.stockapi.vo.StockVo;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.klaus.iv.stockadmin.db.tables.StockGroup.STOCK_GROUP;
import static com.klaus.iv.stockadmin.db.tables.YiGroup.YI_GROUP;
import static com.klaus.iv.stockadmin.db.tables.YiStock.YI_STOCK;

@Service
@Slf4j
public class StockServiceImpl extends BaseServiceImpl<YiStock, Long> implements StockService {

    @Autowired
    private StockRepo stockRepo;


    public StockServiceImpl(DSLContext dsl, StockRepo stockRepo) {
        super(dsl, stockRepo);
    }

    @Override
    public  <D extends BaseDto>  void save(D dto) {
        StockDto stockDto = (StockDto) dto;
        if (!stockRepo.existsDistinctByCode(stockDto.getCode())) {
            this.save(new StockDtoConverter().converterFromDto(stockDto));
        }
    }

    @Override
    public Boolean deleteByCode(String code) {
        stockRepo.deleteYiStockByCode(code);
        return true;
    }

    @Override
    public List<StockVo> findByUserIdAndGroupId(Long userId, Long groupId) {
        return this.dsl.select(YI_STOCK.NAME,YI_STOCK.CODE,YI_STOCK.STOCK_DESC).from(YI_STOCK).join(STOCK_GROUP).on(YI_STOCK.CODE.eq(STOCK_GROUP.STOCK_CODE))
                .join(YI_GROUP).on(STOCK_GROUP.GROUP_CODE.eq(YI_GROUP.CODE))
        .fetch()
        .map( i -> i.into(StockVo.class));
    }


    @Override
    public List<StockVo> search(StockQo stockQo) {
        List<YiStock> yiStocks = null;
        if ( !StringUtils.isEmpty(stockQo.getCode())) {
            yiStocks = stockRepo.findYiStocksByCodeLike("%" +stockQo.getCode() + "%");
        } else if ( !StringUtils.isEmpty(stockQo.getName())) {
            yiStocks = stockRepo.findYiStocksByNameLike("%" +stockQo.getName() + "%");
        }
        if (yiStocks != null && !yiStocks.isEmpty()) {
            List<StockVo> contents = yiStocks.stream().map(i -> new StockVoConverter().converterFromEntity(i)).collect(Collectors.toList());
            return contents;
        } else {
            Page<StockVo> page = this.findAllWithPage(PageRequest.of(0, 10));
            return page.getContent();
        }
    }

    @Override
    protected StockVo converterToVo(YiStock yiStock) {
        return new StockVoConverter().converterFromEntity(yiStock);
    }

    @Override
    protected <D extends BaseDto> YiStock converterToEntity(D dto) {
        return new StockDtoConverter().converterFromDto((StockDto) dto);
    }
}
