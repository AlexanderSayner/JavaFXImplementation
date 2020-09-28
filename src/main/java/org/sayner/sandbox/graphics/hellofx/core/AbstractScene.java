package org.sayner.sandbox.graphics.hellofx.core;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.sayner.sandbox.graphics.hellofx.HelloFXApplication;

import java.io.IOException;

public abstract class AbstractScene {
    protected Button baseButton(
            String title,
            String shortTitle,
            String path,
            double imageWidth,
            double imageHeight,
            String style,
            double prefWidth
    ) throws IOException {
        final Button button = new Button(title);
        final ImageView imageView = new ImageView(HelloFXApplication
                .icon(path));
        imageView.setFitWidth(imageWidth);
        imageView.setFitHeight(imageHeight);
        button.setGraphic(imageView);
        button.setStyle(style);
        button.setPrefWidth(prefWidth);
        return button;
    }
}
