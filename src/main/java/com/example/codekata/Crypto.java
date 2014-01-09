package com.example.codekata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

public class Crypto {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException {
		String userHomeDirectory = System.getProperty("user.home");
		String privateKey = readFile(userHomeDirectory + "/.ssh/" + "id_rsa");
		String publicKey = readFile(userHomeDirectory + "/.ssh/" + "id_rsa.pub");
		
		System.out.print("Please enter the message you want to encrypt: ");
		String message = new Scanner(System.in).next();
		
		byte[] encryptedMessage = encryptTheMessage(message, publicKey);
		System.out.println("Encrypted text: " + new String(encryptedMessage));
		byte[] decryptedMessage = decryptTheMessage(encryptedMessage, privateKey);
		System.out.println("Decrypted text: " + new String(decryptedMessage));
		

	}

	private static byte[] decryptTheMessage(byte[] encryptedMessage, String privateKey) {
		byte[] decrypted = null;
		try {
			RSAPrivateKey key = getPrivateKey(privateKey);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypted = cipher.doFinal(encryptedMessage);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return decrypted;
	}


	private static byte[] encryptTheMessage(String message, String publicKey) {
		byte[] encrypted = new byte[1024];
		try {
			RSAPublicKey key = getPublicKey(publicKey);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypted = cipher.doFinal(message.getBytes());
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return encrypted;
	}

	private static RSAPrivateKey getPrivateKey(String privateKey) {
		BigInteger pubExp = new BigInteger("010001", 16);
		BigInteger modulus;
		RSAPrivateKey key = null;
		try {
			modulus = new BigInteger(1, Base64.decodeBase64(privateKey.getBytes("UTF-8")));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, pubExp);
			key = (RSAPrivateKey) keyFactory.generatePrivate(rsaPrivateKeySpec);
			System.out.println(key);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return key;
	}
	
	/**
	 * @param publicKey
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private static RSAPublicKey getPublicKey(String publicKey) {
		BigInteger pubExp = new BigInteger("010001", 16);
		BigInteger modulus;
		RSAPublicKey key = null;
		try {
			modulus = new BigInteger(1, Base64.decodeBase64(publicKey.getBytes("UTF-8")));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, pubExp);
			key = (RSAPublicKey) keyFactory.generatePublic(rsaPublicKeySpec);
			System.out.println(key);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return key;
	}
	

	/**
	 * @param privateKey
	 */
	private static String readFile(String privateKey) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(privateKey)));
			while (bufferedReader.ready()) {
				sb.append((char) bufferedReader.read());
			}
//			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();	
	}

}
