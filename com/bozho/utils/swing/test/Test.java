package com.bozho.utils.swing.test;

import com.bozho.utils.swing.BContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Bozhidar Ganev on 03.12.17.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Test swing utils");

        ActionListener l = e -> System.out.println(e.getActionCommand() + " was pressed");

        BContainer panel = new BContainer<>(new JPanel())
                .setLayout(BContainer.BOX_LAYOUT, BoxLayout.LINE_AXIS)
                .setMargin(10, 20)
                .setPreferredSize(400, 150)
                .createButtons("test",l,"1", "2", "3", "4")
                .setBorderLine(Color.GREEN, 10);

        BContainer pane = new BContainer<>(new JPanel())
                //.setLayout(BContainer.BOX_LAYOUT, BoxLayout.PAGE_AXIS)
                .setBorderLine(Color.RED, 5)
                .setMargin(0, 20)
                .addAligned(panel.getContainer(), BContainer.ALIGNED_LEFT);
                //.createButtons(l, "5", "6", "7");



        frame.setContentPane(pane.getContainer());
        frame.setPreferredSize(new Dimension(800, 300));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
