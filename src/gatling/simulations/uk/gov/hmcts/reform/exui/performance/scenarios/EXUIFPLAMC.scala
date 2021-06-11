package uk.gov.hmcts.reform.exui.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.exui.performance.scenarios.utils.Environment
import uk.gov.hmcts.reform.exui.performance.scenarios.utils.FPLAHeader

import scala.util.Random

object EXUIFPLAMC {

  val IdamUrl = Environment.idamURL
  val baseURL = Environment.baseURL
  val loginFeeder = csv("FPLUserData.csv").circular

  val MinThinkTime = Environment.minThinkTimeFPLC
  val MaxThinkTime = Environment.maxThinkTimeFPLC
  val MinThinkTimeFPLV = Environment.minThinkTimeFPLV
  val MaxThinkTimeFPLV = Environment.maxThinkTimeFPLV

  private val rng: Random = new Random()
  private def firstName(): String = rng.alphanumeric.take(10).mkString
  private def lastName(): String = rng.alphanumeric.take(10).mkString

  val fplacasecreation1 =

    //set the random variables as usable parameters
    exec(
      _.setAll(
        ("baseURL", baseURL),
        ("firstName", firstName()),
        ("lastName", lastName())
      ))

      .tryMax(2) {
        exec(http("XUI${service}_040_CreateCase")
          .get("/aggregated/caseworkers/:uid/jurisdictions?access=create")
          .headers(FPLAHeader.headers_casecreation)
          .header("X-XSRF-TOKEN", "${XSRFToken}")
          .check(status.in(200, 304)))
      }.exitHereIfFailed

      .pause(MinThinkTime, MaxThinkTime)

      .tryMax(2) {

        exec(http("XUI${service}_050_005_StartCreateCase")
          .get("/data/internal/case-types/CARE_SUPERVISION_EPO/event-triggers/openCase?ignore-warning=false")
          .headers(FPLAHeader.headers_startcreatecase)
          .check(status.is(200))
          .check(jsonPath("$.event_token").optional.saveAs("event_token")))
        .exec(http("XUI${service}_050_010_CreateCaseProfile")
          .get("/data/internal/profile")
          .headers(FPLAHeader.headers_createprofile)
          .header("X-XSRF-TOKEN", "${XSRFToken}")
          .check(status.in(200, 304))).exitHereIfFailed
      }

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_060_005_CaseNameContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=openCase1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"caseName\": \"${firstName}\"\n  },\n  \"event\": {\n    \"id\": \"openCase\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"caseName\": \"${firstName}\"\n  }\n}"))
        .check(status.is(200)))

      .exec(http("XUI${service}_060_010_CaseNameProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_opencaseprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_070_005_CaseNameSaveContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/cases?ignore-warning=false")
        .headers(FPLAHeader.headers_72)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"caseName\": \"${firstName}\"\n  },\n  \"event\": {\n    \"id\": \"openCase\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${event_token}\",\n  \"ignore_warning\": false,\n  \"draft_id\": null\n}"))
        .check(status.in(201,304))
        .check(jsonPath("$.id").optional.saveAs("caseId")))

      .exec(http("XUI${service}_070_010_CaseNameViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))
      .pause(MinThinkTime, MaxThinkTime)

      //Orders Needed
      .exec(http("XUI${service}_080_005_OrdersDirectionNeededGo")
        .get("/data/internal/cases/${caseId}/event-triggers/ordersNeeded?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_080_010_OrdersDirectionProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_orddersprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_090_005_OrdersDirectionNeededContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=ordersNeeded1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"orders\": {\n      \"orderType\": [\n        \"CARE_ORDER\"\n      ],\n      \"directions\": null\n    }\n  },\n  \"event\": {\n    \"id\": \"ordersNeeded\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"orders\": {\n      \"orderType\": [\n        \"CARE_ORDER\"\n      ],\n      \"directions\": null\n    }\n  },\n  \"case_reference\": \"${caseId}\"\n}"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_090_010_OrdersDirectionContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_ordersneed1profile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))
      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_100_005_OrdersDirectionNeededSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_81)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"orders\": {\n      \"orderType\": [\n        \"CARE_ORDER\"\n      ],\n      \"directions\": null\n    }\n  },\n  \"event\": {\n    \"id\": \"ordersNeeded\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_100_010_OrdersDirectionViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))
      .pause(MinThinkTime, MaxThinkTime)

      //hearing needed
      .exec(http("XUI${service}_110_005_HearingNeededGo")
        .get("/data/internal/cases/${caseId}/event-triggers/hearingNeeded?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_110_010_HearingNeededGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_orddersprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_120_005_HearingNeededContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=hearingNeeded1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"hearing\": {\n      \"timeFrame\": \"Within 18 days\",\n      \"type\": null,\n      \"withoutNotice\": null,\n      \"reducedNotice\": null,\n      \"respondentsAware\": null\n    }\n  },\n  \"event\": {\n    \"id\": \"hearingNeeded\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"hearing\": {\n      \"timeFrame\": \"Within 18 days\",\n      \"type\": null,\n      \"withoutNotice\": null,\n      \"reducedNotice\": null,\n      \"respondentsAware\": null\n    }\n  },\n  \"case_reference\": \"${caseId}\"\n}"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_120_010_HearingNeededContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_hearingneededprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_130_005_HearingNeededSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"hearing\": {\n      \"timeFrame\": \"Within 18 days\",\n      \"type\": null,\n      \"withoutNotice\": null,\n      \"reducedNotice\": null,\n      \"respondentsAware\": null\n    }\n  },\n  \"event\": {\n    \"id\": \"hearingNeeded\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_130_010_HearingNeededSaveViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      //enter children
      .exec(http("XUI${service}_140_005_ChildrenGo")
        .get("/data/internal/cases/${caseId}/event-triggers/enterChildren?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_140_010_ChildrenGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_ordersneed1profile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_150_005_ChildrenContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=enterChildren1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"children1\": [\n      {\n        \"id\": \"d01fbe4f-95df-4023-b2cd-0312639a9700\",\n        \"value\": {\n          \"party\": {\n            \"firstName\": \"test\",\n            \"lastName\": \"testing\",\n            \"dateOfBirth\": \"2011-02-22\",\n            \"gender\": \"Boy\",\n            \"livingSituation\": \"Living with respondents\",\n            \"addressChangeDate\": \"2020-06-01\",\n            \"address\": {\n              \"AddressLine1\": \"Flat 14\",\n              \"AddressLine2\": \"Bramber House\",\n              \"AddressLine3\": \"Seven Kings Way\",\n              \"PostTown\": \"Kingston Upon Thames\",\n              \"County\": \"\",\n              \"PostCode\": \"KT2 5BU\",\n              \"Country\": \"United Kingdom\"\n            },\n            \"keyDates\": \"test\",\n            \"careAndContactPlan\": \"test\",\n            \"adoption\": \"No\",\n            \"mothersName\": \"tess\",\n            \"fathersName\": \"dan\",\n            \"fathersResponsibility\": \"Yes\",\n            \"socialWorkerName\": \"test\",\n            \"socialWorkerTelephoneNumber\": {\n              \"telephoneNumber\": \"02088889966\",\n              \"contactDirection\": \"test\"\n            },\n            \"additionalNeeds\": \"No\",\n            \"detailsHidden\": \"No\",\n            \"litigationIssues\": \"NO\"\n          }\n        }\n      }\n    ]\n  },\n  \"event\": {\n    \"id\": \"enterChildren\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"children1\": [\n      {\n        \"id\": \"d01fbe4f-95df-4023-b2cd-0312639a9700\",\n        \"value\": {\n          \"party\": {\n            \"firstName\": \"test\",\n            \"lastName\": \"testing\",\n            \"dateOfBirth\": \"2011-02-22\",\n            \"gender\": \"Boy\",\n            \"livingSituation\": \"Living with respondents\",\n            \"addressChangeDate\": \"2020-06-01\",\n            \"address\": {\n              \"AddressLine1\": \"Flat 14\",\n              \"AddressLine2\": \"Bramber House\",\n              \"AddressLine3\": \"Seven Kings Way\",\n              \"PostTown\": \"Kingston Upon Thames\",\n              \"County\": \"\",\n              \"PostCode\": \"KT2 5BU\",\n              \"Country\": \"United Kingdom\"\n            },\n            \"keyDates\": \"test\",\n            \"careAndContactPlan\": \"test\",\n            \"adoption\": \"No\",\n            \"mothersName\": \"tess\",\n            \"fathersName\": \"dan\",\n            \"fathersResponsibility\": \"Yes\",\n            \"socialWorkerName\": \"test\",\n            \"socialWorkerTelephoneNumber\": {\n              \"telephoneNumber\": \"02088889966\",\n              \"contactDirection\": \"test\"\n            },\n            \"additionalNeeds\": \"No\",\n            \"detailsHidden\": \"No\",\n            \"litigationIssues\": \"NO\"\n          }\n        }\n      }\n    ]\n  },\n  \"case_reference\": \"${caseId}\"\n}"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_150_010_ChildrenContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_childrenprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_160_005_ChildrenSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"children1\": [\n      {\n        \"id\": \"d01fbe4f-95df-4023-b2cd-0312639a9700\",\n        \"value\": {\n          \"party\": {\n            \"firstName\": \"test\",\n            \"lastName\": \"testing\",\n            \"dateOfBirth\": \"2011-02-22\",\n            \"gender\": \"Boy\",\n            \"livingSituation\": \"Living with respondents\",\n            \"addressChangeDate\": \"2020-06-01\",\n            \"address\": {\n              \"AddressLine1\": \"Flat 14\",\n              \"AddressLine2\": \"Bramber House\",\n              \"AddressLine3\": \"Seven Kings Way\",\n              \"PostTown\": \"Kingston Upon Thames\",\n              \"County\": \"\",\n              \"PostCode\": \"KT2 5BU\",\n              \"Country\": \"United Kingdom\"\n            },\n            \"keyDates\": \"test\",\n            \"careAndContactPlan\": \"test\",\n            \"adoption\": \"No\",\n            \"mothersName\": \"tess\",\n            \"fathersName\": \"dan\",\n            \"fathersResponsibility\": \"Yes\",\n            \"socialWorkerName\": \"test\",\n            \"socialWorkerTelephoneNumber\": {\n              \"telephoneNumber\": \"02088889966\",\n              \"contactDirection\": \"test\"\n            },\n            \"additionalNeeds\": \"No\",\n            \"detailsHidden\": \"No\",\n            \"litigationIssues\": \"NO\"\n          }\n        }\n      }\n    ]\n  },\n  \"event\": {\n    \"id\": \"enterChildren\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_160_010_ChildrenSaveViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      //enter respondents
      .exec(http("XUI${service}_170_005_EnterRespondents1")
        .get("/case/PUBLICLAW/CARE_SUPERVISION_EPO/${caseId}/trigger/enterRespondents")
        .headers(FPLAHeader.respondent_headers_3)
        .check(status.in(200,304)))

      .exec(http("XUI${service}_170_010_EnterRespondents2")
        .get("/api/user/details")
        .headers(FPLAHeader.respondent_headers_22)
        .check(status.in(200,304)))

      .exec(http("XUI${service}_170_015_EnterRespondents3")
        .get("/api/configuration?configurationKey=termsAndConditionsEnabled")
        .headers(FPLAHeader.respondent_headers_22)
        .check(status.in(200,304)))

      .exec(http("XUI${service}_170_020_EnterRespondents4")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.respondent_headers_30)
        .check(status.in(200,304)))

      .exec(http("XUI${service}_170_025_RespondentsGo")
        .get("/data/internal/cases/${caseId}/event-triggers/enterRespondents?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$..id").find(2).saveAs("respondentId"))
        .check(jsonPath("$..partyId").saveAs("partyId"))
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_170_030_RespondentsGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_ordersneed1profile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .exec(http("XUI${service}_170_035_RespondentOrgs1")
        .get("/api/caseshare/orgs")
        .headers(FPLAHeader.respondent_headers_63)
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_180_005_RespondentsGetAddress1")
        .get("/addresses?postcode=SW1H9AJ")
        .headers(FPLAHeader.headers_16)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_180_010_RespondentsGetAddress2")
        .get("/addresses?postcode=SW1H9AJ")
        .headers(FPLAHeader.headers_16)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_190_005_RespondentsContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=enterRespondents1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("""{"data":{"respondents1":[{"value":{"persistRepresentedBy":null,"leadRespondentIndicator":null,"legalRepresentation":"Yes","party":{"firstName":"John","lastName":"Smith","dateOfBirth":"1980-02-21","gender":"Male","genderIdentification":null,"relationshipToChild":"Father","contactDetailsHidden":"No","contactDetailsHiddenReason":null,"litigationIssues":"NO","litigationIssuesDetails":null,"partyId":"${partyId}","partyType":null,"placeOfBirth":null,"address":{"AddressLine1":"Ministry Of Justice","AddressLine2":"Seventh Floor 102 Petty France","AddressLine3":"","PostTown":"London","County":"","PostCode":"TS1 1ST","Country":"United Kingdom"},"telephoneNumber":{"telephoneNumber":"020 2772 5772","contactDirection":null}},"representedBy":[],"solicitor":{"firstName":"James","lastName":"Brown","email":"sscs.ptest.4@mailinator.com","organisation":{"OrganisationID":"G7AXGLA","OrganisationName":"Onofpub"},"unregisteredOrganisation":{"name":null,"address":{"AddressLine1":null,"AddressLine2":null,"AddressLine3":null,"PostTown":null,"County":null,"PostCode":null,"Country":null}},"regionalOfficeAddress":{"AddressLine1":"Ministry Of Justice","AddressLine2":"Seventh Floor 102 Petty France","AddressLine3":"","PostTown":"London","County":"","PostCode":"SW1H 9AJ","Country":"United Kingdom"}}},"id":"${respondentId}"}]},"event":{"id":"enterRespondents","summary":"","description":""},"event_data":{"respondents1":[{"value":{"persistRepresentedBy":null,"leadRespondentIndicator":null,"legalRepresentation":"Yes","party":{"firstName":"John","lastName":"Smith","dateOfBirth":"1980-02-21","gender":"Male","genderIdentification":null,"relationshipToChild":"Father","contactDetailsHidden":"No","contactDetailsHiddenReason":null,"litigationIssues":"NO","litigationIssuesDetails":null,"partyId":"${partyId}","partyType":null,"placeOfBirth":null,"address":{"AddressLine1":"Ministry Of Justice","AddressLine2":"Seventh Floor 102 Petty France","AddressLine3":"","PostTown":"London","County":"","PostCode":"TS1 1ST","Country":"United Kingdom"},"telephoneNumber":{"telephoneNumber":"020 2772 5772","contactDirection":null}},"representedBy":[],"solicitor":{"firstName":"James","lastName":"Brown","email":"sscs.ptest.4@mailinator.com","organisation":{"OrganisationID":"G7AXGLA","OrganisationName":"Onofpub"},"unregisteredOrganisation":{"name":null,"address":{"AddressLine1":null,"AddressLine2":null,"AddressLine3":null,"PostTown":null,"County":null,"PostCode":null,"Country":null}},"regionalOfficeAddress":{"AddressLine1":"Ministry Of Justice","AddressLine2":"Seventh Floor 102 Petty France","AddressLine3":"","PostTown":"London","County":"","PostCode":"SW1H 9AJ","Country":"United Kingdom"}}},"id":"${respondentId}"}]},"event_token":"${existing_case_event_token}","ignore_warning":false,"case_reference":"${caseId}"}"""))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_190_010_RespondentsContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_respondantprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .exec(http("XUI${service}_190_015_RespondentOrgs2")
        .get("/api/caseshare/orgs")
        .headers(FPLAHeader.respondent_headers_63)
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_200_005_RespondentsSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("""{"data":{"respondents1":[{"value":{"persistRepresentedBy":null,"leadRespondentIndicator":null,"legalRepresentation":"Yes","party":{"firstName":"John","lastName":"Smith","dateOfBirth":"1980-02-21","gender":"Male","genderIdentification":null,"relationshipToChild":"Father","contactDetailsHidden":"No","contactDetailsHiddenReason":null,"litigationIssues":"NO","litigationIssuesDetails":null,"partyId":"${partyId}","partyType":null,"placeOfBirth":null,"address":{"AddressLine1":"Ministry Of Justice","AddressLine2":"Seventh Floor 102 Petty France","AddressLine3":"","PostTown":"London","County":"","PostCode":"TS1 1ST","Country":"United Kingdom"},"telephoneNumber":{"telephoneNumber":"020 2772 5772","contactDirection":null}},"representedBy":[],"solicitor":{"firstName":"James","lastName":"Brown","email":"sscs.ptest.4@mailinator.com","organisation":{"OrganisationID":"G7AXGLA","OrganisationName":"Onofpub"},"unregisteredOrganisation":{"name":null,"address":{"AddressLine1":null,"AddressLine2":null,"AddressLine3":null,"PostTown":null,"County":null,"PostCode":null,"Country":null}},"regionalOfficeAddress":{"AddressLine1":"Ministry Of Justice","AddressLine2":"Seventh Floor 102 Petty France","AddressLine3":"","PostTown":"London","County":"","PostCode":"SW1H 9AJ","Country":"United Kingdom"}}},"id":"${respondentId}"}]},"event":{"id":"enterRespondents","summary":"","description":""},"event_token":"${existing_case_event_token}","ignore_warning":false}"""))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_200_010_SearchForCompletable")
        .post("/workallocation/searchForCompletable")
        .headers(FPLAHeader.respondent_headers_159)
        .body(StringBody("""{"searchRequest":{"ccdId":"${caseId}","eventId":"enterRespondents","jurisdiction":"PUBLICLAW","caseTypeId":"CARE_SUPERVISION_EPO"}}"""))
        .check(status.in(200,401)))

      .exec(http("XUI${service}_200_015_RespondentsSaveViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

  val fplacasecreation2 =
  // enter applicant
      exec(http("XUI${service}_210_005_ApplicantGo")
        .get("/data/internal/cases/${caseId}/event-triggers/enterApplicant?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_210_010_ApplicantGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_respondantprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_220_ApplicantGetAddress")
        .get("/addresses?postcode=TW33SD")
        .headers(FPLAHeader.headers_16)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_230_005_ApplicantContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=enterApplicant1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"applicants\": [\n      {\n        \"id\": \"9de5744b-26c2-4653-919d-d9b828fc4c3f\",\n        \"value\": {\n          \"party\": {\n            \"organisationName\": \"${firstName}\",\n            \"pbaNumber\": \"1234567\",\n            \"clientCode\": null,\n            \"customerReference\": null,\n            \"address\": {\n              \"AddressLine1\": \"8 Hibernia Gardens\",\n              \"AddressLine2\": \"\",\n              \"AddressLine3\": \"\",\n              \"PostTown\": \"Hounslow\",\n              \"County\": \"\",\n              \"PostCode\": \"TW3 3SD\",\n              \"Country\": \"United Kingdom\"\n            },\n            \"telephoneNumber\": {\n              \"telephoneNumber\": \"07540634567\",\n              \"contactDirection\": \"${firstName}\"\n            },\n            \"jobTitle\": \"kkkuuhhh\",\n            \"mobileNumber\": {\n              \"telephoneNumber\": null\n            },\n            \"email\": {\n              \"email\": \"dddffff@la.gov.uk\"\n            }\n          }\n        }\n      }\n    ],\n    \"solicitor\": {\n      \"name\": \"nhhffsol\",\n      \"mobile\": \"07540687298\",\n      \"telephone\": \"05673245678\",\n      \"email\": \"joe.bloggs@la.gov.uk\",\n      \"dx\": null,\n      \"reference\": null\n    }\n  },\n  \"event\": {\n    \"id\": \"enterApplicant\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"applicants\": [\n      {\n        \"id\": \"9de5744b-26c2-4653-919d-d9b828fc4c3f\",\n        \"value\": {\n          \"party\": {\n            \"organisationName\": \"${firstName}\",\n            \"pbaNumber\": \"1234567\",\n            \"clientCode\": null,\n            \"customerReference\": null,\n            \"address\": {\n              \"AddressLine1\": \"8 Hibernia Gardens\",\n              \"AddressLine2\": \"\",\n              \"AddressLine3\": \"\",\n              \"PostTown\": \"Hounslow\",\n              \"County\": \"\",\n              \"PostCode\": \"TW3 3SD\",\n              \"Country\": \"United Kingdom\"\n            },\n            \"telephoneNumber\": {\n              \"telephoneNumber\": \"07540634567\",\n              \"contactDirection\": \"${firstName}\"\n            },\n            \"jobTitle\": \"kkkuuhhh\",\n            \"mobileNumber\": {\n              \"telephoneNumber\": null\n            },\n            \"email\": {\n              \"email\": \"dddffff@la.gov.uk\"\n            }\n          }\n        }\n      }\n    ],\n    \"solicitor\": {\n      \"name\": \"nhhffsol\",\n      \"mobile\": \"07540687298\",\n      \"telephone\": \"05673245678\",\n      \"email\": \"joe.bloggs@la.gov.uk\",\n      \"dx\": null,\n      \"reference\": null\n    }\n  },\n  \"case_reference\": \"${caseId}\"\n}"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_230_010_ApplicantGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_applicantprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_240_005_ApplicantSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"applicants\": [\n      {\n        \"id\": \"9de5744b-26c2-4653-919d-d9b828fc4c3f\",\n        \"value\": {\n          \"party\": {\n            \"organisationName\": \"${firstName}\",\n            \"pbaNumber\": \"PBA1234567\",\n            \"clientCode\": null,\n            \"customerReference\": null,\n            \"address\": {\n              \"AddressLine1\": \"8 Hibernia Gardens\",\n              \"AddressLine2\": \"\",\n              \"AddressLine3\": \"\",\n              \"PostTown\": \"Hounslow\",\n              \"County\": \"\",\n              \"PostCode\": \"TW3 3SD\",\n              \"Country\": \"United Kingdom\"\n            },\n            \"telephoneNumber\": {\n              \"telephoneNumber\": \"07540634567\",\n              \"contactDirection\": \"${firstName}\"\n            },\n            \"jobTitle\": \"kkkuuhhh\",\n            \"mobileNumber\": {\n              \"telephoneNumber\": null\n            },\n            \"email\": {\n              \"email\": \"dddffff@la.gov.uk\"\n            }\n          }\n        }\n      }\n    ],\n    \"solicitor\": {\n      \"name\": \"nhhffsol\",\n      \"mobile\": \"07540687298\",\n      \"telephone\": \"05673245678\",\n      \"email\": \"joe.bloggs@la.gov.uk\",\n      \"dx\": null,\n      \"reference\": null\n    }\n  },\n  \"event\": {\n    \"id\": \"enterApplicant\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_240_010_ApplicantSaveViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))
      .pause(MinThinkTime, MaxThinkTime)

      // enter grounds
      .exec(http("XUI${service}_250_005_GroundApplicationGo")
        .get("/data/internal/cases/${caseId}/event-triggers/enterGrounds?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_250_010__GroundApplicationGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_ordersneed1profile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_260_005_GroundApplicationContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=enterGrounds1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"grounds\": {\n      \"thresholdReason\": [\n        \"beyondControl\"\n      ],\n      \"thresholdDetails\": \"sdsdsds\"\n    }\n  },\n  \"event\": {\n    \"id\": \"enterGrounds\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"grounds\": {\n      \"thresholdReason\": [\n        \"beyondControl\"\n      ],\n      \"thresholdDetails\": \"sdsdsds\"\n    }\n  },\n  \"case_reference\": \"${caseId}\"\n}"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_260_010_GroundApplicationContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_groundsprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_270_005_GroundApplicationSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"grounds\": {\n      \"thresholdReason\": [\n        \"beyondControl\"\n      ],\n      \"thresholdDetails\": \"sdsdsds\"\n    }\n  },\n  \"event\": {\n    \"id\": \"enterGrounds\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_270_010_GroundApplicationSaveViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      //other proposal
      .exec(http("XUI${service}_280_005_AllocationProposalGo")
        .get("/data/internal/cases/${caseId}/event-triggers/otherProposal?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_280_010_AllocationProposalGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_ordersneed1profile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_290_005_AllocationProposalContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=otherProposal1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"allocationProposal\": {\n      \"proposal\": \"District judge\",\n      \"proposalReason\": \"xccxcx\"\n    }\n  },\n  \"event\": {\n    \"id\": \"otherProposal\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"allocationProposal\": {\n      \"proposal\": \"District judge\",\n      \"proposalReason\": \"xccxcx\"\n    }\n  },\n  \"case_reference\": \"${caseId}\"\n}"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_290_010_AllocationProposalContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_otherprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_300_005_AllocationProposalSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"allocationProposal\": {\n      \"proposal\": \"District judge\",\n      \"proposalReason\": \"xccxcx\"\n    }\n  },\n  \"event\": {\n    \"id\": \"otherProposal\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_300_010_AllocationProposalSaveViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      // upload documents
      .exec(http("XUI${service}_310_005_UploadDocuments1")
        .get("/case/PUBLICLAW/CARE_SUPERVISION_EPO/${caseId}/trigger/uploadDocuments")
        .headers(FPLAHeader.document_headers_3)
        .check(status.in(200,304)))

      .exec(http("XUI${service}_310_010_UploadDocuments2")
        .get("/api/configuration?configurationKey=termsAndConditionsEnabled")
        .headers(FPLAHeader.document_headers_22)
        .check(status.in(200,304)))

      .exec(http("XUI${service}_310_015_UploadDocuments3")
        .get("/api/user/details")
        .headers(FPLAHeader.document_headers_22)
        .check(status.in(200,304)))

      .exec(http("XUI${service}_310_020_UploadDocuments4")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.document_headers_31)
        .check(status.in(200,304)))

      .exec(http("XUI${service}_310_025_DocumentsGo")
        .get("/data/internal/cases/${caseId}/event-triggers/uploadDocuments?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_310_030_DocumentsGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_ordersneed1profile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_320_UploadFile")
        .post("/documents")
        .headers(FPLAHeader.headers_uploadfile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .bodyPart(RawFileBodyPart("files", "3MB.pdf")
          .fileName("3MB.pdf")
          .transferEncoding("binary"))
        .asMultipartForm
        .formParam("classification", "PUBLIC")
        .check(status.is(200))
        .check(regex("""http://(.+)/""").saveAs("DMURL"))
        .check(regex("""internal/documents/(.+?)/binary""").saveAs("Document_ID")))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_330_005_DocumentsContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=uploadDocumentsaddApplicationDocuments")
        .headers(FPLAHeader.document_headers_75)
        .body(StringBody("""{"data":{"applicationDocuments":[{"value":{"documentType":"THRESHOLD","includedInSWET":null,"uploadedBy":null,"document":{"document_url":"http://${DMURL}/${Document_ID}","document_binary_url":"http://${DMURL}/${Document_ID}/binary","document_filename":"3MB.pdf"}},"id":null}],"applicationDocumentsToFollowReason":"This is the necessary document"},"event":{"id":"uploadDocuments","summary":"","description":""},"event_data":{"applicationDocuments":[{"value":{"documentType":"THRESHOLD","includedInSWET":null,"uploadedBy":null,"document":{"document_url":"http://${DMURL}/${Document_ID}","document_binary_url":"http://${DMURL}/${Document_ID}/binary","document_filename":"3MB.pdf"}},"id":null}],"applicationDocumentsToFollowReason":"This is the necessary document"},"event_token":"${existing_case_event_token}","ignore_warning":false,"case_reference":"${caseId}"}"""))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_330_010_DocumentsContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_uploaddocprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_340_005_DocumentsSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("""{"data":{"applicationDocuments":[{"value":{"documentType":"THRESHOLD","includedInSWET":null,"uploadedBy":null,"document":{"document_url":"http://${DMURL}/${Document_ID}","document_binary_url":"http://${DMURL}/${Document_ID}/binary","document_filename":"3MB.pdf"}},"id":null}],"applicationDocumentsToFollowReason":"This is the necessary document"},"event":{"id":"uploadDocuments","summary":"","description":""},"event_token":"${existing_case_event_token}","ignore_warning":false}"""))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_340_010_SearchForCompletable")
        .post("/workallocation/searchForCompletable")
        .headers(FPLAHeader.document_headers_98)
        .body(StringBody("""{"searchRequest":{"ccdId":"${caseId}","eventId":"uploadDocuments","jurisdiction":"PUBLICLAW","caseTypeId":"CARE_SUPERVISION_EPO"}}"""))
        .check(status.in(200,401)))

      .exec(http("XUI${service}_340_015_DocumentsSaveViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      // submit application
      .exec(http("XUI${service}_350_005_SubmitApplicationGo")
        .get("/data/internal/cases/${caseId}/event-triggers/submitApplication?ignore-warning=false")
        .headers(FPLAHeader.headers_76)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_350_010_SubmitApplicationGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_ordersneed1profile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_360_005_SubmitApplicationContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=submitApplication1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"submissionConsent\": [\n      \"agree\"\n    ],\n    \"submissionConsentLabel\": \"I, ${user} (local-authority), believe that the facts stated in this application are true.\"\n  },\n  \"event\": {\n    \"id\": \"submitApplication\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"submissionConsent\": [\n      \"agree\"\n    ],\n    \"submissionConsentLabel\": \"I, ${user} (local-authority), believe that the facts stated in this application are true.\"\n  },\n  \"case_reference\": \"${caseId}\"\n}"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_360_010_SubmitApplicationContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_submitprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_370_005_ApplicationSubmitted")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"submissionConsent\": [\n      \"agree\"\n    ],\n    \"submissionConsentLabel\": \"I, ${user} (local-authority), believe that the facts stated in this application are true.\"\n  },\n  \"event\": {\n    \"id\": \"submitApplication\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_370_010_ApplicationSubmittedViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)


  val findandviewcasefpl=
    tryMax(2) {
      exec(http("XUI${service}_040_005_SearchPage")
        .get("/aggregated/caseworkers/:uid/jurisdictions?access=read")
        .headers(FPLAHeader.headers_search)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304))
      )

        .exec(http("XUI${service}_040_010_SearchPaginationMetaData")
          .get("/aggregated/caseworkers/:uid/jurisdictions/PUBLICLAW/case-types/CARE_SUPERVISION_EPO/cases?view=SEARCH&page=1&state=Submitted")
          .headers(FPLAHeader.headers_search)
          .header("X-XSRF-TOKEN", "${XSRFToken}")
          .check(status.in(200,304)))

    }

      .exec(http("XUI${service}_040_015_SearchPaginationMetaData")
        .get("/data/internal/case-types/CARE_SUPERVISION_EPO/search-inputs")
        .headers(FPLAHeader.headers_searchpaginationmetadata)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304))
      )

      .exec(http("XUI${service}_040_020_SearchResults")
        .post("/data/internal/searchCases?ctid=CARE_SUPERVISION_EPO&use_case=SEARCH&view=SEARCH&page=1&state=Submitted")
        .headers(FPLAHeader.headers_results)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"size\": 25\n}"))
        .check(status.in(200,304))
        // .check(jsonPath("$..case_id").findAll.optional.saveAs("caseNumbersFPL")))
        .check(jsonPath("$..case_id").find(0).optional.saveAs("caseNumberFPL")))
      .pause(MinThinkTimeFPLV , MaxThinkTimeFPLV )

      // .foreach("${caseNumbersFPL}","caseNumberFPL") {
      .exec(http("XUI${service}_050_ViewCase")
        .get("/data/internal/cases/${caseNumberFPL}")
        .headers(FPLAHeader.headers_searchinputs)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304))
        .check(regex("""internal/documents/(.+?)","document_filename""").find(0).saveAs("Document_ID"))
        .check(status.is(200)))

      .pause(MinThinkTimeFPLV , MaxThinkTimeFPLV )

      .exec(http("XUI${service}_060_005_ViewCaseDocumentUI")
        .get("/external/config/ui")
        .headers(FPLAHeader.headers_documents)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_060_010_ViewCaseDocumentT&C")
        .get("/api/configuration?configurationKey=termsAndConditionsEnabled")
        .headers(FPLAHeader.headers_documents)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304))
        .check(status.in(200,304)))

      /* .exec(http("XUI${service}_060_015_ViewCaseDocumentAnnotations")
         .get("/em-anno/annotation-sets/filter?documentId=${Document_ID}")
         .headers(FPLAHeader.headers_documents)
         .header("X-XSRF-TOKEN", "${XSRFToken}")
         .check(status.in(200,304))
         .check(status.in(200, 404,304)))*/

      .exec(http("XUI${service}_060_015_ViewCaseDocumentBinary")
        .get("/documents/${Document_ID}/binary")
        .headers(FPLAHeader.headers_documents)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304))
        .check(status.in(200, 404,304)))
      .pause(MinThinkTimeFPLV , MaxThinkTimeFPLV )
  //  }



}
