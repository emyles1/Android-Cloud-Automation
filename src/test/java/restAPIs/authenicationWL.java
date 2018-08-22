package restAPIs;


import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static org.hamcrest.Matchers.*;

public class authenicationWL  {
	
	String client_id = "123456790006";
	String client_secret = "P@ssword";
	String refresh_token = "";

	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://common-aws3-us-east-1-dev-wlpc.cloud.synchronoss.net";
		RestAssured.basePath = "atp/oauth2/sessions";
	}

	@Test
	public String accessToken() {
		Response response = given()

			.header("Postman-User-Agent", "SyncDrive/Postman")
			.header("Content-Type", "application/x-www-form-urlencoded")
			.header("x-application-identifier","syncdrive.9051af33d6353de9")
			.header("X-Scope-Service","DV")
			.header("X-Client-Platform","HANDSET")
			.header("X-Client-Identifier","Postman")
			.header("Accept","application/json")
			.header("User-Agent", "SyncDrive")
			.param("client_id", "123456790006")
			.param("client_secret", "P@ssword")
			.param("grant_type", "client_credentials")

		.when()
			.post()
		.then()
		.log().all()
			.statusCode(200)
			.extract()
			.response();

		refresh_token = response.path("refresh_token");
		System.out.print(refresh_token);
		
		return refresh_token;


	}
}
	

