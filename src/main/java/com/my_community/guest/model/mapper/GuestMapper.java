package com.my_community.guest.model.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.my_community.guest.model.dto.NewGuestArgs;
import com.my_community.guest.model.entity.Guest;

@Mapper(
		componentModel = ComponentModel.SPRING,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface GuestMapper {
	
	Guest toEntity(NewGuestArgs dto);
	
//	@AfterMapping
//	default void encodingPwd(NewGuestArgs args, @MappingTarget Guest guest) {
//		if (guest != null) {
//			guest.setPwd((guest.getPwd()));
//		}
//	}
}
