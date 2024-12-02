package rythmic.ryhtmic_studio_backend.controller;

import rythmic.ryhtmic_studio_backend.entity.User;
import rythmic.ryhtmic_studio_backend.model.UserRegisterRequest;
import rythmic.ryhtmic_studio_backend.model.UserDataResponse;
import rythmic.ryhtmic_studio_backend.model.UserUpdateRequest;
import rythmic.ryhtmic_studio_backend.model.WebResponse;
import rythmic.ryhtmic_studio_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserDataResponse> register(@RequestBody UserRegisterRequest request) {
        UserDataResponse userDataResponse = userService.register(request);
        return WebResponse.<UserDataResponse>builder()
                .data(userDataResponse)
                .code(200).status("OK")
                .build();
    }

    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserDataResponse> get(User user) {
        UserDataResponse userDataResponse = userService.get(user);
        return WebResponse.<UserDataResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(userDataResponse)
                .build();
    }

    @PatchMapping(
            path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserDataResponse> update(User user, @RequestBody UserUpdateRequest request) {
        UserDataResponse userDataResponse = userService.update(user, request);
        return WebResponse.<UserDataResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(userDataResponse)
                .build();
    }
}
