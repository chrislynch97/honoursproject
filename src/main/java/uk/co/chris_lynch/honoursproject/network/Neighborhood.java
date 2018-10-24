package uk.co.chris_lynch.honoursproject.network;

public interface Neighborhood {

  static Neuron[][] get(final Neuron neuron, final int maxX, final int maxY) {
    Neuron[][] neighborhood = new Neuron[3][3];

    for (int row = -1; row < 2; row++) {
      for (int col = -1; col < 2; col++) {
        int tempI = neuron.getI();
        int tempJ = neuron.getJ();

        tempI += col;
        if (tempI < 0) tempI = maxX;
        if (tempI >= maxX) tempI = 0;

        tempJ += row;
        if (tempJ < 0) tempJ = maxY;
        if (tempJ >= maxY) tempJ = 0;

        neighborhood[col+1][row+1] = new Neuron(tempI,tempJ);
      }
    }

    return neighborhood;
  }

}
