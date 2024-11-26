package com.evela.auth_service.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperUtil {

    private final IModelMapper modelMapper;
   public <D, T> D convertToDTO(T entity, Class<D> dtoClass){
        return modelMapper.map(entity, dtoClass);
    }

    public <D, T> T convertToEntity(D dto, Class<T> entityClass){
        return modelMapper.map(dto, entityClass);
    }
}