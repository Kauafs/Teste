package com.example.projetosorriso.controllers;

import com.example.projetosorriso.models.Task;
import com.example.projetosorriso.services.TaskService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateTaskController {
    @FXML
    TextField txtTitlle;
    @FXML
    TextField txtDescription;

    TaskService taskService = new TaskService();

    Task task;

    @FXML
    public void SaveButtom (){
        task.setTitle(txtTitlle.getText());
        task.setDescription(txtDescription.getText());
        taskService.update(task);
    }

    public void updateTask(){
        this.txtTitlle.setText(task.getTitle());
        this.txtTitlle.setText(task.getDescription());
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
