package com.example.projetosorriso.services;

import com.example.projetosorriso.dao.UserDao;
import com.example.projetosorriso.db.DB;
import com.example.projetosorriso.exception.InvalidUserException;

public class LoginService {
    UserDao userDao = new UserDao(DB.getConnection());

    public void login(String username, String password) {
        Boolean authenticated = userDao.findByUsernameAndPassword(username, password);
        if (!authenticated) {
            throw new InvalidUserException("Usuário e/ou senha inválidos!");
        }
    }
}

