package com.my_community.board.model.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.my_community.board.model.dto.BoardSearchOptionArgs;
import com.my_community.board.model.entity.BoardSearchOption;

@Mapper(
		componentModel = ComponentModel.SPRING,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface BoardMapper {

	BoardSearchOption toEntity(BoardSearchOptionArgs args);

	@AfterMapping
	default void boardSearchOptionAfter(BoardSearchOptionArgs sourceArgs, @MappingTarget BoardSearchOption args) {
		if (args != null) {
			args.setOffset((args.getCurrentPage() - 1) * args.getPerPage());
		}
	}
}
