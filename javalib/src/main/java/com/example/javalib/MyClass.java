package com.example.javalib;

import com.sun.org.apache.bcel.internal.generic.DADD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

public class MyClass {

    public static void main(String[] arge) {
        String log = "WOdeDongLian";

        String sn1 = "4713000002471300000247130000022471300000224713000002";
        String sn2 = "2000003174";
        String data = log + sn1 + sn2;
        System.out.println(sn1.substring(1, 9) + "   " + sn1.substring(1, 9).length() / 2 + "字节");
        System.out.println(sn1.substring(9, 17) + "   " + sn1.substring(9, 17).length() / 2 + "字节");
        System.out.println(sn1.substring(17, 25) + "   " + sn1.substring(17, 25).length() / 2 + "字节");
        System.out.println(sn1.substring(25, 33) + "   " + sn1.substring(25, 33).length() / 2 + "字节");
        System.out.println(sn1.substring(33, 41) + "   " + sn1.substring(33, 41).length() / 2 + "字节");
//        System.out.println( sn1.substring(1,9));
//        System.out.println( sn1.substring(1,9));
//        System.out.println( sn1.substring(1,9));
    }

    public static String getData(byte[] data) {
        //不足16字节，补齐内容为差值
//        int len = 16 - data.length % 16;
//        for (int i = 0; i < len; i++) {
//            byte[] bytes = {(byte) len};
//            data = byteMerger(data, bytes);
//        }
//        return byte2hex(data);

        return null;
    }

    /**
     * 合并byte[]数组 （不改变原数组）
     *
     * @param byte_1
     * @param byte_2
     * @return 合并后的数组
     */
    public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        byte[] byte_3 = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
    }


    //字节数组转成16进制字符串
    public static String byte2hex(byte[] b) { // 一个字节的数，
        StringBuffer sb = new StringBuffer(b.length * 2);
        String tmp = "";
        for (int n = 0; n < b.length; n++) {
            // 整数转成十六进制表示
            tmp = (Integer.toHexString(b[n] & 0XFF));
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        // 转成大写
        return sb.toString().toUpperCase();
    }


    /**
     * 16进制字符串转字节数组
     *
     * @param hex
     * @return
     */
    public static byte[] hex2byte(String hex) {
        hex = hex.replaceAll("", "");
        final byte[] byteArray = new byte[hex.length() / 2];
        int k = 0;
        for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
            byte high = (byte) (Character.digit(hex.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hex.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }

    /**
     * 截取byte数组   不改变原数组
     *
     * @param b      原数组
     * @param off    偏差值（索引）
     * @param length 长度
     * @return 截取后的数组
     */
    public static byte[] subByte(byte[] b, int off, int length) {
        byte[] b1 = new byte[length];
        System.arraycopy(b, off, b1, 0, length);
        return b1;
    }

    /**
     * 字节转十六进制
     *
     * @param b 需要进行转换的byte字节
     * @return 转换后的Hex字符串
     */
    public static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }


}