package com.my_community.guest.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.my_community.guest.model.dto.InNewGuest;
import com.my_community.guest.model.entity.Guest;

@Mapper(
		componentModel = ComponentModel.SPRING,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface GuestMapper {
	
	Guest toEntity(InNewGuest dto); 
}
