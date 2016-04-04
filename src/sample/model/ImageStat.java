package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for iamge statistics.
 *
 * Created by kassava on 03.04.16.
 */
public class ImageStat {

    private final StringProperty filePath;
    private final StringProperty fileName;
    private StringProperty fileExtension;
    private final IntegerProperty decisiveOnSubtractionStat;
    private final IntegerProperty decisiveOnDivisionStat;

    public ImageStat() {
        this(null, null, null, null);
    }

    public ImageStat(String filePath, String fileName, Integer decisiveOnSubtractionStat, Integer decisiveOnDivisionStat) {
        this.filePath = new SimpleStringProperty(filePath);
        this.fileName = new SimpleStringProperty(fileName);
        this.decisiveOnSubtractionStat = new SimpleIntegerProperty(decisiveOnSubtractionStat);
        this.decisiveOnDivisionStat = new SimpleIntegerProperty(decisiveOnDivisionStat);
    }


    public String getFilePath() {
        return filePath.get();
    }

    public StringProperty filePathProperty() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath.set(filePath);
    }

    public int getDecisiveOnSubtractionStat() {
        return decisiveOnSubtractionStat.get();
    }

    public IntegerProperty decisiveOnSubtractionStatProperty() {
        return decisiveOnSubtractionStat;
    }

    public void setDecisiveOnSubtractionStat(int decisiveOnSubtractionStat) {
        this.decisiveOnSubtractionStat.set(decisiveOnSubtractionStat);
    }


    public int getDecisiveOnDivisionStat() {
        return decisiveOnDivisionStat.get();
    }

    public IntegerProperty decisiveOnDivisionStatProperty() {
        return decisiveOnDivisionStat;
    }

    public void setDecisiveOnDivisionStat(int decisiveOnDivisionStat) {
        this.decisiveOnDivisionStat.set(decisiveOnDivisionStat);
    }

    public String getFileName() {
        return fileName.get();
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }


    public String getFileExtension() {
        return fileExtension.get();
    }

    public StringProperty fileExtensionProperty() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension.set(fileExtension);
    }
}
