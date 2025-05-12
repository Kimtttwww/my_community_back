package com.my_community.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.service.GalleryService;

@RestController
@RequestMapping("/gallery")
public class GalleryController extends CommonBoardController {

	public GalleryController(GalleryService service) {
		super(service);
	}

}
