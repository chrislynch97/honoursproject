package uk.co.chris_lynch.honoursproject.network.application;

import java.util.ArrayList;

import static uk.co.chris_lynch.honoursproject.network.application.Constants.*;

public class Neighbourhood {

  private final Neuron centreNeuron;
  private final int radius;
  private final int width;
  private final int maxX;
  private final int maxY;
  private final ArrayList<Neuron> neighbourhood;
  private final ArrayList<Double> weightsW;
  private final ArrayList<Double> weightsM;
  private final Network network;

  public Neighbourhood(final int i, final int j, final Network network, final int radius) {
    this.centreNeuron = network.getNeuron(i, j);
    this.network = network;
    this.maxX = network.getWidth() - 1;
    this.maxY = network.getHeight() - 1;
    this.radius = checkRadius(radius);
    this.width = calculateNeighbourhoodWidth();
    this.neighbourhood = new ArrayList<>(calculateNeighbourhoodSize());
    this.weightsW = new ArrayList<>(neighbourhood.size());
    this.weightsM = new ArrayList<>(neighbourhood.size());

    initNeighbourhood();
    }

  public Neighbourhood(final int i, final int j, final Network network) {
    this(i, j, network, DEFAULT_RADIUS);
  }

  private void initNeighbourhood() {
    for (int col = 0-radius; col < 1+radius; col++)
      for (int row = 0-radius; row < 1+radius; row++) {
        if (row == 0 && col == 0) continue;

        Neuron n = network.getNeuron(
            getCellValue(col, centreNeuron.getI(), maxX),
            getCellValue(row, centreNeuron.getJ(), maxY)
        );

        neighbourhood.add(n);
        weightsW.add(WEIGHT_W);
        weightsM.add(WEIGHT_M);

      }
  }

  private int getCellValue(final int rowCol, int cellValue, final int max) {
    cellValue += rowCol;

    if (cellValue >= max) cellValue = cellValue - max - 1;
    if (cellValue < 0) cellValue = cellValue + max + 1;

    return cellValue;
  }

  private int checkRadius(final int radius) {
    if (network.getWidth() < network.getHeight())
      return (radius < 1 || radius > (network.getWidth()/2)) ? DEFAULT_RADIUS : radius;
    else
      return (radius < 1 || radius > (network.getHeight()/2)) ? DEFAULT_RADIUS : radius;
  }

  private int calculateNeighbourhoodWidth() {
    return (radius*2) + 1;
  }

  private int calculateNeighbourhoodSize() {
    return (width * width) - 1;
  }

  ArrayList<Neuron> getNeighbourhood() {
    return neighbourhood;
  }

  ArrayList<Double> getWeightsW() {
    return weightsW;
  }

  ArrayList<Double> getWeightsM() {
    return weightsM;
  }

  @Override
  public String toString() {
    return neighbourhood.toString();
  }

}