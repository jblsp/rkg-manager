package rkgtool;

import javax.swing.JPanel;

abstract class TabPanel extends JPanel {

    TabbableFile content;

    public TabPanel(TabbableFile f) {
        content = f;
    }
}
