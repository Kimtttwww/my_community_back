package com.my_community.common.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.my_community.common.jwt.JwtWorker;
import com.my_community.common.token.JwtAuthenticationToken;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

	private final JwtWorker jwtWorker;

	private final UserDetailsService service;

	/**
	 * 인증 동작
	 * @param authentication filter에서 제공한 인증되지 않은 사용자 정보
	 * @return 인증된 사용자
	 * @throws AuthenticationException 인증 실패
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String token = (String) authentication.getCredentials();
		if (jwtWorker.isTokenValid(token) && !jwtWorker.extractTokenType(token).equals(JwtWorker.ACCESS_COOKIE_NAME)) {
			throw new BadCredentialsException("Invalid (access) JWT");
		}

		String gid = jwtWorker.extractGid(token);
		if (gid == null) {
			throw new BadCredentialsException("unknown's JWT");
		}

		return JwtAuthenticationToken.authenticated(service.loadUserByUsername(gid));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return JwtAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
