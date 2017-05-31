package spminiproject.lab2.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

public class VerticalChart extends JFrame {

  public VerticalChart(String applicationTitle, String chartTitle, String[] horiz, int[] vert, int c) {
    super(applicationTitle);
    JFreeChart barChart = ChartFactory.createBarChart(
            chartTitle,
            "x",
            "y",
            createDataset(horiz, vert, c),
            PlotOrientation.VERTICAL,
            true, true, false);
    ChartPanel chartPanel = new ChartPanel(barChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
    setContentPane(chartPanel);
  }

  public static void generateChart(String[] horiz, int[] vert, String desc, int c) {
    VerticalChart chart = new VerticalChart(desc, desc, horiz, vert, c);
    chart.pack();
    chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    RefineryUtilities.centerFrameOnScreen(chart);
    chart.setVisible(true);
  }

  private CategoryDataset createDataset(String[] horiz, int[] vert, int c) {
    final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    String str = "Size: " + c;
    for (int i = 0; i < horiz.length; i++) {
      dataset.addValue(vert[i], str, horiz[i]);
    }
    return dataset;
  }

}
