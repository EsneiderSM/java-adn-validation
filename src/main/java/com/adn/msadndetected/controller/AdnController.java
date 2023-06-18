package com.adn.msadndetected.controller;

import com.adn.msadndetected.model.ResponseModel;
import lombok.AllArgsConstructor;
import com.adn.msadndetected.model.AdnModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adn.msadndetected.service.AdnService;

@RestController
@AllArgsConstructor
@RequestMapping("api/adn")
public class AdnController {

    private AdnService _adnService;

    @PostMapping
    public ResponseEntity<ResponseModel> validateADN(@RequestBody AdnModel model){
        ResponseModel response = _adnService.validateSecuence(model);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }
}
