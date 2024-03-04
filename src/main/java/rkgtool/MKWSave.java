package rkgtool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class MKWSave {
    public static class InvalidSave extends Exception {
        public InvalidSave(String msg) {
            super(msg);
        }
    }

    protected byte[] data;
    String file_identifier;

    public MKWSave(File file) throws IOException, InvalidSave {
        this.data = Files.readAllBytes(file.toPath());
        if (data.length < 4) {
            throw new InvalidSave("File size is less than 4 bytes");
        }
        byte[] file_identifier_bytes = Arrays.copyOfRange(this.data, 0x0, 0x4);
        file_identifier = new String(file_identifier_bytes, java.nio.charset.StandardCharsets.US_ASCII);
    }
}
