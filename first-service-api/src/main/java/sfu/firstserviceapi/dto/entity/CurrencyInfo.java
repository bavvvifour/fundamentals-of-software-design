package sfu.firstserviceapi.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyInfo {

    @JsonProperty
    private String code;

    @JsonProperty
    private String symbol;

    @JsonProperty
    private String rate;

    @JsonProperty
    private String description;

    @JsonProperty
    private float rate_float;
}
