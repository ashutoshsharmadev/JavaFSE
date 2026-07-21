package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.util.Base64;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate()");
        LOGGER.debug("AUthentication Header : {}", authHeader);

        Map<String, String> map = new HashMap<>();

        String user = getUser(authHeader);

        LOGGER.debug("User : {}", user);
        String token = generateJwt(user);
        map.put("token", token);
        LOGGER.info("End Authenticate()");

        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("Start getUser()");
        String encodedCredentials = authHeader.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decodedBytes);

        LOGGER.debug("Decoded Credentails : {}", credentials);

        String user = credentials.substring(0,
                credentials.indexOf(":"));
        LOGGER.debug("User Obtained : {}", user);
        LOGGER.debug("End getUser()");

        return user;
    }
    private String generateJwt(String user) {
        LOGGER.debug("Start generateJwt()");
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(new Date().getTime() + 1200000)
        );
        builder.signWith(SignatureAlgorithm.HS256,"secretKeyasfasgsaghasuiguiyiuyigyufiuafgausigduy");
        String token = builder.compact();
        LOGGER.debug("Jwt Generated");
        LOGGER.debug("End generateJwt()");

        return token;
    }

}
