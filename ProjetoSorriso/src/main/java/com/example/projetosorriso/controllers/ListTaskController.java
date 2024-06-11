package com.example.projetosorriso.controllers;

import com.example.projetosorriso.MainApplication;
import com.example.projetosorriso.models.Task;
import com.example.projetosorriso.services.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListTaskController implements Initializable {

    private TaskService taskService;
    @FXML
    private TableView<Task> taskTableView;
    @FXML
    private TableColumn<Task, Integer> tableColumnId;
    @FXML
    private TableColumn<Task, String> tableColumnTitle;
    @FXML
    private TableColumn <Task, String> tableColumnDescri;

    private ObservableList<Task> taskObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnDescri.setCellValueFactory(new PropertyValueFactory<>("description"));

    }

    public void updateTask(){
        taskObservableList = FXCollections.observableList(taskService.findAll());
        taskTableView.setItems(taskObservableList);
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void onUpdateTask(){
        Task selectorTask = taskTableView.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("edit-task-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Edit Task ");
            stage.setScene(scene);
            UpdateTaskController updateTaskController = fxmlLoader.getController();
            updateTaskController.setTask(selectorTask);
            updateTaskController.updateTask();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

