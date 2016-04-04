package sample.model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

import java.io.File;

/**
 * Created by kassava on 03.04.16.
 */
public class ImageStatBuilder {

    File compressedImageFile;
    File initImageFile;
    ImageStat imageStat;


    public ImageStatBuilder(File compressedImageFile) {
        this.compressedImageFile = compressedImageFile;
    }

    public ImageStat getImageStat(File file) {
        initImageFile = file;
        if (this.compressedImageFile != null) {
            computeStat();
        }
        return imageStat;
    }

    private void computeStat() {
        String fileExtension = getFileExtension(compressedImageFile);

        switch (fileExtension) {
            case "jpg":
                computeJpgImageStat();
                break;
            case "raw":
                computeRawImageStat();
                break;
            default:
                break;
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

    /**
     * Computes statistics for image in raw format.
     */
    private void computeRawImageStat() {

    }

    /**
     * Computes statistics for image in jpg format.
     */
    private void computeJpgImageStat() {
        Image image = new Image("file:" + compressedImageFile.getAbsolutePath());

        System.out.println(imageStat.getFilePath());

        PixelReader pixelReader = image.getPixelReader();

        int imageWidth = (int) image.getWidth();
        int imageHeight = (int) image.getHeight();
        Integer[][] byteArray = new Integer[imageHeight][imageWidth];
        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                byteArray[x][y] = (int) (pixelReader.getColor(x, y).getBlue() * 255);
            }
        }

        imageStat = new ImageStat(compressedImageFile.getAbsolutePath(), compressedImageFile.getName(), 0, 0);
    }
}
