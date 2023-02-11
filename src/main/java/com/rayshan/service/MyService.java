package com.rayshan.service;

import com.rayshan.common.data.CountriesResponse;
import com.rayshan.common.data.CountryData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyService {
    public List<String> getCountries() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.first.org/data/v1/countries";
        CountriesResponse resp = restTemplate.getForObject(url, CountriesResponse.class);
        //restTemplate.post


        List<CountryData> countryDataList = resp.getData().entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
        return countryDataList.stream().map(countryData -> countryData.getCountry()).collect(Collectors.toList());
    }
}
