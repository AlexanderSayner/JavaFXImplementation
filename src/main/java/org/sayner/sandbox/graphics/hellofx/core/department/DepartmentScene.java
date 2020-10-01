package org.sayner.sandbox.graphics.hellofx.core.department;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.sayner.sandbox.graphics.hellofx.core.AbstractScene;
import org.sayner.sandbox.graphics.hellofx.model.Department;
import org.sayner.sandbox.graphics.hellofx.service.DepartmentService;
import org.sayner.sandbox.graphics.hellofx.widget.DepartmentTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class DepartmentScene extends AbstractScene {
    private final Logger logger = LoggerFactory.getLogger(DepartmentScene.class);
    private final DepartmentService departmentService = new DepartmentService(webClient());
    private final DepartmentTable departmentTable = new DepartmentTable() {
        @Override
        protected List<Department> getData() {
            return departmentService.getList();
        }
    };
    private final TextField nameTextField = new TextField();

    public DepartmentScene() {
    }

    public Scene createScene(EventHandler<? super MouseEvent> exitEvent) {
        nameTextField.setPrefWidth(270);
        nameTextField.setPromptText("name");
        departmentTable.getTable().setOnMouseClicked(event -> {
            final Department string = departmentTable.getSelectedDepartment();
            if (string != null) {
                nameTextField.setText(string.toString());
            } else {
                nameTextField.setText("none");
            }
        });
        return new Scene(
                new DepartmentFlowPale()
                        .placeOnTablePane(departmentTable.getTable())
                        .placeOnInstrumentsPane(addButton(event -> {
                            departmentService.add(nameTextField.getText());
                            departmentTable.updateTable();
                            nameTextField.deleteText(0, nameTextField.getText().length());
                        }))
                        .placeOnInstrumentsPane(updateButton(event -> {
                            final Department selectedDepartment = departmentTable.getSelectedDepartment();
                            logger.info("Updating {}", selectedDepartment.toString());
                            nameTextField.deleteText(0, nameTextField.getText().length());
                            departmentService.update(selectedDepartment, nameTextField.getText());
                            departmentTable.updateTable();
                        }))
                        .placeOnInstrumentsPane(deleteButton(exitEvent))
                        .placeOnInstrumentsPane(exitButton(exitEvent))
                        .placeOnInstrumentsPane(nameTextField)
                        .getFlowPane(),
                1080,
                460);
    }

    private Button addButton(EventHandler<? super MouseEvent> exitEvent) {
        final Button button = button(
                "Add new department",
                "new department",
                "icons/new_by_copy-104.png",
                50,
                50);
        button.setOnMouseClicked(exitEvent);
        return button;
    }

    private Button updateButton(EventHandler<? super MouseEvent> exitEvent) {
        final Button button = button(
                "Update department",
                "update department",
                "icons/update_file-256.png",
                50,
                50);
        button.setOnMouseClicked(exitEvent);
        return button;
    }

    private Button deleteButton(EventHandler<? super MouseEvent> exitEvent) {
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
            return baseButton(title, path, width, height, "-fx-font: 18 arial; -fx-base: #b6e7c9;", 280);
        } catch (IOException e) {
            logger.warn("Can't open {} console icon: {}", shortTitle, e.getMessage());
        }
        return new Button("Error, see logs to find out the problem");
    }
}
