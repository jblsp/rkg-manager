package rkgtool;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class BaseFrame extends JFrame {

    JMenuBar menu_bar;

    public BaseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RKG Manager");
        this.setSize(900, 400);
        this.setJMenuBar(new MenuBar());
        this.setVisible(true);

        try {
            this.setIconImage(ImageIO.read(new File("src/main/resources/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
