package com.example.projetosorriso.controllers;

import com.example.projetosorriso.MainApplication;
import com.example.projetosorriso.models.Task;
import com.example.projetosorriso.services.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {

    private TaskService taskService = new TaskService();

    @FXML
    private TableView<Task> taskTableView;
    @FXML
    private TableColumn<Task, Integer> tableColumnId;
    @FXML
    private TableColumn<Task, Integer> tableColumnTitle;
    @FXML
    private TableColumn<Task, Integer> tableColumnDescription;

    @FXML
    private ObservableList<Task> observableList;

    @FXML
    public void CreateTask(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("create-task-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("New Task");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onMenuItemListTaskAction(){
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ListTaskView.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
            Stage stage = new Stage();
            stage.setTitle("Listar Usuário!");
            stage.setScene(scene);
            ListTaskController controller = fxmlLoader.getController();
            controller.setTaskService(new TaskService());
            controller.updateTask();
            stage.show();
    }

}
