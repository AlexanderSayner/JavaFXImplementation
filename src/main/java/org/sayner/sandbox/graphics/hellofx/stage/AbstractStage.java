package org.sayner.sandbox.graphics.hellofx.stage;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.sayner.sandbox.graphics.hellofx.HelloFXApplication;
import org.slf4j.Logger;

import java.io.IOException;

public abstract class AbstractStage {
    protected final Logger logger;
    protected final Stage stage=new Stage();

    public AbstractStage(String title, Logger logger) {
        this.logger = logger;
        stage.setTitle(title);
        try {
            stage.getIcons().add(HelloFXApplication.icon());
        } catch (IOException e) {
            this.logger.warn("Can't open application icon: {}", e.getMessage());
        }
        stage.setScene(createScene());
    }

    protected Scene createScene() {
        return new Scene(new StackPane());
    }

    public Stage getStage() {
        return stage;
    }
}
