package com.bozho.utils.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Bozhidar Ganev on 13.12.17.
 */
public class Tables {
    static <T extends Container> BContainer<T> createScrollTable(BContainer<T> container, JTable table, String[] headers, DefaultTableModel model) {
        model.setColumnIdentifiers(headers);
        table.setModel(model);
        container.add(new JScrollPane(table));
        return container;
    }

    static <T extends Container> BContainer<T> createScrollTable(BContainer<T> container, String[] headers, DefaultTableModel model) {
        return createScrollTable(container, new JTable(), headers, model);
    }

    static <T extends Container> BContainer<T> createScrollTable(BContainer<T> container, String[] headers) {
        return createScrollTable(container, new JTable(), headers, new DefaultTableModel());
    }

    static <T extends Container> BContainer<T> createScrollTable(BContainer<T> container, JTable table, String[] headers) {
        return createScrollTable(container, table, headers, new DefaultTableModel());
    }
}
