package uk.gov.hmcts.reform.exui.performance


object Feeders {


  val random = new scala.util.Random

  val repeat  = List(1, 2, 3,4,5)

  def sequenceValue() =
    Stream.continually(repeat.toStream).flatten.take(5).toList

  def randomString(alphabet: String)(n: Int): String =
    Stream.continually(random.nextInt(alphabet.size)).map(alphabet).take(n).mkString


  def randomAlphanumericString(n: Int) =
    randomString("abcdefghijklmnopqrstuvwxyz0123456789")(n)



  var generatedEmail = ""
  var generatedPassword = ""
  var generatedEmailForCase = ""
  var orgName = ""
  var appReferenceName = ""
  var sequence1=0
  var seq = 1

  def nextSeq() : Integer = {

    seq = seq + 1
        seq
    }



  /*def nextseq1()=
    nextSeq()*/
  def generatenextNumber() :Integer = {
    sequence1 = (sequenceValue().iterator.next())
    sequence1
  }

  def generateOrganisationName() :String = {
    orgName = ("fplaatorg-" + randomAlphanumericString(5))
    orgName
  }

  def generateEmailAddress() :String = {
    generatedEmail = (generateOrganisationName() + "_superuser@mailinator.com")
    //print("generated enail"+generatedEmail)
    generatedEmail
  }

  def generateUserEmailAddress() :String = {
    generatedEmail = (generateOrganisationName() + "_user"+"@mailtest.gov.uk")
    //print("generated enail"+generatedEmail)
    generatedEmail
  }



  def generateEmailForCase() :String = {
    generatedEmailForCase = ("exui_case" + randomAlphanumericString(6) + "@mailtest.gov.uk")
    //print("generated enail"+generatedEmail)
    generatedEmailForCase
  }

  def generateAppReferenceName() :String = {
    appReferenceName = ("case ref perftest" + randomAlphanumericString(6))
    appReferenceName
  }
  /*def generatePassword() :String = {
    generatedPassword = randomAlphanumericString(9)
    generatedPassword
  }*/

 /* def generateEmailAddress() :String = {
    generatedEmail = ("simulate-delivered-demo-3330@mailinator.com")
    generatedEmail
  }*/

  def generatePassword() :String = {
    generatedPassword = "Pass19word"
    generatedPassword
  }



  val createDynamicDataFeeder = Iterator.continually(Map("generatedEmail" -> ({
    generateOrganisationName()+"-su@mailtest.gov.uk"
  }),
    "orgName" -> ({
    orgName
  })
  ));
  /*val createDynamicDataFeeder = Iterator.continually(Map("generatedEmail" -> (generatedEmail), "generatedPassword" -> (generatedPassword), "generateOrganisationName" -> (orgName)));
*/

  val createCaseData = Iterator.continually(Map("caseEmail" -> ({
    generateEmailForCase()
  }),"appRef" -> ({
    generateAppReferenceName()
  })));

  val createDynamicUserDataFeeder = Iterator.continually(Map("generatedUserEmail" -> ({
    "-user"
  })));




  val FPLCreateDataFeeder = Iterator.continually(Map("service" -> ({
    "FPLC"
  }),
    "SignoutNumber" -> ({
      "380"
    })
  ));


  val FPLViewDataFeeder = Iterator.continually(Map("service" -> ({
    "FPLV"
  }),
    "SignoutNumber" -> ({
      "070"
    })
  ));

  val FPLSDODataFeeder = Iterator.continually(Map("service" -> ({
    "SDO"
  }),
    "SignoutNumberAdmin" -> ({
      "150"
    }),
    "SignoutNumberGK" -> ({
      "290"
    })

  ));



  val CwDataFeeder = Iterator.continually(Map("service" -> ({
    "CW"
}),
    "SignoutNumber" -> ({
      "60"
    })
  ));




}



