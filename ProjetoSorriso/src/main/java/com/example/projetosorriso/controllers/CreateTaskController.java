package com.example.projetosorriso.controllers;

import com.example.projetosorriso.models.Task;
import com.example.projetosorriso.services.CreateTaskService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateTaskController {

    @FXML
    TextField txtTitlle;
    @FXML
    TextField txtDescription;
    CreateTaskService createTaskService = new CreateTaskService();
    @FXML
    public void SaveButtom(){
        Task task = new Task(txtTitlle.getText(),txtDescription.getText());
        createTaskService.save(task);
    }
}
