package rkgtool;

import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.formdev.flatlaf.util.SystemInfo;

public class Main {

    static JFrame base_frame;

    public static void main(String[] args) {

        if (SystemInfo.isMacOS) {
            // enable screen menu bar (moves menu bar from JFrame to top of screen)
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            // application name used in screen menu bar
            System.setProperty("apple.awt.application.name", "RKG Manager");

            // sets dark title bar
            System.setProperty("apple.awt.application.appearance", "NSAppearanceNameDarkAqua");
        }

        if (SystemInfo.isLinux) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        }

        FlatOneDarkIJTheme.setup();

        base_frame = new BaseFrame();
    }

    public static void openFile() {
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        file_chooser.setFileFilter(new FileNameExtensionFilter("Mario Kart Wii Ghost/Save Files", "rkg", "dat"));
        int return_value = file_chooser.showOpenDialog(null);

        if (return_value == JFileChooser.APPROVE_OPTION) {
            try {
                RKG rkg = new RKG(file_chooser.getSelectedFile());
            } catch (IOException e) {
            } catch (RKG.InvalidRKG e) {

            }
        }
    }
}
