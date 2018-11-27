package uk.co.chris_lynch.honoursproject.network;

public class Neighborhood {

  private final Neuron centerNeuron;
  private final int radius;
  private final int maxX;
  private final int maxY;
  private final Neuron[] neighborhood;
  private final int width;
  private final int size;

  public Neighborhood(final Neuron centerNeuron, final int width, final int height) {
    this(centerNeuron, width, height, 1);
  }

  public Neighborhood(final Neuron centerNeuron, final int width, final int height,int radius) {
    this.centerNeuron = centerNeuron;
    this.maxX = width-1;
    this.maxY = height-1;
    this.radius = checkRadius(radius);
    this.width = calculateNeighborhoodWidth(this.radius);
    this.size = calculateNeighborhoodSize();
    this.neighborhood = new Neuron[size];

    initNeighborhood();
  }

  private void initNeighborhood() {
    int index = 0;

    for (int row = 0-radius; row < 1+radius; row++) {
      for (int col = 0-radius; col < 1+radius; col++) {
        if (row == 0 && col == 0) continue;
        neighborhood[index] = new Neuron(
            getCellValue(col, centerNeuron.getI(), maxX),
            getCellValue(row, centerNeuron.getJ(), maxY));
        index++;
      }
    }
  }

  private int getCellValue(int rowCol, int cellValue, int max) {
    cellValue += rowCol;
    if (cellValue >= max) cellValue = cellValue - max - 1;
    if (cellValue < 0) cellValue = cellValue + max + 1;
    return cellValue;
  }

  private int checkRadius(final int radius) {
    return (radius < 1) ? 1 : radius;
  }

  private int calculateNeighborhoodWidth(final int radius) {
    return (radius*2) + 1;
  }

  private int calculateNeighborhoodSize() {
    return width * width - 1;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    for (Neuron n : neighborhood) {
      s.append(n.toString());
    }
    return s.toString();
  }
}
