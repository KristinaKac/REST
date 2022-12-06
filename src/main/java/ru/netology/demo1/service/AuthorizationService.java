package ru.netology.demo1.service;

import org.springframework.stereotype.Service;
import ru.netology.demo1.exception.InvalidCredentials;
import ru.netology.demo1.exception.UnauthorizedUser;
import ru.netology.demo1.model.Authorities;
import ru.netology.demo1.model.User;
import ru.netology.demo1.repository.UserRepository;

import java.util.List;
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User postAuthorities(String user, String password, List<Authorities> auth){
        return userRepository.postUserAuthorities(user, password, auth);
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
