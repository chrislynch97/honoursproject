package uk.co.chris_lynch.honoursproject.network.application;

public class Network {

  private Neuron[][] network;

  public Network(final InputImage inputImage) {
    createNetwork(inputImage);
  }

  private void createNetwork(final InputImage inputImage) {
    network = new Neuron[inputImage.getWidth()][inputImage.getHeight()];

    for (int i = 0; i < network.length; i++)
      for (int j = 0; j < network[i].length; j++)
        network[i][j] = new Neuron(i, j, inputImage.getPixel(i,j));
  }

  public Neuron getNeuron(final int i, final int j) {
    return network[i][j];
  }

  public int getWidth() {
    return network.length;
  }

  public int getHeight() {
    return network[0].length;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    for (Neuron[] neurons : network) {
      for (Neuron neuron : neurons) {
        s.append(neuron.toString());
      }
      s.append( "\n" );
    }

    return s.toString();
  }
}
