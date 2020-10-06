package org.sayner.sandbox.graphics.hellofx.widget;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.sayner.sandbox.graphics.hellofx.model.Department;

public abstract class DepartmentTable extends AbstractTable<Department> {
    public DepartmentTable() {
        this(700);
    }

    public DepartmentTable(double width) {
        super(width);
    }

    @Override
    protected void init() {
        // Create column Id (Data type of Integer).
        final TableColumn<Department, Integer> id =
                new TableColumn<>("Id");
        // Create column Name (Data type of String).
        final TableColumn<Department, String> name =
                new TableColumn<>("Name");

        table.getColumns().add(id);
        table.getColumns().add(name);

        id.setPrefWidth(50);
        name.setPrefWidth(250);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        id.setSortType(TableColumn.SortType.ASCENDING);
        name.setSortable(false);

        table.setItems(getDataList());
    }
}
