package com.my_community.guest.model.service;

import org.springframework.stereotype.Service;

import com.my_community.guest.model.dao.GuestCUDDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuestService {
	private final GuestCUDDao dao;

	
}
