package rkgtool;

import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static File renameFile(File f, String new_name) throws IOException {
        Path old_path = Paths.get(f.getPath());
        Path new_path = old_path.resolveSibling(new_name);
        Files.move(old_path, new_path);
        return new File(new_path.toUri());
    }
}
