package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;
import sample.model.ImageStat;
import sample.model.ImageStatBuilder;

import java.io.File;

public class ImageStatViewController {

    @FXML
    private TableView<ImageStat> imageStatTable;
    @FXML
    private TableColumn<ImageStat, String> fileNameColumn;

    @FXML
    private ImageView compressedImageView;
    @FXML
    private ImageView initImageView;
    @FXML
    private ListView<Double> subtractionListView;
    @FXML
    private ListView<Double> divisionListView;

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
     * after...?
     */
    @FXML
    private void initialize() {
        fileNameColumn.setCellValueFactory(cellData->cellData.getValue().compressedFileNameProperty());

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

            ImageStatBuilder builder = new ImageStatBuilder(imageStat);
            mainApp.fillListViews(builder.getSubLk(), builder.getDivLk());

            // Fill the labels with info from imageStat object.
//            subtractionLabel.setText("-: " + imageStat.getDecisiveOnSubtractionStat());
//            divisionLabel.setText("\\: " + imageStat.getDecisiveOnDivisionStat());
            Image image = new Image("file:" + imageStat.getCompressedImageFilePath());
            compressedImageView.setImage(image);
            image = new Image("file:" + imageStat.getInitImageFilePath());
            initImageView.setImage(image);
        } else {
//            subtractionLabel.setText("");
//            divisionLabel.setText("");
            Image image = new Image("file:Eye_light.png");
            compressedImageView.setImage(image);
            image = new Image("file:chfdbnj6.png");
            initImageView.setImage(image);
        }
    }

    public void setInitImageView(File file) {
        Image image = new Image("file:" + file.getAbsolutePath());
        initImageView.setImage(image);
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
        subtractionListView.setItems(mainApp.getSubtractionList());
        divisionListView.setItems(mainApp.getDivisionList());

//        System.out.println(mainApp.getInitImageList().size());
        if (mainApp.getInitImageList().size() != 0) {
            initImageView.setImage(new Image("file:" + mainApp.getInitImageList().get(0).getAbsolutePath()));
            System.out.println(mainApp.getInitImageList().get(0).getAbsoluteFile());
        }
    }
}
