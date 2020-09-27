package com.sfa.pet.api.security.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4212261819583367976L;

	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_CREATED = "created";
	static final String CLAIM_KEY_EXPIRED = "exp";

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	public String getUserNameFromToken(final String token) {
		String username;
		try {
			final Claims claims = getClainsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public Date getExpirationFromToken(final String token) {
		try {
			final Claims claims = getClainsFromToken(token);
			return claims.getExpiration();
		} catch (Exception e) {
			return null;
		}
	}

	private Claims getClainsFromToken(final String token) {
		try {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isTokenExpired(final String token) {
		final Date expiration = getExpirationFromToken(token);
		return expiration.before(new Date());
	}

	public String generateToken(final UserDetails userDetails) {
		final Map<String, Object> claims = new HashMap<String, Object>();

		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());

		final Date createdDate = new Date();
		claims.put(CLAIM_KEY_CREATED, createdDate);

		return doGenerateToken(claims);
	}

	private String doGenerateToken(final Map<String, Object> claims) {
		final Date createdDate = (Date) claims.get(CLAIM_KEY_CREATED);
		final Date expirationDate = new Date(createdDate.getTime() + expiration * 1000);
		return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

	public boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token));
	}

	public String refreshToken(final String token) {
		try {
			final Claims claims = getClainsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			return doGenerateToken(claims);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean validateToken(final String token, final UserDetails userDetails) {
		final JwtUser user = (JwtUser) userDetails;
		final String username = getUserNameFromToken(token);
		return username.equals(user.getUsername()) && !isTokenExpired(token);
	}
}
