import java.awt.Font;
import java.io.IOException;
import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;

public class GUI {

    public GUI() {
        FlatDarkLaf.setup();
        JFrame frame = new JFrame();
        frame.setSize(500, 120);
        frame.setTitle("RKG Manager");
        try {
            RKG rkg = new RKG("02m08s6962311 EG2K.rkg");
            String time = String.format("%02d:%02d.%03d", rkg.getMinutes(), rkg.getSeconds(), rkg.getMilliseconds());
            String name = rkg.getMiiName();
            String lap1 = String.format("%02d:%02d.%03d", rkg.getLapMinutes(1), rkg.getLapSeconds(1),
                    rkg.getLapMilliseconds(1));
            String lap2 = String.format("%02d:%02d.%03d", rkg.getLapMinutes(2), rkg.getLapSeconds(2),
                    rkg.getLapMilliseconds(2));
            String lap3 = String.format("%02d:%02d.%03d", rkg.getLapMinutes(3), rkg.getLapSeconds(3),
                    rkg.getLapMilliseconds(3));
            String ghost_info = String.format("%s | %s | %s | %s | %s", name, time, lap1, lap2, lap3);
            JLabel ghost_label = new JLabel(ghost_info);
            ghost_label.setHorizontalAlignment(JLabel.CENTER);
            ghost_label.setVerticalAlignment(JLabel.CENTER);
            ghost_label.setFont(new Font("Bahnschrift", Font.BOLD, 18));
            frame.add(ghost_label);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
}
