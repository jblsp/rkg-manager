package rkgtool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public abstract class MKWSave {
    public static class InvalidSave extends Exception {
        public InvalidSave(String msg) {
            super(msg);
        }
    }

    protected byte[] data;
    public File file;
    String file_identifier;

    public MKWSave(File file) throws IOException, InvalidSave {
        this.data = Files.readAllBytes(file.toPath());
        if (data.length < 4) {
            throw new InvalidSave("File size is less than 4 bytes");
        }
        this.file = file;
        byte[] file_identifier_bytes = Arrays.copyOfRange(this.data, 0x0, 0x4);
        file_identifier = new String(file_identifier_bytes, java.nio.charset.StandardCharsets.US_ASCII);
    }

    protected static int getData(byte[] data, int offset, int bit_length) {
        return getData(data, offset, 0, bit_length);
    }

    // this function returns bits of length l from the byte at offset o, starting
    // from starting_bit
    // the starting bit must be within the first byte given (< 8)
    static protected int getData(byte[] data, int offset, int starting_bit, int bit_length) {

        // handle the first byte
        int result = Byte.toUnsignedInt(data[offset]) & (0b11111111 >>> starting_bit);

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
                int next_byte = Byte.toUnsignedInt(data[offset]) >>> (8 - remaining_bits);
                result <<= remaining_bits;
                result |= next_byte;
                break;
            } else {
                result <<= 8; // make room for another byte on the right
                result |= Byte.toUnsignedInt(data[offset]);
                remaining_bits -= 8;
                offset += 1;
            }
        }

        return result;
    }
}
