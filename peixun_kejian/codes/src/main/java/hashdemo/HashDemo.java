package hashdemo;

import java.security.MessageDigest;

/**
 * Created by DaiYan on 2017/11/18.
 */
public class HashDemo {
    public static void main(String[] args) {
        String str="this is a test";
        System.out.println("time             n33: "+time33(str));
        System.out.println("md5ThenTime33: "+md5ThenTime33(str));
    }

    private static long time33(String origin){
        if(origin==null)
            System.out.println("invalid param");

        long hash=0;
        for(int i=0;i<origin.length();i++){
            hash+=hash*33+origin.charAt(i);
        }

        return hash;
    }

    private static long md5ThenTime33(String origin){
        String md5Str=MD5(origin);
        return time33(md5Str);
    }

    private static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }
}
