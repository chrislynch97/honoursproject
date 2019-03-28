package uk.co.chris_lynch.honoursproject.network.application;

import java.util.ArrayList;

import static uk.co.chris_lynch.honoursproject.network.application.Constants.*;

public class Neighborhood {

  private final Neuron centreNeuron;
  private final int radius;
  private final int width;
  private final int maxX;
  private final int maxY;
  private final ArrayList<Neuron> neighborhood;
  private final ArrayList<Double> weightsW;
  private final ArrayList<Double> weightsM;
  private final Network network;

  public Neighborhood(final int i, final int j, final int radius, final Network network) {
    this.centreNeuron = network.getNeuron(i, j);
    this.network = network;
    this.maxX = network.getWidth() - 1;
    this.maxY = network.getHeight() - 1;
    this.radius = checkRadius(radius);
    this.width = calculateNeighborhoodWidth();
    this.neighborhood = new ArrayList<>(calculateNeighborhoodSize());
    this.weightsW = new ArrayList<>(neighborhood.size());
    this.weightsM = new ArrayList<>(neighborhood.size());

    initNeighborhood();
    initWeights();
  }

  private void initNeighborhood() {

    for (int col = 0-radius; col < 1+radius; col++)
      for (int row = 0-radius; row < 1+radius; row++) {
        if (row == 0 && col == 0) continue;

        Neuron n = network.getNeuron(
            getCellValue(col, centreNeuron.getI(), maxX),
            getCellValue(row, centreNeuron.getJ(), maxY)
        );

        neighborhood.add(n);

      }
  }

  private void initWeights() {
    for (int i = 0; i < neighborhood.size(); i++) {
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
    return (radius < 1 || radius > (network.getWidth()/2)) ? 1 : radius;
  }

  private int calculateNeighborhoodWidth() {
    return (radius*2) + 1;
  }

  private int calculateNeighborhoodSize() {
    return (width * width) - 1;
  }

  ArrayList<Neuron> getNeighborhood() {
    return neighborhood;
  }

  ArrayList<Double> getWeightsW() {
    return weightsW;
  }

  ArrayList<Double> getWeightsM() {
    return weightsM;
  }

  @Override
  public String toString() {
    return neighborhood.toString();
  }

}