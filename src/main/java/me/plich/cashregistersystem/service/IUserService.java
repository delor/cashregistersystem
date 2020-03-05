package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.User;

public interface IUserService {
    void deleteUser(Long userId);
    User getUser(Long userId);
    Long getCurrentLoggedUserId();
    User updateUser(Long userId, User user);
}
