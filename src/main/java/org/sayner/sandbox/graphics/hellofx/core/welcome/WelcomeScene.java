package org.sayner.sandbox.graphics.hellofx.core.welcome;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.sayner.sandbox.graphics.hellofx.core.department.DepartmentScene;
import org.sayner.sandbox.graphics.hellofx.core.main.MainScene;
import org.sayner.sandbox.graphics.hellofx.core.project.ProjectScene;
import org.sayner.sandbox.graphics.hellofx.stage.*;

// TODO: перенести логику создания сцены в Stage классы
public class WelcomeScene {
    public Scene createScene(Stage onCloseStage) throws Exception {
        final Stage mainStage = new MainStage().getMainStage();
        final Stage departmentStage = new DepartmentStage().getStage();
        final Stage projectsStage=new ProjectStage().getStage();

        projectsStage.setScene(
                new ProjectScene().createScene()
        );
        departmentStage.setScene(
                new DepartmentScene().createScene(exitEvent -> {
                            departmentStage.close();
                            mainStage.show();
                        }
                )
        );
        mainStage.setScene(
                new MainScene().createScene(
                        projectEvent->{
                            mainStage.close();
                            projectsStage.show();
                        },
                        departmentEvent -> {
                            mainStage.close();
                            departmentStage.show();
                        }
                )
        );

        final String javaVersion = System.getProperty("java.version");
        final String javafxVersion = System.getProperty("javafx.version");
        final Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        final Label comment = new Label("< press any key to continue >");
        return new Scene(
                new WelcomeFlowPlane(event -> {
                    onCloseStage.close();
                    mainStage.show();
                })
                        .place(l)
                        .place(comment)
                        .getFlowPane(),
                320,
                240);
    }
}
