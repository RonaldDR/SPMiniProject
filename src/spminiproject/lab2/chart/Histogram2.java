package spminiproject.lab2.chart;

import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ronald j del Rosario
 */
public class Histogram2 extends ApplicationFrame {
    public Histogram2 (String title, double vector[], int intervals,String labelx, String labely) {
        super (title);
        JPanel chartPanel = createPanel (title, vector,intervals, labelx, labely);
        chartPanel.setPreferredSize (new java.awt.Dimension (500, 475));
        setContentPane (chartPanel);
    }
    
    private static IntervalXYDataset createDataset (String title, double vector[], int intervals) {
        HistogramDataset dataset = new HistogramDataset ();
//        double vector [] = {70, 36, 43, 69, 82, 48, 34, 62, 35, 15,
//            59, 139, 46, 37, 42, 30, 55, 56, 36, 82,
//            38, 89, 54, 25, 35, 24, 22, 9, 55, 19};
// In the exercise we are asked to construct a distribution of frequencies of 8 intervals
// That's why we put 8 in the third parameter of addSeries
        dataset.addSeries (title, vector, intervals);
        return dataset;
    }
    private static JFreeChart createChart (IntervalXYDataset dataset,String x, String y) {
        JFreeChart chart = ChartFactory.createHistogram (
                "Histogram",
                x,
                y,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        XYPlot plot = (XYPlot) chart.getPlot ();
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer ();
        renderer.setDrawBarOutline (false);
        try {
            ChartUtilities.saveChartAsJPEG (new File ("C:\\Users\\User\\Desktop\\histogram.jpg"), chart, 500, 475);
        }catch (IOException e){
            System.out.println ("Failed to open file");
        }
        return chart;
    }
    public static JPanel createPanel (String title, double vector[], int intervals, String labelx, String labely) {
        JFreeChart chart = createChart (createDataset (title,vector,intervals), labelx, labely);
        return new ChartPanel (chart);
    }
    public static void generateChart(String title, double vector[], int intervals,String labelx, String labely) {
        Histogram2 histo = new Histogram2 (title, vector, intervals, labelx, labely);
        histo.pack ();
        RefineryUtilities.centerFrameOnScreen (histo);
        histo.setVisible (true);
    }
    public static void main (String [] args) throws IOException {
          double vector [] = {70, 36, 43, 69, 82, 48, 34, 62, 35, 15,
            59, 139, 46, 37, 42, 30, 55, 56, 36, 82,
            38, 89, 54, 25, 35, 24, 22, 9, 55, 19};
        Histogram2.generateChart("Hello", vector, 5, "x-axis", "y-axis");
    }
}
