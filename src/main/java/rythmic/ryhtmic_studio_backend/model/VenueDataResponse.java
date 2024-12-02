package rythmic.ryhtmic_studio_backend.model;

<<<<<<< HEAD:src/main/java/rythmic/ryhtmic_studio_backend/model/VenueDataResponse.java
import com.fasterxml.jackson.annotation.JsonProperty;
=======
import jakarta.validation.constraints.*;
>>>>>>> parent of 615c913 (modify create venue):src/main/java/fitspace/fitspace_sports_venue_booking_website_backend/model/VenueDataResponse.java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueDataResponse {

    private Integer id;

    private String name;

    private String phoneNumber;

    private String street;

    private String district;

    private String cityOrRegency;

    private String province;

    private String country;

    private String postalCode;

    private Double latitude;

    private Double longitude;

    private Double rating;

    private Integer reviewsCount;

    private Integer ownerId;

    private List<String> field_types;
}
