package com.rayshan.common.data;

import lombok.Data;
import java.util.Map;

@Data
public class CountriesResponse {
    private Map<String, CountryData> data;
}
