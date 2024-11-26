package com.evela.auth_service.security;

//Clase S2

import com.evela.auth_service.model.Role;
import com.evela.auth_service.model.User;
import com.evela.auth_service.repository.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Clase S2
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    //@Autowired
    private final IUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findOneByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        //String role = user.getRole().getName();
        Set<Role> rolesSet = user.getRoles();
        roles = rolesSet.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
        //roles.add(new SimpleGrantedAuthority(role));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}
