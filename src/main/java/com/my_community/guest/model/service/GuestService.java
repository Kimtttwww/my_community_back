package com.my_community.guest.model.service;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.my_community.guest.model.dao.GuestDao;
import com.my_community.guest.model.dao.GuestRepository;
import com.my_community.guest.model.entity.Guest;
import com.my_community.guest.model.entity.GuestUnknown;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuestService implements UserDetailsService {

	private final GuestRepository repo;

//	private final GuestDao dao;
	
	public Guest authorizeGuest(GuestUnknown unknown) throws NotFoundException {
		return repo.findByIdAndStatusTrue(unknown.getId()).orElseThrow(() -> new NotFoundException("해당 사용자 없음"));
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		Guest guest = repo.findByIdAndStatusTrue(username)
				.orElseThrow(() -> new UsernameNotFoundException("일치하는 사용자 없음"));

		return new User(guest.getId(), guest.getPwd(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
	}
}
