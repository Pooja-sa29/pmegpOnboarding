package com.trust.pmegpcustomeronboardingapp.activity.utils;

import android.util.Base64;

import java.nio.charset.Charset;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

    public class CryptoEncryption {

        // same salt bytes as new byte[]{0x49, …, 0x76} in .NET
        private static final byte[] SALT = new byte[]{
                0x49, 0x76, 0x61, 0x6e, 0x20, 0x4d, 0x65, 0x64,
                0x76, 0x65, 0x64, 0x65, 0x76
        };

        // iteration count matches .NET default (1000)
        private static final int ITERATIONS = 1000;

        /**
         * Encrypts the given text using AES/CBC/PKCS5Padding.
         *
         * @param clearText     The plain text to encrypt.
         * @param encryptionKey The password/key from your config.
         * @return Base64-encoded cipher text.
         */
        public static String encryptString(String clearText, String encryptionKey) throws Exception {
            // 1) derive 32 byte key + 16 byte IV
            byte[] keyIv = deriveKeyAndIv(encryptionKey, SALT, ITERATIONS, 48);
            byte[] keyBytes = new byte[32];
            byte[] ivBytes  = new byte[16];
            System.arraycopy(keyIv, 0,     keyBytes, 0, 32);
            System.arraycopy(keyIv, 32, ivBytes, 0,     16);

            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

            // 2) encrypt
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

            // .NET uses Unicode => UTF-16LE
            byte[] clearBytes = clearText.getBytes(Charset.forName("UTF-16LE"));
            byte[] encrypted  = cipher.doFinal(clearBytes);

            // 3) Base64 (no line breaks)
            return Base64.encodeToString(encrypted, Base64.NO_WRAP);
        }

        /**
         * Decrypts the given Base64-encoded cipher text.
         *
         * @param cipherText    Base64-encoded text.
         * @param encryptionKey The same password/key used to encrypt.
         * @return Decrypted plain text.
         */
        public static String decryptString(String cipherText, String encryptionKey) throws Exception {
            // 1) derive same key + IV
            byte[] keyIv = deriveKeyAndIv(encryptionKey, SALT, ITERATIONS, 48);
            byte[] keyBytes = new byte[32];
            byte[] ivBytes  = new byte[16];
            System.arraycopy(keyIv, 0,     keyBytes, 0, 32);
            System.arraycopy(keyIv, 32, ivBytes, 0,     16);

            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

            // 2) decode + decrypt
            byte[] cipherBytes = Base64.decode(cipherText.replace(" ", "+"), Base64.NO_WRAP);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            byte[] decrypted = cipher.doFinal(cipherBytes);

            // .NET used UTF-16LE => decode accordingly
            return new String(decrypted, Charset.forName("UTF-16LE"));
        }

        /**
         * PBKDF2 key derivation: produces key+IV bytes in one go.
         *
         * @param password   Password or encryption key.
         * @param salt       Salt bytes.
         * @param iterations PBKDF2 iteration count.
         * @param length     Total bytes needed (keyLen + ivLen).
         */
        private static byte[] deriveKeyAndIv(
                String password,
                byte[] salt,
                int iterations,
                int length
        ) throws Exception {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            KeySpec spec = new PBEKeySpec(
                    password.toCharArray(),
                    salt,
                    iterations,
                    length * 8   // bits
            );
            SecretKey tmp = factory.generateSecret(spec);
            return tmp.getEncoded();
        }
    }

