package rkgtool;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.formdev.flatlaf.util.SystemInfo;

public class Main {

    static BaseFrame base_frame;
    static String implVersion;

    public static void main(String[] args) {

        implVersion = Main.class.getPackage().getImplementationVersion();
        if (implVersion == null) {
            implVersion = "Test";
        }

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

    public static InputStream loadFromClassPath(String path) {
        return Main.class.getClassLoader().getResourceAsStream(path);
    }

    public static JLabel createLinkLabel(String text, String url) {
        JLabel link_label = new JLabel("<html><a href=\"#\">" + text + "</a></html>");
        link_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        link_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException | URISyntaxException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });
        return link_label;
    }

}
