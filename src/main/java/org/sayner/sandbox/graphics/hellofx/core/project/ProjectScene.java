package org.sayner.sandbox.graphics.hellofx.core.project;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import org.sayner.sandbox.graphics.hellofx.core.AbstractScene;
import org.sayner.sandbox.graphics.hellofx.core.TwoPartFlowPale;
import org.sayner.sandbox.graphics.hellofx.model.Project;
import org.sayner.sandbox.graphics.hellofx.service.ProjectService;
import org.sayner.sandbox.graphics.hellofx.widget.ProjectTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProjectScene extends AbstractScene {
    private final Logger logger = LoggerFactory.getLogger(ProjectScene.class);
    private final TextField textField = new TextField();
    private final ProjectService projectService = new ProjectService(webClient());
    private final ProjectTable projectTable;

    public ProjectScene() {
        projectTable = new ProjectTable() {
            @Override
            protected List<Project> getData() {
                return projectService.getList();
            }
        };
    }

    public Scene createScene() {
        textField.setPrefWidth(270);
        return new Scene(
                new TwoPartFlowPale()
                        .placeOnTablePane(projectTable.getTable())
                        .placeOnInstrumentsPane(textField)
                        .getFlowPane(),
                1080,
                460);
    }
}
