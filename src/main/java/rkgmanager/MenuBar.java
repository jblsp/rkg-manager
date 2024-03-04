package rkgmanager;

import javax.swing.*;
import java.awt.event.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        // menu categories
        JMenu file_menu = new JMenu("File");
        JMenu edit_menu = new JMenu("Edit");
        JMenu help_menu = new JMenu("Help");

        // menu buttons
        JMenuItem open_button = new JMenuItem("Open");
        open_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open clicked");
            }
        });
        file_menu.add(open_button);

        JMenuItem mii_name_button = new JMenuItem("Mii Name");
        mii_name_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mii_name_button.setEnabled(false);
        edit_menu.add(mii_name_button);

        JMenuItem about_button = new JMenuItem("About");
        about_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutFrame();
            }
        });
        help_menu.add(about_button);

        // add buttons to menu
        this.add(file_menu);
        this.add(edit_menu);
        this.add(help_menu);
    }
}
