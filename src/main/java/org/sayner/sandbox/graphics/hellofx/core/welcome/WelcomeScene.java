package org.sayner.sandbox.graphics.hellofx.core.welcome;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class WelcomeScene {
    public Scene createScene(EventHandler<? super MouseEvent> event) throws Exception {
        final String javaVersion = System.getProperty("java.version");
        final String javafxVersion = System.getProperty("javafx.version");
        final Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        final Label comment = new Label("< press any key to continue >");
        return new Scene(
                new WelcomeFlowPlane(event)
                        .place(l)
                        .place(comment)
                        .getFlowPane(),
                320,
                240);
    }
}
