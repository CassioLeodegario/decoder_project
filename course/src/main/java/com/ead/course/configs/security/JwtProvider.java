package com.ead.course.configs.security;

import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    Logger log = LogManager.getLogger(JwtProvider.class);

    @Value("${ead.auth.jwtSecret}")
    private String jwtSecret;

    public String getSubjectJwt(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public String getClamNameJwt(String token, String claimName){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get(claimName).toString();
    }

    public boolean validateJwt(String authToken){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT  is unsuported : {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT : {}", e.getMessage());
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT Claims String is empty: {}", e.getMessage());
        }
        return false;
    }
}
