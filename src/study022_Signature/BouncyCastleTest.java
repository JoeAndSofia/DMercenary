package study022_Signature;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;

import basic.Basic;

public class BouncyCastleTest extends Basic{
	
	public static final String PRIVATE_KEY_1 = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCxGXIoFDjHOMhBepezgz4S9x3KnwzMdlvZUwoP+JIoOADqOA3Mccwxg5/1tfsPWcTeJOFzsXT6XnMph0BaE01p4atjO2Z6aXBI+xQ0fVrjMeH/U+hnVWG1M5lmFwt7T14/pdQWOpoHe2ycLPbn6XnbVV1iRQLM+9uxC3pIRGvvYjdJw+QW2qdMk6ybtViD3PT4n9Gs9rw4b7/W3u46+R0BB/aNC9PD5ppV8Pni2fiHFCc+MKID9xoyxTqSiSEqxXVOqcjHIKaxtldlBzczB+P1L5W3/zLKVNYejw0Hnkme+f13krS3qBTnGDN/mOJm5UhX3zak9p7r7GtWf4HGxCjjAgMBAAECggEANVA0tm4H/alRV6zhGDBNMoZj2Ihy4OZMlirSX6Zz0VmypM/FD6O+VbWLJPvonWFny3wMxrhIP8rJHlpR/AvNhS9jWdca7YTqQX4cQgTupHBy2VtYHits45CqADq1wSROehigtSRlFBWKx6UdmwkFHwsetqORyUWUiEKtSC4Y1BIbM96xLzL2jswb/p6NefhcAHnMF39na3DhSMhZHZkBy4gOT2th4/wHbWZEtPhiYyYrY8dwMMDXVP4D7B0BBrB+xzniteBeJhJjytsKecx7e8VbgsSWYqL6nno9ejTzw8OVDO80dSddKts0dceTR/b3A2vWFaJbwAFDYTw4f6WJKQKBgQDsArM+3SBWATr3WBMCOIR7C3YBSFloukweWd9ulAQC99wcYmniKPc1uZiMTmFpcXo0qSBT4UgB8ilFvxFolQoPbEQQTte9M+N9xlmKvo8KdUMdaVs7/UwaSbK0ImqFMnozo6J5gtn84VgZ+DRocEKB0hWHtJ2gh8MtdtVqCESP7wKBgQDAGWeLNdvtl1mocpYmy8hNYe90U2Oi/2MwoQK+cWDwTHCc92Uikjq5rLY96qsLD7qjwTxR0XEiUuM70Kp0ZqLQ0l0UWtDSDSxsh2bmMw+95ZdiQnfHhu8aaAV33OEPTEnm9wI8k7m7COy03NZ7MGn7B99VXFOhNQhhxXVcyksCTQKBgQCKMf6RVdwEYE4N3WWsDDoO7qQXliy8dTHzJ778OfGrZ0Vc3YeQpVoz/ExGA/NoUck0IsBKPYTzlr/yFjJ0Yaj1ZPjp77DGGicgU8/EvVZ20jkNdM62bthsIDFi5zAmdGs3555Qtn08ZRs4gaz2Zp2a9NAkmW8fO7/e1FGc9+BlwwKBgGRzZF+5VD3TbQDWmonC+gTs92geyvVLErU1HNg1NXmynxiVjX8cdDTviYSrF7H7EZ/bxg0Ktlw6d7Spkti3auBDgITKUHPmi5pc24P4o3yreBPbqgLeHl3ykxlwmQeE3wg1lifTH8YcDpss98MHOAQaw8BBPUIJF075EDvrVHnpAoGACqSJ+ER8aYFIZCJw9FNfj7e6AMOVTtquCI0uYmp+UIF0X1nbNCqC4ogLpSVSf11yRkibyWT+Z89D4kYkb2lZzuhKAyurcrNESgEfwCTxlGyWQvy4RVGWQbmdYCyvZ238sK2Tf5xhn21YmwbDDF3Fp62/HPVb63725PIMgcAiKUE=";
	
	public static void main(String[] args){
		try{
			test001();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void test001()throws Exception{
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PrivateKey key1 = null;
		byte[] privateKeyByteArr1 = Base64.decodeBase64(PRIVATE_KEY_1);
		PKCS8EncodedKeySpec keySpec1 = new PKCS8EncodedKeySpec(privateKeyByteArr1);
		key1 = factory.generatePrivate(keySpec1);
		
		byte[] pkBytes = key1.getEncoded();
		PrivateKeyInfo pkInfo = PrivateKeyInfo.getInstance(pkBytes);
		ASN1Encodable encodable = pkInfo.parsePrivateKey();
		ASN1Primitive primitive = encodable.toASN1Primitive();
		byte[] privateKeyPKCS1 = primitive.getEncoded();
//		String x = Base64.decodeBase64(privateKeyPKCS1);
		pl(privateKeyPKCS1.length);
		for(int i=0; i<privateKeyPKCS1.length; i++){
			if((i+1)%64==0){
				p(privateKeyPKCS1[i]+",\n");
			}else{
				p(privateKeyPKCS1[i]+",");
			}
		}
	}
}
