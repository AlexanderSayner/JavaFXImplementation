package org.sayner.sandbox.graphics.hellofx.core.department;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import org.sayner.sandbox.graphics.hellofx.core.AbstractFlowPlane;

public class DepartmentFlowPale extends AbstractFlowPlane {
    private final FlowPane tablePane;
    private final FlowPane instrumentsPane;

    public DepartmentFlowPale() {
        super(new FlowPane());
        flowPane.setPadding(new Insets(15, 15, 15, 15));
        flowPane.setHgap(10);
        flowPane.setVgap(20);
        flowPane.setAlignment(Pos.CENTER);
        tablePane = new FlowPane();
        tablePane.setMinWidth(730);
        instrumentsPane = new FlowPane();
        initFlowPane(tablePane);
        initFlowPane(instrumentsPane);
    }

    private void initFlowPane(FlowPane flowPane){
        flowPane.setPadding(new Insets(15,15,15,15));
        flowPane.setAlignment(Pos.BASELINE_CENTER);
        flowPane.setHgap(10);
        flowPane.setVgap(20);
        flowPane.setPrefWidth(150);
    }

    public DepartmentFlowPale placeOnTablePane(Node node) {
        tablePane.getChildren().add(node);
        return this;
    }

    public DepartmentFlowPale placeOnInstrumentsPane(Node node) {
        instrumentsPane.getChildren().add(node);
        return this;
    }

    @Override
    public FlowPane getFlowPane() {
        place(tablePane);
        place(instrumentsPane);
        return super.getFlowPane();
    }
}
