package org.example;

import com.github.pandachanv587.aesutil.AESUtil;
import com.github.pandachanv587.aesutil.exception.AESConfigParamsError;
import com.github.pandachanv587.aesutil.exception.CipherCreateError;


import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main {
    public static void main(String[] args)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException {

        //todo: encrypt
        String algorithm = "AES";
        String transformation = "AES/ECB/PKCS5Padding";

        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        SecretKey secretKey = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        String plaintext = "This is a secret message";
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Encrypted data: " + encryptedBase64);


        //todo: decrypt

        cipher.init(Cipher.DECRYPT_MODE, secretKey);


        byte[] encryptedBytess = Base64.getDecoder().decode(encryptedBase64);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytess);
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);

        System.out.println("Decrypted data: " + decryptedText);
    }


}
