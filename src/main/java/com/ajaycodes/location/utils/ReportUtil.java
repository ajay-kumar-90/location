package com.ajaycodes.location.utils;

import java.io.IOException;
import java.util.List;

public interface ReportUtil {
    // path : path to keep jpeg
    // data : data coming from database
    void generatePieChart(String path, List<Object[]> data) throws IOException;
}
