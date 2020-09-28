package org.sayner.sandbox.graphics.hellofx.stage;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.sayner.sandbox.graphics.hellofx.HelloFXApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainStage {
    private final Logger logger;
    private final Stage mainStage;

    public MainStage() {
        logger = LoggerFactory.getLogger(MainStage.class);
        mainStage = new Stage();
        mainStage.setTitle("Main menu");
        try {
            mainStage.getIcons().add(HelloFXApplication.icon());
        } catch (IOException e) {
            logger.warn("Can't open application icon: {}", e.getMessage());
        }
    }

    public Stage setScene(Scene scene) {
        logger.debug("Setting scene for main stage");
        mainStage.setScene(scene);
        return mainStage;
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
