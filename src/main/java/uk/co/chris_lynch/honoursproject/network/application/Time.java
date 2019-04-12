package uk.co.chris_lynch.honoursproject.network.application;

public class Time {

  private static Time instance = null;

  private int time;

  public static Time getInstance() {
    if (instance == null)
      instance = new Time();

    return instance;
  }

  private Time() {
    time = 0;
  }

  int getTime() {
    return time;
  }

  public void updateTime() {
    time++;
  }
}