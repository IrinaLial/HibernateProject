package demo;

import dao.GenericDao;
import dao.PriorityDao;
import dao.TodoDao;
import dao.UserDao;
import dao.impl.GenericDaoImpl;
import dao.impl.PriorityDaoImpl;
import dao.impl.TodoDaoImpl;
import dao.impl.UserDaoImpl;
import model.Priority;
import model.Todo;
import model.User;
import util.PriorityUtil;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateDemo {

    public static void main(String[] args) {

        start();

//        GenericDao genericDao = new GenericDaoImpl();

//        final Todo todo = new Todo();
//        todo.setUsers(new HashSet<>(Collections.singletonList(user)));
//        todo.setName("Hello");
//        Set<Todo> todos = new HashSet<>();
//        todos.add(todo);
//        todo.setPriorities(new HashSet<>(Collections.singletonList(new Priority(1L, "sefwf4w", todos))));
//
//        genericDao.save(todo);

    }

    private static void start() {
//
////        RoleDao roleDao = new RoleDaoImpl();
////        Role role = roleDao.findOne(RoleUtil.ADMIN);
////
////        User user = new User();
////        user.setRole(role);
////        user.setName("Igor");
////        user.setEmail("joyukr");
////        user.setPassword("goal");
//
        GenericDao genericDao = new GenericDaoImpl();
////        genericDao.save(user);

        UserDao userDao = new UserDaoImpl();
        final List<User> users = userDao.getAll();
        Set<User> userSet = new HashSet<>(users);

        final Todo todo = new Todo();
        todo.setName("Kotlin");
        todo.setStatus("OK");
        todo.setCreationDate(LocalDateTime.now().toString());
        todo.setUsers(userSet);

        PriorityDao priorityDao = new PriorityDaoImpl();
        Priority priority = priorityDao.findOne(PriorityUtil.OK);

        TodoDao todoDao = new TodoDaoImpl();
        final List<Todo> todos = todoDao.getAll();
        Set<Priority > priorities = new HashSet<>();
        todo.setPriorities(priorities);

        //todo.setPriorities(new HashSet<>(Arrays.asList(priority,todoset));
        genericDao.save(todo);
    }

}
