package com.TransBnk.testutility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.TransBnk.Deal.AddSignatories_after_generateAgreement;
import com.TransBnk.Deal.Agreement_Pdf_DealWithout_template;
import com.TransBnk.Deal.AutoSign_Signatories_DealWithout_Template;
import com.TransBnk.Deal.Deal_With_Template;
import com.TransBnk.Deal.Deal_With_template_HandlingNegativeScenarios;
import com.TransBnk.Deal.Deal_Without_Template;
import com.TransBnk.Deal.Deal_Without_template_HandlingNegativeScenarios;
import com.TransBnk.Deal.Delete_TemplateFields_RepeatingSection;
import com.TransBnk.Deal.Edit_Delete_AddMultipleSignartories_Sceanrios;
import com.TransBnk.Deal.Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate;
import com.TransBnk.Deal.Edit_Templates;
import com.TransBnk.Deal.Estamp_agreement;
import com.TransBnk.Deal.MakerCheckerFlow_ForSameEntity;
import com.TransBnk.Deal.MobileOTP_DealWithoutTemplate;
import com.TransBnk.Deal.SignAgreementDocument_DealWithoutTemplate;
import com.TransBnk.Deal.Template_Creation;
import com.TransBnk.Deal.VerifyStatusOf_DealAndAgreement;
import com.TransBnk.Library.BaseClass;
import com.TransBnk.Library.LoginPage;
import com.TransBnk.Library.SignupPage;
import com.TransBnk.Library.UtilityClass;
import com.TransBnk.Payouts.Accounts_Master;
import com.TransBnk.Payouts.Add_Bulk_Beneficiary;
import com.TransBnk.Payouts.AxisTrusteePayoutMakerCheckerApprovalType_APIBased_RBL_Bank;
import com.TransBnk.Payouts.AxisTrusteePayoutMakerCheckerApprovalType_Both_RBL_Bank;
import com.TransBnk.Payouts.BoardResolutionPayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank;
import com.TransBnk.Payouts.BoardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank;
import com.TransBnk.Payouts.Bulk_Payout;
import com.TransBnk.Payouts.Bulk_Payout_RBL_Bank;
import com.TransBnk.Payouts.NegativeScenarios_BulkBeneficiary;
import com.TransBnk.Payouts.PayoutMakerChecker2DiffUser;
import com.TransBnk.Payouts.PayoutMakerCheckerDiffEntity;
import com.TransBnk.Payouts.PayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank;
import com.TransBnk.Payouts.PayoutMakerCheckerSameEntity;
import com.TransBnk.Payouts.PayoutMakerCheckerSameEntity_RBLBank;
import com.TransBnk.RiskRadar.CheckDownloadCenterForBankBalance;
import com.TransBnk.RiskRadar.CheckDownloadCenterForTransaction;
import com.TransBnk.RiskRadar.CheckFilterOptionRiskRadar;
import com.TransBnk.RiskRadar.riskRadarBankBalance;
import com.TransBnk.SanityTesting.SanityTestingFlow;
import com.aventstack.extentreports.Status;

public class BaseTest extends BaseClass {

	@BeforeSuite

	@Parameters("browser")

	// reading browser value from testng.xml file

	public void setup(@Optional("chrome") String browser) throws Exception {

		driver = BaseClass.initializeWebDriver("chrome");

		UtilityClass.loadExcelProperties();
	}

	@AfterSuite
	public void teardown() {
//		 driver.quit();
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		setExtentReport();
	}

	@AfterTest
	public void afterTest() throws IOException {
		extent.flush();
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			try {
				Desktop.getDesktop().browse(new File(getReportFilePath()).toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Opening browser is not supported on this platform.");
		}

		// sending Extend report on mail
		 SendExecutionReportInEmail();
	}

	@BeforeMethod
	public void createExtentTest(ITestResult result, Method m) {
		// test=extent.createExtentTest(m.getName());
		test = extent.createTest(m.getName());
	}

	@AfterMethod
	public void captureScreenshot(ITestResult result, Method m) {
//		System.out.println("fail");
		if (result.getStatus() == ITestResult.FAILURE) {
			UtilityClass.captureScreenshot(result.getMethod().getMethodName(), driver);
			test.log(Status.FAIL, m.getName());
		} else {
			test.log(Status.PASS, m.getName());
		}

	}

	public LoginPage loginpage;
	public SignupPage signup;
	public Deal_Without_Template deal_without_template;
	public UtilityClass utilityClass;
	public SignAgreementDocument_DealWithoutTemplate signAgreementDocument_dealwithoutTemplate;
	public MobileOTP_DealWithoutTemplate mobileOTPdocument_dealWithoutTemplate;
	public Deal_With_Template deal_with_template;
	public Template_Creation create_template;
	public Deal_Without_template_HandlingNegativeScenarios deal_without_HandlingNegativeScnarios;
	public Deal_With_template_HandlingNegativeScenarios deal_with_HandlingNegativeScnarios;
	public Agreement_Pdf_DealWithout_template agreement_pdf_dealwithout_template;
	public Estamp_agreement estamp_agreement;
	public VerifyStatusOf_DealAndAgreement verifyStatusOf_dealAndAgreement;
	public AutoSign_Signatories_DealWithout_Template autosign_signatories_dealwithout_template;
	public MakerCheckerFlow_ForSameEntity makercheckerFlow_forsameEntity;
	public Edit_Delete_AddMultipleSignartories_Sceanrios edit_Delete_AddMultipleSignartories_Sceanrios;
	public AddSignatories_after_generateAgreement addsignatories_afterGenerateAgreement;
	public Template_Creation template_creation;
	public Edit_Templates edit_template;
	public Delete_TemplateFields_RepeatingSection delete_templateFields_repeatingSection;
	public Accounts_Master accounts_master;
	public Add_Bulk_Beneficiary add_bulk_beneficiary;
	public Bulk_Payout bulk_payout;
	public NegativeScenarios_BulkBeneficiary negativescenarios_bulkBeneficiary;
	public Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate edit_delete_addMultiple_scenarios_bulkbeneficiary_dealWithtemplate;
	public riskRadarBankBalance riskRadarBankBalance;
	public PayoutMakerCheckerSameEntity payoutMakerCheckerSameEntity;
	public PayoutMakerCheckerDiffEntity payoutMakerCheckerDiffEntity;
	public PayoutMakerChecker2DiffUser payoutMakerChecker2DiffUser;
	public SanityTestingFlow sanityTestingFlow;
	public CheckFilterOptionRiskRadar checkFilterOptionRiskRadar;
	public CheckDownloadCenterForBankBalance checkDownloadCenterForBankBalance;
	public CheckDownloadCenterForTransaction checkDownloadCenterForTransaction;
	public Bulk_Payout_RBL_Bank bulk_payout_rbl_bank;
	public PayoutMakerCheckerSameEntity_RBLBank payoutMakerCheckerSameEntity_RBLBank;
	public PayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank;
	public BoardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank;
	public BoardResolutionPayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank boardResolutionPayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank;
	public AxisTrusteePayoutMakerCheckerApprovalType_Both_RBL_Bank axisTrusteePayoutMakerCheckerApprovalType_Both_RBL_Bank;
	public AxisTrusteePayoutMakerCheckerApprovalType_APIBased_RBL_Bank axisTrusteePayoutMakerCheckerApprovalType_APIBased_RBL_Bank;

	@BeforeClass
	@Parameters("browser")

	public void pageobjects() {

		loginpage = new LoginPage(driver);
		signup = new SignupPage(driver);
		deal_without_template = new Deal_Without_Template(driver);
		utilityClass = new UtilityClass(driver);
		signAgreementDocument_dealwithoutTemplate = new SignAgreementDocument_DealWithoutTemplate(driver);
		mobileOTPdocument_dealWithoutTemplate = new MobileOTP_DealWithoutTemplate(driver);
		deal_with_template = new Deal_With_Template(driver);
		create_template = new Template_Creation(driver);
		deal_without_HandlingNegativeScnarios = new Deal_Without_template_HandlingNegativeScenarios(driver);
		deal_with_HandlingNegativeScnarios = new Deal_With_template_HandlingNegativeScenarios(driver);
		agreement_pdf_dealwithout_template = new Agreement_Pdf_DealWithout_template(driver);
		estamp_agreement = new Estamp_agreement(driver);
		verifyStatusOf_dealAndAgreement = new VerifyStatusOf_DealAndAgreement(driver);
		autosign_signatories_dealwithout_template = new AutoSign_Signatories_DealWithout_Template(driver);
		makercheckerFlow_forsameEntity = new MakerCheckerFlow_ForSameEntity(driver);
		edit_Delete_AddMultipleSignartories_Sceanrios = new Edit_Delete_AddMultipleSignartories_Sceanrios(driver);
		addsignatories_afterGenerateAgreement = new AddSignatories_after_generateAgreement(driver);
		template_creation = new Template_Creation(driver);
		edit_template = new Edit_Templates(driver);
		delete_templateFields_repeatingSection = new Delete_TemplateFields_RepeatingSection(driver);
		accounts_master = new Accounts_Master(driver);
		add_bulk_beneficiary = new Add_Bulk_Beneficiary(driver);
		bulk_payout = new Bulk_Payout(driver);
		negativescenarios_bulkBeneficiary = new NegativeScenarios_BulkBeneficiary(driver);
		edit_delete_addMultiple_scenarios_bulkbeneficiary_dealWithtemplate = new Edit_Delete_AddMultipleSignartories_Sceanrios_DealWithTemplate(
				driver);
		riskRadarBankBalance = new riskRadarBankBalance(driver);
		payoutMakerCheckerSameEntity = new PayoutMakerCheckerSameEntity(driver);
		payoutMakerCheckerDiffEntity = new PayoutMakerCheckerDiffEntity();
		payoutMakerChecker2DiffUser = new PayoutMakerChecker2DiffUser();
		sanityTestingFlow = new SanityTestingFlow(driver);
		checkFilterOptionRiskRadar = new CheckFilterOptionRiskRadar(driver);
		checkDownloadCenterForBankBalance = new CheckDownloadCenterForBankBalance(driver);
		checkDownloadCenterForTransaction = new CheckDownloadCenterForTransaction(driver);
		bulk_payout_rbl_bank = new Bulk_Payout_RBL_Bank(driver);
		payoutMakerCheckerSameEntity_RBLBank = new PayoutMakerCheckerSameEntity_RBLBank(driver);
		payoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank = new PayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank(
				driver);
		boardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank = new BoardResolutionPayoutMakerCheckerSameEntity_For_RBL_Bank(
				driver);
		boardResolutionPayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank = new BoardResolutionPayoutMakerCheckerMultiEntityDiffUser_For_RBL_Bank(
				driver);

		axisTrusteePayoutMakerCheckerApprovalType_APIBased_RBL_Bank = new AxisTrusteePayoutMakerCheckerApprovalType_APIBased_RBL_Bank(
				driver);
		axisTrusteePayoutMakerCheckerApprovalType_Both_RBL_Bank = new AxisTrusteePayoutMakerCheckerApprovalType_Both_RBL_Bank(
				driver);

	}
}
