package com.adn.msadndetected.service;

import com.adn.msadndetected.model.ResponseModel;
import lombok.AllArgsConstructor;
import com.adn.msadndetected.model.AdnModel;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdnServiceImpl implements AdnService {

    @Override
    public ResponseModel validateSecuence(AdnModel model) {
        ResponseModel response = new ResponseModel();

        String[][] matriz = fillMatrix(model);
        boolean result = validateMatrix(matriz);

        if(result){
            response.setCode(200);
            response.setResul("Verificado");
        }else{
            response.setCode(403);
            response.setResul("No Verificado");
        }


        return response;
    }

    private String[][] fillMatrix(AdnModel model){

        String[][] matriz = new String[5][5];

        for (int f=0;f < model.getMuestra().size(); f++){
            String[] letra = model.getMuestra().get(f).split("");
            for(int l=0; l < letra.length; l++){
                matriz[f][l] = letra[l];
            }
        };

        return matriz;
    };

    private boolean validateMatrix(String[][] matriz){

        boolean result = false;
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int longitudSecuencia = 3;
        int nSecuencias = 0;

        // Búsqueda horizontal
        for(int f = 0; f < filas; f++) {

            for (int c = 0; c < columnas; c++) {

                String letra = matriz[f][c];
                boolean secuenciaEncontrada = true;

                if(matriz.length - c > 2){
                    for (int b = 1; b < longitudSecuencia; b++) {

                        String letra2 = matriz[f][c + b];
                        boolean is = letra.equals(letra2);

                        if (!is) {
                            secuenciaEncontrada = false;
                            break;
                        }
                    }

                    if (secuenciaEncontrada) {
                        nSecuencias = nSecuencias + 1;
                    }
                }
            }
        }

        for(int c = 0; c < filas; c++) {

            for (int f = 0; f < columnas; f++) {

                String letra = matriz[f][c];
                boolean secuenciaEncontrada = true;

                if(matriz.length - f > 2){
                    for (int b = 1; b < longitudSecuencia; b++) {

                        String letra2 = matriz[f + b][c];
                        boolean is = letra.equals(letra2);

                        if (!is) {
                            secuenciaEncontrada = false;
                            break;
                        }
                    }

                    if (secuenciaEncontrada) {
                        nSecuencias = nSecuencias + 1;
                    }
                }
            }
        }

        if(nSecuencias > 1){
            result = true;
        }else {
            result = false;
        }

        return result;
    }
}
