package org.example.service;

/**
 * @Author: Ron
 * @Create: 2023-06-16 11:42
 */
import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaUtil {

    private static final String RSA = "RSA";
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * 加密
     *
     * @param input     明文
     * @param publicKey 公钥
     * @return 密文
     * @throws GeneralSecurityException
     */
    public static String encrypt(String input, String publicKey) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(RSA);
        PublicKey pubKey = KeyFactory.getInstance(RSA)
                .generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey)));
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] data = cipher.doFinal(input.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * 解密
     *
     * @param input      密文
     * @param privateKey 私钥
     * @return 明文
     * @throws GeneralSecurityException
     */
    public static String decrypt(String input, String privateKey) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(RSA);
        PrivateKey priKey = KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        byte[] data = cipher.doFinal(Base64.getDecoder().decode(input));
        return new String(data, CHARSET);
    }

    public static void main(String[] args) throws GeneralSecurityException {
        // 生成公钥／私钥对:
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance(RSA);
        kpGen.initialize(1024);
        KeyPair keyPair = kpGen.generateKeyPair();
        String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
        System.out.println("公钥：" + publicKey);
        System.out.println("私钥：" + privateKey);

        String msg = "我喜欢你，可以做我女朋友吗？";
        System.out.println("加密前：" + msg);
        String pwd = RsaUtil.encrypt(msg, publicKey);
        System.out.println("加密后：" + pwd);
        System.out.println("解密后：" + RsaUtil.decrypt(pwd, privateKey));
    }
}