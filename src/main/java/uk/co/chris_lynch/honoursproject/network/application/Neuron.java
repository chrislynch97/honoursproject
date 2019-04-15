package uk.co.chris_lynch.honoursproject.network.application;

import static uk.co.chris_lynch.honoursproject.network.application.Constants.*;

import java.awt.Color;

public class Neuron {

  private final int i;
  private final int j;
  private final int rgb;

  private Neighbourhood neighbourhood;

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

    previousFeedingField = 0;
    previousLinkingField = 0;
    previousOutputField = 0;
    previousDynamicThreshold = 0;
  }

  public void setNeighbourhood(Neighbourhood neighbourhood) {
    this.neighbourhood = neighbourhood;
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
    return (new Color(rgb).getBlue() > 0) ? 0.0 : 1.0;
  }

  void calculateFeedingField() {
    feedingField = Math.exp(-1.0 * ALPHA * (double) Time.getInstance().getTime()) * previousFeedingField;
    feedingField += getColorDouble();

    int index = 0;
    for (Neuron n : neighbourhood.getNeighbourhood()) {
      feedingField += neighbourhood.getWeightsW().get(index) * n.getPreviousOutputField();
      index++;
    }
  }

  void calculateLinkingField() {
    linkingField = Math.exp(-1.0 * DELTA * (double) Time.getInstance().getTime()) * previousLinkingField;

    int index = 0;
    for (Neuron n : neighbourhood.getNeighbourhood()) {
      linkingField += neighbourhood.getWeightsM().get(index) * n.getPreviousOutputField();
      index++;
    }
  }

  void calculateInternalActivity() {
    internalActivity = feedingField * (1.0 + (BETA * linkingField));
  }

  void calculateOutputField() {
    if (internalActivity > dynamicThreshold)
      outputField = 1.0;
    else
      outputField = 0.0;
  }

  void calculateDynamicThreshold() {
    dynamicThreshold = Math.exp(-1.0 * GAMMA * (double) Time.getInstance().getTime()) * previousDynamicThreshold;
    dynamicThreshold += outputField;
  }

  private double getPreviousOutputField() {
    return previousOutputField;
  }

  double getOutputField() {
    return outputField;
  }

  void setPreviousFeedingField(double previousFeedingField) {
    this.previousFeedingField = previousFeedingField;
  }

  void setPreviousLinkingField(double previousLinkingField) {
    this.previousLinkingField = previousLinkingField;
  }

  void setPreviousOutputField(double previousOutputField) {
    this.previousOutputField = previousOutputField;
  }

  void setPreviousDynamicThreshold(double previousDynamicThreshold) {
    this.previousDynamicThreshold = previousDynamicThreshold;
  }

  double getLinkingField() {
    return linkingField;
  }

  double getFeedingField() {
    return feedingField;
  }

  double getDynamicThreshold() {
    return dynamicThreshold;
  }

  @Override
  public String toString() {
    return "[" +
        "("+i+','+j+")," +
        getColor() +
        "]";
  }

}