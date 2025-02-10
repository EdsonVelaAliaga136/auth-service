package com.evela.auth_service.service;

import com.evela.auth_service.audit.LoggerUser;
import com.evela.common_service.context.AuditContext;
import com.evela.common_service.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private CommonService commonService;

    public void auditInAuthService(){
        String username = LoggerUser.get();
        AuditContext.setCurrentUser(username);
        try{
            commonService.updateAuditInfo();
        }finally {
            AuditContext.clear();
        }
    }
    /*@Autowired
    private CommonService commonService;

    public void auditInAuthService(Long menuId) {
        String username = LoggedUser.get();
        // Configura el nombre de usuario en el contexto de auditoría
        AuditContext.setCurrentUser(username);
        try {
            // Llama a un método en common_service y pasa el ID de la entidad
            commonService.updateAuditInfo(menuId);
        } finally {
            // Limpia el contexto después de la llamada
            AuditContext.clear();
        }
    }*/
}
