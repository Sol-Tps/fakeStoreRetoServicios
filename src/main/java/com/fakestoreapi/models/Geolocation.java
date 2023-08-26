package com.fakestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Geolocation {

    @JsonProperty("lat")
    public String lat;

    @JsonProperty("_long")
    public String _long;
}
