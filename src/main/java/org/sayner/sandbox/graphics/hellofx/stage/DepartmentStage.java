package org.sayner.sandbox.graphics.hellofx.stage;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.sayner.sandbox.graphics.hellofx.HelloFXApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DepartmentStage {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentStage.class);
    private final Stage departmentStage = new Stage();

    public DepartmentStage() {
        departmentStage.setTitle("Departments console");
        try {
            departmentStage.getIcons().add(HelloFXApplication.icon());
        } catch (IOException e) {
            logger.warn("Can't open application icon: {}", e.getMessage());
        }
    }

    public Stage createStage(Scene scene) {
        logger.debug("Setting scene for department stage");
        departmentStage.setScene(scene);
        return departmentStage;
    }

    public Stage getDepartmentStage() {
        return departmentStage;
    }
}
