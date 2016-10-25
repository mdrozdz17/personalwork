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
public class TempConverter {
    public static Convert convert(Convert convert) {
        if (convert.getFromUnit().equals(convert.getToUnit())) {
            convert.setToValue(convert.getFromValue());
            return convert;
        }

        double temperature = convert.getFromValue(); // Kelvin
        switch (convert.getFromUnit()) {
            case "Celsius":
                temperature += 273.15;
                break;
            case "Fahrenheit":
                temperature = (convert.getFromValue() - 32) * 5 / 9 + 273.15;
                break;
            default:
        }

        switch (convert.getToUnit()) {
            case "Celsius":
                convert.setToValue(temperature - 273.15);
                break;
            case "Fahrenheit":
                convert.setToValue((temperature - 273.15) * 9 / 5 + 32);
                break;
                default :
                convert.setToValue(temperature); // kelvin
        }
        return convert;
    }

}

