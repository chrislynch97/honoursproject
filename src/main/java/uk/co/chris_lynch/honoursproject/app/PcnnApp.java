package uk.co.chris_lynch.honoursproject.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.category.CategoryDataset;
import uk.co.chris_lynch.honoursproject.network.application.InputImage;
import uk.co.chris_lynch.honoursproject.network.core.NeuralSimulation;

import java.awt.Color;

public class PcnnApp extends Application{

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    String image = "image5.png";

    InputImage inputImage = new InputImage(image);

    NeuralSimulation simulation = new NeuralSimulation(inputImage);
    simulation.run();

    CategoryDataset dataset = simulation.createDataset();
    JFreeChart chart = createChart(dataset);
    ChartViewer viewer = new ChartViewer(chart);

    primaryStage.setScene(new Scene(viewer));
    primaryStage.setTitle("Honours Project - Christopher Lynch");
    primaryStage.show();
  }

  private JFreeChart createChart(CategoryDataset dataset) {
    JFreeChart chart = ChartFactory.createLineChart(
        "Time Series",
        "Time",
        "Value",
        dataset);

//    Plot plot = chart.getPlot();
//    plot.setBackgroundPaint(Color.RED);

    return chart;
  }
}