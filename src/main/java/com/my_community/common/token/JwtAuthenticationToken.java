package com.my_community.common.token;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 1L;
	private final String token;
	private final UserDetails principal;

	private JwtAuthenticationToken(String token) {
		super(null);
		this.token = token;
		this.principal = null;
		setAuthenticated(false);
	}

	private JwtAuthenticationToken(UserDetails principal) {
		super(principal.getAuthorities());
		this.token = null;
		this.principal = principal;
		setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return token;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	public static JwtAuthenticationToken authenticated(UserDetails user) {
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		if (authorities == null || authorities.size() == 0)
			throw new IllegalArgumentException("잘못된 인수");
		return new JwtAuthenticationToken(user);
	}

	public static JwtAuthenticationToken unauthenticated(String token) {
		return new JwtAuthenticationToken(token);
	}
}
