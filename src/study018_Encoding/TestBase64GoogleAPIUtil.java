package study018_Encoding;


import com.google.api.client.util.Base64;

import basic.Basic;

public class TestBase64GoogleAPIUtil extends Basic{
	
	public static void main(String[] args){
		try{
			String[] params = new String[]{"{\"alg\":\"RS256\",\"typ\":\"JWT\"}", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9", "{\"alg\":\"RS256\",\"typ\":\"JWT\"}123456","123456"}; 
			test001(params);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static void test001(String... params){
		for(String param :params){
//			String result = Base64.encodeBase64String(param.getBytes());
			byte[] result = Base64.encode(param.getBytes());
			pl(result);			
		}

	}
}
