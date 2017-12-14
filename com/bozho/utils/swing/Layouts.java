package com.bozho.utils.swing;

import javax.swing.*;

/**
 * Created by Bozhidar Ganev on 03.12.17.
 */
public class Layouts {
    public static BContainer setLayout(BContainer container, int constant, int layoutVar) {
        switch (constant) {
            case BContainer.BOX_LAYOUT: container.setLayout(new BoxLayout(container.getContainer(), layoutVar)); break;
            case BContainer.BORDER_LAYOUT : break;
        }

        return container;
    }
}
