package rkgtool;

import java.io.File;
import java.io.IOException;

public class RKSYS extends MKWSave {

    public RKSYS(File file) throws IOException, InvalidSave {
        super(file);
        if (!this.file_identifier.equals("RKSD")) {
            throw new InvalidSave("File identifier does not match.");
        }
    }

    public byte[] getMiiData() {
        return "-1".getBytes();
    }
}
