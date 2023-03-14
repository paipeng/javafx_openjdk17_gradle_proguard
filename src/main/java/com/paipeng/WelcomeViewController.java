package com.paipeng;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WelcomeViewController implements Initializable {
    public static Logger logger = LoggerFactory.getLogger(WelcomeViewController.class);
    private static Stage stage;
    private static final String FXML_FILE = "/com/paipeng/WelcomeViewController.fxml";
    private  static ResourceBundle resources;
    public Image backgroundImage;
    @FXML
    private ImageView backgroundImageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //logger = LoggerFactory.getLogger(WelcomeViewController.class);
        waitSleep();
    }


    public static void start() {
        try {
            //resources = ResourceBundle.getBundle("bundles.languages", CommonUtils.getCurrentLanguageLocale());
            URL location = WelcomeViewController.class.getResource(FXML_FILE);
            if (location != null) {
                Parent root = FXMLLoader.load(location);
                Scene scene = new Scene(root);
                stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                //stage.setTitle(resources.getString("s2icodePrintTitle"));
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setResizable(true);
                stage.show();

            } else {

            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    private void waitSleep() {
        logger.info("hello world");
        AsynchronSleepTask<Integer> task = new AsynchronSleepTask<>();

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                                @Override
                                public void handle(WorkerStateEvent event) {
                                    backgroundImageView.setImage(null);
                                }
                            }
                //wse -> alert.close()//listView.getItems()//.setAll(task.getValue())
        );

        Thread t = new Thread(task, "wait-sleep-thread");
        t.setDaemon(true);
        t.start();
    }

    // The Task implementation
    private static class AsynchronSleepTask<E> extends Task<List<E>> {

        private AsynchronSleepTask() {
            updateTitle("AsynchronSleepTask");
        }

        @Override
        protected List<E> call() throws Exception {
            Thread.sleep(2000);


            return null;
        }

        @Override
        protected void running() {
        }

        @Override
        protected void succeeded() {

        }

    }
}
