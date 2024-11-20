package Payloads;

public class deletePayload {
	
	public static String deleteAPI(String placeId)
	{
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}\r\n"
				+ "";
	}

}
