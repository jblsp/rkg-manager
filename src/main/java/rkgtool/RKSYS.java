package rkgtool;

import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

public class RKSYS extends MKWSave {

    public RKSYS(File file) throws IOException {
        super(file, "RKSD");
    }

    @Override
    public JPanel createPanel() {
        return new RKSYSPanel(this);
    }

    @Override
    public byte[] getMiiData() {
        return "-1".getBytes();
    }
}
