package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.dto.AdminDto;
import me.plich.cashregistersystem.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin convertAdminDtoToAdmin(AdminDto adminDto);
    AdminDto convertAdminToAdminDto(Admin admin);
}
