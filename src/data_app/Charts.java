package data_app;

// Import statements
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class Charts {
    
    // Initialize variables for bar chart
    public static BarChart chart;
    public static CategoryAxis xAxis;
    public static NumberAxis yAxis;

    // Creates bar chart based on parameters
    public static Parent theBarChart(double can1997, double can2007, double can2017, double world1997, double world2007, double world2017) {

        // Creates the x-axis and y-axis
        String[] years = { "1997", "2007", "2017" };
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("HDI Score", 0.0, 1.0, 0.1);

        // Adds data and creates bar chart
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
        chart.setTitle("Bar Chart of Canada vs World HDI");
        return chart;
    }

    // Initialize variables for line chart
    public static final String[] CATEGORIES = { "1997", "2007", "2017"};
    public static LineChart<String, Number> chart2;
    public static CategoryAxis xAxis2;
    public static NumberAxis yAxis2;

    // Creates line chart based on parameters
    public static Parent theLineChart(double can1997, double can2007, double can2017, double world1997, double world2007, double world2017) {

        // Creates title of the chart, x-axis, and y-axis
        xAxis2 = new CategoryAxis();
        yAxis2 = new NumberAxis("HDI Score", 0.0, 1.0, 0.2);
        chart2 = new LineChart<>(xAxis2, yAxis2);
        chart2.setTitle("Line Chart of Canada HDI vs World HDI");
        xAxis2.setLabel("Year");
        yAxis2.setLabel("HDI Score");

        // Adds data and creates line chart
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("World HDI");
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[0], world1997));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[1], world2007));
        series.getData().add(new XYChart.Data<String, Number>(CATEGORIES[2], world2017));
        chart2.getData().add(series);

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Canada HDI");
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[0], can1997));
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[1], can2007));
        series2.getData().add(new XYChart.Data<String, Number>(CATEGORIES[2], can2017));
        chart2.getData().add(series2);
        return chart2;
    }
}