package edu.ntnu.idatt2001.trym.cardgame.controller;

import edu.ntnu.idatt2001.trym.cardgame.backend.SwitchScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FrontPageController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void startGame(ActionEvent event) throws IOException{
        SwitchScene.switchScene("ObligGame", event);
    }


}