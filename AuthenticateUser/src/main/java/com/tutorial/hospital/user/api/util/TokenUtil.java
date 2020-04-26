package com.tutorial.hospital.user.api.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenUtil {

	@Value("${secretKey}")
	private String secretKey;
	public String generateToken(String username) {
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());


		LocalDateTime issuedAt = LocalDateTime.now();
		Date issuedate = Date.from(issuedAt.atZone(ZoneId.systemDefault()).toInstant());
		LocalDateTime expiry = issuedAt.plusMinutes(15);
		Date expiryDate = Date.from(expiry.atZone(ZoneId.systemDefault()).toInstant());
		return Jwts.builder().setIssuedAt(issuedate).setExpiration(expiryDate).setIssuer("me")
				.setId(UUID.randomUUID().toString()).claim("user", username).signWith(key).compact();

	}

	public boolean validateExpiry(String token) {
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());


		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
		Date current = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
		return claims.getBody().getExpiration().after(current);

	}

}
