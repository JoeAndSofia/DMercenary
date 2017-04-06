package study018_Encoding;

import java.util.Base64;

import basic.Basic;

public class TestBase64 extends Basic{
	
	public static void main(String[] args){
		try{
			String[] params = new String[]{"{\"alg\":\"RS256\",\"typ\":\"JWT\"}", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9", "{\"alg\":\"RS256\",\"typ\":\"JWT\"}123456","123456"}; 
			test001(params);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static void test001(String... params){
		Base64.Encoder b64 = Base64.getEncoder();
		for(String param :params){
			String result = b64.encodeToString(param.getBytes());
			pl(result);			
		}

	}
	
}
