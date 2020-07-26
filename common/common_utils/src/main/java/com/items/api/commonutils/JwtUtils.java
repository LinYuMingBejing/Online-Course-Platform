package com.items.api.commonutils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {

    // 常量
    public static final long EXPIRE = 1000* 60* 60 * 24; // token過期時間
    public static final String APP_SECRET = "fdsfdwerewt";  // 密鑰

    // 生成token字符串的方法
    public static String getJwtToken(String id, String nickname){

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .setSubject("guli-user")
                .setIssuedAt(new Date()) //得到當前時間
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE)) // 設置過期時間
                .claim("id",id) //設置token主體部分，存儲用戶訊息
                .claim("nickname", nickname)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        return JwtToken;
    }

    // 判斷token是否存在與有效
    public static boolean checkToken(String jwtToken){
        if(StringUtils.isEmpty(jwtToken)) return false;
        try{
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 判斷token是否存在與有效
    public static boolean checkToken(HttpServletRequest request){
        try{
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }



    // 根據token獲取會員id
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("id");
    }

}
