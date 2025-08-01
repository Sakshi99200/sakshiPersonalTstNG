package com.TransBnk.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.UIDFolder;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SubjectTerm;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TransBnk.Deal.Deal_With_Template;
import com.TransBnk.Deal.Deal_Without_Template;

public class UtilityClass {

	public static WebDriver driver;

	public UtilityClass(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// ** from prop.properties file ** //
//	public static String getDatafromPropertyFile(String key) throws Exception // System.getProperty("user.dir")+"/ExtentReports/extentReport.html"
//	{
//
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/TestData/Config.properties" + "");
//		Properties prop = new Properties();
//		prop.load(file);
//		String value = prop.getProperty(key);
//		return value;
//
//	}

	// **Read Properties from excel file ** //

	private static final String EXCEL_FILE_PATH = System.getProperty("user.dir")
			+ "/TestData/PropertyReader_Sandbox.xlsx";
	private static final String SHEET_NAME = "sheet";

	private static Map<String, String> properties;

	public static void loadExcelProperties() throws IOException {
		properties = new HashMap<>();
		try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
				XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(SHEET_NAME);
			for (Row row : sheet) {
				Cell keyCell = row.getCell(0);
				Cell valueCell = row.getCell(1);
				if (keyCell != null && valueCell != null) {
					String key = getCellValueAsString(keyCell);
					String value = getCellValueAsString(valueCell);
					properties.put(key, value);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("An error occurred while loading Excel properties: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static String getCellValueAsString(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return String.valueOf(cell.getDateCellValue());
			} else {
				// Format numeric value without decimals
				DecimalFormat decimalFormat = new DecimalFormat("#");
				return decimalFormat.format(cell.getNumericCellValue());
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		case BLANK:
			return "";
		default:
			return "";
		}
	}

	public static String getDatafromPropertyFile(String key) throws IOException {
		if (properties == null) {
			loadExcelProperties();
		}
		return properties.get(key);
	}

	public static String captureScreenshot(String testCaseName, WebDriver driver) {

		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "//Screenshots//" + testCaseName + ".png";

		try {
			FileHandler.copy(srcScreenshot, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}

	///////////////// **** TAB******//////////////

	public void switchToTab(int tabIndex) {
		// Get the list of window handles
		Set<String> windowHandles = driver.getWindowHandles();

		// Convert the set to an array and switch to the desired tab
		driver.switchTo().window(windowHandles.toArray()[tabIndex].toString());
	}

	///// **********Mail actions for deal without template************/////

	// read mail and click on review and sign button
	public void ReadMailAnd_ClickOnReviewSignButton_forDealWithoutTemplate()
			throws MessagingException, InterruptedException {
		Thread.sleep(70000);
//		Thread.sleep(2000);

		// Set your email credentials and properties
		String username = "sakshi.bodhare@techstalwarts.com";
		String password = "zkztrufkmjqfkeqe";
		Properties properties = new Properties();
		properties.put("mail.store.protocol", "imaps");
		properties.put("mail.imaps.host", "imap.gmail.com");
		properties.put("mail.imaps.port", "993");
		try {
			// Connect to the mailbox
			Session session = Session.getInstance(properties, null);
			Store store = session.getStore();
			store.connect(username, password);
			String targetSubject = "Sign Agreement Document of - " + Deal_Without_Template.DealRefereneceID;
//			String targetSubject = "Sign Agreement Document of - Deal240820141557";

			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			Message[] messages = inbox.search(new SubjectTerm(targetSubject));
			if (messages.length > 0) {
				Message targetMessage = messages[0];
				String emailContent = getMessageContent(targetMessage);

//				System.out.println(emailContent);
				String firstUrl = getFirstUrlFromMessage(emailContent);

				if (firstUrl != null) {
					System.out.println("Selected URL: " + firstUrl);
					// Open a new tab using JavaScript
					((ChromeDriver) driver).executeScript("window.open();");
					// Switch to the new tab
					switchToTab(1);

					driver.get(firstUrl);

//					driver.navigate().refresh();

					// ** click on send otp button ** //

					Thread.sleep(6000);
					driver.findElement(By.xpath(" //button[contains(.,'Send OTP ')]")).click();

				} else {
					System.err.println("No matching URL found.");
					Assert.fail("No matching URL found.");
				}
			} else {
				System.out.println("No email found with the specified subject.");
				Assert.fail("No email found with the specified subject.");
			}
			inbox.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}

	public String getMessageContent(Message message) throws IOException, MessagingException {
		Object content = message.getContent();
		if (content instanceof Multipart) {
			Multipart multipart = (Multipart) content;
			StringBuilder emailContent = new StringBuilder();
			for (int i = 0; i < multipart.getCount(); i++) {
				BodyPart bodyPart = multipart.getBodyPart(i);
				if (bodyPart.isMimeType("text/html")) {
					emailContent.append(bodyPart.getContent().toString());
				}
			}
			return emailContent.toString();
		} else if (content instanceof String) {
			return content.toString();
		}
		return "";
	}

	public static String getFirstUrlFromMessage(String emailContent) {
		try {
			Document doc = Jsoup.parse(emailContent);
			Elements links = doc.select("a[href^='http://email.click2redirect.me/ls/click?upn=']");
			if (!links.isEmpty()) {
				return links.get(0).attr("href");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/////////////////// **** to enter OTP *****////////////////////

	public static void EnterOTPFrom_Mail(String targetSubject)
			throws MessagingException, IOException, InterruptedException {

		System.out.println("Executing method : EnterOTPFrom_Mail()");

		// Email account details (replace with your own information)
		Thread.sleep(13000);
		String host = "imap.gmail.com";
		String username = "sakshi.bodhare@techstalwarts.com";
		String password = "zkztrufkmjqfkeqe";
//		String targetSubject = "Verification OTP of - " + Deal_With_Template.DealWithtemplate_RefereneceID;

		// Set up properties for IMAP
		Properties properties = new Properties();
		properties.setProperty("mail.imap.ssl.enable", "true");
		properties.setProperty("mail.imap.host", host);
		properties.setProperty("mail.imap.port", "993");

		// Create a session with the properties and authenticate
		Session session = Session.getInstance(properties);
		Store store = session.getStore("imap");
		store.connect(host, username, password);

		// Open the inbox folder
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		// Search for messages with the specified subject
		SubjectTerm searchTerm = new SubjectTerm(targetSubject);
		Message[] messages = inbox.search(searchTerm);
		// Find the most recent email based on sequence number
		Message mostRecentEmail = null;
		int highestSequenceNumber = -1;

		for (Message message : messages) {
			int sequenceNumber = (int) ((UIDFolder) inbox).getUID(message);
			if (sequenceNumber > highestSequenceNumber) {
				highestSequenceNumber = sequenceNumber;
				mostRecentEmail = message;
			}
		}

		if (mostRecentEmail != null) {

			// Get the content
			Object content = mostRecentEmail.getContent();

			if (content instanceof Multipart) {
				// Handle multipart messages if needed
				Multipart multipart = (Multipart) content;

				BodyPart bodyPart = multipart.getBodyPart(0);

//				// Check the content type of the body part
//				String contentType = bodyPart.getContentType();
//				System.out.println("Content Type: " + contentType);
				// Check the content type of the body part
				String contentType = bodyPart.getContentType().toLowerCase(); // Convert to lowercase
//				System.out.println("Content Type: " + contentType);

				if (contentType.startsWith("text/plain") || contentType.startsWith("text/html")) {
					// Assuming plain text or HTML content, extract and process it
					String contents = bodyPart.getContent().toString();
					System.out.println("Email Content: " + contents);

					processContent(contents);

				} else {
					System.out.println("Unsupported content type in multipart: " + contentType);
				}
			} else if (content instanceof String) {
				// Handle simple text content
				String contents = (String) content;
				System.out.println("Email Content: " + contents);

				processContent(contents);

			} else {
				System.err.println("Unsupported content type: " + content.getClass().getName());

				Assert.fail("Unsupported content type: " + content.getClass().getName());
			}
		} else {
			System.err.println("mostRecentEmail is null. No email found with the specified subject: " + targetSubject);
			Assert.fail("mostRecentEmail is null. No email found with the specified subject: " + targetSubject);
		}
	}

	// Extracted method for processing content
	private static void processContent(String contents) throws InterruptedException {
		String otpPattern = "(\\b\\d{6}\\b)";
		Pattern pattern = Pattern.compile(otpPattern);

		Matcher matcher = pattern.matcher(contents);

		if (matcher.find()) {
			String otp = matcher.group(1);
			System.out.println("Extracted OTP: " + otp);

			// enter OTP in otp field
//			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id=\"OTP\"]")).sendKeys(otp);
		} else {
			System.err.println("No OTP found in the email content.");
			Assert.fail("No OTP found in the email content.");
		}
	}

/////********** Mail actions for deal with template ************/////

	// read mail and click on review and sign button
	public void ReadMailAnd_ClickOnReviewSignButton_forDealWithTemplate()
			throws MessagingException, InterruptedException {
		Thread.sleep(40000);
//		Thread.sleep(2000);

		// Set your email credentials and properties
		String username1 = "sakshi.bodhare@techstalwarts.com";
		String password1 = "zkztrufkmjqfkeqe";
		Properties properties1 = new Properties();
		properties1.put("mail.store.protocol", "imaps");
		properties1.put("mail.imaps.host", "imap.gmail.com");
		properties1.put("mail.imaps.port", "993");

		try {
			// Connect to the mailbox
			Session session1 = Session.getInstance(properties1, null);
			Store store1 = session1.getStore();
			store1.connect(username1, password1);
			String targetSubject1 = "Sign Agreement Document of - " + Deal_With_Template.DealWithtemplate_RefereneceID;
			System.out.println("targetsubject" + targetSubject1);

			System.out.println(Deal_With_Template.DealWithtemplate_RefereneceID);
//			String targetSubject = "Sign Agreement Document of - Deal240122110934";

			Folder inbox1 = store1.getFolder("INBOX");
			inbox1.open(Folder.READ_ONLY);
			Message[] messages1 = inbox1.search(new SubjectTerm(targetSubject1));
			if (messages1.length > 0) {
				Message targetMessage1 = messages1[0];
				String emailContent1 = getMessageContent_2(targetMessage1);

//				System.out.println(emailContent1);
				String firstUrl_1 = getFirstUrlFromMessage_2(emailContent1);

				if (firstUrl_1 != null) {
					System.out.println("Selected URL: " + firstUrl_1);
					// Open a new tab using JavaScript
					((ChromeDriver) driver).executeScript("window.open();");
					// Switch to the new tab
					switchToTab(1);
					driver.get(firstUrl_1);

//					driver.navigate().refresh();

					// ** click on send otp button ** //

					Thread.sleep(6000);
					driver.findElement(By.xpath(" //button[contains(.,'Send OTP ')]")).click();

				} else {
					System.err.println("No matching URL found.");
					Assert.fail("No matching URL found.");
				}
			} else {
				System.err.println("No email found with the specified subject." + targetSubject1);
				Assert.fail("No email found with the specified subject." + targetSubject1);

			}
			inbox1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getMessageContent_2(Message message1) throws IOException, MessagingException {

		Object content1 = message1.getContent();
		if (content1 instanceof Multipart) {
			Multipart multipart1 = (Multipart) content1;
			StringBuilder emailContent1 = new StringBuilder();
			for (int i = 0; i < multipart1.getCount(); i++) {
				BodyPart bodyPart1 = multipart1.getBodyPart(i);
				if (bodyPart1.isMimeType("text/html")) {
					emailContent1.append(bodyPart1.getContent().toString());
				}
			}
			return emailContent1.toString();
		} else if (content1 instanceof String) {
			return content1.toString();
		}
		return "";
	}

	public static String getFirstUrlFromMessage_2(String emailContent1) {

		try {
			Document doc1 = Jsoup.parse(emailContent1);
			Elements links1 = doc1.select("a[href^='http://email.click2redirect.me/ls/click?upn=']");
			if (!links1.isEmpty()) {
				return links1.get(0).attr("href");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ** Send Extend report on Mail ** //

	public static void sendReportByEmail(String reportFilePath) {
		// Recipient's email ID needs to be mentioned.
		String to = "sakshi.bodhare@techstalwarts.com";
//		String cc = "sakshi.bodhare@techstalwarts.com, mayur.gangurde@techstalwarts.com";
		String cc = "sakshi.bodhare@techstalwarts.com";

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
		props.put("mail.smtp.port", "25");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));

			// Set Subject: header field
			message.setSubject("Automation TransBnk Test Execution Report : "
					+ new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date()));

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Add the logo as an embedded image
			MimeMultipart multipart = new MimeMultipart();

			// set the actual message
			messageBodyPart.setText("Hello Team, \r\n" + "\r\n"
					+ " Automation Test Execution is done on project 'TransBnk' .\r\n"
					+ "\r\nKindly take a moment to review the attached Automation Test Execution report for an in-depth analysis of our automation test execution \r\n through which we have run entire Test Suite"
					+ "\r\n" + "\r\nBest Regards," + "\r\n");

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment1 -- Emailable report
			messageBodyPart = new MimeBodyPart();
			String filename = reportFilePath;
			FileDataSource source = new FileDataSource(filename);

			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setHeader("Content-Type", "text/html"); // Set content type as HTML

			messageBodyPart.setFileName(new File(filename).getName());
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			// Send message
			Transport.send(message);

			System.out.println("Sent Email successfully....");

		} catch (

		MessagingException e) {
			System.out.println("Email not sent");
			Assert.fail("Email not sent");
			System.out.println(e);
			throw new RuntimeException(e);

		}

	}

	// ----** close driver **----//

	public void CloseDriver() throws InterruptedException {
		Thread.sleep(1500);

		driver.close();

	}

}
