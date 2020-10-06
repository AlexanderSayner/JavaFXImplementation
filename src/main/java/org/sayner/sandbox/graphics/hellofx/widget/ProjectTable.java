package org.sayner.sandbox.graphics.hellofx.widget;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.sayner.sandbox.graphics.hellofx.model.Project;

import java.time.LocalDate;
import java.util.List;

public abstract class ProjectTable extends AbstractTable<Project> {
    public ProjectTable() {
        this(700);
    }

    public ProjectTable(double width) {
        super(width);
    }

    @Override
    protected void init() {
        // Create column Id (Data type of Integer)
        final TableColumn<Project, Integer> id =
                new TableColumn<>("Id");
        // Create column Name (Data type of String)
        final TableColumn<Project, String> name =
                new TableColumn<>("Name");
        // Open date column (Data type of LocalDate)
        final TableColumn<Project, LocalDate> open_date =
                new TableColumn<>("Open date");
        // Release date column (Data type of LocalDate)
        final TableColumn<Project, LocalDate> release_date =
                new TableColumn<>("Release date");
        final TableColumn<Project, String> dates =
                new TableColumn<>("dates");
        dates.getColumns().add(open_date);
        dates.getColumns().add(release_date);

        final TableColumn<Project, List<String>> listTableColumn =
                new TableColumn<>("list");

        table.getColumns().add(id);
        table.getColumns().add(name);
//        table.getColumns().add(open_date);
//        table.getColumns().add(release_date);
        table.getColumns().add(dates);
        table.getColumns().add(listTableColumn);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        open_date.setCellValueFactory(new PropertyValueFactory<>("open_date"));
        release_date.setCellValueFactory(new PropertyValueFactory<>("release_date"));

        final ObservableList<Project> dataList = getDataList();
        table.setItems(dataList);
    }
}
