package com.adn.msadndetected.service;

import com.adn.msadndetected.model.AdnModel;
import com.adn.msadndetected.model.ResponseModel;
import com.adn.msadndetected.model.StatsModel;

public interface AdnService {

    ResponseModel validateSecuence(AdnModel model);
    StatsModel getResults();

}
