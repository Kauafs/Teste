package com.example.projetosorriso.services;

import com.example.projetosorriso.dao.ITaskDao;
import com.example.projetosorriso.dao.TaskDao;
import com.example.projetosorriso.db.DB;
import com.example.projetosorriso.models.Task;

import java.util.List;

public class TaskService {

    private ITaskDao taskDao;

    public TaskService() {
        this.taskDao = new TaskDao(DB.getConnection());
    }

    public void createTask(Task task){
        if (task.getTitle().length()<3){
            throw new RuntimeException(("O titulo deve ser maior que 3 caractere"));
        }
        taskDao.insert(task);
    }

    public List<Task> findAll(){
        return taskDao.findAll();
    }

    public void update(Task task){
        taskDao.update(task);
    }
}
