package ru.netology.demo1.repository;

import org.springframework.stereotype.Repository;
import ru.netology.demo1.model.Authorities;
import ru.netology.demo1.model.User;
import ru.netology.demo1.exception.ExistException;

import java.util.*;

import static ru.netology.demo1.model.Authorities.*;

@Repository
public class UserRepository {
    List<User> users = new ArrayList<>();

    public void userAuthorities(){
        User Ivan = new User("Ivan", "1234", Arrays.asList(READ));
        User Anna = new User("Anna", "1111", Arrays.asList(READ, WRITE));
        User Nikolay = new User("Nikolay", "4321", Arrays.asList(WRITE, DELETE));
        users.add(Ivan); users.add(Anna); users.add(Nikolay);
    }
    public User postUserAuthorities(String user, String password, List<Authorities> auth) {
        for (User person: users) {
            String name = person.getUser();
            String pass = person.getPassword();
            if (user.equals(name) && pass.equals(password)) {
                throw new ExistException("Пользователь уже существует");
            }
        }
        User us = new User(user, password, auth);
        users.add(us);
        return us;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        userAuthorities();
        for (User person : users) {
            String name = person.getUser();
            String pass = person.getPassword();
            List<Authorities> authorities = person.getAuthorities();
            if (user.equals(name) && pass.equals(password)) {
                return authorities;
            }
        }
        return null;
    }
}
