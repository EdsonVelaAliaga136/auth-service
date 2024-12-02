package com.evela.auth_service.service;

import com.evela.auth_service.dto.UserDTO;
import com.evela.auth_service.model.User;
import com.evela.common_service.service.ICRUD;

public interface IUserService extends ICRUD<User, Long> {

    //UserDTO getUserDTO(User user);

}
