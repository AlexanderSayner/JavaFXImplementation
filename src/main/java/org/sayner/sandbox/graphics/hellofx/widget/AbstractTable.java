package org.sayner.sandbox.graphics.hellofx.widget;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.List;

public abstract class AbstractTable<T> {
    protected final TableView<T> table;

    public AbstractTable(double width) {
        table = new TableView<>();
        table.setMinWidth(width);
        init();
    }

    /**
     * Размещает столбцы
     */
    protected abstract void init();

    /**
     * Запрос данных таблицы
     *
     * @return список сущностей
     */
    protected abstract List<T> getData();

    /**
     * Список для вывода на таблицу
     *
     * @return готовый объект для занесения в таблицу
     */
    protected ObservableList<T> getDataList() {
        final ObservableList<T> data = FXCollections.observableArrayList();
        data.addAll(getData());
        return data;
    }

    /**
     * Вернёт выбранную строчку таблицы в виде сущности
     *
     * @return выбранную сущность
     */
    public T getSelectedItem() {
        return table.getSelectionModel().getSelectedItem();
    }

    /**
     * Обновит данные в таблице
     */
    public void updateTable() {
        table.setItems(getDataList());
    }

    /**
     * Вернёт сконфигурируванную таблицу
     *
     * @return сущность, готовая к отрисовке
     */
    public TableView<T> getTable() {
        return table;
    }
}
