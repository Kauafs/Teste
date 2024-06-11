package com.example.projetosorriso.controllers;

import com.example.projetosorriso.MainApplication;
import com.example.projetosorriso.services.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    TextField txtFieldEmail;
    @FXML
    TextField txtFieldSenha;
    @FXML
    Text txtError;

    LoginService loginService = new LoginService();

    @FXML
    public void registeruser(){
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("signup-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Cadastrar Usuário!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    public void loginAction (){
        txtError.setText("");
        try {
            loginService.login(txtFieldEmail.getText(),txtFieldSenha.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 600, 400);
                Stage stage = new Stage();
                stage.setTitle("Bem vindo!");
                stage.setScene(scene);
                stage.show();
                Stage stageLogin = (Stage) txtError.getScene().getWindow();
                stageLogin.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            txtError.setText(e.getMessage());

        }

    }
}