package ru.netology.demo1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {
    List<Authorities> authorities = new ArrayList<>();
    HashMap<String, String> users = new HashMap<>();


    public List<Authorities> getUserAuthorities(String user, String password) {
        users.put("admin1", "1234");
        users.put("admin2", "12345");
        users.put("guest1", "12346");
        users.put("guest2", "12347");
        if (users.containsKey(user) && users.containsValue(password)){
            authorities.add(Authorities.DELETE);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.READ);
        } else {
            return authorities;
        }

        return authorities;
    }
}
