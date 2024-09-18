
package com.ism.services.Implemente;

import com.ism.entites.User;
import com.ism.repository.List.UserRepository;


import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl {
    private UserRepository UserRepository = new UserRepository();
    private List<User> users = new ArrayList<>();

    public void createUser(User user) {
        users.add(user); 
    }

    public List<User> listUsers() {
        return new ArrayList<>(users); 
    }

    public User findUserByPhone(String phone) {
        return users.stream()
                    .filter(user -> user.getName().equals(phone)) 
                    .findFirst()
                    .orElse(null);
    }
}
