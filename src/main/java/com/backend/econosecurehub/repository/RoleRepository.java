package com.backend.econosecurehub.repository;

import com.backend.econosecurehub.domain.Role;
import com.backend.econosecurehub.domain.User;

import java.util.Collection;

public interface RoleRepository <T extends Role> {
    /* Basic CRUD Operations */
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    void addRoleToUser(Long userID, String roleName);
    /* More Complex Operations */
}
