package com.calculator.service;

import com.calculator.calculator.model.CalculationModel;
import org.springframework.stereotype.Component;


public interface CalculatorService {

    /**
     * Effectuer le calcul demandé par un modèle
     *
     *  Modèle de calcul
     * @return Modèle de calcul rempli du résultat
     */
    public CalculationModel calculate(CalculationModel calculationModel);
}
