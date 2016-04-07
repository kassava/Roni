package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.model.ImageStat;
import sample.view.ImageStatViewController;
import sample.view.RootLayoutController;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<ImageStat> imageStatList = FXCollections.observableArrayList();
    private ObservableList<Double> subtractionList = FXCollections.observableArrayList();
    private ObservableList<Double> divisionList = FXCollections.observableArrayList();
    private ImageStatViewController controller;
    private FXMLLoader loader;
    private File initImageFile;
    private ObservableList<File> initImageList = FXCollections.observableArrayList();

    public Main() {
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Returns the list as an observable list of image's statistic.
     * @return
     */
    public ObservableList<ImageStat> getImageStatList() {
        return imageStatList;
    }

    public ObservableList<Double> getSubtractionList() {
        return subtractionList;
    }

    public ObservableList<Double> getDivisionList() {
        return divisionList;
    }

    public ObservableList<File> getInitImageList() {
        return initImageList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Рони");

        initRootLayout();
        showImageStatView();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showImageStatView() {
        try {
            loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ImageStatView.fxml"));
            AnchorPane imageStatView = loader.load();

            rootLayout.setCenter(imageStatView);

            // Give the controller access to the main app.
            controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadInitImage(File file) {
        initImageFile = file;
        initImageList.removeAll(initImageList);
        initImageList.add(file);

        controller.setInitImageView(file);

        for (ImageStat imageStat : imageStatList) {
            imageStat.setInitImageFilePath(initImageFile.getAbsolutePath());
        }

//        System.out.println(initImageList.get(0).getAbsoluteFile());
    }

    public void loadImages(List<File> imageFiles) {
        System.out.println("count: " + imageFiles.size());
        imageStatList.removeAll(imageStatList);

        for(File compressedImage : imageFiles) {
            imageStatList.add(new ImageStat(initImageFile.getAbsolutePath(),
                    compressedImage.getAbsolutePath()));
        }
    }

    public void fillListViews() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
