package uk.co.chris_lynch.honoursproject.network.application;

import static uk.co.chris_lynch.honoursproject.network.Constants.*;

import java.awt.Color;

public class Neuron {

  private final int i;
  private final int j;
  private final int rgb;

  private Neighborhood neighborhood;

  private double feedingField;
  private double previousFeedingField;

  private double linkingField;
  private double previousLinkingField;

  private double internalActivity;

  private double outputField;
  private double previousOutputField;

  private double dynamicThreshold;
  private double previousDynamicThreshold;

  Neuron(final int i, final int j, final int rgb) {
    this.i = i;
    this.j = j;
    this.rgb = rgb;

    feedingField = INITIAL_FEEDING_FIELD;
    previousFeedingField = 0;

    linkingField = INITIAL_LINKING_FIELD;
    previousLinkingField = 0;

    internalActivity = INITIAL_INTERNAL_ACTIVITY;

    outputField = INITIAL_OUTPUT_FIELD;
    previousOutputField = 0;

    dynamicThreshold = INITIAL_DYNAMIC_THRESHOLD;
    previousDynamicThreshold = 0;
  }

  public void setNeighborhood(Neighborhood neighborhood) {
    this.neighborhood = neighborhood;
  }

  int getI() {
    return this.i;
  }

  int getJ() {
    return this.j;
  }

  private String getColor() {
    return (new Color( rgb ).getBlue() > 0) ? "white" : "black";
  }

  private double getColorDouble() {
    return (new Color(rgb).getBlue() > 0) ? 255.0 : 0.0;
  }

  public void run() {
    calculateFeedingField();
    calculateLinkingField();
    calculateInternalActivity();
    calculateOutputField();
    calculateDynamicThreshold();
  }

  private void calculateFeedingField() {
    feedingField = Math.exp(-1.0 * ALPHA * Time.getInstance().getTime()) * previousFeedingField;
    feedingField += getColorDouble();

    int index = 0;
    for (Neuron n : neighborhood.getNeighborhood()) {
      feedingField += neighborhood.getWeightsW().get(index) * n.getPreviousOutputField();
      index++;
    }
  }

  private void calculateLinkingField() {
    linkingField = Math.exp(-1.0 * DELTA * Time.getInstance().getTime()) * previousLinkingField;

    int index = 0;
    for (Neuron n : neighborhood.getNeighborhood()) {
      linkingField += neighborhood.getWeightsM().get(index) * n.getPreviousOutputField();
      index++;
    }
  }

  private void calculateInternalActivity() {
    internalActivity = feedingField * (1 + (BETA * linkingField));
  }

  private void calculateOutputField() {
    if (internalActivity > dynamicThreshold)
      outputField = 1;
    else
      outputField = 0;
  }

  private void calculateDynamicThreshold() {
    dynamicThreshold = Math.exp(-1.0 * GAMMA * Time.getInstance().getTime()) * previousDynamicThreshold;
    dynamicThreshold += outputField;
  }

  public double getOutputField() {
    return outputField;
  }

  private double getPreviousOutputField() {
    return previousOutputField;
  }

  @Override
  public String toString() {
    return "[" +
        "("+i+','+j+")," +
        getColor() +
        "]";
  }
}