package dao;

import model.Role;

public interface RoleDao extends GenericDao<Role,Long> {
    Role findOne(String name);
}
