package ru.netology.springBootDemo2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springBootDemo2.model.Authorities;
import ru.netology.springBootDemo2.model.UserData;

import java.util.List;

@Repository
public class UserRepository {

    private final List<UserData> userData = List.of(new UserData("Oleg", "12345", List.of(Authorities.READ, Authorities.WRITE)),
            new UserData("Maks", "54321", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (UserData person : userData) {
            if (user.equals(person.getName()) && password.equals(person.getPassword())) {
                return person.getData();
            }
        }
        return List.of();
    }

}
