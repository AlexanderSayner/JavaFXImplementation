package org.sayner.sandbox.graphics.hellofx.core.welcome;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import org.sayner.sandbox.graphics.hellofx.core.AbstractFlowPlane;

public class WelcomeFlowPlane extends AbstractFlowPlane {
    public WelcomeFlowPlane(EventHandler<? super MouseEvent> event) {
        super(new FlowPane());
        flowPane.setPadding(new Insets(15,15,15,15));
        flowPane.setHgap(10);
        flowPane.setVgap(20);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setOnMouseClicked(event);
    }
}
