package udemyautomation.resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentReports extendReport = new ExtentReports(); 
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Web test Report");
		sparkReporter.config().setDocumentTitle("Tets Results");
		extendReport.attachReporter(sparkReporter);
		extendReport.setSystemInfo("Engineer", "Bartash Yurii");
		return extendReport;
	}
}
