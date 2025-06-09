package com.my_community.common.jwt;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
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

	public static final String ACCESS_COOKIE_NAME = "accessToken";
	
	public static final String REFRESH_COOKIE_NAME = "refreshToken";
	
	public static final Duration ACCESS_EXPIRATION = Duration.ofMinutes(30);

	public static final Duration REFRESH_EXPIRATION = Duration.ofHours(6);

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
				.claim("type", ACCESS_COOKIE_NAME)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_EXPIRATION.toMillis()))
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
				.claim("type", REFRESH_COOKIE_NAME)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION.toMillis()))
				.signWith(secretKey, SignatureAlgorithm.HS256)
				.compact();
	}

	/**
	 * JWT의 payload에 있는 사용자 식별명 추출
	 * @param token 사용자에게 제공받은 JWT
	 * @return JWT에서 추출한 사용자 식별명
	 */
	public String extractGid(String token) {
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

	/**
	 * JWT의 payload에 있는 JWT 용도 추출(access / refresh)
	 * @param token 사용자에게 제공받은 JWT
	 * @return JWT에서 추출한 JWT 용도
	 */
	public String extractTokenType(String token) {
		return extractClaim(token, claims -> claims.get("type", String.class));
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = parser.parseClaimsJws(token).getBody();
		return claimsResolver.apply(claims);
	}

	/**
	 * JWT 유효성 검사(알고리즘, 식별명, 만료일)
	 * @param token 사용자에게 제공받은 JWT
	 */
	public boolean isTokenValid(String token) {
		if (isTokenExpired(token))
			throw new BadCredentialsException("Invalid JWT");
		return true;
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
}
