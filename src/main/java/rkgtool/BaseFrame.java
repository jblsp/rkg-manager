package rkgtool;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BaseFrame extends JFrame {

    TabPane tab_pane = new TabPane();
    MenuBar menu_bar = new MenuBar();

    public BaseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RKG Tool");
        this.setSize(950, 600);
        this.setMinimumSize(new java.awt.Dimension(400, 250));
        this.setLocationRelativeTo(null);

        try {
            this.setIconImage(ImageIO.read(Helper.loadResource("icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setJMenuBar(menu_bar);

        this.add(tab_pane);

        this.setVisible(true);
    }
}
