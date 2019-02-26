package uk.co.chris_lynch.honoursproject.network.core;

import uk.co.chris_lynch.honoursproject.network.application.InputImage;
import uk.co.chris_lynch.honoursproject.network.application.NeuralNet;
import uk.co.chris_lynch.honoursproject.network.application.NeuronNeighborhood;

public class NeuralSimulation {

  public void run() {

    InputImage inputImage = new InputImage("image1.jpg");

    NeuralNet network = new NeuralNet(inputImage);
    System.out.println(network.toString());

    NeuronNeighborhood nn = new NeuronNeighborhood(1, 1, 1, network);
    System.out.println( nn.toString() );
  }
}