package com.evela.auth_service.repository;


import com.evela.auth_service.model.Menu;
import com.evela.common_service.repository.IGenericRepo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMenuRepo extends IGenericRepo<Menu, Long> {

    @Query(value = """
            select mr.* from menu_role mr
            inner join user_role ur on ur.id_role = mr.id_role
            inner join menu m on m.id_menu = mr.id_menu
            inner join user_data u on u.id_user= ur.id_user
            where u.username = :username
            """, nativeQuery = true)
    List<Menu> getMenuByUsername(String usermenu);
}
