package uk.gov.hmcts.reform.exui.performance.simulations

import io.gatling.core.Predef._
import uk.gov.hmcts.reform.exui.performance.scenarios._
import uk.gov.hmcts.reform.exui.performance.scenarios.utils._

class ExUI extends Simulation {

	val BaseURL = Environment.baseURL
	val feedUserDataFPL = csv("FPLUserData.csv").circular

	val FPLhttpProtocol = Environment.HttpProtocol
		.baseUrl(BaseURL)
		.inferHtmlResources()
		.silentResources

	val EXUIMCaseCreationFPLAScn = scenario("FPL Scenario ")
		.exitBlockOnFail {
			feed(feedUserDataFPL)
				.exec(EXUIMCLogin.manageCasesHomePage)
				.exec(EXUIMCLogin.manageCaseslogin)
				.exec(EXUIFPLAMC.fplcasecreation)
				.exec(EXUIFPLAMC.fplOrdersAndDirections)
				.exec(EXUIFPLAMC.fplHearingUrgency)
				.exec(EXUIFPLAMC.fplGrounds)
				.exec(EXUIFPLAMC.fplLocalAuthority)
				.exec(EXUIFPLAMC.fplChildDetails)
				.exec(EXUIFPLAMC.fplRespondentDetails)
				.exec(EXUIFPLAMC.fplAllocationProposal)
				.exec(EXUIFPLAMC.fplSubmitApplication)
				.exec(EXUIFPLAMC.fplReturnToCase)
				.exec(EXUIMCLogin.manageCase_Logout)
		}

	setUp(
			EXUIMCaseCreationFPLAScn.inject(atOnceUsers(1)).disablePauses
			//EXUIMCaseCreationFPLAScn.inject(rampUsers(10) during (180))
		).protocols(FPLhttpProtocol)
		.assertions(global.successfulRequests.percent.gte(95),
			forAll.successfulRequests.percent.gte(80))

}
