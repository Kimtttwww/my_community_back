package com.my_community.guest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.my_community.guest.model.service.GuestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GuestController {

	private final GuestService service;

}
