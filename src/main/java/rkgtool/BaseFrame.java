package rkgtool;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;

public class BaseFrame extends JFrame {

    JTabbedPane tabbed_pane;
    MenuBar menu_bar;

    public BaseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RKG Tool");
        this.setSize(950, 600);
        this.setMinimumSize(new java.awt.Dimension(400, 250));
        this.setLocationRelativeTo(null);
        menu_bar = new MenuBar();
        this.setJMenuBar(menu_bar);

        try {
            this.setIconImage(ImageIO.read(new File("src/main/resources/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        tabbed_pane = new JTabbedPane();
        this.add(tabbed_pane);

        tabbed_pane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                menu_bar.updateMenubarOptions((JPanel) tabbed_pane.getComponentAt(tabbed_pane.getSelectedIndex()));
            }
        });
        this.setVisible(true);
    }
}
