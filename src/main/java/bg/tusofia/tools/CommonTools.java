package bg.tusofia.tools;

import bg.tusofia.models.Layout;
import bg.tusofia.models.Typedef;

import java.util.List;
import java.util.stream.Collectors;

public class CommonTools {

    public static String abbreviate(String src, int size) {
        if (src.isEmpty()) {
            return "";
        }
        if (src.length() > size) {
            return src.substring(0, size) + "...";
        } else return src;
    }

    public static List<String> getListOfTypedef() {
        Layout layout = WorkingFile.getInstance().getDataset().getLayout();
        return layout.getTypedef().stream().map(Typedef::getTypename).collect(Collectors.toList());
    }
}
