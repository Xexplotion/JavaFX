package com.xexplotion.javafx;

import com.xexplotion.javafx.ai.Agent;
import com.xexplotion.javafx.ai.Brain;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        int size = 10;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle room = new Rectangle();
                room.setWidth(50);
                room.setHeight(50);
                room.setFill(Color.SADDLEBROWN);
                root.add(room, i, j);
            }
        }
        var xs = size*size;

        Random rand = new Random();

                                          //max | min
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        Agent agent1 = null;
        Agent agent = new Agent("Joe", new Brain(1,true, agent1), 1 ,new ArrayList<>(),randomNum,randomNum);


        Scene scene = new Scene(root, 650, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}