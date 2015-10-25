package bg.tusofia.tools;

import bg.tusofia.models.Dataset;

import java.io.File;

public class WorkingFile {

    private static final WorkingFile singletonInstance = new WorkingFile();
    private Dataset dataset = null;
    private Boolean isChanged = false;
    private File physicalFile = null;

    //Preventing from instantiating
    private WorkingFile() {

    }

    // Providing Global point of access
    public static WorkingFile getInstance() {
        return singletonInstance;
    }

    public void clear(){
        dataset = new Dataset();
        isChanged = false;
        physicalFile = null;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public Boolean isChanged() {
        return isChanged;
    }

    public void setChanged(Boolean isChanged) {
        this.isChanged = isChanged;
    }

    public File getPhysicalFile() {
        return physicalFile;
    }

    public void setPhysicalFile(File physicalFile) {
        this.physicalFile = physicalFile;
    }
}