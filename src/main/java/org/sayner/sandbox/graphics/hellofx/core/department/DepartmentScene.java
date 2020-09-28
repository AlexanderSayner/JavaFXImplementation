package org.sayner.sandbox.graphics.hellofx.core.department;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.sayner.sandbox.graphics.hellofx.core.AbstractScene;
import org.sayner.sandbox.graphics.hellofx.widget.DepartmentTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DepartmentScene extends AbstractScene {
    private final Logger logger = LoggerFactory.getLogger(DepartmentScene.class);

    public Scene createScene(EventHandler<? super MouseEvent> exitEvent) {
        return new Scene(
                new DepartmentFlowPale()
                        .placeOnTablePane(new DepartmentTable().getTable())
                        .placeOnInstrumentsPane(addButton(exitEvent))
                        .placeOnInstrumentsPane(updateButton(exitEvent))
                        .placeOnInstrumentsPane(deleteButton(exitEvent))
                        .placeOnInstrumentsPane(exitButton(exitEvent))
                        .getFlowPane(),
                628,
                460);
    }

    private Button addButton(EventHandler<? super MouseEvent> exitEvent){
        final Button button = button(
                "Add new department",
                "new department",
                "icons/new_by_copy-104.png",
                50,
                50);
        button.setOnMouseClicked(exitEvent);
        return button;
    }

    private Button updateButton(EventHandler<? super MouseEvent> exitEvent){
        final Button button = button(
                "Update department",
                "update department",
                "icons/update_file-256.png",
                50,
                50);
        button.setOnMouseClicked(exitEvent);
        return button;
    }

    private Button deleteButton(EventHandler<? super MouseEvent> exitEvent){
        final Button button = button(
                "Delete department",
                "update department",
                "icons/Files-Delete-File-icon.png",
                50,
                50);
        button.setOnMouseClicked(exitEvent);
        return button;
    }

    private Button exitButton(EventHandler<? super MouseEvent> exitEvent) {
        final Button button = button(
                "Go back to the menu",
                "exit",
                "icons/system-log-out.svg.png",
                50,
                50);
        button.setOnMouseClicked(exitEvent);
        return button;
    }

    private Button button(String title, String shortTitle, String path, double width, double height) {
        try {
            return baseButton(title, shortTitle, path, width, height, "-fx-font: 18 arial; -fx-base: #b6e7c9;",280);
        } catch (IOException e) {
            logger.warn("Can't open {} console icon: {}", shortTitle, e.getMessage());
        }
        return new Button("Error, see logs to find out the problem");
    }
}
