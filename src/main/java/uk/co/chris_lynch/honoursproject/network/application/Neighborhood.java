package uk.co.chris_lynch.honoursproject.network.application;

import java.util.Arrays;

public class Neighborhood {

  private final Neuron centreNeuron;
  private final int radius;
  private final int width;
  private final int maxX;
  private final int maxY;
  private final Neuron[] neighborhood;
  private final Network network;

  public Neighborhood(final int i, final int j, final int radius, final Network network) {
    this.centreNeuron = network.getNeuron(i, j);
    this.network = network;
    this.maxX = network.getWidth() - 1;
    this.maxY = network.getHeight() - 1;
    this.radius = checkRadius(radius);
    this.width = calculateNeighborhoodWidth();
    this.neighborhood = new Neuron[calculateNeighborhoodSize()];

    initNeighborhood();
  }

  private void initNeighborhood() {
    int index = 0;

    for (int col = 0 - radius; col < 1 + radius; col++) {
      for (int row = 0 - radius; row < 1 + radius; row++) {

        if (row == 0 && col == 0) continue;

        neighborhood[index] = network.getNeuron(
            getCellValue(col, centreNeuron.getI(), maxX),
            getCellValue(row, centreNeuron.getJ(), maxY));

        index++;
      }
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

  @Override
  public String toString() {
    return Arrays.toString(neighborhood);
  }

  public Neuron getCentreNeuron() {
    return centreNeuron;
  }

  public int getRadius() {
    return radius;
  }

  public int getWidth() {
    return width;
  }

  public int getMaxX() {
    return maxX;
  }

  public int getMaxY() {
    return maxY;
  }

  public Neuron[] getNeighborhood() {
    return neighborhood;
  }

  public Network getNetwork() {
    return network;
  }
}