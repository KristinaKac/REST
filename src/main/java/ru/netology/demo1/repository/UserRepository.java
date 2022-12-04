package ru.netology.demo1.repository;

import org.springframework.stereotype.Repository;
import ru.netology.demo1.model.Authorities;
import ru.netology.demo1.model.User;
import ru.netology.demo1.exception.ExistException;

import java.util.*;

import static ru.netology.demo1.model.Authorities.*;

@Repository
public class UserRepository {
    List<Authorities> authorities = Arrays.asList();
    List<User> users = new ArrayList<>();
    public List<User> postUserAuthorities(String user, String password) {
        for (User person: users) {
            String name = person.getUser();
            String pass = person.getPassword();
            if (user.equals(name) && pass.equals(password)) {
                throw new ExistException("Пользователь уже существует");
            }
        }
        users.add(new User(user, password, Arrays.asList(DELETE, READ, WRITE)));
        return users;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (User person : users) {
            String name = person.getUser();
            String pass = person.getPassword();
            List<Authorities> auth = person.getAuthorities();
            if (user.equals(name) && pass.equals(password)) {
                authorities = auth;
                return auth;
            }
        }
        return authorities;
    }
}
