package org.sayner.sandbox.graphics.hellofx;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.sayner.sandbox.graphics.hellofx.core.department.DepartmentScene;
import org.sayner.sandbox.graphics.hellofx.core.main.MainScene;
import org.sayner.sandbox.graphics.hellofx.core.welcome.WelcomeScene;
import org.sayner.sandbox.graphics.hellofx.stage.DepartmentStage;
import org.sayner.sandbox.graphics.hellofx.stage.MainStage;
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

        final Stage departmentStage = new DepartmentStage().getDepartmentStage();
        final Stage mainStage = new MainStage().getMainStage();

        departmentStage.setScene(
                new DepartmentScene().createScene(exitEvent -> {
                            departmentStage.close();
                            mainStage.show();
                        }
                )
        );
        mainStage.setScene(
                new MainScene().createScene(departmentEvent -> {
                            mainStage.close();
                            departmentStage.show();
                        }
                )
        );
        primaryStage.setScene(
                new WelcomeScene().createScene(event -> {
                                    primaryStage.close();
                                    mainStage.show();
                                }
                        )
        );
        primaryStage.show();
    }
}
