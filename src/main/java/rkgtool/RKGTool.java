package rkgtool;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

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

        FlatOneDarkIJTheme.setup();

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

        base_frame = new BaseFrame();
    }

    public static void openTabbableFiles() {
        FileChooser file_chooser = new FileChooser(true);
        file_chooser.addChoosableFileFilter(FileChooser.rkg_filter);
        file_chooser.addChoosableFileFilter(FileChooser.rksys_filter);

        if (file_chooser.showOpenDialog() == JFileChooser.APPROVE_OPTION) {

            List<String> errors = new LinkedList<String>();

            for (File f : file_chooser.getSelectedFiles()) {

                String fname = f.getName();
                String f_ext = fname.substring(fname.lastIndexOf('.') + 1);
                try {
                    switch (f_ext) {
                        case "rkg":
                            base_frame.tabbed_pane.addTab(new RKG(f));
                            break;
                        case "dat":
                            base_frame.tabbed_pane.addTab(new RKSYS(f));
                            break;
                        default:
                            throw new IOException("Invalid file extension.");
                    }

                } catch (IOException ex) {
                    errors.add(f.getName() + ": " + ex.getMessage());
                }
            }
            Helper.showFileErrorsDialog(errors);

        }
    }

    public static void renameRKGs() {
        FileChooser file_chooser = new FileChooser(true);
        file_chooser.addChoosableFileFilter(FileChooser.rkg_filter);
        if (file_chooser.showOpenDialog() == JFileChooser.APPROVE_OPTION) {
            record RKGFilePair(RKG rkg, File file) {
            }
            List<RKGFilePair> valid_rkgs = new LinkedList<RKGFilePair>();
            List<String> errors = new LinkedList<String>();
            for (File f : file_chooser.getSelectedFiles()) {
                try {
                    valid_rkgs.add(new RKGFilePair(new RKG(f), f));
                } catch (IOException ex) {
                    errors.add(f.getName() + ": " + ex.getMessage());
                }
            }
            Helper.showFileErrorsDialog(errors);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel line1 = new JLabel("The following files:");
            line1.putClientProperty(FlatClientProperties.STYLE_CLASS, "h3");
            panel.add(line1);
            for (RKGFilePair entry : valid_rkgs) {
                panel.add(new JLabel(entry.file.getName()));
            }
            panel.add(Box.createVerticalStrut(15));
            JLabel line2 = new JLabel("Will be renamed to:");
            line2.putClientProperty(FlatClientProperties.STYLE_CLASS, "h3");
            panel.add(line2);
            for (RKGFilePair entry : valid_rkgs) {
                panel.add(new JLabel(entry.rkg.getFormattedFileName()));
            }

            int selection = JOptionPane.showConfirmDialog(RKGTool.base_frame, panel, "Rename RKGs",
                    JOptionPane.OK_CANCEL_OPTION);
            if (selection == JOptionPane.OK_OPTION) {
                for (RKGFilePair entry : valid_rkgs) {
                    try {
                        Helper.renameFile(entry.file, entry.rkg.getFormattedFileName());
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }

        }

    }

}
