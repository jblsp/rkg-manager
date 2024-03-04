package rkgmanager;

import javax.swing.*;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.formdev.flatlaf.util.SystemInfo;

public class Main {
    public static void main(String[] args) {

        if (SystemInfo.isMacOS) {
            // enable screen menu bar
            // (moves menu bar from JFrame window to top of screen)
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            // application name used in screen menu bar
            // (in first menu after the "apple" menu)
            System.setProperty("apple.awt.application.name", "RKG Manager");

            // appearance of window title bars
            // possible values:
            // - "system": use current macOS appearance (light or dark)
            // - "NSAppearanceNameAqua": use light appearance
            // - "NSAppearanceNameDarkAqua": use dark appearance
            // (must be set on main thread and before AWT/Swing is initialized;
            // setting it on AWT thread does not work)
            System.setProperty("apple.awt.application.appearance", "system");
        }

        // Linux
        if (SystemInfo.isLinux) {
            // enable custom window decorations
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        }

        FlatOneDarkIJTheme.setup();

        new BaseFrame();
    }
}
