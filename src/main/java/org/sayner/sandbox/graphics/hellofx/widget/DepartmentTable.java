package org.sayner.sandbox.graphics.hellofx.widget;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.sayner.sandbox.graphics.hellofx.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class DepartmentTable {
    private final Logger logger = LoggerFactory.getLogger(DepartmentTable.class);
    private final TableView<Department> table;

    public DepartmentTable() {
        table = new TableView<>();
        table.setMinWidth(700);
        init();
    }

    private void init(){
        // Create column Id (Data type of Integer).
        final TableColumn<Department, Integer> id
                = new TableColumn<>("Id");
        table.getColumns().add(id);
        // Create column Name (Data type of String).
        final TableColumn<Department, String> name
                = new TableColumn<>("Name");
        table.getColumns().add(name);

        id.setPrefWidth(50);
        name.setPrefWidth(250);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        id.setSortType(TableColumn.SortType.ASCENDING);
        name.setSortable(false);

        table.setItems(getDataList());
    }
    
    public Department getSelectedDepartment(){
        return table.getSelectionModel().getSelectedItem();
    }

    public void updateTable(){
        table.setItems(getDataList());
    }

    private ObservableList<Department> getDataList() {
        final ObservableList<Department> departments = FXCollections.observableArrayList();
        departments.addAll(getData());
        return departments;
    }

    protected abstract List<Department> getData();

    public TableView<Department> getTable() {
        return table;
    }
}
