package uk.gov.hmcts.reform.exui.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.exui.performance.scenarios.EXUIMCLogin.baseDomain
import uk.gov.hmcts.reform.exui.performance.scenarios.utils.Environment
import uk.gov.hmcts.reform.exui.performance.scenarios.utils.FPLAHeader

import scala.util.Random

object EXUIFPLAMC {

  val headers_0 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/octet-stream",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val headers_1 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val headers_3 = Map(
    "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "document",
    "sec-fetch-mode" -> "navigate",
    "sec-fetch-site" -> "same-origin",
    "sec-fetch-user" -> "?1",
    "upgrade-insecure-requests" -> "1")

  val headers_4 = Map(
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val headers_10 = Map(
    "Origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val headers_12 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtpc" -> "1$130897621_929h3vSAGPWCFIPMPCPPUBAHVVLATFUIURPUOK-0e14")

  val headers_13 = Map(
    "Accept" -> "application/json, text/plain, */*",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val headers_18 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "access-control-request-headers" -> "x-launchdarkly-user-agent",
    "access-control-request-method" -> "GET",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "cross-site")

  val headers_19 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> "d751713988987e9331980363e24189ce",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "cross-site",
    "x-launchdarkly-user-agent" -> "JSClient/3.1.2")

  val headers_21 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> "812cb",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "cross-site",
    "x-launchdarkly-user-agent" -> "JSClient/3.1.2")

  val headers_22 = Map(
    "accept" -> "application/json, text/plain, */*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val headers_28 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Access-Control-Request-Headers" -> "content-type,x-launchdarkly-event-schema,x-launchdarkly-payload-id,x-launchdarkly-user-agent",
    "Access-Control-Request-Method" -> "POST",
    "Origin" -> "https://manage-case.aat.platform.hmcts.net",
    "Sec-Fetch-Dest" -> "empty",
    "Sec-Fetch-Mode" -> "cors",
    "Sec-Fetch-Site" -> "cross-site")

  val headers_29 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Content-Type" -> "application/json",
    "Origin" -> "https://manage-case.aat.platform.hmcts.net",
    "Sec-Fetch-Dest" -> "empty",
    "Sec-Fetch-Mode" -> "cors",
    "Sec-Fetch-Site" -> "cross-site",
    "X-LaunchDarkly-Event-Schema" -> "3",
    "X-LaunchDarkly-Payload-ID" -> "3f74e720-b7bd-11eb-b4ef-3f095b2cf1cd",
    "X-LaunchDarkly-User-Agent" -> "JSClient/3.1.2",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val headers_31 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.ui-case-view.v2+json",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val headers_32 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.ui-start-event-trigger.v2+json;charset=UTF-8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val headers_43 = Map(
    "accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "image",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val headers_44 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Content-Type" -> "application/json",
    "Origin" -> "https://manage-case.aat.platform.hmcts.net",
    "Sec-Fetch-Dest" -> "empty",
    "Sec-Fetch-Mode" -> "cors",
    "Sec-Fetch-Site" -> "cross-site",
    "X-LaunchDarkly-Event-Schema" -> "3",
    "X-LaunchDarkly-Payload-ID" -> "4334d550-b7bd-11eb-b4ef-3f095b2cf1cd",
    "X-LaunchDarkly-User-Agent" -> "JSClient/3.1.2",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val headers_46 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val headers_47 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtreferer" -> "https://manage-case.aat.platform.hmcts.net/case/PUBLICLAW/CARE_SUPERVISION_EPO/1621330613983467/trigger/uploadDocuments")

  val headers_49 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.ui-user-profile.v2+json;charset=UTF-8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val headers_65 = Map(
    "accept" -> "application/json, text/plain, */*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "multipart/form-data; boundary=----WebKitFormBoundarywZdDEqaxqGmVq2Qf",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-xsrf-token" -> "cuW1YQBJ-GnnO7OIXapgFi-X9wSY586rKlnw")

  val headers_75 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.case-data-validate.v2+json;charset=UTF-8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-xsrf-token" -> "${XSRFToken}")

  val headers_88 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtreferer" -> "https://manage-case.aat.platform.hmcts.net/cases/case-details/1621330613983467/trigger/uploadDocuments/uploadDocumentsaddApplicationDocuments")

  val headers_93 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.create-event.v2+json;charset=UTF-8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-xsrf-token" -> "ry2NzvAG-e4trDx5nLqJS5VKHVsxVZjoxiY0")

  val headers_98 = Map(
    "accept" -> "application/json",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-xsrf-token" -> "${XSRFToken}")

  val headers_102 = Map(
    "accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> """W/"2a47fea0a68d36784544a73040307f2e64e5f950fab8a46f0393d9db87b542a7"""",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "image",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val headers_104 = Map(
    "accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> """W/"b10547e2a7c088405793c1632acf9a4b22509658e3bd555290bf6ad12b034bb0"""",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "image",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val headers_105 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtreferer" -> "https://manage-case.aat.platform.hmcts.net/cases/case-details/1621330613983467/trigger/uploadDocuments/submit")

  val respondent_headers_0 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/octet-stream",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val respondent_headers_1 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val respondent_headers_3 = Map(
    "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "document",
    "sec-fetch-mode" -> "navigate",
    "sec-fetch-site" -> "same-origin",
    "sec-fetch-user" -> "?1",
    "upgrade-insecure-requests" -> "1")

  val respondent_headers_4 = Map(
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val respondent_headers_10 = Map(
    "Origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val respondent_headers_12 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtpc" -> "2$300933225_46h3vKOSBAFHKHTKVMVPFAAJRTFWULTGTPPSF-0e15")

  val respondent_headers_13 = Map(
    "Accept" -> "application/json, text/plain, */*",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val respondent_headers_18 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "access-control-request-headers" -> "x-launchdarkly-user-agent",
    "access-control-request-method" -> "GET",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "cross-site")

  val respondent_headers_19 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> "d751713988987e9331980363e24189ce",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "cross-site",
    "x-launchdarkly-user-agent" -> "JSClient/3.1.2")

  val respondent_headers_21 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> "827cb",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "cross-site",
    "x-launchdarkly-user-agent" -> "JSClient/3.1.2")

  val respondent_headers_22 = Map(
    "accept" -> "application/json, text/plain, */*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val respondent_headers_27 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Content-Type" -> "application/json",
    "Origin" -> "https://manage-case.aat.platform.hmcts.net",
    "Sec-Fetch-Dest" -> "empty",
    "Sec-Fetch-Mode" -> "cors",
    "Sec-Fetch-Site" -> "cross-site",
    "X-LaunchDarkly-Event-Schema" -> "3",
    "X-LaunchDarkly-Payload-ID" -> "2494e120-b949-11eb-8e6f-dbe2c60fcf05",
    "X-LaunchDarkly-User-Agent" -> "JSClient/3.1.2",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val respondent_headers_30 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.ui-case-view.v2+json",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val respondent_headers_31 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.ui-start-event-trigger.v2+json;charset=UTF-8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val respondent_headers_41 = Map(
    "accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "image",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val respondent_headers_44 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Content-Type" -> "application/json",
    "Origin" -> "https://manage-case.aat.platform.hmcts.net",
    "Sec-Fetch-Dest" -> "empty",
    "Sec-Fetch-Mode" -> "cors",
    "Sec-Fetch-Site" -> "cross-site",
    "X-LaunchDarkly-Event-Schema" -> "3",
    "X-LaunchDarkly-Payload-ID" -> "2796d680-b949-11eb-8e6f-dbe2c60fcf05",
    "X-LaunchDarkly-User-Agent" -> "JSClient/3.1.2",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0")

  val respondent_headers_48 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtreferer" -> "https://manage-case.aat.platform.hmcts.net/case/PUBLICLAW/CARE_SUPERVISION_EPO/1621500656093644/trigger/enterRespondents")

  val respondent_headers_52 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val respondent_headers_61 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.ui-user-profile.v2+json;charset=UTF-8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val respondent_headers_63 = Map(
    "accept" -> "application/json, text/plain, */*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtpc" -> "2$300933225_46h22vKOSBAFHKHTKVMVPFAAJRTFWULTGTPPSF-0e15",
    "x-dtreferer" -> "https://manage-case.aat.platform.hmcts.net/case/PUBLICLAW/CARE_SUPERVISION_EPO/1621500656093644/trigger/enterRespondents")

  val respondent_headers_69 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "cross-site")

  val respondent_headers_77 = Map(
    "accept" -> "application/json",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin")

  val respondent_headers_139 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.case-data-validate.v2+json;charset=UTF-8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-xsrf-token" -> "7Y0USLZT-PQLKOaMVjeew70Rv7iMX6QQJKFg")

  val respondent_headers_151 = Map(
    "accept" -> "application/vnd.uk.gov.hmcts.ccd-data-store-api.create-event.v2+json;charset=UTF-8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "experimental" -> "true",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-xsrf-token" -> "hG3zhjiC--WaXISl_8cBaRmGw3AjJszzAoH8")

  val respondent_headers_158 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtreferer" -> "https://manage-case.aat.platform.hmcts.net/cases/case-details/1621500656093644/trigger/enterRespondents/enterRespondents1")

  val respondent_headers_159 = Map(
    "accept" -> "application/json",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "application/json",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-xsrf-token" -> "${XSRFToken}")

  val respondent_headers_162 = Map(
    "accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> """W/"b10547e2a7c088405793c1632acf9a4b22509658e3bd555290bf6ad12b034bb0"""",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "image",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val respondent_headers_163 = Map(
    "accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> """W/"2a47fea0a68d36784544a73040307f2e64e5f950fab8a46f0393d9db87b542a7"""",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "image",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val respondent_headers_164 = Map(
    "accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "if-none-match" -> """W/"e3540f2c832e36de73d56909a7ca74ef069f583df9d3b45188053320bcba3930"""",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "image",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "cross-site")

  val respondent_headers_165 = Map(
    "accept" -> "*/*",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "content-type" -> "text/plain;charset=UTF-8",
    "origin" -> "https://manage-case.aat.platform.hmcts.net",
    "sec-ch-ua" -> """Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "empty",
    "sec-fetch-mode" -> "cors",
    "sec-fetch-site" -> "same-origin",
    "x-dtreferer" -> "https://manage-case.aat.platform.hmcts.net/cases/case-details/1621500656093644/trigger/enterRespondents/submit")

  val uri2 = "https://app.launchdarkly.com/sdk"
  val uri3 = "https://www.googletagmanager.com"
  val uri4 = "https://events.launchdarkly.com/events/bulk/5de6610b23ce5408280f2268"
  val uri5 = "https://raw.githubusercontent.com/hmcts/fpl-ccd-configuration/master/resources"
  val uri6 = "https://manage-case.aat.platform.hmcts.net"

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

  val fplacasecreation =
    tryMax(2) {
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

      //set the random variables as usable parameters
      .exec(
      _.setAll(
        ("firstName", firstName()),
        ("lastName", lastName())
      ))

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
      .exec(http("XUI${service}_170_005_RespondentsGo")
        .get("/case/PUBLICLAW/CARE_SUPERVISION_EPO/1621500656093644/trigger/enterRespondents")
        .headers(respondent_headers_3))

      .exec(http("XUI${service}_170_005_RespondentsGo")
        .get("/api/user/details")
        .headers(respondent_headers_22))

      .exec(http("XUI${service}_170_005_RespondentsGo")
        .get("/api/configuration?configurationKey=termsAndConditionsEnabled")
        .headers(respondent_headers_22))

      .exec(http("XUI${service}_170_005_RespondentsGo")
        .get("/data/internal/cases/1621500656093644")
        .headers(respondent_headers_30))

        .exec(http("XUI${service}_170_005_RespondentsGo")
      .get("/data/internal/cases/${caseId}/event-triggers/enterRespondents?ignore-warning=false")
      .headers(FPLAHeader.headers_76)
      .header("X-XSRF-TOKEN", "${XSRFToken}")
      .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
      .check(status.in(200,304)))

      .exec(http("XUI${service}_170_010_RespondentsGoProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_ordersneed1profile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_170_010_RespondentsGoProfile")
        .get("/api/caseshare/orgs")
        .headers(respondent_headers_63))

        .exec(http("XUI${service}_180_005_RespondentsGetAddress")
        .get("/addresses?postcode=SW1H9AJ")
        .headers(FPLAHeader.headers_16)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_180_005_RespondentsGetAddress")
        .get("/addresses?postcode=SW1H9AJ")
        .headers(FPLAHeader.headers_16)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .exec(http("XUI${service}_190_005_RespondentsContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=enterRespondents1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(RawFileBody("FPLRespondentDetails_0139_request.txt"))
        .check(status.in(200,304)))

      .exec(http("XUI${service}_200_005_RespondentsSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"respondents1\": [\n      {\n        \"id\": \"416c4c9c-fdae-4259-8e32-fc7877dc1abf\",\n        \"value\": {\n          \"party\": {\n            \"firstName\": \"tess\",\n            \"lastName\": \"tickles\",\n            \"dateOfBirth\": \"1981-02-22\",\n            \"gender\": \"Female\",\n            \"placeOfBirth\": \"london\",\n            \"address\": {\n              \"AddressLine1\": \"Flat 12\",\n              \"AddressLine2\": \"Bramber House\",\n              \"AddressLine3\": \"Seven Kings Way\",\n              \"PostTown\": \"Kingston Upon Thames\",\n              \"County\": \"\",\n              \"PostCode\": \"KT2 5BU\",\n              \"Country\": \"United Kingdom\"\n            },\n            \"telephoneNumber\": {\n              \"telephoneNumber\": \"02088889966\",\n              \"contactDirection\": \"tess\"\n            },\n            \"relationshipToChild\": \"test\",\n            \"contactDetailsHidden\": \"No\",\n            \"litigationIssues\": \"NO\"\n          }\n        }\n      }\n    ]\n  },\n  \"event\": {\n    \"id\": \"enterRespondents\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(201,304)))

      .exec(http("XUI${service}_190_010_RespondentsContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_respondantprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_190_010_RespondentsContinueProfile")
        .post("/workallocation/searchForCompletable")
        .headers(respondent_headers_159)
        .body(RawFileBody("FPLRespondentDetails_0159_request.txt"))
        .check(status.is(401)))

        .exec(http("XUI${service}_200_010_RespondentsSaveViewCase")
        .get("/data/internal/cases/${caseId}")
        .headers(FPLAHeader.headers_casesprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      // enter applicant
      .exec(http("XUI${service}_210_005_ApplicantGo")
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
      .exec(http("XUI${service}_310_005_DocumentsGo")
        .get("/case/PUBLICLAW/CARE_SUPERVISION_EPO/${caseId}/trigger/uploadDocuments")
        .headers(headers_3))

      .exec(http("XUI${service}_310_005_DocumentsGo")
        .get(uri6 + "/api/configuration?configurationKey=termsAndConditionsEnabled")
        .headers(headers_22))

      .exec(http("XUI${service}_310_005_DocumentsGo")
        .get(uri6 + "/api/user/details")
        .headers(headers_22))

      .exec(http("XUI${service}_310_005_DocumentsGo")
        .get(uri6 + "/data/internal/cases/${caseId}")
        .headers(headers_31))

    .exec(http("XUI${service}_310_005_DocumentsGo")
      .get("/data/internal/cases/${caseId}/event-triggers/uploadDocuments?ignore-warning=false")
      .headers(FPLAHeader.headers_76)
      .header("X-XSRF-TOKEN", "${XSRFToken}")
      .check(jsonPath("$.event_token").saveAs("existing_case_event_token"))
      .check(status.in(200,304)))

      .exec(http("XUI${service}_310_010_DocumentsGoProfile")
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

      .exec{
        session =>
          println("This is the token:" + session("existing_case_event_token").as[String])
          session
      }
      .exec{
        session =>
          println("This is the DMURL:" + session("DMURL").as[String])
          session
      }
      .exec{
        session =>
          println("This is the document ID:" + session("Document_ID").as[String])
          session
      }

      .exec(getCookieValue(CookieKey("XSRF-TOKEN").withDomain(baseDomain).saveAs("XSRFToken")))

      .exec{
        session =>
          println("This is the XSRF token:" + session("XSRFToken").as[String])
          session
      }

      .exec(http("XUI${service}_330_005_DocumentsContinue")
        .post(uri6 + "/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=uploadDocumentsaddApplicationDocuments")
        .headers(headers_75)
        .body(RawFileBody("FPLUploadDocument_0075_request.txt")))

      /*.exec(http("XUI${service}_330_005_DocumentsContinue")
        .post("/data/case-types/CARE_SUPERVISION_EPO/validate?pageId=uploadDocuments1")
        .headers(FPLAHeader.headers_71)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"documents_socialWorkChronology_document\": {\n      \"documentStatus\": \"Attached\",\n      \"typeOfDocument\": {\n        \"document_url\": \"http://dm-store-aat.service.core-compute-aat.internal/documents/${Document_ID}\",\n        \"document_binary_url\": \"http://dm-store-aat.service.core-compute-aat.internal/documents/${Document_ID}/binary\",\n        \"document_filename\": \"3MB.pdf\"\n      }\n    },\n    \"documents_socialWorkStatement_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkAssessment_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkCarePlan_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkEvidenceTemplate_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_threshold_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_checklist_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkOther\": []\n  },\n  \"event\": {\n    \"id\": \"uploadDocuments\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false,\n  \"event_data\": {\n    \"documents_socialWorkChronology_document\": {\n      \"documentStatus\": \"Attached\",\n      \"typeOfDocument\": {\n        \"document_url\": \"http://dm-store-aat.service.core-compute-aat.internal/documents/${Document_ID}\",\n        \"document_binary_url\": \"http://dm-store-aat.service.core-compute-aat.internal/documents/${Document_ID}/binary\",\n        \"document_filename\": \"3MB.pdf\"\n      }\n    },\n    \"documents_socialWorkStatement_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkAssessment_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkCarePlan_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkEvidenceTemplate_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_threshold_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_checklist_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkOther\": []\n  },\n  \"case_reference\": \"${caseId}\"\n}"))
        .check(status.in(200,304)))*/

      .exec(http("XUI${service}_330_010_DocumentsContinueProfile")
        .get("/data/internal/profile")
        .headers(FPLAHeader.headers_uploaddocprofile)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .check(status.in(200,304)))

      .pause(MinThinkTime, MaxThinkTime)

      .exec(http("XUI${service}_330_010_DocumentsContinueProfile")
        .post(uri6 + "/workallocation/searchForCompletable")
        .headers(headers_98)
        .body(RawFileBody("FPLUploadDocument_0098_request.txt"))
        .check(status.is(401)))

  /*.exec(http("XUI${service}_340_005_DocumentsSaveContinue")
        .post("/data/cases/${caseId}/events")
        .headers(FPLAHeader.headers_80)
        .header("X-XSRF-TOKEN", "${XSRFToken}")
        .body(StringBody("{\n  \"data\": {\n    \"documents_socialWorkChronology_document\": {\n      \"documentStatus\": \"Attached\",\n      \"typeOfDocument\": {\n        \"document_url\": \"http://dm-store-aat.service.core-compute-aat.internal/documents/${Document_ID}\",\n        \"document_binary_url\": \"http://dm-store-aat.service.core-compute-aat.internal/documents/${Document_ID}/binary\",\n        \"document_filename\": \"3MB.pdf\"\n      }\n    },\n    \"documents_socialWorkStatement_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkAssessment_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkCarePlan_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkEvidenceTemplate_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_threshold_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_checklist_document\": {\n      \"documentStatus\": \"To follow\",\n      \"statusReason\": \"test\"\n    },\n    \"documents_socialWorkOther\": []\n  },\n  \"event\": {\n    \"id\": \"uploadDocuments\",\n    \"summary\": \"\",\n    \"description\": \"\"\n  },\n  \"event_token\": \"${existing_case_event_token}\",\n  \"ignore_warning\": false\n}"))
        .check(status.in(200,304)))*/

      .exec(http("XUI${service}_340_010_DocumentsSaveViewCase")
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