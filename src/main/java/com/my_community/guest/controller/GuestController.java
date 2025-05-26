package com.my_community.guest.controller;

import java.time.Duration;
import java.util.Optional;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_community.common.jwt.JwtWorker;
import com.my_community.guest.model.entity.Guest;
import com.my_community.guest.model.entity.GuestUnknown;
import com.my_community.guest.model.service.GuestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class GuestController {

	private final GuestService service;

	private final JwtWorker jwtWorker;

	@PostMapping("/access")
	public ResponseEntity<?> authorizeGuest(@RequestBody GuestUnknown unknown) throws NotFoundException {
		Guest guest = service.authorizeGuest(unknown);
		String accessJWT = jwtWorker.generateAccessToken(Long.toString(guest.getGid()));
		String refreshJWT = jwtWorker.generateRefreshToken(Long.toString(guest.getGid()));

		return ResponseEntity.ok().headers(cookieHasJWTs(accessJWT, refreshJWT)).build();
	}

	@GetMapping("/refresh")
	public ResponseEntity<?> takeRefreshJWT(@CookieValue(JwtWorker.REFRESH_COOKIE_NAME) String oldRefreshJWT) {
		String gid = jwtWorker.extractUsername(oldRefreshJWT);
		String accessJWT = jwtWorker.generateAccessToken(gid);
		String refreshJWT = jwtWorker.generateRefreshToken(gid);

		return ResponseEntity.ok().headers(cookieHasJWTs(accessJWT, refreshJWT)).build();
	}

	@GetMapping("/test")
	public ResponseEntity<String> jwtTest() {
		Optional<Authentication> auth = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
		return ResponseEntity.ok(auth.isPresent() ? auth.get().toString() : "nothing");
	}

	private HttpHeaders cookieHasJWTs(String accessJWT, String refreshJWT) {
		HttpHeaders header = new HttpHeaders();

		ResponseCookie accessCookie = ResponseCookie.from(JwtWorker.ACCESS_COOKIE_NAME, accessJWT).httpOnly(true)
				.path("/").maxAge(Duration.ofMinutes(10)).sameSite("Lax").build();
		ResponseCookie refreshCookie = ResponseCookie.from(JwtWorker.REFRESH_COOKIE_NAME, refreshJWT).httpOnly(true)
				.path("/guest/refresh").maxAge(Duration.ofHours(1)).sameSite("Strict").build();
		header.add(HttpHeaders.SET_COOKIE, accessCookie.toString());
		header.add(HttpHeaders.SET_COOKIE, refreshCookie.toString());

		return header;
	}
}
