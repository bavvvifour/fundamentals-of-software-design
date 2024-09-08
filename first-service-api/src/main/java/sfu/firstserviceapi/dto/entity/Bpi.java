package sfu.firstserviceapi.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bpi {

    @JsonProperty("USD")
    private CurrencyInfo USD;

    @JsonProperty("GBP")
    private CurrencyInfo GBP;

    @JsonProperty("EUR")
    private CurrencyInfo EUR;
}