package com.bozho.utils.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Bozhidar Ganev on 03.12.17.
 */
public class Buttons {
    static <T extends Container> BContainer<T> createButtons(BContainer<T> container, ActionListener l, String prefix, String... buttonNames) {
        //Check if the arguments are valid; the others will be handled manually
        if (container == null || l == null) throw new IllegalArgumentException("Null object passed!");

        //List to store the valid buttons
        ArrayList<JButton> buttons = new ArrayList<>();

        //Process all button names
        for (int i = 0; i < buttonNames.length; i++) {
            //Skip the illegal ones
            if (buttonNames[i] != null) {
                //If the prefix is valid, append it before the name
                if (prefix != null) buttonNames[i] = prefix + buttonNames[i];
                //Create the button
                JButton button = new JButton(buttonNames[i]);
                button.addActionListener(l);
                button.setActionCommand(buttonNames[i].toLowerCase());
                buttons.add(button);
            }
        }

        //Add all buttons to the container
        container.addGlue(container.center_direction);
        for (int i = 0; i < buttons.size() - 1; i++) {
            container.add(buttons.get(i));
            container.addMargin();
        }
        container.add(buttons.get(buttons.size() - 1));
        container.addGlue(container.center_direction);

        return container;
    }
}
