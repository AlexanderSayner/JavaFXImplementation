package org.sayner.sandbox.graphics.hellofx.core;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ApplicationWindow {
    public Scene createScene() throws Exception{
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        return new Scene(new StackPane(l), 640, 480);
    }
}
