package org.sayner.sandbox.graphics.hellofx.widget;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.sayner.sandbox.graphics.hellofx.model.Department;

public class DepartmentTable {
    private final TableView<Department> table;

    public DepartmentTable() {
        this.table = new TableView<>();
        init();
    }

    private void init(){
        // Create column Id (Data type of Integer).
        final TableColumn<Department, Integer> id
                = new TableColumn<>("Id");
        this.table.getColumns().add(id);
        // Create column Name (Data type of String).
        final TableColumn<Department, String> name
                = new TableColumn<>("Name");
        this.table.getColumns().add(name);
    }

    public TableView<Department> getTable() {
        return table;
    }
}
