package sample.model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import sample.Statistics.Statistic1;

import java.io.*;

/**
 * Created by kassava on 03.04.16.
 */
public class ImageStatBuilder {

    ImageStat imageStat;
    int[][] initImageBytes;
    int[][] compressedImageBytes;


    public ImageStatBuilder(ImageStat imageStat) {
        this.imageStat = imageStat;

        computeStat();
    }

    private void computeStat() {
        String initFileExtension = getFileExtension(imageStat.getInitImageFilePath());
        switch (initFileExtension) {
            case "jpg":
                initImageBytes = getJpgBytes(imageStat.getInitImageFilePath());
                break;
            case "raw":
                initImageBytes = getRawBytes(imageStat.getInitImageFilePath());
                break;
        }

        String compressedFileExtension = getFileExtension(imageStat.getCompressedImageFilePath());
        switch (compressedFileExtension) {
            case "jpg":
                compressedImageBytes = getJpgBytes(imageStat.getCompressedImageFilePath());
                break;
            case "raw":
                compressedImageBytes = getRawBytes(imageStat.getCompressedImageFilePath());
                break;
        }

        makeCalculating();
    }

    /**
     * Gets bytes from jpg image.
     */
    private int[][] getJpgBytes(String imageFilePath) {
        Image image = new Image("file:" + imageFilePath);
        int imageWidth = (int) image.getWidth();
        int imageHeight = (int) image.getHeight();
        int[][] imageBytes = new int[imageHeight][imageWidth];
        PixelReader pixelReader = image.getPixelReader();
        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                imageBytes[x][y] = (int) (pixelReader.getColor(y, x).getBlue() * 255);
            }
        }
        return imageBytes;
    }

    /**
     * Gets bytes from raw image.
     * @return array of bytes
     */
    private int[][] getRawBytes(String imageFilePath) {
        File imageFile = new File(imageFilePath);
        int imageFileSize = (int) imageFile.length();
//        imageFileSize /= 3;
        int[][] imageBytes = new int[(int) Math.sqrt(imageFileSize)][(int) Math.sqrt(imageFileSize)];
        byte[] mirerBytes = new byte[imageFileSize];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(imageFile));
            buf.read(mirerBytes, 0, mirerBytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        for (int x = 0; x < (int) Math.sqrt(imageFileSize); x++) {
            for (int y = 0; y < (int) Math.sqrt(imageFileSize); y++) {
                imageBytes[x][y] =  0xFF & (int) mirerBytes[i++];
            }
        }

        return imageBytes;
    }

    private void makeCalculating() {
        double[] initLk = Statistic1.stat1(initImageBytes);
        double[] compressedLk = Statistic1.stat1(compressedImageBytes);
        double[] subLk = new double[initLk.length];
        for (int idx = 0; idx < initLk.length; idx++) {
            subLk[idx] = initLk[idx] - compressedLk[idx];
            System.out.println(subLk[idx]);
        }
        System.out.println("---");
        double[] divLk = new double[initLk.length];
        for (int idx = 0; idx < initLk.length; idx++) {
            divLk[idx] = initLk[idx] / compressedLk[idx];
            System.out.println(divLk[idx]);
        }
    }

    private static String getFileExtension(String fileName) {
//        String fileName = file.getName();
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

    }
}
