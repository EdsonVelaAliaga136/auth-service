package com.evela.auth_service.service;

import com.evela.auth_service.dto.UserDTO;
import com.evela.auth_service.model.User;
import com.evela.common_service.service.ICRUD;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface IUserService extends ICRUD<User, Long> {
    User findOneByUsername(String username);
    //UserDTO getUserDTO(User user);
}
