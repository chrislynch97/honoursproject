package uk.co.chris_lynch.honoursproject.network.core;

class OutputPoint {

  private final int timeStep;
  private final double feedingField;
  private final double linkingField;
  private final double internalActivity;
  private final double outputField;
  private final double dynamicThreshold;

  OutputPoint(int timeStep, double feedingField, double linkingField, double internalActivity, double outputField, double dynamicThreshold) {
    this.timeStep = timeStep;
    this.feedingField = feedingField;
    this.linkingField = linkingField;
    this.internalActivity = internalActivity;
    this.outputField = outputField;
    this.dynamicThreshold = dynamicThreshold;
  }

  int getTimeStep() {
    return timeStep;
  }

  double getOutputField() {
    return outputField;
  }

  double getFeedingField() {
    return feedingField;
  }

  double getLinkingField() {
    return linkingField;
  }

  double getInternalActivity() {
    return internalActivity;
  }

  double getDynamicThreshold() {
    return dynamicThreshold;
  }
}
