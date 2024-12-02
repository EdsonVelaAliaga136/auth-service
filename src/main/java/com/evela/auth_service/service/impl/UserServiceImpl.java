package com.evela.auth_service.service.impl;

import com.evela.auth_service.dto.UserDTO;
import com.evela.auth_service.mapper.UserMapper;
import com.evela.auth_service.model.User;
import com.evela.auth_service.repository.IUserRepo;
import com.evela.auth_service.service.IUserService;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl extends CRUDImpl<User, Long> implements IUserService {
    private UserMapper userMapper;

    private final IUserRepo repo;
    @Override
    protected IGenericRepo<User, Long> getRepo() {
        return repo;
    }

    /*@Override
    public UserDTO getUserDTO(User user) {
        return userMapper.toDTO(user);
    }*/


}
