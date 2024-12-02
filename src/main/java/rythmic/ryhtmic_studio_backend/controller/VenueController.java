package rythmic.ryhtmic_studio_backend.controller;

import rythmic.ryhtmic_studio_backend.entity.User;
import rythmic.ryhtmic_studio_backend.model.VenueAddRequest;
import rythmic.ryhtmic_studio_backend.model.VenueDataResponse;
import rythmic.ryhtmic_studio_backend.model.VenueUpdateRequest;
import rythmic.ryhtmic_studio_backend.model.WebResponse;
import rythmic.ryhtmic_studio_backend.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping(
            path = "/api/venues",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<VenueDataResponse> create(User user, @RequestBody VenueAddRequest request) {
        VenueDataResponse venueDataResponse = venueService.create(user, request);
        return WebResponse.<VenueDataResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(venueDataResponse)
                .build();
    }

    @GetMapping(
            path = "/api/venues/{venueId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<VenueDataResponse> get(@PathVariable("venueId") Integer venueId) {
        VenueDataResponse venueDataResponse = venueService.get(venueId);
        return WebResponse.<VenueDataResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(venueDataResponse)
                .build();
    }

    @PatchMapping(
            path = "/api/venues/{venueId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<VenueDataResponse> update(User user, @PathVariable("venueId") Integer venueId, @RequestBody VenueUpdateRequest request) {
        VenueDataResponse venueDataResponse = venueService.update(user, venueId, request);
        return WebResponse.<VenueDataResponse>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(venueDataResponse)
                .build();
    }

    @DeleteMapping(
            path = "/api/venues/{venueId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(User user, @PathVariable("venueId") Integer venueId) {
        venueService.delete(user, venueId);
        return WebResponse.<String>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data("Successfully deleted venue")
                .build();
    }

    @GetMapping(
            path = "/api/venues",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<VenueDataResponse>> getAll() {
        List<VenueDataResponse> venueDataResponses = venueService.getAll();
        return WebResponse.<List<VenueDataResponse>>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(venueDataResponses)
                .build();
    }

    @GetMapping(
            path = "/api/users/{userId}/venues",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<VenueDataResponse>> getAllFromOwner(User user, @PathVariable("userId") Integer userId) {
        List<VenueDataResponse> venueDataResponses = venueService.getAllFromOwner(user, userId);
        return WebResponse.<List<VenueDataResponse>>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(venueDataResponses)
                .build();
    }
}
