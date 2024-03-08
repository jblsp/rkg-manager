package rkgtool;

public class RKGPanel extends TabPanel {
    public RKGPanel(RKG rkg) {
        super(rkg);
    }

    public RKG getRKG() {
        return (RKG) this.content;
    }
}
