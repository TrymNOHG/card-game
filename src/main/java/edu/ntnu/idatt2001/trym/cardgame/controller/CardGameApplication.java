package edu.ntnu.idatt2001.trym.cardgame.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CardGameApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/ntnu/idatt2001/trym/cardgame/view/FrontPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("*** Card Game Application ***");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void init() throws Exception{
        super.init();
    }

    @Override
    public void stop() throws Exception{
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}