package com.example.projetosorriso.services;

import com.example.projetosorriso.dao.ITaskDao;
import com.example.projetosorriso.dao.TaskDao;
import com.example.projetosorriso.db.DB;
import com.example.projetosorriso.models.Task;

public class CreateTaskService {
    ITaskDao taskDao = new TaskDao(DB.getConnection());
    public void save(Task task){
    taskDao.insert(task);
    }
}
