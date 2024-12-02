package rythmic.ryhtmic_studio_backend.model;

<<<<<<< HEAD:src/main/java/rythmic/ryhtmic_studio_backend/model/VenueAddRequest.java
import com.fasterxml.jackson.annotation.JsonProperty;
=======
>>>>>>> parent of 615c913 (modify create venue):src/main/java/fitspace/fitspace_sports_venue_booking_website_backend/model/VenueAddRequest.java
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueAddRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Pattern(regexp = "\\+?[0-9]*")
    @Size(max = 100)
    private String phoneNumber;

    @NotBlank
    @Size(max = 255)
    private String street;

    @NotBlank
    @Size(max = 100)
    private String district;

    @NotBlank
    @Size(max = 100)
    private String cityOrRegency;

    @NotBlank
    @Size(max = 100)
    private String province;

    @NotBlank
    @Size(max = 100)
    private String country;

    @NotBlank
    @Size(max = 10)
    private String postalCode;

    @NotNull
    @DecimalMin(value = "-90.0")
    @DecimalMax(value = "90.0")
    private Double latitude;

    @NotNull
    @DecimalMin(value = "-180.0")
    @DecimalMax(value = "180.0")
    private Double longitude;

}
