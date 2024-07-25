package rkgtool;

import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import com.github.weisj.jsvg.attributes.ViewBox;
import com.github.weisj.jsvg.parser.SVGLoader;
import com.github.weisj.jsvg.SVGDocument;

public class Flag extends JPanel {

    public static final Map<Integer, String> CODE_MAP = new HashMap<>();

    private final SVGDocument doc;

    static {
        // Japan
        CODE_MAP.put(1, "jp");

        // Anguilla
        CODE_MAP.put(8, "ai");

        // Antigua and Barbuda
        CODE_MAP.put(9, "ag");

        // Argentina
        CODE_MAP.put(10, "ar");

        // Aruba
        CODE_MAP.put(11, "aw");

        // Bahamas
        CODE_MAP.put(12, "bs");

        // Barbados
        CODE_MAP.put(13, "bb");

        // Belize
        CODE_MAP.put(14, "bz");

        // Bolivia
        CODE_MAP.put(15, "bo");

        // Brazil
        CODE_MAP.put(16, "br");

        // British Virgin Islands
        CODE_MAP.put(17, "vg");

        // Canada
        CODE_MAP.put(18, "ca");

        // Cayman Islands
        CODE_MAP.put(19, "ky");

        // Chile
        CODE_MAP.put(20, "cl");

        // Colombia
        CODE_MAP.put(21, "co");

        // Costa Rica
        CODE_MAP.put(22, "cr");

        // Dominica
        CODE_MAP.put(23, "dm");

        // Dominican Republic
        CODE_MAP.put(24, "do");

        // Ecuador
        CODE_MAP.put(25, "ec");

        // El Salvador
        CODE_MAP.put(26, "sv");

        // French Guiana
        CODE_MAP.put(27, "gf");

        // Grenada
        CODE_MAP.put(28, "gd");

        // Guadeloupe
        CODE_MAP.put(29, "gp");

        // Guatemala
        CODE_MAP.put(30, "gt");

        // Guyana
        CODE_MAP.put(31, "gy");

        // Haiti
        CODE_MAP.put(32, "ht");

        // Honduras
        CODE_MAP.put(33, "hn");

        // Jamaica
        CODE_MAP.put(34, "jm");

        // Martinique
        CODE_MAP.put(35, "mq");

        // Mexico
        CODE_MAP.put(36, "mx");

        // Montserrat
        CODE_MAP.put(37, "ms");

        // Netherlands Antilles
        CODE_MAP.put(38, "nl");

        // Nicaragua
        CODE_MAP.put(39, "ni");

        // Panama
        CODE_MAP.put(40, "pa");

        // Paraguay
        CODE_MAP.put(41, "py");

        // Peru
        CODE_MAP.put(42, "pe");

        // St. Kitts and Nevis
        CODE_MAP.put(43, "kn");

        // St. Lucia
        CODE_MAP.put(44, "lc");

        // St. Vincent and the Grenadines
        CODE_MAP.put(45, "vc");

        // Suriname
        CODE_MAP.put(46, "sr");

        // Trinidad and Tobago
        CODE_MAP.put(47, "tt");

        // Turks and Caicos Islands
        CODE_MAP.put(48, "tc");

        // United States
        CODE_MAP.put(49, "us");

        // Uruguay
        CODE_MAP.put(50, "uy");

        // US Virgin Islands
        CODE_MAP.put(51, "vi");

        // Venezuela
        CODE_MAP.put(52, "ve");

        // Albania
        CODE_MAP.put(64, "al");

        // Australia
        CODE_MAP.put(65, "au");

        // Austria
        CODE_MAP.put(66, "at");

        // Belgium
        CODE_MAP.put(67, "be");

        // Bosnia and Herzegovina
        CODE_MAP.put(68, "ba");

        // Botswana
        CODE_MAP.put(69, "bw");

        // Bulgaria
        CODE_MAP.put(70, "bg");

        // Croatia
        CODE_MAP.put(71, "hr");

        // Cyprus
        CODE_MAP.put(72, "cy");

        // Czech Republic
        CODE_MAP.put(73, "cz");

        // Denmark
        CODE_MAP.put(74, "dk");

        // Estonia
        CODE_MAP.put(75, "ee");

        // Finland
        CODE_MAP.put(76, "fi");

        // France
        CODE_MAP.put(77, "fr");

        // Germany
        CODE_MAP.put(78, "de");

        // Greece
        CODE_MAP.put(79, "gr");

        // Hungary
        CODE_MAP.put(80, "hu");

        // Iceland
        CODE_MAP.put(81, "is");

        // Ireland
        CODE_MAP.put(82, "ie");

        // Italy
        CODE_MAP.put(83, "it");

        // Latvia
        CODE_MAP.put(84, "lv");

        // Lesotho
        CODE_MAP.put(85, "ls");

        // Liechtenstein
        CODE_MAP.put(86, "li");

        // Lithuania
        CODE_MAP.put(87, "lt");

        // Luxembourg
        CODE_MAP.put(88, "lu");

        // F.Y.R of Macedonia
        CODE_MAP.put(89, "mk");

        // Malta
        CODE_MAP.put(90, "mt");

        // Montenegro
        CODE_MAP.put(91, "me");

        // Mozambique
        CODE_MAP.put(92, "mz");

        // Namibia
        CODE_MAP.put(93, "na");

        // Netherlands
        CODE_MAP.put(94, "nl");

        // New Zealand
        CODE_MAP.put(95, "nz");

        // Norway
        CODE_MAP.put(96, "no");

        // Poland
        CODE_MAP.put(97, "pl");

        // Portugal
        CODE_MAP.put(98, "pt");

        // Romania
        CODE_MAP.put(99, "ro");

        // Russia
        CODE_MAP.put(100, "ru");

        // Serbia
        CODE_MAP.put(101, "rs");

        // Slovakia
        CODE_MAP.put(102, "sk");

        // Slovenia
        CODE_MAP.put(103, "si");

        // South Africa
        CODE_MAP.put(104, "za");

        // Spain
        CODE_MAP.put(105, "es");

        // Swaziland
        CODE_MAP.put(106, "sz");

        // Sweden
        CODE_MAP.put(107, "se");

        // Switzerland
        CODE_MAP.put(108, "ch");

        // Turkey
        CODE_MAP.put(109, "tr");

        // United Kingdom
        CODE_MAP.put(110, "gb");

        // Zambia
        CODE_MAP.put(111, "zm");

        // Zimbabwe
        CODE_MAP.put(112, "zw");

        // Azerbaijan
        CODE_MAP.put(113, "az");

        // Mauritania (Islamic Republic of Mauritania)
        CODE_MAP.put(114, "mr");

        // Mali (Republic of Mali)
        CODE_MAP.put(115, "ml");

        // Niger (Republic of Niger)
        CODE_MAP.put(116, "true");

        // Chad (Republic of Chad)
        CODE_MAP.put(117, "td");

        // Sudan (Republic of the Sudan)
        CODE_MAP.put(118, "sd");

        // Eritrea (State of Eritrea)
        CODE_MAP.put(119, "er");

        // Djibouti (Republic of Djibouti)
        CODE_MAP.put(120, "dj");

        // Somalia (Somali Republic)
        CODE_MAP.put(121, "so");

        // Taiwan
        CODE_MAP.put(128, "tw");

        // South Korea
        CODE_MAP.put(136, "kr");

        // Hong Kong
        CODE_MAP.put(144, "hk");

        // Macau
        CODE_MAP.put(145, "mo");

        // Indonesia
        CODE_MAP.put(152, "id");

        // Singapore
        CODE_MAP.put(153, "sg");

        // Thailand
        CODE_MAP.put(154, "th");

        // Philippines
        CODE_MAP.put(155, "ph");

        // Malaysia
        CODE_MAP.put(156, "my");

        // China
        CODE_MAP.put(160, "cn");

        // U.A.E.
        CODE_MAP.put(168, "ae");

        // India
        CODE_MAP.put(169, "in");

        // Egypt
        CODE_MAP.put(170, "eg");

        // Oman
        CODE_MAP.put(171, "om");

        // Qatar
        CODE_MAP.put(172, "qa");

        // Kuwait
        CODE_MAP.put(173, "kw");

        // Saudi Arabia
        CODE_MAP.put(174, "sa");

        // Syria
        CODE_MAP.put(175, "sy");

        // Bahrain
        CODE_MAP.put(176, "bh");

        // Jordan
        CODE_MAP.put(177, "jo");
    }

    public Flag(int country_code) {
        String svg_path = "flags/" + CODE_MAP.get(country_code) + ".svg";
        SVGLoader loader = new SVGLoader();
        System.out.println(svg_path);
        InputStream svg_url = Helper.loadResource(svg_path);
        this.doc = loader.load(svg_url);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_PURE);

        this.doc.render(this, (Graphics2D) g, new ViewBox(0, 0, getWidth(), getHeight()));
    }

}
