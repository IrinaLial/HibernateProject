package dao;


import model.Priority;

public interface PriorityDao extends GenericDao<Priority,Long> {
    Priority findOne(String name);
}
