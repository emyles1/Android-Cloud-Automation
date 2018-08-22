package restAPIs;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonutilities.RestUtilities;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class authenicationVzn  {
	
	RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpec;
	String refresh_token = "";
	String lcid = "";
	String access_token = "";
	String NWBToken = "";

	
//	@BeforeClass
//	public void setup() {
//
//	}

	@Test
	public void refreshToken() {
		Response response = given()
				.spec(RestUtilities.getRequestSpecGlobal())
				
				.header("Accept","application/json")
				.header("x-application-identifier","DV")
				.header("X-Newbay-User-Uid", "2188080881")
				.header("X-Scope-Service","DV")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("User-Agent", "SyncDrive")
				.body("grant_type=http://purl.oclc.org/webdata/auth/ccoe&assertion=enriched")
			
				//.param("grant_type", "http://purl.oclc.org/webdata/auth/ccoe")
				//.param("assertion", "enriched")
		.when()
			.post()
		.then()
		.log().all()
			.statusCode(200)
			.extract()
			.response();

		refresh_token = response.path("refresh_token");
		lcid = response.path("lcid");
		access_token = response.path("access_token");
		

	}
	
	@Test (dependsOnMethods = { "refreshToken" })
	public void mmCount() {
		
		System.out.print("NWB token=\""+access_token+"\"; authVersion=\"1.0\";");

		Response response = given()
				.log().all()

				.spec(RestUtilities.getMMRequestSpecification())	
				.header("Accept","application/vnd.newbay.message-1.0+json")
				.header("Content-Type", "application/vnd.newbay.message-1.0+json")
				.header("Authorization", "NWB token=\""+access_token+"\"; authVersion=\"1.0\";")

				
		.when()
			.get()
		.then()
		.log().all()
			.statusCode(200)
			.extract()
			.response();

	}
	
	@Test (dependsOnMethods = { "mmCount" })
	public void upload() {
		

		Response response = given()
				.log().all()

				.spec(RestUtilities.getDVRequestSpecification())	
				.header("Accept","application/vnd.newbay.dv-1.16+json")
				.header("Content-Type", "multipart/form-data")
				.header("Authorization", "NWB token=\""+access_token+"\"; authVersion=\"1.0\";")
				
				.formParam("files=@Ape.xml", "type=application/vnd.newbay.dv-1.16+xml")
				.formParam("665a1dacb1679481472227ec77dae34a43efa33afb04bb83d962b56622d063b0=@Ape.png")
		
		.when()
			.get()
		.then()
		.log().all()
			.statusCode(200)
			.extract()
			.response();

	}
}
	

