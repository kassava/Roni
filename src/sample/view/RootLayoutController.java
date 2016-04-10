package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import sample.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kassava on 03.04.16.
 */
public class RootLayoutController {

    @FXML
    private MenuItem menuItem;

    // Reference to the main application.
    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Opens a FileChooser to let the user select images.
     */
    @FXML
    private void handleOpen() {
        FileChooser filesChooser = new FileChooser();

        List<File> imageFiles= new ArrayList<File>();
        imageFiles = filesChooser.showOpenMultipleDialog(mainApp.getPrimaryStage());

        if (imageFiles != null) {
            mainApp.loadImages(imageFiles);
        }
    }

    /**
     * Open init image (the uncompressed image).
     */
    @FXML
    private void handleOpenInitImage() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filters
        FileChooser.ExtensionFilter allImagesFilter = new FileChooser.ExtensionFilter(
                "Images", new String[] {"*.jpg*", "*.png", "*.bmp", "*.raw"});
        FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter(
                "JPG", "*.jpg*");
        FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter(
                "PNG", "*.png*");
        FileChooser.ExtensionFilter bmpFilter = new FileChooser.ExtensionFilter(
                "BMP", "*.bmp*");
        FileChooser.ExtensionFilter rawFilter = new FileChooser.ExtensionFilter(
                "RAW", "*.raw*");

        fileChooser.getExtensionFilters().addAll(allImagesFilter, jpgFilter, pngFilter, bmpFilter, rawFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadInitImage(file);
            menuItem.setDisable(false);
        }
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Широнин А.С. 46 отдел.");
        alert.setHeaderText("Детали...");
        alert.setTitle("Внимание!");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                alert.close();
            }
        });
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
