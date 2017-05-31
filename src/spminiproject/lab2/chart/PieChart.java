package spminiproject.lab2.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

public class PieChart extends JFrame {

  public PieChart(String title, String[] horiz, double[] vert) {
    super(title);
    setContentPane(createDemoPanel(horiz, vert, title));
  }

  private static PieDataset createDataset(String[] horiz, double[] vert) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    for (int i = 0; i < horiz.length; i++) {
      dataset.setValue(horiz[i], vert[i]);
    }
    return dataset;
  }

  private static JFreeChart createChart(PieDataset dataset, String title) {
    JFreeChart chart = ChartFactory.createPieChart(
            title,
            dataset,
            true,
            true,
            true);
    return chart;
  }

  public static JPanel createDemoPanel(String[] horiz, double[] vert, String title) {
    JFreeChart chart = createChart(createDataset(horiz, vert), title);
    return new ChartPanel(chart);
  }

  public static void generateChart(String[] horiz, double[] vert, String desc) {
    PieChart chart = new PieChart(desc, horiz, vert);
    chart.pack();
    chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    RefineryUtilities.centerFrameOnScreen(chart);
    chart.setVisible(true);
  }
}
