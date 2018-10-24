package uk.co.chris_lynch.honoursproject;

import uk.co.chris_lynch.honoursproject.network.Neighborhood;
import uk.co.chris_lynch.honoursproject.network.Neuron;

public class Main {

  public static void main(String[] args) {
    new Main().run();
  }

  private void run() {
    Neuron neuron = new Neuron(1,1);
      Neuron[][] neighborhood = Neighborhood.get(neuron, 10, 10);
    for (Neuron[] aNeighborhood : neighborhood) {
      for (Neuron n : aNeighborhood) {
        System.out.print(n.toString() + "\t");
      }
      System.out.println();
    }
  }
}