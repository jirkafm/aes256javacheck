package jirkafm;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

/**
 * Simple utility class to check if AES256 can be used by JVM.
 * 
 * @author jkaplan
 *
 */
public class AES256JavaCheck {

	private static final String AES_TRANSFORMATION = "AES/CBC/PKCS5Padding";
	private static final String UNLIMITED_JCE_INSTALLED = "Unlimited JCE policy is active for JVM. JVM can use AES256.";
	private static final String UNLIMITED_JCE_NOT_INSTALLED = "Unlimited JCE policy has not been applied for JVM. JVM cannot use AES256.";

	public static void main(String[] args) throws NoSuchAlgorithmException {
		int maxAesCipherSize = Cipher.getMaxAllowedKeyLength(AES_TRANSFORMATION);
		String message = maxAesCipherSize == Integer.MAX_VALUE ? UNLIMITED_JCE_INSTALLED : UNLIMITED_JCE_NOT_INSTALLED;
		System.out.println(message);
	}

}
