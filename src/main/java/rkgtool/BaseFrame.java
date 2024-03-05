package rkgtool;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class BaseFrame extends JFrame {

    JTabbedPane tabbed_pane;
    MenuBar menu_bar;

    public BaseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RKG Tool");
        this.setSize(950, 600);
        this.setMinimumSize(new java.awt.Dimension(400, 250));
        this.setLocationRelativeTo(null);
        this.menu_bar = new MenuBar();
        this.setJMenuBar(menu_bar);

        try {
            this.setIconImage(ImageIO.read(Main.loadFromClassPath("icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.tabbed_pane = new JTabbedPane();
        tabbed_pane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                menu_bar.updateMenubarOptions();
            }
        });
        this.add(tabbed_pane);

        this.setVisible(true);
    }
}
