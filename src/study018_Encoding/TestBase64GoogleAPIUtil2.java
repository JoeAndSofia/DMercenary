package study018_Encoding;



import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;

import basic.Basic;

public class TestBase64GoogleAPIUtil2 extends Basic{

	public static void main(String[] args){
		try{
//			String[] params = new String[]{"{\"alg\":\"RS256\",\"typ\":\"JWT\"}", "123", "456", "{\"alg\":\"RS256\",\"typ\":\"JWT\"}123456","123456"};
//			String[] params = new String[]{	"1","2","3","4","5","6",};
			String[] params = new String[]{
					"{\"alg\":\"RS256\",\"typ\":\"JWT\"}",
					"{\"iss\":\"761326798069-r5mljlln1rd4lrbhg75efgigp36m78j5@developer.gserviceaccount.com\",\"scope\":\"https://www.googleapis.com/auth/prediction\",\"aud\":\"https://www.googleapis.com/oauth2/v4/token\",\"exp\":1328554385,\"iat\":1328550785}",
					
			};
			String[] compareParams = new String[]{
					"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9",
					"eyJpc3MiOiI3NjEzMjY3OTgwNjktcjVtbGpsbG4xcmQ0bHJiaGc3NWVmZ2lncDM2bTc4ajVAZGV2ZWxvcGVyLmdzZXJ2aWNlYWNjb3VudC5jb20iLCJzY29wZSI6Imh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL2F1dGgvcHJlZGljdGlvbiIsImF1ZCI6Imh0dHBzOi8vd3d3Lmdvb2dsZWFwaXMuY29tL29hdXRoMi92NC90b2tlbiIsImV4cCI6MTMyODU1NDM4NSwiaWF0IjoxMzI4NTUwNzg1fQ",
					"UFUt59SUM2_AW4cRU8Y0BYVQsNTo4n7AFsNrqOpYiICDu37vVt-tw38UKzjmUKtcRsLLjrR3gFW3dNDMx_pL9DVjgVHDdYirtrCekUHOYoa1CMR66nxep5q5cBQ4y4u2kIgSvChCTc9pmLLNoIem-ruCecAJYgI9Ks7pTnW1gkOKs0x3YpiLpzplVHAkkHztaXiJdtpBcY1OXyo6jTQCa3Lk2Q3va1dPkh_d--GU2M5flgd8xNBPYw4vxyt0mP59XZlHMpztZt0soSgObf7G3GXArreF_6tpbFsS3z2t5zkEiHuWJXpzcYr5zWTRPDEHsejeBSG8EgpLDce2380ROQ",
			};
//			test000("{\"alg\":\"RS256\",\"typ\":\"JWT\"}.{\"iss\":\"761326798069-r5mljlln1rd4lrbhg75efgigp36m78j5@developer.gserviceaccount.com\",\"scope\":\"https://www.googleapis.com/auth/prediction\",\"aud\":\"https://www.googleapis.com/oauth2/v4/token\",\"exp\":1328554385,\"iat\":1328550785}");
//			test001(params, compareParams);
			test002(params, null);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void test000(String param){
		String result = Base64.encodeBase64String(param.getBytes());
		pl(result);
	}
	
	public static void test001(String[] params, String[] compareParams){
		for(int i=0;i<params.length;i++){
			String param = params[i];
			String result = Base64.encodeBase64String(param.getBytes());
			pl(result);
			pl(compareParams[i]);
			pl(compareParams[i].equals(result));
		}
	}
	
	public static void test002(String[] params, String[] compareParams){
		StringBuffer inputSb = new StringBuffer();
		inputSb.append(params[0]);
		inputSb.append(".");
		inputSb.append(params[1]);
		
		StringBuffer hashedSb = new StringBuffer();
		hashedSb.append(Base64.encodeBase64String(params[0].getBytes()));
		hashedSb.append(".");
		hashedSb.append(Base64.encodeBase64String(params[1].getBytes()));
		
		String signature = Base64.encodeBase64String(hashedSb.toString().getBytes());
		
		hashedSb.append(".");
		hashedSb.append(signature);

		pl(hashedSb);
		
	}
}
