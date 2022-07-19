package offices

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.typesafe.config._

class Offices extends Simulation {
  val config = ConfigFactory.load("application")

  var baseUrl = config.getString("url.baseUrl")

  val httpProtocol = http
    .baseUrl(baseUrl)
    .inferHtmlResources(WhiteList(), BlackList())
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("PostmanRuntime/7.28.4")

  val headers = Map(
    "Cache-Control" -> "no-cache",
    "Postman-Token" -> "a435098d-aa46-4824-970f-756a972d44ce"
  )

  var oficinas = csv("feeders/oficinas.csv")
  var oficinas2 = csv("feeders/oficinas.csv")

  object Offices {
    val getAll =
      exec(
        http("Obtener oficinas")
          .get(baseUrl + "/api/offices")
          .headers(headers)
          .check(status.is(200))
          .check(jsonPath("$.header.status").is("000"))
          .check(jsonPath("$.body.response[0].officeId").saveAs("officeId"))
      )
    val getById =
      exec(
        http("Obtener oficina por id")
          .get(baseUrl + "/api/offices/${officeId}")
          .headers(headers)
          .check(status.is(200))
          .check(jsonPath("$.header.status").is("000"))
      )
    val update =
      exec(
        http("Actualizar oficina por id")
          .put(baseUrl + "/api/offices/${officeId}")
          .body(StringBody("""{
            "territory": "NA",
            "country": "USA",
            "city": "San Francisco UPDATED gatling",
            "state": "CA",
            "addressLine1": "100 Market Street",
            "addressLine2": "Suite 300",
            "phone": "+1 650 219 4782",
            "zip": "94080"
          }""".stripMargin))
          .asJson
          .headers(headers)
          .check(status.is(200))
      )
    val create =
      feed(oficinas)
        .exec(
          http("Agregar oficina por feeder")
            .post(baseUrl + "/api/offices")
            .body(StringBody("""{
                "officeId" : "${officeId}",
                "territory":"${territory}",
                "country": "${country}",
                "city": "${city}",
                "state": "${state}",
                "addressLine1": "${addressLine1}",
                "addressLine2": "${addressLine1}",
                "phone": "${phone}",
                "zip": "${zip}"
              }""".stripMargin))
            .asJson
            .headers(headers)
            .check(status.is(201))
        )

    val delete =
      feed(oficinas2)
        .exec(
          http("Eliminar oficina por id")
            .delete(baseUrl + "/api/offices/${officeId}")
            .headers(headers)
            .check(status.is(200))
        )
  }

  val scn = scenario("API de oficinas")
    .exec(Offices.getAll, Offices.getById, Offices.update, Offices.create, Offices.delete)

  setUp(
    scn.inject(rampUsers(50).during(10))
  ).protocols(httpProtocol)

}
