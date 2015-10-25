package bg.tusofia.tools;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import bg.tusofia.models.Dataset;

import java.io.File;

public class FileChooserHelper {
    private static FileChooser.ExtensionFilter extFilterTmp = new FileChooser.ExtensionFilter("Working file (*.tmp)", "*.tmp");
    private static FileChooser.ExtensionFilter extFilterXml = new FileChooser.ExtensionFilter("XML file (*.xml)", "*.xml");

    public static Dataset openFile(Scene scene) {
        //Open file - fileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Compatible files (*.xml, *.tmp)", "*.xml", "*.tmp"));
        File xmlFile = fileChooser.showOpenDialog(scene.getWindow());
        if (xmlFile != null) {
            //Set file data to working file
            System.out.println("Loading file...");
            Dataset dataset = JAXBUtilities.unmarshal(xmlFile);
            if (dataset != null) {
                System.out.println("Dataset loaded...");
                WorkingFile.getInstance().setDataset(dataset);
                WorkingFile.getInstance().setPhysicalFile(xmlFile);
                return dataset;
            }
            PromBox.alert("Error ...", "Invalid file! Syntactical error");
        }
        return null;
    }

    public static boolean saveFile(Dataset dataset, boolean validation) {
        File file = WorkingFile.getInstance().getPhysicalFile();
        boolean result = false;

        if (file != null) {
            if (file.getPath().endsWith("xml") && !validation) {
                PromBox.alert("Validation error", "Validation error.");
                result = false;
            } else {
                result = JAXBUtilities.marshall(file.getPath(), dataset);
            }
        }
        if (result) {
            WorkingFile.getInstance().setChanged(false);
        }
        return result;
    }

    public static boolean saveAsFile(Dataset dataset, Scene scene, boolean validation) {
        //Open file - fileChooser
        FileChooser fileChooser = new FileChooser();
        //Set extension filters
        fileChooser.getExtensionFilters().addAll(extFilterTmp, extFilterXml);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(scene.getWindow());
        WorkingFile.getInstance().setPhysicalFile(file);

        return saveFile(dataset, validation);
    }
}