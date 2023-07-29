package com.ceceg.smaffy.Service;

import com.ceceg.smaffy.Model.UsersData;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private static final UsersData[] users = {
            new UsersData("user1@example.com", "password1", "John factory"),
            new UsersData("user2@example.com", "password2", "Jane factory")
    };

    public UsersData authenticate(String userid, String pw) {
        for (UsersData user : users) {
            if (user.getId().equals(userid) && user.getPw().equals(pw)) {
                return user;
            }
        }
        return null; // Return null if authentication fails
    }
}
