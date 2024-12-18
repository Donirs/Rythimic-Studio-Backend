package rythmic.ryhtmic_studio_backend.controller;

<<<<<<< HEAD:src/main/java/rythmic/ryhtmic_studio_backend/controller/GoogleAuthController.java
import rythmic.ryhtmic_studio_backend.model.TokenResponse;
import rythmic.ryhtmic_studio_backend.model.WebResponse;
import rythmic.ryhtmic_studio_backend.service.GoogleAuthService;
=======
import fitspace.fitspace_sports_venue_booking_website_backend.entity.User;
import fitspace.fitspace_sports_venue_booking_website_backend.model.TokenResponse;
import fitspace.fitspace_sports_venue_booking_website_backend.model.WebResponse;
import fitspace.fitspace_sports_venue_booking_website_backend.service.GoogleAuthService;
>>>>>>> parent of 615c913 (modify create venue):src/main/java/fitspace/fitspace_sports_venue_booking_website_backend/controller/GoogleAuthController.java
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("api/auth/login/google")
public class GoogleAuthController {

    @Autowired
    private GoogleAuthService googleAuthService;

    @GetMapping
    public void initiateGoogleLogin(HttpServletResponse response) throws IOException {
        String authUrl = googleAuthService.generateAuthUrl();
        response.sendRedirect(authUrl);
    }

    @GetMapping("/callback")
    public WebResponse<TokenResponse> handleGoogleCallback(@RequestParam("code") String code) {
        String accessToken = googleAuthService.getAccessToken(code);
        Map<String, Object> profile = googleAuthService.getUserProfile(accessToken);
        TokenResponse tokenResponse = googleAuthService.findOrCreateUser(profile);
        return WebResponse.<TokenResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(tokenResponse)
                .build();
    }
}
