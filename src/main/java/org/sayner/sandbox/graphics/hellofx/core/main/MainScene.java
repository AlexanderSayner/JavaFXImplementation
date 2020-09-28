package org.sayner.sandbox.graphics.hellofx.core.main;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import org.sayner.sandbox.graphics.hellofx.core.AbstractScene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainScene extends AbstractScene {
    private final Logger logger = LoggerFactory.getLogger(MainScene.class);

    public Scene createScene(EventHandler<? super MouseEvent> departmentEvent) {
        final ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(
                new MainFlowPlane()
                        .place(clientsButton())
                        .place(employeeButton())
                        .place(projectsButton())
                        .place(departmentsButton(departmentEvent))
                        .place(rolesButton())
                        .getFlowPane()
        );
        return new Scene(
                scrollPane,
                545,
                720);
    }

    private Button clientsButton() {
        return button("Working with clients console",
                "client",
                "icons/Sotrudniki.png",
                145.5,
                160);
    }

    private Button employeeButton() {
        return button(
                "Employees working console",
                "employee",
                "icons/employees-icon.png",
                150,
                150);
    }

    private Button projectsButton() {
        return button(
                "Projects working console",
                "projects",
                "icons/game-controller.png",
                150,
                150);
        
    }

    private Button departmentsButton(EventHandler<? super MouseEvent> event) {
        final Button button = button(
                "Departments working console",
                "department",
                "icons/department.png",
                150,
                150);
        button.setOnMouseClicked(event);
        return button;
    }

    private Button rolesButton() {
        return button(
                "Working with roles console",
                "roles",
                "icons/role.png",
                150,
                150);
    }


    private Button button(String title, String shortTitle, String path, double width, double height) {
        try {
            return baseButton(title, shortTitle, path, width, height,"-fx-font: 22 arial; -fx-base: #b6e7c9;",500);
        } catch (IOException e) {
            logger.warn("Can't open {} console icon: {}", shortTitle, e.getMessage());
        }
        return new Button("Error, see logs to find out the problem");
    }
}
