package uk.co.chris_lynch.honoursproject.network.application;

import java.awt.Color;

public class Neuron {

  private final int i;
  private final int j;
  private final int rgb;

  Neuron(final int i, final int j, final int rgb) {
    this.i = i;
    this.j = j;
    this.rgb = rgb;
  }

  int getI() {
    return this.i;
  }

  int getJ() {
    return this.j;
  }

  public int getRgb() {
    return this.rgb;
  }

  private String getColor() {
    return (new Color( rgb ).getBlue() > 0) ? "white" : "black";
  }

  @Override
  public String toString() {
    return "[" +
        "("+i+','+j+")," +
        getColor() +
        "]";
  }
}