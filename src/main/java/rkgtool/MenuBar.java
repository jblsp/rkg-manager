package rkgtool;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;

public class MenuBar extends JMenuBar {

    // arrays that inlcude options that appear for specific tabs
    // items that are not in either array will always appear
    ArrayList<JComponent> rkg_options;
    ArrayList<JComponent> rksys_options;
    ArrayList<JMenu> tab_menus;

    public MenuBar() {

        rkg_options = new ArrayList<JComponent>();
        rksys_options = new ArrayList<JComponent>();
        tab_menus = new ArrayList<JMenu>();

        // file menu
        JMenu file_menu = new JMenu("File");
        this.add(file_menu);
        tab_menus.add(file_menu);

        JMenu new_submenu = new JMenu("New");
        file_menu.add(new_submenu);

        JMenuItem rksys_button = new JMenuItem("rksys.dat File");
        rksys_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rksys_button.setEnabled(false);
        new_submenu.add(rksys_button);

        JMenuItem open_button = new JMenuItem("Open");
        open_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.openTab();
            }
        });
        file_menu.add(open_button);

        JMenuItem close_button = new JMenuItem("Close");
        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.closeTab(Main.base_frame.tabbed_pane.getSelectedIndex());
            }
        });
        file_menu.add(close_button);

        JMenuItem save_button = new JMenuItem("Save");
        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.closeTab(Main.base_frame.tabbed_pane.getSelectedIndex());
            }
        });
        save_button.setEnabled(false);
        file_menu.add(save_button);

        JMenu export_submenu = new JMenu("Export");
        file_menu.add(export_submenu);
        export_submenu.setEnabled(false);

        JMenuItem export_rkg_button = new JMenuItem(".rkg File");
        export_rkg_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        export_submenu.add(export_rkg_button);
        rkg_options.add(export_rkg_button);

        JMenuItem export_rksys_button = new JMenuItem("rksys.dat File");
        export_rksys_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        export_submenu.add(export_rksys_button);
        rksys_options.add(export_rksys_button);

        JMenuItem export_mii_button = new JMenuItem("Mii file");
        export_mii_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        export_submenu.add(export_mii_button);
        rkg_options.add(export_mii_button);

        file_menu.addSeparator();

        JMenuItem preferences_button = new JMenuItem("Preferences");
        preferences_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        preferences_button.setEnabled(false);
        file_menu.add(preferences_button);

        file_menu.addSeparator();

        JMenuItem exit_button = new JMenuItem("Exit");
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file_menu.add(exit_button);

        // edit menu
        JMenu edit_menu = new JMenu("Edit");
        this.add(edit_menu);
        // tab_menus.add(edit_menu);
        edit_menu.setEnabled(false);

        JMenu time_submenu = new JMenu("Total Time");
        edit_menu.add(time_submenu);
        rkg_options.add(time_submenu);

        JMenuItem minutes_button = new JMenuItem("Minutes");
        minutes_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        time_submenu.add(minutes_button);

        JMenuItem seconds_button = new JMenuItem("Seconds");
        seconds_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        time_submenu.add(seconds_button);

        JMenuItem milliseconds_button = new JMenuItem("Milliseconds");
        milliseconds_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        time_submenu.add(milliseconds_button);

        JMenu date_submenu = new JMenu("Date Set");
        edit_menu.add(date_submenu);
        rkg_options.add(date_submenu);

        JMenuItem year_button = new JMenuItem("Year");
        year_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        date_submenu.add(year_button);

        JMenuItem month_button = new JMenuItem("Month");
        month_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        date_submenu.add(month_button);

        JMenuItem day_button = new JMenuItem("Day");
        day_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        date_submenu.add(day_button);

        JMenu location_submenu = new JMenu("Location");
        edit_menu.add(location_submenu);
        rkg_options.add(location_submenu);

        JMenuItem country_button = new JMenuItem("Country");
        country_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        location_submenu.add(country_button);

        JMenuItem state_button = new JMenuItem("State");
        state_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        edit_menu.add(state_button);
        location_submenu.add(state_button);

        JMenuItem mii_name_button = new JMenuItem("Mii Name");
        mii_name_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        edit_menu.add(mii_name_button);
        rkg_options.add(mii_name_button);

        JMenuItem controller_button = new JMenuItem("Controller");
        controller_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        edit_menu.add(controller_button);
        rkg_options.add(controller_button);

        JMenuItem ghost_type_button = new JMenuItem("Ghost Type");
        ghost_type_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        edit_menu.add(ghost_type_button);
        rkg_options.add(ghost_type_button);

        JMenuItem unlock_all_button = new JMenuItem("Unlock All");
        unlock_all_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        edit_menu.add(unlock_all_button);
        rksys_options.add(unlock_all_button);

        // help menu
        JMenu help_menu = new JMenu("Help");
        this.add(help_menu);
        tab_menus.add(help_menu);

        JMenuItem about_button = new JMenuItem("About");
        about_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutFrame();
            }
        });
        help_menu.add(about_button);

    }

    public void updateMenubarOptions() {
        JPanel tab = (JPanel) Main.base_frame.tabbed_pane.getSelectedComponent();

        for (JComponent jc : rkg_options) {
            jc.setVisible(false);
        }
        for (JComponent jc : rksys_options) {
            jc.setVisible(false);
        }
        if (tab instanceof RKGPanel) {
            for (JComponent jc : rkg_options) {
                jc.setVisible(true);
            }
        } else if (tab instanceof RKSYSPanel) {
            for (JComponent jc : rksys_options) {
                jc.setVisible(true);
            }
        }
        // disable all tab menus that have no components that are enabled and visible
        for (JMenu m : tab_menus) {
            m.setEnabled(false);
            for (Component c : m.getMenuComponents()) {
                if (c.isEnabled() && c.isVisible()) {
                    m.setEnabled(true);
                    break;
                }
            }
        }

    }
}
