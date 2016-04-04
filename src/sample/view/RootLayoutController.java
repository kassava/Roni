package sample.view;

import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import sample.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kassava on 03.04.16.
 */
public class RootLayoutController {

    // Reference to the main application.
    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Opens a FileChooser to let the user select a folder with images?
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

    @FXML
    private void handleAbout() {

    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
