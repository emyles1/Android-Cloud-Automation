package commonutilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;
import restAPIs.VznPath;

public class RestUtilities {
	
//	public static String BASEURi;
	public static RequestSpecBuilder REQUEST_BUILDER;
	public static RequestSpecification REQUEST_SPEC;
	
//	public static void setBaseURi(String buri){
//	
//	BASEURi = buri;
//	}
	

	public  static RequestSpecification getRequestSpecGlobal(){
		REQUEST_BUILDER = new RequestSpecBuilder();
		REQUEST_BUILDER.setBaseUri(VznPath.GLOBALBASE_URI);
		REQUEST_BUILDER.setBasePath(VznPath.BASEPATH);
		REQUEST_SPEC = REQUEST_BUILDER.build();
		return REQUEST_SPEC;
	}
	

	public static RequestSpecification getMMRequestSpecification() {
		REQUEST_BUILDER = new RequestSpecBuilder();
		REQUEST_BUILDER.setBaseUri(VznPath.MM_URI);
		REQUEST_BUILDER.setBasePath(VznPath.MSG_COUNT);
		REQUEST_SPEC = REQUEST_BUILDER.build();
		return REQUEST_SPEC;
	}
	
	public static RequestSpecification getDVRequestSpecification() {
		REQUEST_BUILDER = new RequestSpecBuilder();
		REQUEST_BUILDER.setBaseUri(VznPath.DV_URL);
		REQUEST_BUILDER.setBasePath(VznPath.MSG_COUNT);
		REQUEST_SPEC = REQUEST_BUILDER.build();
		return REQUEST_SPEC;
	}
}
