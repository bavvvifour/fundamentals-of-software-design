package sfu.firstserviceapi.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Time {

    @JsonProperty()
    private String updated;

    @JsonProperty()
    private String updatedISO;

    @JsonProperty()
    private String updateduk;
}
