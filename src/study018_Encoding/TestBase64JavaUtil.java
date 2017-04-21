package study018_Encoding;


import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;

import org.apache.commons.codec.binary.Base64;

import basic.Basic;
import study022_Signature.SignUtil;

public class TestBase64JavaUtil extends Basic{
	
	public static final String PRIVATE_KEY_1 = "\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCxGXIoFDjHOMhB\nepezgz4S9x3KnwzMdlvZUwoP+JIoOADqOA3Mccwxg5/1tfsPWcTeJOFzsXT6XnMp\nh0BaE01p4atjO2Z6aXBI+xQ0fVrjMeH/U+hnVWG1M5lmFwt7T14/pdQWOpoHe2yc\nLPbn6XnbVV1iRQLM+9uxC3pIRGvvYjdJw+QW2qdMk6ybtViD3PT4n9Gs9rw4b7/W\n3u46+R0BB/aNC9PD5ppV8Pni2fiHFCc+MKID9xoyxTqSiSEqxXVOqcjHIKaxtldl\nBzczB+P1L5W3/zLKVNYejw0Hnkme+f13krS3qBTnGDN/mOJm5UhX3zak9p7r7GtW\nf4HGxCjjAgMBAAECggEANVA0tm4H/alRV6zhGDBNMoZj2Ihy4OZMlirSX6Zz0Vmy\npM/FD6O+VbWLJPvonWFny3wMxrhIP8rJHlpR/AvNhS9jWdca7YTqQX4cQgTupHBy\n2VtYHits45CqADq1wSROehigtSRlFBWKx6UdmwkFHwsetqORyUWUiEKtSC4Y1BIb\nM96xLzL2jswb/p6NefhcAHnMF39na3DhSMhZHZkBy4gOT2th4/wHbWZEtPhiYyYr\nY8dwMMDXVP4D7B0BBrB+xzniteBeJhJjytsKecx7e8VbgsSWYqL6nno9ejTzw8OV\nDO80dSddKts0dceTR/b3A2vWFaJbwAFDYTw4f6WJKQKBgQDsArM+3SBWATr3WBMC\nOIR7C3YBSFloukweWd9ulAQC99wcYmniKPc1uZiMTmFpcXo0qSBT4UgB8ilFvxFo\nlQoPbEQQTte9M+N9xlmKvo8KdUMdaVs7/UwaSbK0ImqFMnozo6J5gtn84VgZ+DRo\ncEKB0hWHtJ2gh8MtdtVqCESP7wKBgQDAGWeLNdvtl1mocpYmy8hNYe90U2Oi/2Mw\noQK+cWDwTHCc92Uikjq5rLY96qsLD7qjwTxR0XEiUuM70Kp0ZqLQ0l0UWtDSDSxs\nh2bmMw+95ZdiQnfHhu8aaAV33OEPTEnm9wI8k7m7COy03NZ7MGn7B99VXFOhNQhh\nxXVcyksCTQKBgQCKMf6RVdwEYE4N3WWsDDoO7qQXliy8dTHzJ778OfGrZ0Vc3YeQ\npVoz/ExGA/NoUck0IsBKPYTzlr/yFjJ0Yaj1ZPjp77DGGicgU8/EvVZ20jkNdM62\nbthsIDFi5zAmdGs3555Qtn08ZRs4gaz2Zp2a9NAkmW8fO7/e1FGc9+BlwwKBgGRz\nZF+5VD3TbQDWmonC+gTs92geyvVLErU1HNg1NXmynxiVjX8cdDTviYSrF7H7EZ/b\nxg0Ktlw6d7Spkti3auBDgITKUHPmi5pc24P4o3yreBPbqgLeHl3ykxlwmQeE3wg1\nlifTH8YcDpss98MHOAQaw8BBPUIJF075EDvrVHnpAoGACqSJ+ER8aYFIZCJw9FNf\nj7e6AMOVTtquCI0uYmp+UIF0X1nbNCqC4ogLpSVSf11yRkibyWT+Z89D4kYkb2lZ\nzuhKAyurcrNESgEfwCTxlGyWQvy4RVGWQbmdYCyvZ238sK2Tf5xhn21YmwbDDF3F\np62/HPVb63725PIMgcAiKUE=\n";
	public static final String PRIVATE_KEY_2 = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCxGXIoFDjHOMhBepezgz4S9x3KnwzMdlvZUwoP+JIoOADqOA3Mccwxg5/1tfsPWcTeJOFzsXT6XnMph0BaE01p4atjO2Z6aXBI+xQ0fVrjMeH/U+hnVWG1M5lmFwt7T14/pdQWOpoHe2ycLPbn6XnbVV1iRQLM+9uxC3pIRGvvYjdJw+QW2qdMk6ybtViD3PT4n9Gs9rw4b7/W3u46+R0BB/aNC9PD5ppV8Pni2fiHFCc+MKID9xoyxTqSiSEqxXVOqcjHIKaxtldlBzczB+P1L5W3/zLKVNYejw0Hnkme+f13krS3qBTnGDN/mOJm5UhX3zak9p7r7GtWf4HGxCjjAgMBAAECggEANVA0tm4H/alRV6zhGDBNMoZj2Ihy4OZMlirSX6Zz0VmypM/FD6O+VbWLJPvonWFny3wMxrhIP8rJHlpR/AvNhS9jWdca7YTqQX4cQgTupHBy2VtYHits45CqADq1wSROehigtSRlFBWKx6UdmwkFHwsetqORyUWUiEKtSC4Y1BIbM96xLzL2jswb/p6NefhcAHnMF39na3DhSMhZHZkBy4gOT2th4/wHbWZEtPhiYyYrY8dwMMDXVP4D7B0BBrB+xzniteBeJhJjytsKecx7e8VbgsSWYqL6nno9ejTzw8OVDO80dSddKts0dceTR/b3A2vWFaJbwAFDYTw4f6WJKQKBgQDsArM+3SBWATr3WBMCOIR7C3YBSFloukweWd9ulAQC99wcYmniKPc1uZiMTmFpcXo0qSBT4UgB8ilFvxFolQoPbEQQTte9M+N9xlmKvo8KdUMdaVs7/UwaSbK0ImqFMnozo6J5gtn84VgZ+DRocEKB0hWHtJ2gh8MtdtVqCESP7wKBgQDAGWeLNdvtl1mocpYmy8hNYe90U2Oi/2MwoQK+cWDwTHCc92Uikjq5rLY96qsLD7qjwTxR0XEiUuM70Kp0ZqLQ0l0UWtDSDSxsh2bmMw+95ZdiQnfHhu8aaAV33OEPTEnm9wI8k7m7COy03NZ7MGn7B99VXFOhNQhhxXVcyksCTQKBgQCKMf6RVdwEYE4N3WWsDDoO7qQXliy8dTHzJ778OfGrZ0Vc3YeQpVoz/ExGA/NoUck0IsBKPYTzlr/yFjJ0Yaj1ZPjp77DGGicgU8/EvVZ20jkNdM62bthsIDFi5zAmdGs3555Qtn08ZRs4gaz2Zp2a9NAkmW8fO7/e1FGc9+BlwwKBgGRzZF+5VD3TbQDWmonC+gTs92geyvVLErU1HNg1NXmynxiVjX8cdDTviYSrF7H7EZ/bxg0Ktlw6d7Spkti3auBDgITKUHPmi5pc24P4o3yreBPbqgLeHl3ykxlwmQeE3wg1lifTH8YcDpss98MHOAQaw8BBPUIJF075EDvrVHnpAoGACqSJ+ER8aYFIZCJw9FNfj7e6AMOVTtquCI0uYmp+UIF0X1nbNCqC4ogLpSVSf11yRkibyWT+Z89D4kYkb2lZzuhKAyurcrNESgEfwCTxlGyWQvy4RVGWQbmdYCyvZ238sK2Tf5xhn21YmwbDDF3Fp62/HPVb63725PIMgcAiKUE=";
	
	public static final String JSON_SECRET_FILE_PATH = "";
	
	public static void main(String[] args){
		try{
//			String[] params = new String[]{"{\"alg\":\"RS256\",\"typ\":\"JWT\"}", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9", "{\"alg\":\"RS256\",\"typ\":\"JWT\"}123456","123456"};
			String[] params = new String[]{
					"{\"alg\":\"RS256\",\"typ\":\"JWT\"}",
					"{\"iss\":\"qraved-maps-booking-service@qraved-id.iam.gserviceaccount.com\",\"scope\":\"https://www.googleapis.com/auth/mapsbooking\",\"aud\":\"https://www.googleapis.com/oauth2/v4/token\",\"exp\":1491878003,\"iat\":1491874403}"
			};
//			test000(params);
			
			KeyStore ks = KeyStore.getInstance("PKCS12");
//			ks.load(new FileInputStream(JSON_SECRET_FILE_PATH), "joepasswd".toCharArray());
			
			KeyFactory factory = KeyFactory.getInstance("RSA");
			
			PrivateKey key1 = null;
			byte[] privateKeyByteArr1 = Base64.decodeBase64(PRIVATE_KEY_1);
			PKCS8EncodedKeySpec keySpec1 = new PKCS8EncodedKeySpec(privateKeyByteArr1);
			key1 = factory.generatePrivate(keySpec1);
			
			
			PrivateKey key2 = null;
			byte[] privateKeyByteArr2 = Base64.decodeBase64(PRIVATE_KEY_2);
//			RSAPrivateKeySpec rasKeySpec = new RSAPrivateKeySpec(modulus, privateExponent)
			PKCS8EncodedKeySpec keySpec2 = new PKCS8EncodedKeySpec(privateKeyByteArr2);
			key2 = factory.generatePrivate(keySpec2);
			
			StringBuffer generatedInput = step01(params);
			byte[] signature1 = step02(generatedInput.toString(), key1);
			byte[] signature2 = step02(generatedInput.toString(), key2);
			
//			pl(signature1.length);
//			pl(signature2.length);
			
			String signatureBase64_1 = Base64.encodeBase64String(signature1);
			pl(signatureBase64_1);
			String signatureBase64_2 = Base64.encodeBase64String(signature2);
			pl(signatureBase64_2);
//			for(byte b : signature){
//				pl(b);
//			}
			
			
			
			
			
			
			
//			test001();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static void test000(String... params){
		for(String param :params){
			pl(param);
			String result = Base64.encodeBase64String(param.getBytes());
			pl(result);
		}
	}
	
	public static void test001(){
		Provider[] ps = Security.getProviders();
		for(Provider p : ps){
			pl(p);
		}
	}
	
	public static StringBuffer step01(String...params) throws Exception{
		String x = null;
		String y = null;
		StringBuffer generatedInput = new StringBuffer()
		.append(x = Base64.encodeBase64String(params[0].getBytes("UTF8")))
		.append(".")
		.append(y = Base64.encodeBase64String(params[1].getBytes("UTF8")));
		pl(x);
		pl(y);
		
//		while(x.startsWith("=")){
//			x.replaceFirst("=", "");
//		}
//		
//		while(x.endsWith("=")){
//			x = x.substring(0, x.length()-1);
//		}
//		
//		while(y.startsWith("=")){
//			y.replaceFirst("=", "");
//		}
//		
//		while(y.endsWith("=")){
//			y = y.substring(0, y.length()-1);
//		}

		pl(x);
		pl(y);
		
		pl(x = new String(Base64.decodeBase64(x.getBytes("UTF8"))));
		pl(y = new String(Base64.decodeBase64(y.getBytes("UTF8"))));
//		pl(x.equals(params[0]));
//		pl(y.equals(params[1]));
		return generatedInput;
	}
	
	public static byte[] step02(String input, PrivateKey key)throws Exception{
		return SignUtil.sign256(input, key);
	}
	
	
}

