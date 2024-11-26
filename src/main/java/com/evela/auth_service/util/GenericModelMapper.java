package com.evela.auth_service.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("gnenericMapper")
@RequiredArgsConstructor
public class GenericModelMapper implements IModelMapper{
  private final ModelMapper modelMapper;

    @Override
    public <D, T> D map(T source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}