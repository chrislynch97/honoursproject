//package uk.co.chris_lynch.honoursproject.utils;
//
//import org.junit.jupiter.api.Test;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.net.URL;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//class FileHandlerTest {
//
//  @Test
//  void getViewPathTestValid() {
//    URL url = FileHandlerTest.class.getResource("/views/main_view.fxml");
//    URL viewPath = FileHandler.getViewPath("main_view");
//
//    assertEquals(url, viewPath);
//  }
//
//  @Test
//  void getViewPathTestInvalid() {
//    assertNull(FileHandler.getViewPath(("a")));
//  }
//
//  @Test
//  void fileToBufferedImageTestValid() {
//  }
//
//  @Test
//  void imageToBufferedImage() {
//  }
//
//  @Test
//  void loadBufferedImage() {
//  }
//
//  @Test
//  void loadImageChooser() {
//  }
//}