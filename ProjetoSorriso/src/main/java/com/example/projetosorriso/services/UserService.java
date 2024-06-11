package com.example.projetosorriso.services;

import com.example.projetosorriso.dao.UserDao;
import com.example.projetosorriso.db.DB;
import com.example.projetosorriso.exception.InvalidPasswordException;
import com.example.projetosorriso.models.User;

public class UserService {
    private final UserDao userDao = new UserDao(DB.getConnection());

    public void create(User user) {
        if(user.getPassword().length() < 6) {
            throw new InvalidPasswordException("O Password deve conter pelo menos 6 caracteres.");
        }
        userDao.insert(user);
    }
}
