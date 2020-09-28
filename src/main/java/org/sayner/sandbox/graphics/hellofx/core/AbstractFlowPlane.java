package org.sayner.sandbox.graphics.hellofx.core;

import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

public abstract class AbstractFlowPlane {
    protected final FlowPane flowPane;

    public AbstractFlowPlane(FlowPane flowPane) {
        this.flowPane = flowPane;
    }

    public AbstractFlowPlane place(Node node){
        flowPane.getChildren().add(node);
        return this;
    }

    public FlowPane getFlowPane() {
        return flowPane;
    }
}
