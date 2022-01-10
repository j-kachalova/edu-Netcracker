package org.example.NC.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, Courier;
    @Override
    public String getAuthority() {
        return name();
    }
}
