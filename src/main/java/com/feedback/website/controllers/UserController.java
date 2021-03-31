package com.feedback.website.controllers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> one(@PathVariable Integer id) {
        UserDto userDto = userService.getOneUser(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Object> all() {
        List<UserDto> all = userService.listUsers();
        return ResponseEntity.ok(all);
    }

    @PostMapping(value = "/")
    public ResponseEntity<UserDto> newUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
        userService.updateUser(userDto, id);
        return ResponseEntity.ok("user id="+id+" updated");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        userService.deleteOneUser(id);
        return ResponseEntity.ok("user deleted");
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<Object> deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity.ok("all users deleted");
    }


}


