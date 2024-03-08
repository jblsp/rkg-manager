package rkgtool;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.formdev.flatlaf.util.SystemInfo;

public class RKGTool {

    static BaseFrame base_frame;
    static String implVersion;

    public static void main(String[] args) {

        implVersion = RKGTool.class.getPackage().getImplementationVersion();
        if (implVersion == null) {
            implVersion = "Test";
        }

        if (SystemInfo.isMacOS) {
            // enable screen menu bar (moves menu bar from JFrame to top of screen)
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            // application name used in screen menu bar
            System.setProperty("apple.awt.application.name", "RKG Tool");

            // sets dark title bar
            System.setProperty("apple.awt.application.appearance", "NSAppearanceNameDarkAqua");
        }

        if (SystemInfo.isLinux) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        }

        FlatOneDarkIJTheme.setup();

        base_frame = new BaseFrame();
    }

    public static void renameRKG(List<RKG> rkgs) {
        JLabel line1 = new JLabel("The following files:");
        line1.putClientProperty(FlatClientProperties.STYLE_CLASS, "h3");
        JLabel line2 = new JLabel("Will be renamed to:");
        line2.putClientProperty(FlatClientProperties.STYLE_CLASS, "h3");

        Object[] dialog_contents = new Object[rkgs.size() * 2 + 3];
        dialog_contents[0] = line1;
        for (int i = 0; i < rkgs.size(); i++) {
            dialog_contents[i + 1] = rkgs.get(i).getFile().getName();
        }
        dialog_contents[rkgs.size() + 1] = " ";
        dialog_contents[rkgs.size() + 2] = line2;
        for (int i = 0; i < rkgs.size(); i++) {
            dialog_contents[i + rkgs.size() + 3] = rkgs.get(i).getFormattedFileName();
        }
        int selection = JOptionPane.showConfirmDialog(RKGTool.base_frame, dialog_contents, "Rename",
                JOptionPane.OK_CANCEL_OPTION);
        if (selection == JOptionPane.OK_OPTION) {
            for (RKG rkg : rkgs) {
                try {
                    rkg.setFile(Helper.renameFile(rkg.getFile(), rkg.getFormattedFileName()));
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
            for (int i = 0; i < RKGTool.base_frame.tab_pane.getTabCount(); i++) {
                Component tab = RKGTool.base_frame.tab_pane.getComponentAt(i);
                if (tab instanceof RKGPanel) {
                    RKGPanel t = (RKGPanel) tab;
                    RKGTool.base_frame.tab_pane.setTitleAt(i,
                            new String(t.getRKG().getFile().getName()));
                }
            }
        }
    }

    public static void openTabbableFiles() {
        FileChooser file_chooser = new FileChooser(true);
        file_chooser.addChoosableFileFilter(FileChooser.rkg_filter);
        file_chooser.addChoosableFileFilter(FileChooser.rksys_filter);

        if (file_chooser.showOpenDialog() == JFileChooser.APPROVE_OPTION) {

            for (File f : file_chooser.getSelectedFiles()) {

                String fname = f.getName();
                String f_ext = fname.substring(fname.lastIndexOf('.') + 1);
                try {
                    switch (f_ext) {
                        case "rkg":
                            base_frame.tab_pane.addTab(new RKG(f));
                            break;
                        case "dat":
                            base_frame.tab_pane.addTab(new RKSYS(f));
                            break;
                        default:
                            throw new IOException("Invalid file extension.");
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(file_chooser, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }
}
