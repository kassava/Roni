package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;
import sample.model.ImageStat;

public class ImageStatViewController {

    @FXML
    private TableView<ImageStat> imageStatTable;
    @FXML
    private TableColumn<ImageStat, String> fileNameColumn;

    @FXML
    private Label subtractionLabel;
    @FXML
    private Label devisionLabel;
    @FXML
    private ImageView imageView;

    /**
     * Reference to the main application.
     */
    private Main mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ImageStatViewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        fileNameColumn.setCellValueFactory(cellData->cellData.getValue().fileNameProperty());

        // Clear person details.
        showImageStatDetails(null);

        // Listen for selection changes and show the image stat details when changes.
        imageStatTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showImageStatDetails(newValue)
        );
    }

    /**
     * Fills all text fields to show image stats details.
     * If the specified person is null, all text fields are cleared.
     * @param imageStat the image stat or null
     */
    private void showImageStatDetails(ImageStat imageStat) {
        if (imageStat != null) {
            // Fill the labels with info from imageStat object.
            subtractionLabel.setText("-: " + imageStat.getDecisiveOnSubtractionStat());
            devisionLabel.setText("\\: " + imageStat.getDecisiveOnDivisionStat());
            Image image = new Image("file:" + imageStat.getFilePath());
            imageView.setImage(image);
        } else {
            subtractionLabel.setText("");
            devisionLabel.setText("");
            Image image = new Image("file:Eye_light.png");
            imageView.setImage(image);
        }
    }

    @FXML
    private void handleDeleteImageStat() {
        int selectedIndex = imageStatTable.getSelectionModel().getSelectedIndex();
        imageStatTable.getItems().remove(selectedIndex);
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        // Add observable list to the table.
        imageStatTable.setItems(mainApp.getImageStatList());
    }
}
