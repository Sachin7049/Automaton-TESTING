package Framework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class Reports {

    public static ExtentReports getreportsobject() {

        String reportDir = System.getProperty("user.dir")
                + "\\src\\main\\resources\\report";

        File directory = new File(reportDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String path = reportDir + "\\index.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sachin Rathore");

        return extent;
    }
}
