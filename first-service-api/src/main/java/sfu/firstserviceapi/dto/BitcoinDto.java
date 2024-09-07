package sfu.firstserviceapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import sfu.firstserviceapi.dto.entity.Bpi;
import sfu.firstserviceapi.dto.entity.Time;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinDto {

    @JsonProperty()
    private Time time;

    @JsonProperty()
    private String disclaimer;

    @JsonProperty()
    private String chartName;

    @JsonProperty
    private Bpi bpi;
}
