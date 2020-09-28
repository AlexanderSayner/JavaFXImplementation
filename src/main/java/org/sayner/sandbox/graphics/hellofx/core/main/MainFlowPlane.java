package org.sayner.sandbox.graphics.hellofx.core.main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import org.sayner.sandbox.graphics.hellofx.core.AbstractFlowPlane;

public class MainFlowPlane extends AbstractFlowPlane {

    public MainFlowPlane() {
        super(new FlowPane());
        flowPane.setPadding(new Insets(15,15,15,15));
        flowPane.setHgap(10);
        flowPane.setVgap(20);
        flowPane.setAlignment(Pos.CENTER);
    }
}
