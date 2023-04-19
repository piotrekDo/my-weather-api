package com.example.myweatherapi.geocode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GeoModel implements Serializable {

    private String lat;
    private String lon;
    private String display_name;
}
