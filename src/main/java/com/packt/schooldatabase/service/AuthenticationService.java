package com.packt.schooldatabase.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static java.util.Collections.emptyList;

public class AuthenticationService {
    static final long EXPIRATIONTIME = 864_000_00; //1 day in milisecondes
    static final String SIGNINKEY = "SecretKey";
    static final String PREFIX = "Bearer";

    static public void addToken(HttpServletResponse res, String username){
        String JwtToken = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINKEY)
                .compact();
        res.addHeader("Authorization", PREFIX + " " + JwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    static public Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null){
            String user = Jwts.parser()
                    .setSigningKey(SIGNINKEY)
                    .parseClaimsJws(token.replace(PREFIX,""))
                    .getBody()
                    .getSubject();
            if (user != null)
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
        }

        return null;
    }
}
