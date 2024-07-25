package rkgtool;

import javax.swing.*;

import com.formdev.flatlaf.FlatClientProperties;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class MenuBar extends JMenuBar {

    // list of options/submenus that are visible only for specific tabs
    List<JMenuItem> rkg_visible_options = new ArrayList<>(); // rkg panel options
    List<JMenuItem> rksys_visible_options = new ArrayList<>(); // rksys panel options

    // list of options/submenus that are enabled only in specific tabs
    List<JMenuItem> any_tab_enabled_options = new ArrayList<>(); // any tab is open
    List<JMenuItem> rkg_enabled_options = new ArrayList<>(); // rkg panel options
    List<JMenuItem> rksys_enabled_options = new ArrayList<>(); // rksys panel options

    // Generally, I want options under File to be dynamically enabled, and options
    // under Edit to be dynamically visible.

    public MenuBar() {

        // ============================= FILE MENU =============================

        JMenu file_menu = new JMenu("File");
        this.add(file_menu);

        JMenu new_submenu = new JMenu("New");
        file_menu.add(new_submenu);

        JMenuItem rksys_button = new JMenuItem("rksys.dat File");
        rksys_button.addActionListener(e -> {

        });
        new_submenu.add(rksys_button);
        rksys_button.setEnabled(false); // TODO: New rksys button

        JMenuItem open_button = new JMenuItem("Open");
        open_button.addActionListener(e -> RKGTool.openTabbableFiles());
        file_menu.add(open_button);

        JMenuItem close_button = new JMenuItem("Close");
        close_button.addActionListener(e -> {
            int cur_tab_index = RKGTool.base_frame.tabbed_pane.getSelectedIndex();
            RKGTool.base_frame.tabbed_pane.removeTabAt(cur_tab_index);
        });
        file_menu.add(close_button);
        any_tab_enabled_options.add(close_button);

        file_menu.addSeparator();

        JMenuItem save_as_button = new JMenuItem("Save As");
        save_as_button.addActionListener(e -> {
        });
        save_as_button.setEnabled(false);
        // TODO: Save as button
        // rksys_enabled_options.add(save_as_button);
        // rkg_enabled_options.add(save_as_button);
        file_menu.add(save_as_button);

        JMenu export_submenu = new JMenu("Export");
        file_menu.add(export_submenu);

        JMenuItem export_rkg_button = new JMenuItem(".rkg File");
        export_rkg_button.addActionListener(e -> {
        });
        export_submenu.add(export_rkg_button);
        rkg_visible_options.add(export_rkg_button);

        JMenuItem export_rksys_button = new JMenuItem("rksys.dat File");
        export_rksys_button.addActionListener(e -> {

        });
        export_submenu.add(export_rksys_button);
        export_rksys_button.setEnabled(false); // TODO: Export rksys button
        // rksys_visible_options.add(export_rksys_button);

        JMenuItem export_mii_button = new JMenuItem("Mii Data");
        export_mii_button.addActionListener(e -> {

        });
        export_submenu.add(export_mii_button);
        export_mii_button.setEnabled(false); // TODO: Export mii button
        // rkg_visible_options.add(export_mii_button);

        file_menu.addSeparator();

        JMenuItem preferences_button = new JMenuItem("Preferences");
        preferences_button.addActionListener(e -> {

        });
        preferences_button.setEnabled(false); // TODO: Preferences button
        file_menu.add(preferences_button);

        JMenuItem exit_button = new JMenuItem("Exit");
        exit_button.addActionListener(e -> System.exit(0));
        file_menu.add(exit_button);

        // ============================= EDIT MENU =============================

        JMenu edit_menu = new JMenu("Edit");
        this.add(edit_menu);

        JMenu time_submenu = new JMenu("Time");
        edit_menu.add(time_submenu);
        rkg_visible_options.add(time_submenu);

        JMenuItem minutes_button = new JMenuItem("Minutes");
        minutes_button.addActionListener(e -> {

        });
        time_submenu.add(minutes_button);
        minutes_button.setEnabled(false); // TODO: Minutes button

        JMenuItem seconds_button = new JMenuItem("Seconds");
        seconds_button.addActionListener(e -> {

        });
        time_submenu.add(seconds_button);
        seconds_button.setEnabled(false); // TODO: Seconds button

        JMenuItem milliseconds_button = new JMenuItem("Milliseconds");
        milliseconds_button.addActionListener(e -> {

        });
        time_submenu.add(milliseconds_button);
        milliseconds_button.setEnabled(false); // TODO: Milliseconds button

        JMenu date_submenu = new JMenu("Date Set");
        edit_menu.add(date_submenu);
        rkg_visible_options.add(date_submenu);

        JMenuItem year_button = new JMenuItem("Year");
        year_button.addActionListener(e -> {

        });
        date_submenu.add(year_button);
        year_button.setEnabled(false); // TODO: Year button

        JMenuItem month_button = new JMenuItem("Month");
        month_button.addActionListener(e -> {

        });
        date_submenu.add(month_button);
        month_button.setEnabled(false); // TODO: Month button

        JMenuItem day_button = new JMenuItem("Day");
        day_button.addActionListener(e -> {

        });
        date_submenu.add(day_button);
        day_button.setEnabled(false); // TODO: Day button

        JMenu location_submenu = new JMenu("Location");
        edit_menu.add(location_submenu);
        rkg_visible_options.add(location_submenu);

        JMenuItem country_button = new JMenuItem("Country");
        country_button.addActionListener(e -> {

        });
        location_submenu.add(country_button);
        country_button.setEnabled(false); // TODO: Country button

        JMenuItem state_button = new JMenuItem("State");
        state_button.addActionListener(e -> {

        });
        location_submenu.add(state_button);
        state_button.setEnabled(false); // TODO: State button

        JMenuItem mii_name_button = new JMenuItem("Mii Name");
        mii_name_button.addActionListener(e -> {

        });
        edit_menu.add(mii_name_button);
        mii_name_button.setVisible(false); // TODO: Mii Name button
        // rkg_visible_options.add(mii_name_button);

        JMenuItem controller_button = new JMenuItem("Controller");
        controller_button.addActionListener(e -> {

        });
        edit_menu.add(controller_button);
        controller_button.setVisible(false); // TODO : Controller button
        // rkg_visible_options.add(controller_button);

        JMenuItem ghost_type_button = new JMenuItem("Ghost Type");
        ghost_type_button.addActionListener(e -> {

        });
        edit_menu.add(ghost_type_button);
        ghost_type_button.setVisible(false); // TODO: Ghost type button
        // rkg_visible_options.add(ghost_type_button);

        JMenuItem unlock_all_button = new JMenuItem("Unlock All");
        unlock_all_button.addActionListener(e -> {

        });
        edit_menu.add(unlock_all_button);
        unlock_all_button.setVisible(false); // TODO: unlock all button
        // rksys_visible_options.add(unlock_all_button);

        // ============================= FILE MENU =============================

        JMenu tools_menu = new JMenu("Tools");
        this.add(tools_menu);

        JMenuItem rename_rkgs_button = new JMenuItem("Rename RKGs");
        rename_rkgs_button.addActionListener(e -> RKGTool.renameRKGs());
        tools_menu.add(rename_rkgs_button);

        // ============================= HELP MENU =============================

        JMenu help_menu = new JMenu("Help");
        this.add(help_menu);

        JMenuItem about_button = new JMenuItem("About");
        about_button.addActionListener(e -> {
            JLabel title = new JLabel("RKG Tool");
            title.putClientProperty(FlatClientProperties.STYLE_CLASS, "h1");
            String version;
            if (RKGTool.implVersion.equals("Test")) {
                version = "Test Build";
            } else {
                version = "Version " + RKGTool.implVersion;
            }
            Object[] dialog_contents = new Object[] {
                    title,
                    version,
                    " ",
                    "Made by Joe",
                    Helper.createLinkLabel("Source", "https://github.com/jblsp/rkg-tool"),
                    Helper.createLinkLabel("License", "https://github.com/jblsp/rkg-tool/blob/master/LICENSE")
            };
            JOptionPane.showMessageDialog(RKGTool.base_frame, dialog_contents, "About", JOptionPane.PLAIN_MESSAGE);
        });
        help_menu.add(about_button);

        // =====================================================================

        this.updateMenubarOptions();
    }

    public void updateMenubarOptions() {
        TabPanel tab;
        try {
            tab = (TabPanel) RKGTool.base_frame.tabbed_pane.getSelectedComponent();
        } catch (NullPointerException e) {
            tab = null;
        }

        // Disable/Hide all dynamic menu elements
        for (JMenuItem jmi : rkg_visible_options) {
            jmi.setVisible(false);
        }
        for (JMenuItem jmi : rksys_visible_options) {
            jmi.setVisible(false);
        }
        for (JMenuItem jmi : any_tab_enabled_options) {
            jmi.setEnabled(false);
        }
        for (JMenuItem jmi : rkg_enabled_options) {
            jmi.setEnabled(false);
        }
        for (JMenuItem jmi : rksys_enabled_options) {
            jmi.setEnabled(false);
        }

        // Show/enable appropriate dynamic menu elements
        if (tab instanceof RKGPanel) {
            for (JComponent jmi : rkg_visible_options) {
                jmi.setVisible(true);
            }
            for (JComponent jmi : rkg_enabled_options) {
                jmi.setEnabled(true);
            }
        } else if (tab instanceof RKSYSPanel) {
            for (JComponent jmi : rksys_visible_options) {
                jmi.setVisible(true);
            }
            for (JMenuItem jmi : rksys_enabled_options) {
                jmi.setEnabled(true);
            }
        } else if (tab != null) {
            for (JComponent jmi : any_tab_enabled_options) {
                jmi.setEnabled(true);
            }
        }
        for (Component m : this.getComponents()) {
            if (m instanceof JMenu) {
                this.disableEmptyMenusR((JMenu) m);
            }
        }
    }

    // disables menus that contain elements that are only disabled or not visible
    private void disableEmptyMenusR(JMenu m) {
        m.setEnabled(false);
        for (Component c : m.getMenuComponents()) {
            if (c instanceof JMenu) {
                this.disableEmptyMenusR((JMenu) c);
                if (c.isVisible() && c.isEnabled() && !m.isEnabled()) {
                    m.setEnabled(true);
                }
            } else if (c.isVisible() && c.isEnabled() && !m.isEnabled()) {
                m.setEnabled(true);
            }
        }
    }
}
