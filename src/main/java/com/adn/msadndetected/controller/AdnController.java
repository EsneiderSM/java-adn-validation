package com.adn.msadndetected.controller;

import com.adn.msadndetected.model.ResponseModel;
import com.adn.msadndetected.model.StatsModel;
import lombok.AllArgsConstructor;
import com.adn.msadndetected.model.AdnModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/stats")
    public ResponseEntity<ResponseModel> getResults(){
        ResponseModel<StatsModel> response = new ResponseModel();
        StatsModel stats = _adnService.getResults();
        response.setResult(stats);
        response.setCode(200);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }
}
