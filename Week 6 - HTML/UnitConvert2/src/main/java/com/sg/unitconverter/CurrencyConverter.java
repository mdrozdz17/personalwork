/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.unitconverter;

import com.sg.unitconverter.model.Convert;

/**
 *
 * @author apprentice
 */
class CurrencyConverter {
    public static Convert convert(Convert convert) {
        if (convert.getFromUnit().equals(convert.getToUnit())) {
            convert.setToValue(convert.getFromValue());
            return convert;
        }

        double currency = convert.getFromValue(); // USD
        switch (convert.getFromUnit()) {
            case "CAD":
                currency *= .75;
                break;
            case "Euro":
                currency *= 1.09;
                break;
            default:
        }

        switch (convert.getToUnit()) {
            case "CAD":
                convert.setToValue(currency / .75);
                break;
            case "Euro":
                convert.setToValue(currency / 1.09);
                break;
            default :
                convert.setToValue(currency); // USD
        }
        return convert;
    }

}  

