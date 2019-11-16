package com.lga.struts2.dao;

import com.lga.struts2.domain.User;

import java.util.Arrays;
import java.util.List;

public class UserDao {
    
    public List<User> getAll(){
        User user1 = new User("lga1",21);
        User user2 = new User("lga2",22);
        User user3 = new User("lga3",23);
        User user4 = new User("lga4",24);
        return Arrays.asList(user1, user2, user3, user4);
    }
}
