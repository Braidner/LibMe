package org.braidner.libme.core.service;

import org.braidner.libme.core.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Braidner
 */
public class BaseService {
    protected User getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication() != null ? (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : null;
    }
}
