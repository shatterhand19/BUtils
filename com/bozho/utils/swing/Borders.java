package com.bozho.utils.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bozhidar Ganev on 03.12.17.
 */
public class Borders {
    static <T extends Container> BContainer<T> setEmpty(BContainer<T> container, int t, int r, int b, int l) {
        if (container.getContainer() instanceof JComponent) {
            container.setBorder(BorderFactory.createEmptyBorder(t, l, b, r));
        }
        return container;
    }

    static <T extends Container> BContainer<T> setLine(BContainer<T> container, Color c, int thickness) {
        if (container.getContainer() instanceof JComponent) {
            if (thickness >= 0) {
                container.setBorder(BorderFactory.createLineBorder(c, thickness));
            } else container.setBorder(BorderFactory.createLineBorder(c));
        }
        return container;
    }

    static <T extends Container> BContainer<T> setLine(BContainer<T> container, Color c) {
        return setLine(container, c, 0);
    }

    //TODO: include more borders
}
