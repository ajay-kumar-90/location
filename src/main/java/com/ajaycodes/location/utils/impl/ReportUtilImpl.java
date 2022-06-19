package com.ajaycodes.location.utils.impl;

import com.ajaycodes.location.utils.ReportUtil;
import org.jetbrains.annotations.NotNull;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.lang.Double.valueOf;
import static org.jfree.chart.ChartUtils.saveChartAsJPEG;

@Component
public class ReportUtilImpl implements ReportUtil {
    @Override
    public void generatePieChart(String path, @NotNull List<Object[]> data) throws IOException {
        // Create DefaultPieDataset Object
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Loop List of Object array(List<Object[]) coming from DB
        // And set is as key value in setValue(String, Double) of DefaultPieDataset
        // key - object Array first element(object[0]) & value - object Array second element(object[1])
        // setValue will not override the existing values rather will add new values
        for (Object[] object : data) {
            dataset.setValue(object[0].toString(), valueOf(object[1].toString()));
        }

        // Create Pie Chart 3D using Chart Factory by passing Name and populated dataset
        JFreeChart locationChart = ChartFactory.createPieChart3D("Location Type Report", dataset);

        // save jFreeChart as Jpeg using ChartUtils's saveChartAsJPEG by passing File with location, chart and dimension
        saveChartAsJPEG(new File(path+"/location.jpeg"),locationChart,300,300);
    }
}

