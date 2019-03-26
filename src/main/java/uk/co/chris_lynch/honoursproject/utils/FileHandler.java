package uk.co.chris_lynch.honoursproject.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class FileHandler {


  /**
   * Gets {@link java.net.URL} of view with desired name.
   *
   * @param view name of desired view
   * @return    A {@link java.net.URL} object or {@code null} if no
   *            view with this name is found.
   */
  public static URL getViewPath(final String view) {

    return FileHandler.class.getResource("/views/".concat(view).concat(".fxml"));
  }

  /**
   * Converts given {@link java.io.File} into a
   * {@link java.awt.image.BufferedImage}.
   * @param file the {@link java.io.File} to be converted
   * @return    A {@link java.awt.image.BufferedImage} object or {@code null}
   *            if the {@link java.io.File} is not an image.
   */
  public static BufferedImage fileToBufferedImage(File file) {

    try {
      return ImageIO.read(file);
    } catch (IOException e ) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Converts given {@link javafx.scene.image.Image} into
   * a {@link java.awt.image.BufferedImage}.
   * @param image the {@link javafx.scene.image.Image} to be converted
   * @return    A {@link java.awt.image.BufferedImage} object or {@code null}
   *            if the {@link javafx.scene.image.Image} could not be converted.
   */
  public static BufferedImage imageToBufferedImage(final Image image) {

    return SwingFXUtils.fromFXImage(image, null);

  }

  /**
   * Load {@link java.awt.image.BufferedImage} from resources
   * with desired filename.
   * @param filename name of image to load
   * @return    A {@link java.awt.image.BufferedImage} object or
   *            {@code null} if it could not be found.
   */
  public static BufferedImage loadBufferedImage(final String filename) {

    try {
      return ImageIO.read(FileHandler.class.getResource("/".concat(filename)));
    } catch ( IOException e ) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Creates a {@link javafx.stage.FileChooser} for selecting
   * images of type '.png' and '.jpg'.
   * @param title title of the {@link javafx.stage.FileChooser} window
   * @param stage parent {@link javafx.stage.Stage} of the {@link javafx.stage.FileChooser}
   * @return {@link javafx.scene.image.Image} selected by user using {@link javafx.stage.FileChooser}.
   */
  public static Image loadImageChooser(final String title, final Stage stage) {

    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle(title);
    fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
    File file = fileChooser.showOpenDialog(stage);

    if (file!= null) {
      return new Image(file.toURI().toString());
    } else {
      return null;
    }
  }
}
