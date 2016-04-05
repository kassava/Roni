package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for iamge statistics.
 *
 * Created by kassava on 03.04.16.
 */
public class ImageStat {

    private final StringProperty compressedImageFilePath;
    private StringProperty initImageFilePath;
    private StringProperty fileExtension;
    private StringProperty decisiveOnSubtractionStat = new SimpleStringProperty("no stat");
    private StringProperty decisiveOnDivisionStat = new SimpleStringProperty("no stat");

    public ImageStat() {
        this(null, null);
    }

    public ImageStat(String initImageFilePath, String compressedImageFilePath) {
        this.initImageFilePath = new SimpleStringProperty(initImageFilePath);
        this.compressedImageFilePath = new SimpleStringProperty(compressedImageFilePath);
    }

    public String getCompressedImageFilePath() {
        return compressedImageFilePath.get();
    }

    public StringProperty compressedImageFilePathProperty() {
        return compressedImageFilePath;
    }

    public void setCompressedImageFilePath(String filePath) {
        this.compressedImageFilePath.set(filePath);
    }

    public String getDecisiveOnSubtractionStat() {
        return decisiveOnSubtractionStat.get();
    }

    public StringProperty decisiveOnSubtractionStatProperty() {
        return decisiveOnSubtractionStat;
    }

    public void setDecisiveOnSubtractionStat(String decisiveOnSubtractionStat) {
        this.decisiveOnSubtractionStat.set(decisiveOnSubtractionStat);
    }

    public String getDecisiveOnDivisionStat() {
        return decisiveOnDivisionStat.get();
    }

    public StringProperty decisiveOnDivisionStatProperty() {
        return decisiveOnDivisionStat;
    }

    public void setDecisiveOnDivisionStat(String decisiveOnDivisionStat) {
        this.decisiveOnDivisionStat.set(decisiveOnDivisionStat);
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


    public String getInitImageFilePath() {
        return initImageFilePath.get();
    }

    public StringProperty initImageFilePathProperty() {
        return initImageFilePath;
    }

    public void setInitImageFilePath(String initImageFilePath) {
        this.initImageFilePath.set(initImageFilePath);
    }
}
