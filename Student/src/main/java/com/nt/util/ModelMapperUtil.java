package com.nt.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    // Convert from source object to target class
    public static <D> D convert(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }


}
