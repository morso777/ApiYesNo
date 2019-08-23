package api;


	import org.testng.annotations.Test;
	import org.testng.AssertJUnit;
	import org.testng.Assert;
	import static io.restassured.RestAssured.*;
	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	
	public class ApiTesting {

		@Test
		 void getbody()
		 {
		  //Specify base URI
		  RestAssured.baseURI="https://api.adviceslip.com";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		  Response response=httpRequest.request(Method.GET,"/advice");
		  
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		 }
		
		
		@Test
		public void testResponsecode ()
		{				
			Response resp =get("https://api.adviceslip.com/advice");
			int code=resp.getStatusCode();
			System.out.println("Status code is "+code);
			Assert.assertEquals(code, 200);
				
		    String statusLine=resp.getStatusLine();
		    System.out.println("Status line is:"+statusLine);
		    Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	    }
		
		
		
		@Test
		public void corto ()
		{
			Response resp =get("https://api.adviceslip.com/advice");					
			String data=resp.asString();
			System.out.println("Data is "+ data);
			System.out.println("Response time long "+resp.getTime());
		}
		
		@Test
		public void largo ()
		{
			long time= get("https://api.adviceslip.com/advice").getTime();
			System.out.println("Response time short "+time);
		}
	}

