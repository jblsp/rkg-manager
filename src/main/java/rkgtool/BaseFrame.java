package rkgtool;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BaseFrame extends JFrame {

    TabbedPane tabbed_pane = new TabbedPane();
    MenuBar menu_bar = new MenuBar();
    BasePanel base_panel = new BasePanel();

    public BaseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RKG Tool");
        this.setSize(950, 600);
        this.setMinimumSize(new java.awt.Dimension(400, 250));
        this.setLocationRelativeTo(null);

        try {
            this.setIconImage(ImageIO.read(Helper.loadResource("icon.png")));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        this.setJMenuBar(menu_bar);

        this.setContentPane(base_panel);

        this.setVisible(true);
    }

    public void updateContentPane() {
        if (this.tabbed_pane.getComponentCount() == 0
                && !(this.getContentPane() instanceof BasePanel)) {
            this.setContentPane(this.base_panel);
        } else if (this.tabbed_pane.getComponentCount() > 0 && !(this.getContentPane() instanceof TabbedPane)) {
            this.setContentPane(this.tabbed_pane);
        }
    }
}
