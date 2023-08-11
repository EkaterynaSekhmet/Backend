package de.ait.listtasks.services;

import de.ait.listtasks.dto.*;

public interface UsersService { // Сервис - это бизнес логика, функционал
  // Система может делать только то, что написано в сервисе
  // Всегда !всегда! используются ДТО как на вход, так и на выход
  UserDto addUser(NewUserDto newUser); // Добавить пользователя

  UsersDto getAllUsers(); // Получить всех пользователей

  UserDto deleteUser(Long userId); // Удалить пользователя

  UserDto updateUser(Long userId, UpdateUserDto updateUser); // Обновить пользователя


  UserDto getUser(Long userId); // Получить определенного пользователя

  TasksDto getTasksOfUser(Long userId); // Получить все задачи какого-то определенного пользователя
  // Сначала запрашиваем пользователя, а потом все его задачи
  // ЮзерСервис заходит в задачи через юзера
}

