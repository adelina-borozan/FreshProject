package tests.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            Path reportsDirectory = Path.of("extent-reports");
            createReportsDirectory(reportsDirectory);

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportsDirectory.resolve("ExtentReport.html").toString());
            reporter.config().setDocumentTitle("FreshProject Test Report");
            reporter.config().setReportName("FreshProject Automation Results");
            reporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Project", "FreshProject");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }

        return extent;
    }

    private static void createReportsDirectory(Path reportsDirectory) {
        try {
            Files.createDirectories(reportsDirectory);
        } catch (IOException e) {
            throw new RuntimeException("Could not create Extent report directory", e);
        }
    }
}
