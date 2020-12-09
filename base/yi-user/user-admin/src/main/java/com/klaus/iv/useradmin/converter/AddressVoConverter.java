package com.klaus.iv.useradmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.useradmin.po.Address;
import com.klaus.iv.userapi.vo.AddressVo;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public class AddressVoConverter extends Converter<AddressVo, Address> {
    public AddressVoConverter() {
        super(new AddressDtoFunction(), new AddressFunction() );
    }

    static class AddressDtoFunction implements Function<AddressVo, Address> {
        @Override
        public Address apply(AddressVo addressVo) {
            // 可定制需要复制的属性
            Address address = new Address();
            BeanUtils.copyProperties(addressVo, address);
            return address;
        }
    }

    static class AddressFunction implements Function<Address, AddressVo> {
        @Override
        public AddressVo apply(Address address) {
            // 可定制需要复制的属性
            AddressVo addressVo = new AddressVo();
            BeanUtils.copyProperties(address, addressVo);
            return addressVo;
        }
    }

}
