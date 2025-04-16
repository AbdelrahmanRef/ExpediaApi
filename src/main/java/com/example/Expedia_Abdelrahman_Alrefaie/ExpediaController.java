package com.example.Expedia_Abdelrahman_Alrefaie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExpediaController {
    @GetMapping("/searchPackages")
    public ResponseEntity<String> getPackages(@RequestParam String origin, @RequestParam String destination) {
        String apiUrl = "https://offersvc.expedia.com/offers/v2/getOffers" +
                "?scenario=deal-finder" +
                "&page=foo" +
                "&uid=test" +
                "&productType=Package" +
                "&clientId=test" +
                "&originCity=" + origin +
                "&destinationCity=" + destination;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(apiUrl, String.class);
        return ResponseEntity.ok(result);
    }
}
