package ru.netology.restdz2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.restdz2.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.netology.restdz2.Authorities.*;

@Repository
public class UserRepository {
    private static Map<String, String> usersREAD = new ConcurrentHashMap<>();
    private static Map<String, String> usersWRITE = new ConcurrentHashMap<>();
    private static Map<String, String> usersDELETE = new ConcurrentHashMap<>();
    List<Authorities> authorities;



    public List<Authorities> getUserAuthorities(String user, String password) {
        authorities = new ArrayList<>();
        if (mapREAD(user, password)) {
            authorities.add(READ);
            return authorities;
        } else if (mapWRITE(user, password)) {
            authorities.add(WRITE);
            return authorities;
        }
        else if (mapDELETE(user, password)) {
            authorities.add(DELETE);
            return authorities;
        }
        return null;
    }

    private static boolean mapREAD(String user, String password) {
        usersREAD.put("Ivan", "12345");
        boolean result = false;
        if (usersREAD.containsKey(user)) {
            if (password.equals(usersREAD.get(user))) {
                result = true;
            }
        }
        return result;
    }

    private static boolean mapWRITE(String user, String password) {
        usersWRITE.put("Koly", "123");
        boolean result = false;
        if (usersWRITE.containsKey(user)) {
            if (password.equals(usersWRITE.get(user))) {
                result = true;
            }
        }
        return result;
    }

    private static boolean mapDELETE(String user, String password) {
        usersDELETE.put("Dasa", "121212");
        boolean result = false;
        if (usersDELETE.containsKey(user)) {
            if (password.equals(usersDELETE.get(user))) {
                result = true;
            }
        }
        return result;
    }
}

