package com.klaus.iv.useradmin.converter;

import com.klaus.iv.commonbase.converter.Converter;
import com.klaus.iv.useradmin.po.Address;
import com.klaus.iv.useradmin.po.Address.AddressType;
import com.klaus.iv.userapi.dto.AddressDto;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.function.Function;

public class AddressDtoConverter extends Converter<AddressDto, Address> {
    public AddressDtoConverter() {
        super(new AddressDtoFunction(), new AddressFunction() );
    }

    static class AddressDtoFunction implements Function<AddressDto, Address> {
        @Override
        public Address apply(AddressDto addressDto) {
            // 可定制需要复制的属性
            Address address = new Address();
            BeanUtils.copyProperties(addressDto, address);
            Optional<AddressType> us = AddressType.of(addressDto.getAddressType());
            if (us.isPresent()) {
                address.setType(us.get());
            } else {
                address.setType(AddressType.HOME);
            }
            return address;
        }
    }

    static class AddressFunction implements Function<Address, AddressDto> {
        @Override
        public AddressDto apply(Address address) {
            // 可定制需要复制的属性
            AddressDto userDto = new AddressDto();
            BeanUtils.copyProperties(address, userDto);
            userDto.setAddressType(address.getType().getValue());
            return userDto;
        }
    }

}
