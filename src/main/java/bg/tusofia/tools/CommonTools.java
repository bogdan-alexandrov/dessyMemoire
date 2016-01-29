package bg.tusofia.tools;

public class CommonTools {

    public static String abbreviate(String src, int size) {
        if (src.isEmpty()) {
            return "";
        }
        if (src.length() > size) {
            return src.substring(0, size) + "...";
        } else return src;
    }
}
