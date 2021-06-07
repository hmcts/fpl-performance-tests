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
	val feedUserDataFPLCreate = csv("FPLDataCreate.csv").circular
	val feedUserDataCaseworker = csv("Caseworkers.csv").circular
  val feedUserDataFPLCases = csv("FPLCases.csv").circular



	/*val httpProtocol = Environment.HttpProtocol
		.proxy(Proxy("proxyout.reform.hmcts.net", 8080).httpsPort(8080))
	//.baseUrl("https://xui-webapp-aat.service.core-compute-aat.internal")
		.baseUrl("https://ccd-case-management-web-perftest.service.core-compute-perftest.internal")*/

  val XUIHttpProtocol = Environment.HttpProtocol
    .proxy(Proxy("proxyout.reform.hmcts.net", 8080).httpsPort(8080))
    .baseUrl(orgurl)
    //.baseUrl("https://ccd-case-management-web-perftest.service.core-compute-perftest.internal")
    .headers(Environment.commonHeader)


  val IAChttpProtocol = Environment.HttpProtocol
		//.proxy(Proxy("proxyout.reform.hmcts.net", 8080).httpsPort(8080))
		.baseUrl(BaseURL)
		//.baseUrl("https://xui-webapp-perftest.service.core-compute-perftest.internal")
		//.baseUrl("https://ccd-case-management-web-perftest.service.core-compute-perftest.internal")

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
		feed(feedUserDataFPLCreate).feed(Feeders.FPLCreateDataFeeder)
	  	.exec(EXUIMCLogin.manageCasesHomePage)
		.exec(EXUIMCLogin.manageCaseslogin)
			//.exec(EXUIMCLogin.termsnconditions)
		  	.repeat(1) {
					 exec(EXUIFPLAMC.fplacasecreation1)
					.exec(EXUIFPLAMC.fplacasecreation2)
				}
		.exec(EXUIMCLogin.manageCase_Logout)
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

		EXUIMCaseCaseworkerScn.inject(rampUsers(10) during (300)),
		EXUIMCaseCreationFPLAScn.inject(rampUsers(10) during 300)
	).protocols(IAChttpProtocol)
	 .assertions(global.successfulRequests.percent.gte(95))
	 .assertions(forAll.successfulRequests.percent.gte(90))

}
