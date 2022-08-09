package com.zhangbo.lovepets.until;
import com.zhangbo.lovepets.pojo.User;
import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;



public class MD5{

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    /**
     * 用户加密
     * @param user
     * @return
     */
    public static User encryptionUser(User user){
        //进行数据加密
        if (StringUtils.isNotEmpty(user.getUserPhone())){
            user.setUserPhone(convertMD5(user.getUserPhone()));
        }else {
            user.setUserPhone(null);
        }
        if (StringUtils.isNotEmpty(user.getUserAdd())){
            user.setUserAdd(convertMD5(user.getUserAdd()));
        }else {
            user.setUserAdd(null);
        }
        if (StringUtils.isNotEmpty(user.getEmail())){
            user.setEmail(convertMD5(user.getEmail()));
        }else {
            user.setEmail(null);
        }
        if (StringUtils.isNotEmpty(user.getPassword())){
            user.setPassword(convertMD5(user.getPassword()));
        }else {
            user.setPassword(null);
        }
        if (StringUtils.isNotEmpty(user.getUserName())){
            user.setUserName(convertMD5(user.getUserName()));
        }else {
            user.setUserName(null);
        }
        return user;
    }

    public static User decryptUser(User user){
        //部分数据解密
        if (StringUtils.isNotEmpty(user.getUserPhone())){
            user.setUserPhone(convertMD5(user.getUserPhone()));
        }else {
            user.setUserPhone(null);
        }
        if (StringUtils.isNotEmpty(user.getUserAdd())){
            user.setUserAdd(convertMD5(user.getUserAdd()));
        }else {
            user.setUserAdd(null);
        }
        if (StringUtils.isNotEmpty(user.getEmail())){
            user.setEmail(convertMD5(user.getEmail()));
        }else {
            user.setEmail(null);
        }
        if (StringUtils.isNotEmpty(user.getUserName())){
            user.setUserName(convertMD5(user.getUserName()));
        }else {
            user.setUserName(null);
        }
        return user;
    }



    // 测试主函数
    public static void main(String args[]) {
        String s = new String("2466258400@qq.com");
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + string2MD5(s));
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));

    }
}

