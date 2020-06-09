package xyz.hsn.interview.util;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtil {
    private final static String saltString = "OEZIqyoDvXvzFJEL";
    public static String getMD5Password(String password){
        String hashAlgorithmName = "MD5";
        String credentials = password;
        ByteSource salt = ByteSource.Util.bytes(saltString);
        int hashIterations = 1024;
        SimpleHash md5Password = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        return md5Password.toString();
    }

    public static void main(String[] args) {
        System.out.println(getMD5Password("prince1115"));
    }
}
