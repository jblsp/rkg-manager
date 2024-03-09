package rkgtool;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.formdev.flatlaf.FlatClientProperties;

public class BasePanel extends JPanel {

    public BasePanel() {
        JLabel title = new JLabel("RKG Tool");
        title.putClientProperty(FlatClientProperties.STYLE, "font: +40 $h1.font");
        // title.setForeground(new Color(10, 10, 10));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.CENTER);

        JButton open_button = new JButton("Open Files");
        open_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RKGTool.openTabbableFiles();
            }
        });
        this.add(open_button);

        JButton rename_button = new JButton("Rename RKGs");
        rename_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RKGTool.renameRKGs();
            }
        });
        this.add(rename_button);
    }
}
