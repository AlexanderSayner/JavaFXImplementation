package org.sayner.sandbox.graphics.hellofx.core.project;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import org.sayner.sandbox.graphics.hellofx.core.AbstractScene;
import org.sayner.sandbox.graphics.hellofx.core.TwoPartFlowPale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectScene extends AbstractScene {
    private final Logger logger = LoggerFactory.getLogger(ProjectScene.class);
    private final TextField textField = new TextField();

    public ProjectScene() {
    }

    public Scene createScene() {
        textField.setPrefWidth(270);
        return new Scene(
                new TwoPartFlowPale()
                        .placeOnInstrumentsPane(textField)
                        .getFlowPane(),
                1080,
                460);
    }
}
