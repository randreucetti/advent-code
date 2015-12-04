package com.randreucetti.advent.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdventCoins {
    public static int getLowestNumber(String key, String patternToMatch) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();

        boolean hashFound = false;
        int i = 0;
        while (!hashFound) {
            StringBuffer sb = new StringBuffer();
            sb.append(key);
            sb.append(i);
            byte[] hash = md.digest(sb.toString().getBytes());
            String hashStr = getStringFromMD5ByteArray(hash);
            if (hashStr.subSequence(0, patternToMatch.length()).equals(patternToMatch)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static String getStringFromMD5ByteArray(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0"
                        + Integer.toHexString((0xFF & hash[i])));
            } else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
    }
}
