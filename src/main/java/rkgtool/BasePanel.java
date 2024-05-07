package rkgtool;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.formdev.flatlaf.FlatClientProperties;

public class BasePanel extends JPanel {

    public BasePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(centerPanel);
        this.add(Box.createVerticalGlue());

        JLabel title = new JLabel("RKG Tool");
        title.putClientProperty(FlatClientProperties.STYLE, "font: +40 $h1.font");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(title);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(buttonPanel);

        JButton open_button = new JButton("Open Files");
        open_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RKGTool.openTabbableFiles();
            }
        });
        buttonPanel.add(open_button);

        JButton rename_button = new JButton("Rename RKGs");
        rename_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RKGTool.renameRKGs();
            }
        });
        buttonPanel.add(rename_button);
    }
}
