package a.b.c.common;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//import javax.crypto.BadPaddingException;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.InvalidAlgorithmParameterException;

import org.apache.commons.codec.binary.Base64;

public class EncryptAES {

	final static String secretKey = "shplab123456789abcdefghijklmnopq"; // 32bit	
    static String IV = secretKey.substring(0, 16); // 16bit
    // #####################  //
    // 싱글톤 패턴 적용 : 객체를 하나만 사용하세요 : 객체는 항상 메모리에 하나만 있어야 한다. 
    private EncryptAES() {    
    }
    
    public static EncryptAES getInstance() {
    	return SingletonLazyHolder.INSTANCE;
    }
    
    private static class SingletonLazyHolder {
    	private static final EncryptAES INSTANCE = new EncryptAES();
    }
    // #####################  //
    
    // 암호화
    public String aesEncode(String str){
    	
		String enStr = "";
		
		try {
			
			byte[] keyData = secretKey.getBytes();
			SecretKey secureKey = new SecretKeySpec(keyData, "AES");
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));
			
			byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
			
			enStr = new String(Base64.encodeBase64(encrypted));
			
		}catch(Exception e) {
		}
		
		return enStr;
	}

    // 복호화
    public String aesDecode(String str){
    	
    	String deStr = "";
        
		try {
			
			byte[] keyData = secretKey.getBytes();
			SecretKey secureKey = new SecretKeySpec(keyData, "AES");
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));
			
			byte[] byteStr = Base64.decodeBase64(str.getBytes());
			
			deStr = new String(c.doFinal(byteStr), "UTF-8");
			
		}catch(Exception e) {
		}
		
		return deStr;
    }
      
	public static void main(String args[]) {
    	
    	String id = "shplab123";
    	
    	EncryptAES ase = EncryptAES.getInstance();
    	String enId = ase.aesEncode(id);
        String desId = ase.aesDecode(enId);
        
        System.out.println("enId >>> : " + enId);
        System.out.println("desId >>> : " + desId);
    }
} 
