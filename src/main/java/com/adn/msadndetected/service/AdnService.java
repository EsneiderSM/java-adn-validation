package com.adn.msadndetected.service;

import com.adn.msadndetected.model.AdnModel;
import com.adn.msadndetected.model.ResponseModel;

public interface AdnService {

    ResponseModel validateSecuence(AdnModel model);

}
