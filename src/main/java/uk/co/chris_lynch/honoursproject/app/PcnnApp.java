package uk.co.chris_lynch.honoursproject.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import uk.co.chris_lynch.honoursproject.network.application.InputImage;
import uk.co.chris_lynch.honoursproject.network.core.NeuralSimulation;

public class PcnnApp extends Application{

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)  {
    InputImage inputImage = new InputImage("image5.png");

    NeuralSimulation simulation = new NeuralSimulation(inputImage);
    CategoryDataset dataset = simulation.run();

    JFreeChart chart = createChart(dataset);
    ChartViewer viewer = new ChartViewer(chart);

    CategoryPlot plot = (CategoryPlot) chart.getPlot();
    CategoryAxis domainAxis = plot.getDomainAxis();
    domainAxis.setTickLabelsVisible(false);

    primaryStage.setScene(new Scene(viewer));
    primaryStage.setTitle("Honours Project - Christopher Lynch");
    primaryStage.show();
  }

  private JFreeChart createChart(CategoryDataset dataset) {
    return ChartFactory.createLineChart(
        "Time Series",
        "Time",
        "Value",
        dataset);
  }

}