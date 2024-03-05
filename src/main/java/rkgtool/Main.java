package rkgtool;

import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.formdev.flatlaf.util.SystemInfo;

public class Main {

    static BaseFrame base_frame;

    public static void main(String[] args) {

        if (SystemInfo.isMacOS) {
            // enable screen menu bar (moves menu bar from JFrame to top of screen)
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            // application name used in screen menu bar
            System.setProperty("apple.awt.application.name", "RKG Tool");

            // sets dark title bar
            System.setProperty("apple.awt.application.appearance", "NSAppearanceNameDarkAqua");
        }

        if (SystemInfo.isLinux) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        }

        FlatOneDarkIJTheme.setup();

        base_frame = new BaseFrame();
        base_frame.menu_bar.updateMenubarOptions();
    }

    public static void openTab() {
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        file_chooser.setFileFilter(new FileNameExtensionFilter("Mario Kart Wii Ghost/Save Files", "rkg", "dat"));
        int return_value = file_chooser.showOpenDialog(null);

        if (return_value == JFileChooser.APPROVE_OPTION) {
            try {
                MKWSave save_file = new RKG(file_chooser.getSelectedFile());
                switch (save_file.file_identifier) {
                    case "RKGD":
                        RKG rkg = (RKG) save_file;
                        JPanel RKGPanel = new RKGPanel(rkg);
                        base_frame.tabbed_pane.addTab("RKG", RKGPanel);
                        break;
                    case "RKSD":
                        throw new MKWSave.InvalidSave("rksys.dat files are not yet supported.");
                }

            } catch (IOException | MKWSave.InvalidSave e) {
                new ErrorFrame(e);
            }
        }
    }

    public static void closeTab(int index) {
        base_frame.tabbed_pane.removeTabAt(index);
    }

}
