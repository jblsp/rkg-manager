package rkgtool;

import javax.swing.JPanel;

interface TabbableFile {

    public String getTabName();

    public JPanel createPanel();
}
