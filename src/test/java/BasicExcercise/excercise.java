package BasicExcercise;

import org.testng.annotations.Test;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import Payloads.Courseprice;
import io.restassured.path.json.JsonPath;

public class excercise {
	
	@Test
	public void run()
	{
		SoftAssert as = new SoftAssert();
		JsonPath js = new JsonPath(Courseprice.courseAPI());
		
		// Number of Courses
		int numberofCourses = js.getInt("courses.size()");
		System.out.println("Number of Courses :" +numberofCourses);
		// Print Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount :" +purchaseAmount);
		// Print Title of First Courses
		String title = js.getString("courses[0].title");
		System.out.println("First Course Title "+title);
		int sum = 0;
		// Print all Course Title and Respective Price
		for(int i=0;i<numberofCourses;i++)
		{
			String getTitle = js.getString("courses[" + i + "].title");
			int getPrice = js.getInt("courses[" + i +"].price");
			int copies = js.getInt("courses[" + i + "].copies");
			System.out.println("Course Title "  +getTitle +"\n" +"getPrice " +getPrice);
			
			sum = sum + (getPrice*copies);
			
			//Print Number of Copies Sold by RPA
			
			if(getTitle.equalsIgnoreCase("RPA")) {
				// courses[2].copies
				int copiesSoldRPA = js.getInt("courses[" + i + "].copies");
				System.out.println("Number of Copies Sold By RPA : " +copiesSoldRPA);
			}
		}
			System.out.println("Checking Assertions for Purchase amount and Total Sum Amount");
			as.assertEquals(purchaseAmount, sum);
			System.out.println("PASS --> Checking purchase amoutn and total sum amount");
			as.assertAll();
		
				
	}

}
