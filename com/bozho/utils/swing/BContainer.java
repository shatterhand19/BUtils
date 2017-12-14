package com.bozho.utils.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Bozhidar Ganev on 03.12.17.
 */
public class BContainer<T extends Container> {
    private T container;

    int h_margin = 0, w_margin = 0;
    int layout = FLOW_LAYOUT;
    int center_direction = 0;

    public static final int BOX_LAYOUT = 0;
    public static final int BORDER_LAYOUT = 1;
    public static final int CARD_LAYOUT = 2;
    public static final int FLOW_LAYOUT = 3;
    public static final int GRIDBAG_LAYOUT = 4;
    public static final int GRID_LAYOUT = 5;
    public static final int SPRING_LAYOUT = 6;

    public static final int CENTERED_HORIZONTAL = 0;
    public static final int CENTERED_VERTICAL = 1;
    public static final int ALIGNED_LEFT = 2;
    public static final int ALIGNED_RIGHT = 3;


    public BContainer(T container) {
        this.container = container;
    }

    public BContainer<T> add(Component component) {
        container.add(component);
        return this;
    }

    public BContainer<T> addMargin(Component component) {
        container.add(component);
        this.addMargin();
        return this;
    }

    public BContainer<T> setCenterDirection(int direction) {
        if (direction >= 0 && direction <= 3) {
            center_direction = direction;
        }
        return this;
    }

    public BContainer<T> addAligned(Component component, int direction) {
        if (direction >= 0 && direction <= 3) {
            if (direction == 0 || direction == 1 || direction == 3) this.addGlue(direction);
            container.add(component);
            if (direction == 0 || direction == 1 || direction == 2) this.addGlue(direction);
        }
        return this;
    }

    public BContainer<T> addGlue(int direction) {
        if (direction >= 0 && direction <= 3) {
            container.add(direction == CENTERED_VERTICAL ? Box.createVerticalGlue() : Box.createHorizontalGlue());
        }
        return this;
    }

    public BContainer<T> addMargin(int w_margin, int h_margin) {
        if (h_margin >= 0 && w_margin >= 0) {
            container.add(Box.createRigidArea(new Dimension(w_margin, h_margin)));
        }
        return this;
    }

    public BContainer<T> addMargin() {
        return addMargin(w_margin, h_margin);
    }

    public BContainer<T> createButtons(String prefix, ActionListener l, String... buttonNames) {
        return Buttons.createButtons(this, l, prefix, buttonNames);
    }

    public BContainer<T> createButtons(ActionListener l, String... buttonNames) {
        return Buttons.createButtons(this, l, "", buttonNames);
    }

    public BContainer<T> createScrollTable(String[] headers) {
        return Tables.createScrollTable(this, headers);
    }

    public BContainer<T> createScrollTable(JTable table, String[] headers, DefaultTableModel model) {
        return Tables.createScrollTable(this, table, headers, model);
    }

    public BContainer<T> createScrollTable(JTable table, String[] headers) {
        return Tables.createScrollTable(this, table, headers);
    }

    public BContainer<T> createScrollTable(String[] headers, DefaultTableModel model) {
        return Tables.createScrollTable(this, headers, model);
    }

    public BContainer<T> setPreferredSize(int width, int height) {
        container.setPreferredSize(new Dimension(width, height));
        return this;
    }

    void setBorder(Border b) {
        if (container instanceof JComponent) {
            ((JComponent) container).setBorder(b);
        }
    }

    public BContainer<T> setBorderEmpty(int t, int r, int b, int l) {
        return Borders.setEmpty(this, t, r, b, l);
    }

    public BContainer<T> setBorderLine(Color c, int thickness) {
        return Borders.setLine(this, c, thickness);
    }

    public BContainer<T> setBorderLine(Color c) {
        return Borders.setLine(this, c);
    }

    public BContainer<T> setLayout(int constant, int layoutVal) {
        if (constant >= 0 && constant <= 6) {
            this.layout = constant;
            return Layouts.setLayout(this, constant, layoutVal);
        }
        return this;
    }

    BContainer<T> setLayout(LayoutManager2 layout) {
        container.setLayout(layout);
        return this;
    }

    public BContainer<T> setMargin(int w, int h) {
        this.h_margin = h;
        this.w_margin = w;
        return this;
    }

    public T getContainer() {
        return container;
    }

}
