package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.File;

/**
 * Model class for iamge statistics.
 *
 * Created by kassava on 03.04.16.
 */
public class ImageStat {

    private final StringProperty compressedImageFilePath;
    private StringProperty initImageFilePath;
    private StringProperty compressedFileName;
    private StringProperty initFileName;
    private StringProperty decisiveOnSubtractionStat = new SimpleStringProperty("no stat");
    private StringProperty decisiveOnDivisionStat = new SimpleStringProperty("no stat");

    public ImageStat() {
        this(null, null);
    }

    public ImageStat(String initImageFilePath, String compressedImageFilePath) {
        this.initImageFilePath = new SimpleStringProperty(initImageFilePath);
        this.compressedImageFilePath = new SimpleStringProperty(compressedImageFilePath);

        File file = new File(compressedImageFilePath);
        this.compressedFileName = new SimpleStringProperty(file.getName());

        file = new File(initImageFilePath);
        this.initFileName = new SimpleStringProperty(file.getName());
    }

    public String getCompressedImageFilePath() {
        return compressedImageFilePath.get();
    }

    public StringProperty compressedImageFilePathProperty() {
        return compressedImageFilePath;
    }

    public void setCompressedImageFilePath(String filePath) {
        this.compressedImageFilePath.set(filePath);

        File file = new File(filePath);
        this.compressedFileName = new SimpleStringProperty(file.getName());
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

    public String getCompressedFileName() {
        return compressedFileName.get();
    }

    public StringProperty compressedFileNameProperty() {
        return compressedFileName;
    }

    public void setCompressedImageFileName(String fileName) {
        this.compressedFileName.set(fileName);
    }

    public String getInitFileName() {
        return initFileName.get();
    }

    public StringProperty initFileNameProperty() {
        return initFileName;
    }

    public void setInitFileName(String fileName) {
        this.initFileName.set(fileName);
    }

    public String getInitImageFilePath() {
        return initImageFilePath.get();
    }

    public StringProperty initImageFilePathProperty() {
        return initImageFilePath;
    }

    public void setInitImageFilePath(String initImageFilePath) {
        this.initImageFilePath.set(initImageFilePath);

        File file = new File(initImageFilePath);
        this.initFileName = new SimpleStringProperty(file.getName());
    }
}
