package uk.co.chris_lynch.honoursproject.network.core;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import uk.co.chris_lynch.honoursproject.network.application.InputImage;
import uk.co.chris_lynch.honoursproject.network.application.Neighborhood;
import uk.co.chris_lynch.honoursproject.network.application.Network;
import uk.co.chris_lynch.honoursproject.network.application.Neuron;
import uk.co.chris_lynch.honoursproject.network.application.Time;

import java.util.ArrayList;

public class NeuralSimulation {

  private ArrayList<OutputPoint> outputPoints;
  private final Network network;

  public NeuralSimulation(final InputImage inputImage) {
    outputPoints = new ArrayList<>();
    network = new Network(inputImage);
    initNeighborhoods();
  }

  public CategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    for (OutputPoint outputPoint : outputPoints) {
//      dataset.addValue(outputPoint.getFeedingField(), "feeding field", String.valueOf(outputPoint.getTimeStep()));
//      dataset.addValue(outputPoint.getLinkingField(), "linking field", String.valueOf(outputPoint.getTimeStep()));
//      dataset.addValue(outputPoint.getInternalActivity(), "internal activity", String.valueOf(outputPoint.getTimeStep()));
      dataset.addValue(outputPoint.getOutputField(), "output field", String.valueOf(outputPoint.getTimeStep()));
//      dataset.addValue(outputPoint.getDynamicThreshold(), "dynamic threshold", String.valueOf(outputPoint.getTimeStep()));
    }

    return dataset;
  }

  public void run() {
    Neuron neuron;

    int timeStepCounter = 0;
    for (int i = 0; i < network.getWidth(); i++) {
      for (int j = 0; j < network.getHeight(); j++) {
        neuron = network.getNeuron(i, j);
        neuron.run();
        outputPoints.add(new OutputPoint(timeStepCounter, neuron.getFeedingField(), neuron.getLinkingField(), neuron.getInternalActivity(), neuron.getOutputField(), neuron.getDynamicThreshold()));
        timeStepCounter++;
        Time.getInstance().updateInstant();
      }
    }
  }

  private void initNeighborhoods() {
    for (int i = 0; i < network.getWidth(); i++)
      for (int j = 0; j < network.getHeight(); j++)
        network.getNeuron(i, j).setNeighborhood(new Neighborhood(i, j, 1, network));
  }
}