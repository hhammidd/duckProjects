package com.java1.week3.others.exportCountry;

import com.java1.week3.others.exportCountry.service.ExportService;
import com.java1.week3.others.exportCountry.model.ExporterList;

public class MainExporter {
    public static void main(String[] args) {
        ExportService es = new ExportService();
        es.testExporter();
    }
}
