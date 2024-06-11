package com.example.projetosorriso.controllers;

import com.example.projetosorriso.models.User;
import com.example.projetosorriso.services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.Serializable;

public class UserController implements Serializable {

    private final UserService userService = new UserService();

    @FXML
    TextField textFieldEmail;

    @FXML
    TextField textFieldPassword;

    @FXML
    public void cadastratAction (){
        try {
            User user = new User(
                    textFieldEmail.getText(),
                    textFieldPassword.getText()

            );
            userService.create(user);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastrado!");
            alert.setHeaderText(null);
            alert.setContentText("Usuário Cadastrado com Sucesso");
            alert.showAndWait();

            Stage stage = (Stage) textFieldEmail.getScene().getWindow();
            stage.close();
        } catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Dados inválidos!");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
