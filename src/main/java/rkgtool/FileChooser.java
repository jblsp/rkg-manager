package rkgtool;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFileChooser {

    static FileNameExtensionFilter rkg_filter = new FileNameExtensionFilter("Ghost Files (*.rkg)", "rkg");
    static FileNameExtensionFilter rksys_filter = new FileNameExtensionFilter("Savegame Files (rksys.dat)",
            "rksys.dat");

    public FileChooser(boolean multi_selection) {
        this.setMultiSelectionEnabled(multi_selection);
        this.setCurrentDirectory(new File(System.getProperty("user.home")));
        this.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    public int showOpenDialog() {
        return this.showOpenDialog(RKGTool.base_frame);
    }

    @Override
    public int showOpenDialog(Component c) {
        if (this.getChoosableFileFilters().length > 1) {
            this.setFileFilter(this.getChoosableFileFilters()[1]);
        }
        return super.showOpenDialog(RKGTool.base_frame);
    }

}
