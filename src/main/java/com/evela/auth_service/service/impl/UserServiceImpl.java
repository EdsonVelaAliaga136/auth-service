package com.evela.auth_service.service.impl;

import com.evela.auth_service.exception.UserAlreadyExistsException;
import com.evela.auth_service.mapper.UserMapper;
import com.evela.auth_service.model.User;
import com.evela.auth_service.repository.IUserRepo;
import com.evela.auth_service.service.IUserService;
import com.evela.auth_service.util.PasswordUtils;
import com.evela.common_service.enums.UserStatus;
import com.evela.common_service.repository.IGenericRepo;
import com.evela.common_service.service.impl.CRUDImpl;
import com.evela.common_service.util.LoggerUtils;
import com.evela.common_service.validator.ValidationUtils;
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

    @Override
    public User findOneByUsername(String username) {
        return repo.findOneByUsername(username);
    }

    @Override
    public User registerUser(User user) throws Exception {
        //Verify username and email if this existing
        if (repo.existsByUsername(user.getUsername()) || repo.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException("Username or Email already exists");
        }
        User userCreated = new User();
        String encryptedPassword = PasswordUtils.encodePassword(user.getPassword());
        userCreated.setUsername(user.getUsername());
        userCreated.setPassword(encryptedPassword);
        userCreated.setEmail(user.getEmail());
        userCreated.setActive(true);
        userCreated.setStatus(UserStatus.REGISTERED);
        userCreated.setLocked(false);
        //userCreated.setVersion();
        this.save(userCreated);
        return userCreated;
    }

    @Override
    public User deactivateUser(Long id) throws Exception {
        User user = this.findById(id);
        if(ValidationUtils.isNotNull(user)){
          user.setActive(false);
          user.setStatus(UserStatus.DELETED);
          this.save(user);
            LoggerUtils.logInfo("User with id: " + id + " has been deactivated");
          return user;
        }
        LoggerUtils.logInfo("User with id: " + id + " does not exist");
        return null;
    }

    /*@Override
    public UserDTO getUserDTO(User user) {
        return userMapper.toDTO(user);
    }*/


}
