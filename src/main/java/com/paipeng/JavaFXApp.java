package com.paipeng;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

public class JavaFXApp extends Application {

    public static HostServices hostServices;
    @Override
    public void start(Stage primaryStage) throws Exception {
        //MainViewController.start();
        hostServices = getHostServices();
        //TestS2iCodePrintViewController.start();
        WelcomeViewController.start();
    }

}
