package com.my_community.common.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.my_community.common.jwt.JwtWorker;
import com.my_community.common.token.JwtAuthenticationToken;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final AuthenticationManager manager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String accessToken = extractJwtFromCookies(request);
		if (accessToken == null) {
			filterChain.doFilter(request, response);
			return;
		}
		try {
			Authentication authResult = manager.authenticate(JwtAuthenticationToken.unauthenticated(accessToken));
			SecurityContextHolder.getContext().setAuthentication(authResult);
		} catch (AuthenticationException ex) {
			SecurityContextHolder.clearContext();
		}
		filterChain.doFilter(request, response);
	}

	private String extractJwtFromCookies(HttpServletRequest request) {
		if (request.getCookies() == null)
			return null;

		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals(JwtWorker.ACCESS_COOKIE_NAME)) {
				return cookie.getValue();
			}
		}
		return null;
	}
}
