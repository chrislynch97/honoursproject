package uk.co.chris_lynch.honoursproject.network.application;

public class Network {

  private Neuron[][] neurons;

  public Network(final InputImage inputImage) {
    neurons = new Neuron[inputImage.getWidth()][inputImage.getHeight()];

    for (int i = 0; i < neurons.length; i++)
      for (int j = 0; j < neurons[i].length; j++)
        neurons[i][j] = new Neuron(i, j, inputImage.getPixel(i,j));
  }

  public Neuron getNeuron(final int i, final int j) {
    return neurons[i][j];
  }

  public int getWidth() {
    return neurons.length;
  }

  public int getHeight() {
    return neurons[0].length;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();

    for (Neuron[] neurons : neurons) {
      for (Neuron neuron : neurons) {
        s.append(neuron.toString());
      }
      s.append( "\n" );
    }

    return s.toString();
  }

}
