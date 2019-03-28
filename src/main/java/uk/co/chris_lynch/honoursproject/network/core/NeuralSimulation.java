package uk.co.chris_lynch.honoursproject.network.core;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import uk.co.chris_lynch.honoursproject.network.application.InputImage;
import uk.co.chris_lynch.honoursproject.network.application.Neighborhood;
import uk.co.chris_lynch.honoursproject.network.application.Network;
import uk.co.chris_lynch.honoursproject.network.application.Neuron;
import uk.co.chris_lynch.honoursproject.network.application.Time;

import java.util.ArrayList;

import static uk.co.chris_lynch.honoursproject.network.application.Constants.NEIGHBORHOOD_RADIUS;

public class NeuralSimulation {

  private final Network network;

  public NeuralSimulation(final InputImage inputImage) {
    network = new Network(inputImage);

    // setup neuron neighborhoods
    for (int i = 0; i < network.getWidth(); i++)
      for (int j = 0; j < network.getHeight(); j++)
        network.getNeuron(i, j).setNeighborhood(new Neighborhood(i, j, NEIGHBORHOOD_RADIUS, network));
  }

  public CategoryDataset run() {
    Neuron neuron;
    ArrayList<OutputPoint> outputPoints = new ArrayList<>();
    int timeStepCounter = 0;

    for (int i = 0; i < network.getWidth(); i++) {
      for (int j = 0; j < network.getHeight(); j++) {
        neuron = network.getNeuron(i, j);
        neuron.run();
        outputPoints.add(new OutputPoint(timeStepCounter, neuron.getOutputField()));
        timeStepCounter++;
        Time.getInstance().updateInstant();
      }
    }

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    for (OutputPoint outputPoint : outputPoints)
      dataset.addValue(outputPoint.getOutputField(), "output field", String.valueOf(outputPoint.getTimeStep()));

    return dataset;
  }

}