package com.example.client;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import cn.hutool.core.codec.Base64;

public class AEScbcUtil {

    private final static String sKey = "1234567890abcdef";//16位自定义的key
    private final static String sIv = "0987654321fedcba";//16位自定义向量

    public static void main(String[] args) throws Exception {
        /*
         * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
         * 此处使用AES-128-CBC加密模式，key需要为16位。
         */
        long lStart = System.currentTimeMillis();
//        // 需要加密的字串
//        String sSrc = "13800000000";
//        System.out.println("原字符串："+sSrc);
//        // 加密
//        String enString = AEScbcUtil.Encrypt(sSrc, sKey);
//        System.out.println("加密后的字串是：" + enString);
//
//        long lUseTime = System.currentTimeMillis() - lStart;
//        System.out.println("加密耗时：" + lUseTime + "毫秒");
        // 解密
//        lStart = System.currentTimeMillis();



//        String enString = "dvW96M0KcPZY+y4/2gjfUB6bqBQ86d62t6x6riDEaWyFMZliCjPZUxQfr+NqtXQsLDBQZuCHLPBQJ72QkWq3XZRmYf5ZctBANAFDP92h3siACeFBB6NXHTLBF8cvc3RL/MYFMwOkckWF0MivFbxFZslfOSkSqFpwfDZ8+XUHxsEDBfHVMRezsmAbCbsZ36oz6Qn1OkdhHglGbs2zhHk6W4nBcBhLudEePYLLe+yp+B21oMMo6oO1Wo04Ee06q0vyYmEOlZPPiK8UxgDM+/18SCHv6LcnfCx2pdfcTtX0Cy5V4NET6YmCkXmL4xC+zugRVVCkNz5yf72co6xcZQBvk8Y09o2cy51N86u7XwlixufAchVZfrWGGPlfy+f4ePEqfK5qhFNCBXkkfWFqeX/i8n3wi9/+9n6i5E6IrUAjLUuB0/JHiBqmccQuiwRDNGet58WEnVAxC0nA4mUio9N4qgKONtJPztDGppiVeYzw3fiuiGOni233eojr8VN51Z7nwEtGFJeJN4u1UukJe0XRhlCC3fokb0oobxQvRD5gSQA=";

//        String enString = "dvW96M0KcPZY+y4/2gjfUB6bqBQ86d62t6x6riDEaWyjgr4mNwf1uINpkFzRDdgkXAWfvtTKb+ZpYq3nAzyYmoo9Rs+/HCiOqDo6mbGq2QSYMjqVGqrZzFlgX7yijnd3t5lq+0jMt2rv8bL6OpUE6WkKgKLwf7r4lHr2e87cJa0b6belC07KAANrmzZ+xuM4Bnu27bTWn6t6MGSlELvucg5OvtYmcSetlDG0UYDQmfBWbfvlMpdyJi7L7Aue4CMkaJr0W+zO+/roP8r6KvKDZCE8/3SiIjMyICH11k/qNlTCC608DcqtimpHoVsQDp5N4LyIIEegIslEgEpW47wvQlPOpHKxBYrqJN5D98u9/cnw+YIJMEYR9j8a0xQYdDS2cHIEDa7BmA+VvMpsOIUJvTYk7SRY4TMqetKp9TqcRXx2r+Pmm0zGcBB6aStdEb1ml/Fx32MGZCjI7vfN7vw6jA==";
        String enString = "dvW96M0KcPZY+y4/2gjfUB6bqBQ86d62t6x6riDEaWyHltF7bd6d/w5g/C1fdj6sWsxRyEo9oW46ddXSnJnzrP2vEcHk4fEm7YXure+gwO7hXZKut8dZlokww62S3qheW286aq+/fnhZlZpI5LpNU7NL54DRxpKw/8euTD6ym7AqrV8n5+zI6dGESaU5UuEwKVCP03zbBiahMhMZ/3eVYX7qwJCVjB4IAGEOL5Co5DnOjoJstyLPzcRuYA7z1zHYobBh/wiz9ORVAOWQcXk5fehHlRd6nQxxQVwvM8JCnPpLsTIWQoq9Ov5YTsVdIhdweIvlbwasN5BBYsEJd+CxzsyND6MZ32HbSqkPAKtmWfO4UZtmjFFNTBSvprxTywMKARwZK83xi2Gve7hM8EJWIg==";


        String DeString = AEScbcUtil.Decrypt(enString, sKey);
        System.out.println("解密后的字串是：\n" + DeString);
//        lUseTime = System.currentTimeMillis() - lStart;
//        System.out.println("解密耗时：" + lUseTime + "毫秒");
    }

    //加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        byte[] bytes = sIv.getBytes();
        IvParameterSpec iv = new IvParameterSpec(bytes);//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        return new Base64().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    /**
     * 解密
     * @param sSrc 需要解密的字符串
     * @param sKey 秘钥
     * @return
     * @throws Exception
     */
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(sIv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
