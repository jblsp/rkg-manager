package rkgtool;

import javax.swing.JPanel;

import java.io.File;

interface TabbableFile {

    public File getFile();

    public void setFile(File f);

    public JPanel createPanel();
}
