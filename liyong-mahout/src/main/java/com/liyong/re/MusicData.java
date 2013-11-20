package com.liyong.re;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: liyong
 * Date: 13-11-20
 * Time: 下午6:28
 */
public class MusicData {

    Map<String, List<Pair<Integer, Integer>>> musicData = new HashMap<String, List<Pair<Integer, Integer>>>();

    public MusicData() {

    }

    public static void main(String[] args) {
        JFreeChart chart = createChart(createDataset());
        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("/home/liyong/Desktop/fruit.jpg");
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 400, 300, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {}
        }
    }

    private static CategoryDataset createDataset() {
        String series1 = "First";
        String series2 = "Second";
        String series3 = "Third";
        String type1 = "11";
        String type2 = "22";
        String type3 = "33";
        String type4 = "44";
        String type5 = "55";
        String type6 = "66";
        String type7 = "77";
        String type8 = "88";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, series1, type1);
        defaultcategorydataset.addValue(4D, series1, type2);
        defaultcategorydataset.addValue(3D, series1, type3);
        defaultcategorydataset.addValue(5D, series1, type4);
        defaultcategorydataset.addValue(5D, series1, type5);
        defaultcategorydataset.addValue(7D, series1, type6);
        defaultcategorydataset.addValue(7D, series1, type7);
        defaultcategorydataset.addValue(8D, series1, type8);

        defaultcategorydataset.addValue(5D, series2, type1);
        defaultcategorydataset.addValue(7D, series2, type2);
        defaultcategorydataset.addValue(6D, series2, type3);
        defaultcategorydataset.addValue(8D, series2, type4);
        defaultcategorydataset.addValue(4D, series2, type5);
        defaultcategorydataset.addValue(4D, series2, type6);
        defaultcategorydataset.addValue(2D, series2, type7);
        defaultcategorydataset.addValue(1.0D, series2, type8);

        defaultcategorydataset.addValue(4D, series3, type1);
        defaultcategorydataset.addValue(3D, series3, type2);
        defaultcategorydataset.addValue(2D, series3, type3);
        defaultcategorydataset.addValue(3D, series3, type4);
        defaultcategorydataset.addValue(6D, series3, type5);
        defaultcategorydataset.addValue(3D, series3, type6);
        defaultcategorydataset.addValue(4D, series3, type7);
        defaultcategorydataset.addValue(3D, series3, type8);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createLineChart("Line Chart Demo 1",
                "Type",
                "Value",
                categorydataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);
//获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setShapesVisible(true); //series 点（即数据点）可见
        lineandshaperenderer.setSeriesStroke(0, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
                10F, 6F
        }, 0.0F)); //定义series为”First”的（即series1）点之间的连线 ，这里是虚线，默认是直线
        lineandshaperenderer.setSeriesStroke(1, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
                6F, 6F
        }, 0.0F)); //定义series为”Second”的（即series2）点之间的连线
        lineandshaperenderer.setSeriesStroke(2, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
                2.0F, 6F
        }, 0.0F)); //定义series为”Third”的（即series3）点之间的连线
        return jfreechart;
    }
}
