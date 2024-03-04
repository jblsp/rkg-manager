package rkgmanager;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.HyperlinkEvent;

public class AboutFrame extends JFrame {

    public AboutFrame() {
        this.setTitle("About");
        this.setResizable(false);
        this.setSize(250, 130);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JEditorPane about_pane = new JEditorPane("text/html",
                "<html><body style='display: flex; justify-content: center; align-items: center;'>" +
                        "<div style='text-align: center; font-size: 14pt;'>" +
                        "Made by Joe<br><br>" +
                        "<a href='https://github.com/jblsp/rkg-manager'>Source</a><br>" +
                        "<a href='https://github.com/jblsp/rkg-manager/blob/master/LICENSE'>License</a>" +
                        "</div></body></html>");
        about_pane.setEditable(false);
        about_pane.setBackground(this.getBackground());
        about_pane.setBorder(null);
        about_pane.setAlignmentY(JEditorPane.CENTER_ALIGNMENT);
        about_pane.addHyperlinkListener(e -> {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    Desktop.getDesktop().browse(e.getURL().toURI());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.add(about_pane);
    }
}
