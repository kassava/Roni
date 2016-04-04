package sample.model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kassava on 03.04.16.
 */
public class ImageStatBuilder {

    File file;
    ImageStat imageStat;

    public ImageStatBuilder(File file) {
        this.file = file;

        if (file != null) {
            computeStat();
        }
    }

    public ImageStat getImageStat() {
        return imageStat;
    }

    private void computeStat() {
        String fileExtension = getFileExtension(file);

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
            return fileName.substring(fileName.lastIndexOf(".")+1);
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
        Image image = new Image("file:" + file.getAbsolutePath());
        imageStat = new ImageStat(file.getAbsolutePath(), file.getName(), 0, 0);
        System.out.println(imageStat.getFilePath());

        PixelReader pixelReader = image.getPixelReader();
        System.out.println("width: " + image.getWidth());
        System.out.println("height: " + image.getHeight());
        System.out.println("format: " + pixelReader.getPixelFormat());
        Color color = pixelReader.getColor(0, 0);
        System.out.println(color.getBlue());
        System.out.println(color.getRed());
        System.out.println(color.getGreen());
    }
}
