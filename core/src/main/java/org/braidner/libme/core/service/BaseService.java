package org.braidner.libme.core.service;

import org.braidner.libme.core.model.User;

/**
 * Created by Braidner
 */
public class BaseService {
    protected User getCurrentUser() {
//        return SecurityContextHolder.getContext().getAuthentication() != null ? (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : null;
        return null;
    }
}
