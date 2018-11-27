package uk.co.chris_lynch.honoursproject;

import uk.co.chris_lynch.honoursproject.network.Neighborhood;
import uk.co.chris_lynch.honoursproject.network.Neuron;


public class Main {

  public static void main(String[] args) {
    new Main().run();
  }

  private void run() {

    Neighborhood neighborhood;
    Neuron neuron = new Neuron(0,0);
    int width = 10;
    int height = 10;

    neighborhood = new Neighborhood(neuron, width, height, 1);
    System.out.println(neighborhood.toString());

    neighborhood = new Neighborhood(neuron, width, height);
    System.out.println(neighborhood.toString());

    neighborhood = new Neighborhood(neuron, width, height, 0);
    System.out.println(neighborhood.toString());

    neighborhood = new Neighborhood(neuron, width, height, 2);
    System.out.println(neighborhood.toString());

    neighborhood = new Neighborhood(neuron, width, height, 3);
    System.out.println(neighborhood.toString());
  }
}