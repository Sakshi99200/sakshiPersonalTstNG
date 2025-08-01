package com.TransBnk.Deal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MobileOTP_DealWithoutTemplate {

	public WebDriver driver;

	public MobileOTP_DealWithoutTemplate(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
    private static final String constantSubjectPart = "AADHAR";

	public static void mobile_otp() throws InterruptedException {
//		Thread.sleep(20000);
//		System.out.println("hi......mobile");
//		try {
//			// Specify the subject of the SMS to filter
//			String smsSubject = "ADHAAR";
//
//			// Build the command to retrieve all SMS messages with the specified subject
//			ProcessBuilder processBuilder = new ProcessBuilder(
//					"C:\\Users\\lenovo\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe", "shell", "content",
//					"query", "--uri", "content://sms/inbox", "--projection", "date,body,subject");
//
//			// Redirect error stream to capture any error messages
//			processBuilder.redirectErrorStream(true);
//
//			// Start the process
//			Process process = processBuilder.start();
//
//			// Read the output of the command
//			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//				String line;
//				long latestTimestamp = 0;
//				String latestMessageBody = null;
//
//				// Iterate through each line of the ADB command output
//				while ((line = reader.readLine()) != null) {
//					System.out.println("ADB Output: " + line); // Print each line
//
//					if (!line.contains(smsSubject)) {
//						continue;
//					} else {
//						System.out.println("message not found");
//					}
//
//					// Extract timestamp and body from each line
//					String[] parts = line.split(",");
//					if (parts.length == 3) {
//						try {
//							long timestamp = Long.parseLong(parts[0].trim());
//							String messageBody = parts[1].trim();
//							String messageSubject = parts[2].trim();
//
//							// Check if the current message has a later timestamp
//							if (timestamp > latestTimestamp && messageSubject.contains(smsSubject)) {
//								System.out.println("Timestamp: " + timestamp); // Print timestamp for debugging
//
//								latestTimestamp = timestamp;
//								latestMessageBody = messageBody;
//							} else {
//								System.out.println("error..");
//							}
//						} catch (NumberFormatException e) {
//							// Handle the case where parsing the timestamp fails (non-numeric characters)
//							System.err.println("Skipping line due to non-numeric timestamp: " + line);
//						}
//					}
//				}
//
//				// Extract OTP from the latest SMS body
//				String otp = extractOTPFromSMS(latestMessageBody);
//				System.out.println(latestMessageBody);
//				System.out.println("OTP: " + otp);
//
//				// Print the entire SMS body of the latest message
//				System.out.println("Latest SMS Body:\n" + latestMessageBody);
//			}
//
//			// Wait for the process to complete
//			int exitCode = process.waitFor();
//			System.out.println("Process exited with code: " + exitCode);
//		} catch (IOException | InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static String extractOTPFromSMS(String smsMessage) {
//		// Check if smsMessage is null
//		if (smsMessage == null) {
//			return null;
//		} else {
//			System.out.println("error ...1");
//		}
//		// Implement logic to extract OTP from the SMS message
//		// Example: Assuming OTP is a 6-digit number
//		Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
//		Matcher matcher = pattern.matcher(smsMessage);
//		if (matcher.find()) {
//			return matcher.group();
//		} else {
//			return null;
//		}
//	}

		///////////////////////////////////////// last minute changes

		try {
			// Specify the subject of the SMS to filter
			String smsSubject = "AADHAR";

			// Build the command to retrieve all SMS messages with the specified subject
			ProcessBuilder processBuilder = new ProcessBuilder(
					"C:\\Users\\lenovo\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe", "shell", "content",
					"query", "--uri", "content://sms/inbox", "--projection", "date,body,subject");

			// Redirect error stream to capture any error messages
			processBuilder.redirectErrorStream(true);

			// Start the process
			Process process = processBuilder.start();

			// Read the output of the command
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String line;
				long latestTimestamp = 0;
				String latestMessageBody = null;

				// Iterate through each line of the ADB command output
				while ((line = reader.readLine()) != null) {
					System.out.println("ADB Output: " + line); // Print each line

					if (!line.contains(smsSubject)) {
						continue;
					} else {
						System.out.println("message not found");
					}

					// Extract timestamp, body, and subject from each line
					String[] parts = line.split(",");
					if (parts.length == 3) {
						try {
							String timestampPart = parts[0].trim();
							// Check if timestampPart is a numeric value
							if (timestampPart.matches("\\d+")) {
								long timestamp = Long.parseLong(timestampPart);
								String messageBody = parts[1].trim();
								String messageSubject = parts[2].trim();

								// Check if the current message has a later timestamp and contains the constant
								// part
								if (timestamp > latestTimestamp && messageSubject.endsWith(constantSubjectPart)) {
									System.out.println("Timestamp: " + timestamp); // Print timestamp for debugging

									latestTimestamp = timestamp;
									latestMessageBody = messageBody;
								}
							} else {
								// Handle the case where the timestamp is not numeric
								System.err.println("Skipping line due to non-numeric timestamp: " + line);
							}
						} catch (NumberFormatException e) {
							// Handle the case where parsing the timestamp fails (non-numeric characters)
							System.err.println("Skipping line due to non-numeric timestamp: " + line);
						}
					}
				}

				// Extract OTP from the latest SMS body
				String otp = extractOTPFromSMS(latestMessageBody);
				System.out.println(latestMessageBody);
				System.out.println("OTP: " + otp);

				// Print the entire SMS body of the latest message
				System.out.println("Latest SMS Body:\n" + latestMessageBody);
			}

			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Process exited with code: " + exitCode);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static String extractOTPFromSMS(String smsMessage) {
		// Check if smsMessage is null
		if (smsMessage == null) {
			return null;
		} else {
			System.out.println("error ...1");
		}
		// Implement logic to extract OTP from the SMS message
		// Example: Assuming OTP is a 6-digit number
		Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
		Matcher matcher = pattern.matcher(smsMessage);
		if (matcher.find()) {
			return matcher.group();
		} else {
			return null;
		}
	}

}
