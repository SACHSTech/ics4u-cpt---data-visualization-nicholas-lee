package data_app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class Charts {
    
    public static BarChart chart;
    public static CategoryAxis xAxis;
    public static NumberAxis yAxis;

    public static Parent theBarChart() {

        String[] years = { "2007", "2008", "2009" };
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("Units Sold", 0.0d, 3000.0d, 1000.0d);
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
                new BarChart.Series("Apples",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], 567d),
                    new BarChart.Data(years[1], 1292d),
                    new BarChart.Data(years[2], 1292d))),
                new BarChart.Series("Lemons",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], 956),
                    new BarChart.Data(years[1], 1665),
                    new BarChart.Data(years[2], 2559))),
                new BarChart.Series("Oranges",
                                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], 1154),
                    new BarChart.Data(years[1], 1927),
                    new BarChart.Data(years[2], 2774)))
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
        return chart;
    }

    public static LineChart chart2;
    public static NumberAxis xAxis2;
    public static NumberAxis yAxis2;

    public static Parent theLineChart(){
        xAxis2 = new NumberAxis("Values for X-Axis", 0, 3, 1);
        yAxis2 = new NumberAxis("Values for Y-Axis", 0, 3, 1);
        ObservableList<XYChart.Series<Double,Double>> lineChartData =
            FXCollections.observableArrayList(
                new LineChart.Series<>("Series 1",
                                       FXCollections.observableArrayList(
                    new XYChart.Data<>(0.0, 1.0),
                    new XYChart.Data<>(1.2, 1.4),
                    new XYChart.Data<>(2.2, 1.9),
                    new XYChart.Data<>(2.7, 2.3),
                    new XYChart.Data<>(2.9, 0.5))),
                new LineChart.Series<>("Series 2",
                                       FXCollections.observableArrayList(
                    new XYChart.Data<>(0.0, 1.6),
                    new XYChart.Data<>(0.8, 0.4),
                    new XYChart.Data<>(1.4, 2.9),
                    new XYChart.Data<>(2.1, 1.3),
                    new XYChart.Data<>(2.6, 0.9)))
            );
        chart2 = new LineChart(xAxis2, yAxis2, lineChartData);
        return chart2;
    }

}
