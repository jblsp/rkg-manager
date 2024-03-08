package rkgtool;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Arrays;

import javax.swing.JOptionPane;

public abstract class MKWSave implements TabbableFile {

    protected byte[] data;
    private File file;
    String file_identifier;

    public MKWSave(File file, String correct_identifier) throws IOException {
        this.data = Files.readAllBytes(file.toPath());
        if (data.length < 4) {
            throw new IOException("File size is less than 4 bytes.");
        }
        this.file = file;
        byte[] file_identifier_bytes = Arrays.copyOfRange(this.data, 0x0, 0x4);
        file_identifier = new String(file_identifier_bytes, java.nio.charset.StandardCharsets.US_ASCII);
        if (!file_identifier.equals(correct_identifier)) {
            throw new IOException("File identifier does not match.");
        }
    }

    public abstract byte[] getMiiData();

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public void setFile(File f) {
        this.file = f;
    }

    public String getMiiName() {
        // Each character is made up of two bytes
        // When we encounter the null character (0x0 0x0) that is the end of the string
        byte[] name_bytes = Arrays.copyOfRange(this.getMiiData(), 0x2, 0x16);
        for (int i = 0x0; i < name_bytes.length - 1; i += 0x2) {
            if (name_bytes[i] == 0 && name_bytes[i + 0x1] == 0) {
                name_bytes = Arrays.copyOfRange(name_bytes, 0x0, i);
                break;
            }
        }
        try {
            String name = new String(name_bytes, "UTF-16BE");
            return name;
        } catch (UnsupportedEncodingException e) {
            String msg = new String("Error reading mii name of file " + this.file.getName() + ":\n" + e.getMessage());
            JOptionPane.showMessageDialog(RKGTool.base_frame, msg, "Error", JOptionPane.ERROR_MESSAGE);
            return " ";
        }
    }

    protected int getData(int offset, int bit_length) {
        return getData(offset, 0, bit_length);
    }

    // this function returns bits of length l from the byte at offset o, starting
    // from starting_bit
    // the starting bit must be within the first byte given (< 8)
    protected int getData(int offset, int starting_bit, int bit_length) {

        // handle the first byte
        int result = Byte.toUnsignedInt(this.data[offset]) & (0b11111111 >>> starting_bit);

        // less than one byte case
        // this case is unique because there is extra data on the right
        if (starting_bit + bit_length < 8) {
            // Just remove the unneeded bits on the left
            return result >>> (8 - (starting_bit + bit_length));
        }

        int remaining_bits = bit_length - (8 - starting_bit);

        offset += 1;

        // handle the rest of the bytes
        while (remaining_bits > 0) {
            if (remaining_bits < 8) {
                int next_byte = Byte.toUnsignedInt(this.data[offset]) >>> (8 - remaining_bits);
                result <<= remaining_bits;
                result |= next_byte;
                break;
            } else {
                result <<= 8; // make room for another byte on the right
                result |= Byte.toUnsignedInt(this.data[offset]);
                remaining_bits -= 8;
                offset += 1;
            }
        }

        return result;
    }

}
