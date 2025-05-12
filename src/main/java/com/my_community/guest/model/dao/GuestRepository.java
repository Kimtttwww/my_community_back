package com.my_community.guest.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_community.guest.model.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

	public Optional<Guest> findByIdAndStatusTrue(String id);
}
