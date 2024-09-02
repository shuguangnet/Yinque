package com.example.demo.controller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import com.example.demo.controller.Status
import com.example.demo.entity.Videos;

public class CarPhoneController {
    private static String generateRandomCode() {
        Random random = new Random();
        int min = 1000; // 随机验证码的最小值
        int max = 9999; // 随机验证码的最大值
        int code = random.nextInt(max - min + 1) + min; // 生成随机数字验证码
        return String.valueOf(code);
    }
    public static void main(String[] args) {
// 生成随机验证码
        String code = generateRandomCode();
        String testUsername = "15829561090"; //在短信宝注册的用户名
        String testPassword = "13991564254"; //在短信宝注册的密码
        String testPhone = "18509144920";
        String testContent = "【曙光网络】您的验证码为"+code+"，在30分钟内有效。"; // 注意测试时，也请带上公司简称或网站签名，发送正规内容短信。千万不要发送无意义的内容：例如 测一下、您好。否则可能会收不到

        String httpUrl = "http://api.smsbao.com/sms";
        // 将{code}替换为随机验证码
        String replacedContent = testContent.replace("{code}", code);

        // 现在replacedContent包含了随机验证码
        System.out.println(replacedContent);

        // 将replacedContent存入phone数据表中（这里需要您的数据库操作代码）
        // 假设有一个名为phone的数据库表，可以使用数据库连接和SQL语句进行插入操作
        // 例如：INSERT INTO phone (content) VALUES ('" + replacedContent + "');
        StringBuffer httpArg = new StringBuffer();
        httpArg.append("u=").append(testUsername).append("&");
        httpArg.append("p=").append(md5(testPassword)).append("&");
        httpArg.append("m=").append(testPhone).append("&");
        httpArg.append("c=").append(encodeUrlString(testContent, "UTF-8"));

        String result = request(httpUrl, httpArg.toString());
        System.out.println(result);
        // 生成随机验证码的方法

    }

    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = reader.readLine();
            if (strRead != null) {
                sbf.append(strRead);
                while ((strRead = reader.readLine()) != null) {
                    sbf.append("\n");
                    sbf.append(strRead);
                }
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String md5(String plainText) {
        StringBuffer buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public static String encodeUrlString(String str, String charset) {
        String strret = null;
        if (str == null)
            return str;
        try {
            strret = java.net.URLEncoder.encode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strret;
    }
}
