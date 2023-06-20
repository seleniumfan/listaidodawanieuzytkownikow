package org.seleniumfan.listidodawanieuzytkownikow;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>(List.of(
            new User("Tadeusz", "Nalepa", 33),
            new User("Adam", "Nowak", 17),
            new User("Marzena", "Rogalska", 50)
    ));

    public void addUser(User user) {
        userList.add(user);
    }

    public void addUsers(List<User> list) {
        userList.addAll(list);
    }

    public List<User> getUsers() {
        return userList;
    }
}
