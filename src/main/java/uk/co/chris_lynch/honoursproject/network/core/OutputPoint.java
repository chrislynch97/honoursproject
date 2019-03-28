package uk.co.chris_lynch.honoursproject.network.core;

class OutputPoint {

  private final int timeStep;
  private final double outputField;

  OutputPoint(int timeStep, double outputField) {
    this.timeStep = timeStep;
    this.outputField = outputField;
  }

  int getTimeStep() {
    return timeStep;
  }

  double getOutputField() {
    return outputField;
  }

}