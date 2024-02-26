package com.codipster.mchinacommunity.service.imp;

import com.codipster.mchinacommunity.mongodocs.Role;
import com.codipster.mchinacommunity.repository.RoleRepository;
import com.codipster.mchinacommunity.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(String roleName) {
        return roleRepository.save(Role.builder().roleName(roleName).build());
    }

    @Override
    public Role getRole(String roleName) {
        Optional<Role> role = roleRepository.findByRoleName(roleName);
        return role.orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(String roleName) {
        Optional<Role> role = roleRepository.findByRoleName(roleName);
        Role role1 = role.orElse(null);
        if (role1 == null) {
            return null;
        }
        role1.setRoleName(roleName);
        return roleRepository.save(role1);
    }

    @Override
    public void deleteRole(String roleName) {
        Optional<Role> role = roleRepository.findByRoleName(roleName);
        role.ifPresent(roleRepository::delete);
    }
}
