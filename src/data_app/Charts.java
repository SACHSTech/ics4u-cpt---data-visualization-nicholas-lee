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

    public static Parent theBarChart(double can1997, double can2007, double can2017, double world1997, double world2007, double world2017) {

        String[] years = { "1997", "2007", "2017" };
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("HDI Score", 0.0, 1.0, 0.1);
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
                new BarChart.Series("Canada",
                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], can1997),
                    new BarChart.Data(years[1], can2007),
                    new BarChart.Data(years[2], can2017))),
                new BarChart.Series("World",
                    FXCollections.observableArrayList(
                    new BarChart.Data(years[0], world1997),
                    new BarChart.Data(years[1], world2007),
                    new BarChart.Data(years[2], world2017)))
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 20.0);
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
