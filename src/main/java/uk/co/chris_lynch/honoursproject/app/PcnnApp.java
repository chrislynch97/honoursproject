package uk.co.chris_lynch.honoursproject.app;

import org.apache.log4j.Logger;
import uk.co.chris_lynch.honoursproject.network.application.InputImage;
import uk.co.chris_lynch.honoursproject.network.core.NeuralSimulation;

public class PcnnApp {

  private static final Logger log = Logger.getLogger(PcnnApp.class.getName());

  public static void main(String[] args) {
    log.info("App started");
    new PcnnApp().run();
  }

  private void run() {
    InputImage inputImage = new InputImage("image4.png");
    new NeuralSimulation().run(inputImage);
  }
}