package uk.co.chris_lynch.honoursproject.network.core;

import uk.co.chris_lynch.honoursproject.network.application.InputImage;
import uk.co.chris_lynch.honoursproject.network.application.Network;
import uk.co.chris_lynch.honoursproject.network.application.Neighborhood;
import uk.co.chris_lynch.honoursproject.network.application.Neuron;

public class NeuralSimulation {

  public void run(final InputImage inputImage) {
    Network network = new Network(inputImage);

    // initialise neuron neighborhoods
    for (int i = 0; i < network.getWidth(); i++) {
      for (int j = 0; j < network.getHeight(); j++) {
        network.getNeuron(i, j).setNeighborhood(new Neighborhood(i, j, 1, network));
      }
    }

    Neuron neuron;

    for (int i = 0; i < network.getWidth(); i++) {
      for (int j = 0; j < network.getHeight(); j++) {
        neuron = network.getNeuron(i, j);
        neuron.run();
        System.out.println(neuron.getOutputField());
      }
    }
  }
}