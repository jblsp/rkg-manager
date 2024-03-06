package rkgtool;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RKG extends MKWSave {

    public RKG(File file) throws IOException, InvalidSave {
        super(file);
        if (!this.file_identifier.equals("RKGD")) {
            throw new InvalidSave("File identifier does not match.");
        }
    }

    public byte[] getMiiData() {
        return Arrays.copyOfRange(this.data, 0x3C, 0x3C + 0x4A + 0x01);
    }

    public int getMinutes() {
        return getData(this.data, 0x04, 7);
    }

    public int getSeconds() {
        return getData(this.data, 0x04, 7, 7);
    }

    public int getMilliseconds() {
        return getData(this.data, 0x05, 6, 10);
    }

    public int getTrackID() {
        return getData(this.data, 0x07, 6);
    }

    public int getVehicleID() {
        return getData(this.data, 0x08, 6);
    }

    public int getCharacterID() {
        return getData(this.data, 0x08, 6, 6);
    }

    public int getYear() {
        return getData(this.data, 0x09, 4, 7);
    }

    public int getMonth() {
        return getData(this.data, 0x0A, 3, 4);
    }

    public int getDay() {
        return getData(this.data, 0x0A, 7, 5);
    }

    public int getControllerID() {
        return getData(this.data, 0x0B, 4, 4);
    }

    public int getCompressedFlag() {
        return getData(this.data, 0x0C, 4, 1);
    }

    public int getGhostType() {
        return getData(this.data, 0x0C, 7, 7);
    }

    public int getDriftType() {
        return getData(this.data, 0x0D, 6, 1);
    }

    public int getInputDataLength() {
        return getData(this.data, 0x0E, 2 * 8);
    }

    public int getLapCount() {
        return getData(this.data, 0x10, 1 * 8);
    }

    public int getLapMinutes(int lap) {
        int offset = 0x11 + 3 * (lap - 1);
        return getData(this.data, offset, 7);
    }

    public int getLapSeconds(int lap) {
        int offset = 0x11 + 3 * (lap - 1);
        return getData(this.data, offset, 7, 7);
    }

    public int getLapMilliseconds(int lap) {
        int offset = 0x12 + 3 * (lap - 1);
        return getData(this.data, offset, 6, 10);
    }

    public int getCountryCode() {
        return getData(this.data, 0x34, 1 * 8);
    }

    public int getStateCode() {
        return getData(this.data, 0x35, 1 * 8);
    }

    public int getLocationCode() {
        return getData(this.data, 0x36, 2 * 8);
    }

    public String getFormattedFileName() {
        return String.format("%02dm%02ds%03d %s.rkg", this.getMinutes(), this.getSeconds(), this.getMilliseconds(),
                this.getMiiName());
    }
}
