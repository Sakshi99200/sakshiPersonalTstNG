package com.TransBnk.Library;

import java.awt.Desktop;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Properties prop;
	public static WebDriver driver;
	public static FirefoxOptions Fdriver;
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriverWait wait;
	public static ChromeOptions option;
	public static FirefoxOptions firefoxOption;
	public static EdgeOptions Edgeoption;
	public static FirefoxProfile ffprofile;

	// ** to run the script on different browsers and
	// reading the browser value from testng.xml file

	public static WebDriver initializeWebDriver(String browser) throws IOException {
		WebDriver driver = null;
		ChromeOptions option;

		try {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				option = new ChromeOptions();

				option.addArguments("disable-infobars");
				option.addArguments("--disable-notifications");
				option.addArguments("--disable-extensions");
				option.addArguments("--headless");
//				option.setHeadless(false);
				option.addArguments("--disable-gpu");
				option.addArguments("--disable-dev-shm-usage");
				option.addArguments("--no-sandbox");
				option.addArguments("--remote-allow-origins=*");
				option.addArguments("--window-size=1920,1080");
				driver = new ChromeDriver(option);

				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					// Invoke Desktop.browse()
					System.out.println("Desktop browsing is supported on this platform.");

				} else {
					System.err.println("Desktop browsing is not supported on this platform.");

				}

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(UtilityClass.getDatafromPropertyFile("baseURL"));
				// Save the original tab handle
//				driver.manage().deleteAllCookies();
				driver.getTitle();
				System.out.println(driver.getCurrentUrl());
				System.out.println("chrome driver started Succhessfully..!");

			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();

				firefoxOption = new FirefoxOptions();
				driver = new FirefoxDriver(firefoxOption);
				ffprofile = new FirefoxProfile();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				ffprofile.setPreference("dom.webnotifications.enabled", false);
				driver.get(UtilityClass.getDatafromPropertyFile("baseURL"));
				driver.manage().deleteAllCookies();
				driver.getTitle();
				System.out.println(driver.getCurrentUrl());

				System.out.println("Firefox driver started successfully..!");

			} else if (browser.equalsIgnoreCase("edge")) {

				System.out.println("edge");
				WebDriverManager.edgedriver().setup();
				Edgeoption = new EdgeOptions();

				driver = new EdgeDriver(Edgeoption);
				Edgeoption.addArguments("start-maximized"); // open Browser in maximized mode
				Edgeoption.addArguments("disable-infobars"); // disabling infobars
				Edgeoption.addArguments("--disable-notification");
				Edgeoption.addArguments("--disable-extensions"); // disabling extensions
//				Edgeoption.addArguments("--disable-gpu"); // applicable to windows os only
				Edgeoption.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//				Edgeoption.addArguments("--no-sandbox"); // Bypass OS security model
				Edgeoption.addArguments("--remote-debugging-port=9222");
				Edgeoption.addArguments("--remote-allow-origins=*");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(UtilityClass.getDatafromPropertyFile("baseURL"));
				driver.manage().deleteAllCookies();
				driver.getTitle();
				System.out.println(driver.getCurrentUrl());

				System.out.println("Edge driver started successfully..!");

			} else if (browser.equalsIgnoreCase("safari")) {
				System.out.println("safari");

				driver = new SafariDriver();
				System.out.println("safari");

			}

		} catch (IllegalStateException e) {
			System.out.println(e);
			if (driver != null) {
				driver.get("https://sandbox.trusthub.in");

				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			}

		}
		return driver;

	}

	private static int reportCounter = 0;
	private static String reportFilePath;

	public static String getReportFilePath() {
		return reportFilePath;
	}

	public static void setExtentReport() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String timestamp = dateFormat.format(new Date());
		System.out.println("reportCounter value: " + reportCounter); // Add logging statement
		reportCounter++;
		reportFilePath = "AutomationExecutionReport" + reportCounter + "_" + timestamp + ".html";

		spark = new ExtentSparkReporter(reportFilePath);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("TransBnk Test Automation Results Report");
		spark.config().setDocumentTitle("Automation Execution Report");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public void SendExecutionReportInEmail() {
		// Recipient's email ID needs to be mentioned.
		String to = "sakshi.bodhare@techstalwarts.com";
		String cc = "sakshi.bodhare@techstalwarts.com";
//		String cc = "sakshi.bodhare@techstalwarts.com";
		// Sender's email ID needs to be mentioned
		String from = "sakshi.bodhare@techstalwarts.com";
		final String username = "sakshi.bodhare@techstalwarts.com";
		final String password = "zkztrufkmjqfkeqe";
		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";//
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
			// Set Subject: header field
			message.setSubject("Sandbox Automation Testing Execution Report - "
					+ new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date()));
			// Create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			// set the actual message
			messageBodyPart.setText("Hello Team, \r\n" + "\r\n"
					+ "Automated testing conducted on the Sandbox  Server. \r\n" + "\r\n"
					+ "Please find below the summary of the test execution report for the mentioned modules:\r\n"

					+ "\r\n  " + "\r\n" + "\r\nBest Regards," + "\r\n Sakshi Bodhare");

			// Create a multiple message
			MimeMultipart multipart = new MimeMultipart();
			// Set text message part
			multipart.addBodyPart(messageBodyPart);
			// Part two is attachment1 -- Emailable report
			messageBodyPart = new MimeBodyPart();
			String filename = reportFilePath;
			FileDataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			// Send message
			Transport.send(message);
			System.out.println("Sent Email successfully....");
		} catch (MessagingException e) {
			System.out.println("Email not sent");
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

}