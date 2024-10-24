package ru.netology.restdz2.service;

import org.springframework.stereotype.Service;
import ru.netology.restdz2.Authorities;
import ru.netology.restdz2.advice.InvalidCredentials;
import ru.netology.restdz2.advice.UnauthorizedUser;
import ru.netology.restdz2.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository = new UserRepository();


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
