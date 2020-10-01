package org.sayner.sandbox.graphics.hellofx.stage;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import org.slf4j.LoggerFactory;

public class DepartmentStage extends AbstractStage{
    public DepartmentStage() {
        super("Departments console",LoggerFactory.getLogger(DepartmentStage.class));
    }

    @Override
    protected Scene createScene() {
        return new Scene(new StackPane());
    }
}
