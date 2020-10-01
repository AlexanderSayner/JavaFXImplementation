package org.sayner.sandbox.graphics.hellofx.core;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.sayner.sandbox.graphics.hellofx.HelloFXApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

public abstract class AbstractScene {
    protected Button baseButton(
            String title,
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

    protected WebClient webClient(){
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();
    }
}
