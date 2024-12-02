package rythmic.ryhtmic_studio_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoAddRequest {

    @NotBlank
    @JsonProperty("photo_url")
    private String photoUrl;

    @NotBlank
    private String description;

}
