package com.codipster.mchinacommunity.service;

import com.codipster.mchinacommunity.mongodocs.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(String roleName);
    Role getRole(String roleName);
    List<Role> getAllRoles();
    Role updateRole(String roleName);
    void deleteRole(String roleName);

}
