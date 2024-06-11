package com.example.projetosorriso.dao;

import com.example.projetosorriso.models.Task;
import com.example.projetosorriso.models.User;

import java.util.List;

public interface ITaskDao {
    void insert(Task task);
    void update(Task task);
    void deleteById(Integer id);

    List<Task> findAll();

}
