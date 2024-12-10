package com.evela.auth_service.service;

import com.evela.auth_service.model.Menu;
import com.evela.common_service.service.ICRUD;

import java.util.List;

public interface IMenuService extends ICRUD<Menu, Long>  {

    List<Menu> getMenuByUsername(String usermenu) throws Exception;
}
