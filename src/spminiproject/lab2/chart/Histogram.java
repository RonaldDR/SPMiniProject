package spminiproject.lab2.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;

/**
 * This demo shows a simple bar chart created using the
 * {@link XYSeriesCollection} dataset.
 */
public class Histogram extends JFrame {

  public Histogram(final String title, double[] horiz, int[] vert) {
    super(title);
    IntervalXYDataset dataset = createDataset(title, horiz, vert);
    JFreeChart chart = createChart(dataset);
    final ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
    setContentPane(chartPanel);
  }

  public static void generateChart(String desc, double[] horiz, int[] vert) {
    final Histogram chart = new Histogram(desc, horiz, vert);
    chart.pack();
    chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    RefineryUtilities.centerFrameOnScreen(chart);
    chart.setVisible(true);
  }

  private IntervalXYDataset createDataset(String title, double[] horiz, int[] vert) {
    final XYSeries series = new XYSeries(title);
    for (int i = 0; i < horiz.length; i++) {
      series.add(horiz[i], vert[i]);
    }
    final XYSeriesCollection dataset = new XYSeriesCollection(series);
    return dataset;
  }

  private JFreeChart createChart(IntervalXYDataset dataset) {
    final JFreeChart chart = ChartFactory.createHistogram("",
            "Values",
            "Y",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);
    XYPlot plot = (XYPlot) chart.getPlot();
    final IntervalMarker target = new IntervalMarker(0.0, 0.0);
    target.setLabel("Target Range");
    target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
    target.setLabelAnchor(RectangleAnchor.LEFT);
    target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
    target.setPaint(new Color(222, 222, 255, 128));
    plot.addRangeMarker(target, Layer.BACKGROUND);
    return chart;
  }
}
