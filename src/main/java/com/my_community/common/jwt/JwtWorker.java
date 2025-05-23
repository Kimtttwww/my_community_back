package com.my_community.common.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtWorker {

	private final SecretKey secretKey;

	private final JwtParser parser;

	private final long ACCESS_EXPIRATION = 1000 * 60 * 10L;

	private final long REFRESH_EXPIRATION = ACCESS_EXPIRATION * 6;

	public final static String ACCESS_COOKIE_NAME = "accessToken";

	public final static String REFRESH_COOKIE_NAME= "refreshToken";

	public JwtWorker(@Value("${jwt.secret}") String secretKey) {
		super();
		this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
		this.parser = Jwts.parserBuilder().setSigningKey(this.secretKey).build();
	}

	/**
	 * access JWT 발급
	 * @param id token에 담을 사용자 id
	 * @return JWT(str)
	 */
	public String generateAccessToken(String id) {
		return Jwts.builder()
				.setSubject(id)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_EXPIRATION))
				.signWith(secretKey, SignatureAlgorithm.HS256)
				.compact();
	}
	
	/**
	 * refresh JWT 발급
	 * @param id token에 담을 사용자 id
	 * @return JWT(str)
	 */
	public String generateRefreshToken(String id) {
		return Jwts.builder()
				.setSubject(id)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION))
				.signWith(secretKey, SignatureAlgorithm.HS256)
				.compact();
	}

	/**
	 * JWT의 payload에 있는 사용자 식별명 추출
	 * @param token 사용자에게 제공받은 JWT
	 * @return JWT에서 추출한 사용자 식별명
	 */
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	/**
	 * JWT의 payload에 있는 만료일 추출
	 * @param token 사용자에게 제공받은 JWT
	 * @return JWT에서 추출한 만료일
	 */
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = parser.parseClaimsJws(token).getBody();
		return claimsResolver.apply(claims);
	}

	/**
	 * JWT 유효성 검사(알고리즘, 식별명, 만료일)
	 * @param token 사용자에게 제공받은 JWT
	 * @param userDetails 사용자 이름
	 */
	public void isTokenValid(String token, UserDetails userDetails) {
		if (!userDetails.getUsername().equals(extractUsername(token)) && isTokenExpired(token))
			throw new BadCredentialsException("JWT Token is not valid");
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
}
