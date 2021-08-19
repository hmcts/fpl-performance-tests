package uk.gov.hmcts.reform.exui.performance.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.exui.performance.Feeders
import uk.gov.hmcts.reform.exui.performance.scenarios._
import uk.gov.hmcts.reform.exui.performance.scenarios.utils._

class ExUI extends Simulation {

	val BaseURL = Environment.baseURL
	val orgurl=Environment.manageOrdURL

	val feedUserDataFPLView = csv("FPLDataView.csv").circular
	// val feedUserDataFPLCreate = csv("FPLDataCreate.csv").circular
	val feedUserDataFPLCreate = csv("FPLUserData.csv").circular
	val feedUserDataCaseworker = csv("Caseworkers.csv").circular
  val feedUserDataFPLCases = csv("FPLCases.csv").circular

  val IAChttpProtocol = Environment.HttpProtocol
		.baseUrl(BaseURL)
   // .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")

	val EXUIScn = scenario("EXUI").repeat(1)
	 {
		exec(
		//S2SHelper.S2SAuthToken,
		/*ExUI.createSuperUser,
		ExUI.createOrg,
      ExUI.approveOrgHomePage,
		ExUI.approveOrganisationlogin,
			ExUI.approveOrganisationApprove,
			ExUI.approveOrganisationLogout*/
			ExUI.manageOrgHomePage,
			ExUI.manageOrganisationLogin,
			ExUI.usersPage,
			ExUI.inviteUserPage
			.repeat(5,"n") {
				exec(ExUI.sendInvitation)
				},
			ExUI.manageOrganisationLogout
			)
	 }

	val EXUIMCaseCreationFPLAScn = scenario("***** FPLA Create Case ***** ").repeat(1)
	{
		feed(feedUserDataFPLCreate)
    .feed(Feeders.FPLCreateDataFeeder)
    .exitBlockOnFail {
      exec(EXUIMCLogin.manageCasesHomePage)
      .exec(EXUIMCLogin.manageCaseslogin)
      .repeat(1) {
        exec(EXUIFPLAMC.fplcasecreation)
        .exec(EXUIFPLAMC.fplOrdersNeeded)
        .exec(EXUIFPLAMC.fplHearingNeeded)
        .exec(EXUIFPLAMC.fplChildDetails)
        .exec(EXUIFPLAMC.fplEnterRespondents)
        .exec(EXUIFPLAMC.fplEnterApplicant)
        .exec(EXUIFPLAMC.fplEnterGrounds)
        .exec(EXUIFPLAMC.fplAllocationProposal)
        .exec(EXUIFPLAMC.fplUploadDocuments)
        .exec(EXUIFPLAMC.fplLocalAuthority)
        .exec(EXUIFPLAMC.fplSubmitApplication)
      }
      .exec(EXUIMCLogin.manageCase_Logout)
    }
	}

	/*val EXUIMCaseViewFPLAScn = scenario("***** FPLA View Case ***** ").repeat(1)
	{
		feed(feedUserDataFPLView).feed(Feeders.FPLViewDataFeeder)
			.exec(EXUIMCLogin.manageCasesHomePage)
			.exec(EXUIMCLogin.manageCaseslogin)
			//.exec(EXUIMCLogin.termsnconditions)
			.exec(EXUIFPLAMC.findandviewcasefpl)
			.exec(EXUIMCLogin.manageCase_Logout)
	}

	// below is for FPLa SDO And CMO
	val EXUIMCFPLASDOScn = scenario("***** FPLA SDO ***** ").repeat(1)
	{
		feed(feedUserDataFPLCases).feed(Feeders.FPLSDODataFeeder)
		/*.exec(EXUIMCLogin.manageCasesHomePage)
    .exec(EXUIMCLogin.manageCaseslogin)
    .exec(EXUIMCLogin.termsnconditions)
    .repeat(1) {
      exec(EXUIFPLAMC.fplacasecreation)
    }
    .exec(EXUIMCLogin.manageCase_Logout)*/
		.exec(EXUIMCLogin.manageCasesHomePage)
		.exec(EXUIMCLogin.managecasesadminlogin)
		//.exec(EXUIFPLASDO.fplviewcaseforsdoasadmin)
		.exec(EXUIFPLASDO.fplasdoadminactivities)
		.exec(EXUIMCLogin.manageCase_LogoutAdmin)
		.exec(EXUIMCLogin.manageCasesHomePageGK)
		.exec(EXUIMCLogin.managecasesgatekeeperlogin)
	//	.exec(EXUIFPLASDO.fplviewcaseforsdoasgatekeeper)
		.exec(EXUIFPLASDO.fplasdogatekeeperactivities)
		.exec(EXUIMCLogin.manageCase_LogoutGK)

	}*/

	val EXUIMCaseCaseworkerScn = scenario("***** Caseworker Journey ******").repeat(1)
  {
		feed(feedUserDataCaseworker).feed(Feeders.CwDataFeeder)
			.exec(EXUIMCLogin.manageCasesHomePage)
			.exec(EXUIMCLogin.caseworkerLogin)
		.repeat(1) {
			exec(EXUICaseWorker.ApplyFilters)
			.exec(EXUICaseWorker.ApplySort)
			.exec(EXUICaseWorker.ClickFindCase)
			.exec(EXUICaseWorker.ViewCase)
			}
		.exec(EXUIMCLogin.manageCase_Logout)
  }



	setUp(

		// EXUIMCaseCaseworkerScn.inject(rampUsers(1) during (300)),
		EXUIMCaseCreationFPLAScn.inject(rampUsers(1) during 180)
	).protocols(IAChttpProtocol)
  
	 .assertions(global.successfulRequests.percent.gte(95))
	 .assertions(forAll.successfulRequests.percent.gte(90))

}
