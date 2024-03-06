package rkgtool;

import java.io.InputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class Helper {

    public static InputStream loadResource(String path) {
        return RKGTool.class.getClassLoader().getResourceAsStream(path);
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
