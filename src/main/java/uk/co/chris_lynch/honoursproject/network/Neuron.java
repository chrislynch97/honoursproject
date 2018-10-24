package uk.co.chris_lynch.honoursproject.network;

public class Neuron {

  private final int i;
  private final int j;

  public Neuron(final int i, final int j) {
    this.i = i;
    this.j = j;
  }

  public int getI() {
    return i;
  }

  public int getJ() {
    return j;
  }

  @Override
  public String toString() {
    return "(" +
        i +
        ',' +
        j +
        '}';
  }
}
