package tests.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.nio.file.Path;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(Path.of("extent-reports", "ExtentReport.html").toString());
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
}
