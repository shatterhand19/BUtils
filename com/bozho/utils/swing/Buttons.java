package com.bozho.utils.swing;

import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Bozhidar Ganev on 03.12.17.
 */
public class Buttons {
    static <T extends Container> BContainer<T> addButtons(@NotNull BContainer<T> container, @NotNull ActionListener l, String prefix, @NotNull String[] buttonNames, @NotNull String[] actionCommands) {
        //Check if the arguments are valid; the others will be handled manually
        if (container == null || l == null || buttonNames == null || actionCommands == null || buttonNames.length != actionCommands.length) throw new IllegalArgumentException("Illegal argument passed!");

        //List to store the valid buttons
        ArrayList<JButton> buttons = new ArrayList<>();

        //Process all button names
        for (int i = 0; i < buttonNames.length; i++) {
            //Skip the illegal ones
            if (buttonNames[i] != null) {
                //If the prefix is valid, append it before the name
                if (prefix != null) buttonNames[i] = prefix + buttonNames[i];
                //Create the button
                buttons.add(createButton(l, buttonNames[i], actionCommands[i]));
            }
        }

        //Add all buttons to the container
        container.addGlue(container.alignment_direction);
        for (int i = 0; i < buttons.size() - 1; i++)
            container.addWithMargin(buttons.get(i));
        container.add(buttons.get(buttons.size() - 1));
        container.addGlue(container.alignment_direction);

        return container;
    }

    /**
     * Creates buttons and adds them to the specified BContainer.
     *
     * @param container is the container where the buttons are added
     * @param l is the action listener
     * @param prefix is a prefix for the button names; if null then nothing is added
     * @param buttonNames is an array of the names of the buttons
     * @param <T> is the type of the BContainer object
     * @return the container object
     */
    static <T extends Container> BContainer<T> addButtons(@NotNull BContainer<T> container, @NotNull ActionListener l, String prefix, @NotNull String[] buttonNames) {
        //Create action commands names; they are the names of the buttons, to lower case
        String[] actionCommands = new String[buttonNames.length];
        for (int i = 0; i < buttonNames.length; i++)
            actionCommands[i] = buttonNames[i].toLowerCase();
        return addButtons(container, l, prefix, buttonNames, actionCommands);
    }

    /**
     * Creates a button.
     *
     * @param l is the action listener for the button
     * @param name is the name of the button
     * @param actionName is the action command for the button
     * @return the created button
     */
    static JButton createButton(@NotNull ActionListener l,@NotNull String name,@NotNull String actionName) {
        JButton b = new JButton(name);
        b.setActionCommand(actionName);
        b.addActionListener(l);
        return b;
    }

    /**
     * Creates a button with action command the name of the button to lower case.
     *
     * @param l is the action listener for the button
     * @param name is the name of the button
     * @return the created button
     */
    static JButton createButton(@NotNull ActionListener l,@NotNull String name) {
        return createButton(l, name, name.toLowerCase());
    }
}
