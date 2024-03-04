package rkgtool;

import javax.swing.*;

public class ErrorFrame extends JFrame {
    public ErrorFrame(Exception e) {
        this.setTitle("Error");
        this.setResizable(false);
        this.setLocationRelativeTo(Main.base_frame);

        JLabel error_msg = new JLabel(e.getMessage());
        this.add(error_msg);

        this.pack();
        this.setVisible(true);
    }
}
