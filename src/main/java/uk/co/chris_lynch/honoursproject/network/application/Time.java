package uk.co.chris_lynch.honoursproject.network.application;

import java.time.Instant;

public class Time {

  private static Time instance = null;

  private Instant instant;
  private int time;

  public static Time getInstance() {
    if (instance == null)
      instance = new Time();

    return instance;
  }

  private Time() {
    instant = Instant.now();
    time = instant.getNano();
  }

  int getTime() {
    return time;
  }

  public void updateInstant() {
    instant = Instant.now();
  }

}