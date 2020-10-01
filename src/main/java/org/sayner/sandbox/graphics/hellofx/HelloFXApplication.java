package org.sayner.sandbox.graphics.hellofx;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.sayner.sandbox.graphics.hellofx.core.welcome.WelcomeScene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * webClient
 * .post()
 * .uri(uri)
 * .header("Content-Type", "application/json")
 * .bodyValue(request)
 * .retrieve()
 * .onStatus(
 * HttpStatus::isError,
 * clientResponse -> handleError(clientResponse.statusCode())
 * )
 * .bodyToMono(responseElement)
 * .block();
 */
public class HelloFXApplication extends Application {
    private static final Logger logger = LoggerFactory.getLogger(HelloFXApplication.class);
    public static final ObjectMapper OBJECT_MAPPER=new ObjectMapper();

    public static void main(String[] args) {
        logger.info("Application has started");
        launch();
        logger.info("Finished execution");
    }

    public static Image icon() throws IOException {
        return icon("icons/bass.png");
    }

    public static Image icon(String path) throws IOException {
        final ClassPathResource resource = new ClassPathResource(path);
        final InputStream iconStream = resource.getInputStream();
        return new Image(iconStream);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX");
        try {
            primaryStage.getIcons().add(icon());
        } catch (IOException e) {
            logger.warn("Can't open application icon: {}", e.getMessage());
        }
        primaryStage.setScene(
                new WelcomeScene().createScene(primaryStage)
        );
        primaryStage.show();
    }
}
