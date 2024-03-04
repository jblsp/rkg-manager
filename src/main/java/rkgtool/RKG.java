package rkgtool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class RKG {

    byte[] data;

    public RKG(String file_path) throws IOException {
        this.data = Files.readAllBytes(Path.of(file_path));
    }

    public int getMinutes() {
        return FileHelper.getData(this.data, 0x04, 7);
    }

    public int getSeconds() {
        return FileHelper.getData(this.data, 0x04, 7, 7);
    }

    public int getMilliseconds() {
        return FileHelper.getData(this.data, 0x05, 6, 10);
    }

    public int getTrackID() {
        return FileHelper.getData(this.data, 0x07, 6);
    }

    public int getVehicleID() {
        return FileHelper.getData(this.data, 0x08, 6);
    }

    public int getCharacterID() {
        return FileHelper.getData(this.data, 0x08, 6, 6);
    }

    public int getYear() {
        return FileHelper.getData(this.data, 0x09, 4, 7);
    }

    public int getMonth() {
        return FileHelper.getData(this.data, 0x0A, 3, 4);
    }

    public int getDay() {
        return FileHelper.getData(this.data, 0x0A, 7, 5);
    }

    public int getControlleriD() {
        return FileHelper.getData(this.data, 0x0B, 4, 4);
    }

    public int getCompressedFlag() {
        return FileHelper.getData(this.data, 0x0C, 4, 1);
    }

    public int getGhostType() {
        return FileHelper.getData(this.data, 0x0C, 7, 7);
    }

    public int getDriftType() {
        return FileHelper.getData(this.data, 0x0D, 6, 1);
    }

    public int getInputDataLength() {
        return FileHelper.getData(this.data, 0x0E, 2 * 8);
    }

    public int getLapCount() {
        return FileHelper.getData(this.data, 0x10, 1 * 8);
    }

    public int getLapMinutes(int lap) {
        int offset = 0x11 + 3 * (lap - 1);
        return FileHelper.getData(this.data, offset, 7);
    }

    public int getLapSeconds(int lap) {
        int offset = 0x11 + 3 * (lap - 1);
        return FileHelper.getData(this.data, offset, 7, 7);
    }

    public int getLapMilliseconds(int lap) {
        int offset = 0x12 + 3 * (lap - 1);
        return FileHelper.getData(this.data, offset, 6, 10);
    }

    public int getCountryCode() {
        return FileHelper.getData(this.data, 0x34, 1 * 8);
    }

    public int getStateCode() {
        return FileHelper.getData(this.data, 0x35, 1 * 8);
    }

    public int getLocationCode() {
        return FileHelper.getData(this.data, 0x36, 2 * 8);
    }

    public String getMiiName() throws UnsupportedEncodingException {
        String name = new String(Arrays.copyOfRange(this.data, 0x3C + 0x2, 0x03C + 0x15 + 1), "UTF-16BE");
        return name.replaceAll("\\x00", "");
    }
}
