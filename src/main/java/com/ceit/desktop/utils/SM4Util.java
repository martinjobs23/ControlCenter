package com.ceit.desktop.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;

public class SM4Util {
    private static final BouncyCastleProvider BOUNCY_CASTLE_PROVIDER = new BouncyCastleProvider();
    private static final String BOUNCY_CASTLE_PROVIDER_NME = BouncyCastleProvider.PROVIDER_NAME;
    private static final String SM4_ALGORITHM = "SM4";
    private static final int DEFAULT_KEY_SIZE = 128;
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String keyPwd = "CEIT909123456789";
    private static final String ivPwd = "123456789CEIT909";
    private static final String keyCom = "NCEPUCEIT9091234";
    private static final String ivCom = "1234909CEITNCEPU";




    static {
        Security.removeProvider(BOUNCY_CASTLE_PROVIDER_NME);
        Security.addProvider(BOUNCY_CASTLE_PROVIDER);
    }

    /**
     * SM4 加密
     *
     * @param plainText      明文数据
     * @param key            密钥
     * @param modeAndPadding 加密模式和padding模式
     * @param iv             初始向量(ECB模式下传NULL)
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] plainText, byte[] key, SM4ModeAndPaddingEnum modeAndPadding, byte[] iv) {
        return sm4(plainText, key, modeAndPadding, iv, Cipher.ENCRYPT_MODE);
    }

    /**
     * SM4 解密
     *
     * @param cipherText            密文数据
     * @param key                   密钥
     * @param sm4ModeAndPaddingEnum 加密模式和padding模式
     * @param iv                    初始向量(ECB模式下传NULL)
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] cipherText, byte[] key, SM4ModeAndPaddingEnum sm4ModeAndPaddingEnum, byte[] iv) {
        return sm4(cipherText, key, sm4ModeAndPaddingEnum, iv, Cipher.DECRYPT_MODE);
    }

    /**
     * SM4算法
     *
     * @param input                 输入数据
     * @param key                   密钥
     * @param sm4ModeAndPaddingEnum SM4模式
     * @param iv                    初始向量ECB模式下为null
     * @param mode                  加密或解密模式
     * @return
     * @throws Exception
     */
    private static byte[] sm4(byte[] input, byte[] key, SM4ModeAndPaddingEnum sm4ModeAndPaddingEnum, byte[] iv, int mode) {
        SecretKeySpec sm4Key = new SecretKeySpec(key, SM4_ALGORITHM);
        byte[] output = null;
        try {
            Cipher cipher = Cipher.getInstance(sm4ModeAndPaddingEnum.getName(), BOUNCY_CASTLE_PROVIDER_NME);
            if (iv == null) {
                cipher.init(mode, sm4Key);
            } else {
                cipher.init(mode, sm4Key, new IvParameterSpec(iv));
            }
            output = cipher.doFinal(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output;
    }

    public enum SM4ModeAndPaddingEnum {
        SM4_ECB_NoPadding("SM4/ECB/NoPadding"),
        SM4_ECB_PKCS5Padding("SM4/ECB/PKCS5Padding"),
        SM4_ECB_PKCS7Padding("SM4/ECB/PKCS7Padding"),
        SM4_CBC_NoPadding("SM4/CBC/NoPadding"),
        SM4_CBC_PKCS5Padding("SM4/CBC/PKCS5Padding"),
        SM4_CBC_PKCS7Padding("SM4/CBC/PKCS7Padding");

        private String name;

        SM4ModeAndPaddingEnum(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 生成密钥
     *
     * @param sm4ModeAndPaddingEnum
     * @return
     * @throws Exception
     */
    public static byte[] generateKey(SM4ModeAndPaddingEnum sm4ModeAndPaddingEnum) throws NoSuchProviderException, NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance(sm4ModeAndPaddingEnum.getName(), BOUNCY_CASTLE_PROVIDER_NME);
        kg.init(DEFAULT_KEY_SIZE, new SecureRandom());
        return kg.generateKey().getEncoded();
    }

    /**
     * 生成密钥
     *
     * @return
     */
    /*public static String generateKey() {
        *//**
         * 默认使用SM4_ECB_NoPadding
         *//*
        String key = "";
        try {
            key = Base64.encodeBase64URLSafeString(generateKey(SM4ModeAndPaddingEnum.SM4_ECB_NoPadding));
        } catch (NoSuchProviderException e) {
        } catch (NoSuchAlgorithmException e) {
        }
        return key;
    }*/


    /**
     * 加密
     *
     * @param plainText
     * @param flag      flag = 0 Com  flag = 1 Pwd
     * @return
     */
    public static String encrypt(String plainText, int flag) {
        /**
         * 默认使用SM4_CBC_NoPadding
         */
        /*String base64Cipher = "";
        try {
            byte[] plain = plainText.getBytes(DEFAULT_ENCODING);
            byte[] key = Base64.decodeBase64(base64Key);
            base64Cipher = Base64.encodeBase64URLSafeString(encrypt(plain, key, SM4ModeAndPaddingEnum.SM4_ECB_NoPadding, null));
        } catch (UnsupportedEncodingException e) {
        }
        return base64Cipher;*/
        byte[] key = null;
        byte[] iv = null;
        String outCipher = "";
        if(flag == 0){
            key = keyCom.getBytes();
            iv = ivCom.getBytes();
        }
        else {
            key = keyPwd.getBytes();
            iv = ivPwd.getBytes();
        }
        try{
            byte[] plain = plainText.getBytes(DEFAULT_ENCODING);
            outCipher = Base64.toBase64String(encrypt(plain,key,SM4ModeAndPaddingEnum.SM4_CBC_PKCS5Padding,iv));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return outCipher;
    }


    /**
     * 解密
     *
     * @param inCipher
     * @return
     */
    public static String decrypt(String inCipher,int flag) {
        /**
         * 默认使用SM4_CBC_NoPadding
         */
        /*String plain = "";
        try {
            byte[] cipher = Base64.decodeBase64(base64Cipher);
            byte[] key = Base64.decodeBase64(base64Key);
            plain = new String(decrypt(cipher, key, SM4ModeAndPaddingEnum.SM4_ECB_NoPadding, null),DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return plain;*/
        byte[] key = null;
        byte[] iv = null;
        String plain = "";
        if(flag == 0){
            key = keyCom.getBytes();
            iv = ivCom.getBytes();
        }
        else {
            key = keyPwd.getBytes();
            iv = ivPwd.getBytes();
        }
        try{
            byte[] cipher = Base64.decode(inCipher);
            plain = new String(decrypt(cipher,key,SM4ModeAndPaddingEnum.SM4_CBC_PKCS5Padding,iv),DEFAULT_ENCODING);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  plain;
    }
}
