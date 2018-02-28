package com.example.util;
import org.apache.commons.codec.binary.Base64;

public class Base64Utils {
    public Base64Utils() {
    }

    public static byte[] decodeBase64(String content) {
        byte[] contents = new byte[1024];
        contents = Base64.decodeBase64(content);
        return contents;
    }

    public static byte[] encodeBase64(byte[] content) {
        byte[] c = new byte[1024];
        c = Base64.encodeBase64(content);
        return c;
    }
}
