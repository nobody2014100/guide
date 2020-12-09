package com.klaus.iv.useradmin.service.impl;

import com.klaus.iv.commonbase.model.dto.BaseDto;
import com.klaus.iv.commonjpa.service.impl.BaseServiceImpl;
import com.klaus.iv.useradmin.converter.AddressDtoConverter;
import com.klaus.iv.useradmin.converter.AddressVoConverter;
import com.klaus.iv.useradmin.po.Address;
import com.klaus.iv.useradmin.repo.AddressRepo;
import com.klaus.iv.useradmin.service.AddressService;
import com.klaus.iv.userapi.dto.AddressDto;
import com.klaus.iv.userapi.vo.AddressVo;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressServiceImpl extends BaseServiceImpl<Address, Long> implements AddressService{

    public AddressServiceImpl(DSLContext dsl, AddressRepo addressRepo) {
        super(dsl, addressRepo);
    }

    @Override
    public AddressVo converterToVo(Address address) {
        return new AddressVoConverter().converterFromEntity(address);
    }

    @Override
    public <D extends BaseDto> Address converterToEntity(D dto) {
        return new AddressDtoConverter().converterFromDto((AddressDto) dto);
    }
}
