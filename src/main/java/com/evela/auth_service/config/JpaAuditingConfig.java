package com.evela.auth_service.config;

import com.evela.common_service.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
//@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class JpaAuditingConfig {
    @Bean
    public AuditorAwareImpl auditorAware(SecurityAuditorProvider securityAuditorProvider){
        return new AuditorAwareImpl(securityAuditorProvider);
    }

}
