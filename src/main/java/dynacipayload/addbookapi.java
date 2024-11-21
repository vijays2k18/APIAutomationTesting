package dynacipayload;

public class addbookapi {
	
	public static String addbookapipayload(String aid,String uid)
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+aid+"\",\r\n"
				+ "\"aisle\":\""+uid+"\",\r\n"
				+ "\"author\":\"Vijay S\"\r\n"
				+ "}";
	}

}
