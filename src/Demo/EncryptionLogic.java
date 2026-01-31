package Demo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionLogic {

	public String getSHA256(String strBlockRequest) {
		String shared_secret = "MSME_Unblk_@8&6%4_2@22";
		String algorithm = "HmacSHA256";
		String shaData = "";
		try {
			Mac sha256_hmac = Mac.getInstance(algorithm);
			SecretKeySpec secret_key = new SecretKeySpec(shared_secret.getBytes("UTF-8"), algorithm);
			sha256_hmac.init(secret_key);

			byte[] doFinal = sha256_hmac.doFinal(strBlockRequest.getBytes("UTF-8"));

			shaData = Base64.getEncoder().encodeToString(doFinal);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		} catch (InvalidKeyException e) {

			e.printStackTrace();

		}
		return shaData;
	}

	public static void main(String[] args) {

		EncryptionLogic obj = new EncryptionLogic();
		String blockRequestStr = "223344|BLOCK|WEB|2022-08-30 12:25:35";
		String ShaValue = obj.getSHA256(blockRequestStr);

		System.out.println(ShaValue);

	}
}
