package Payloads;

public class putPayload {
	
	public static String putAPI(String placeId,String address,String Key)
	{
		return "{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\""+Key+"\"\r\n"
				+ "}";
	}

}
