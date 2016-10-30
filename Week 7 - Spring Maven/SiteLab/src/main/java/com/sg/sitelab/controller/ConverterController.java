/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.controller;

import com.sg.sitelab.controller.model.Convert;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/converter", method = RequestMethod.GET)
    public String displayConverterPage() {
        return "converter";
    }

    @RequestMapping(value = "/converter", method = RequestMethod.POST)
    public String displayConverterPage(HttpServletRequest request, Map<String, Object> model) {

        Convert convert = new Convert();

        convert.setConversionType(request.getParameter("conversionType"));
        convert.setFromUnit(request.getParameter("fromUnit"));
        convert.setToUnit(request.getParameter("toUnit"));
        convert.setFromValue(Double.parseDouble(request.getParameter("fromValue")));

        model.put("result", convert(convert));
        return "csresponse";
    }

    private Convert convert(Convert conversion) {
        switch (conversion.getConversionType()) {
            case "Temperature":
                return TempConverter.convert(conversion);
            case "Currency":
                return CurrencyConverter.convert(conversion);
            default:
                return conversion;
        }

    }

}
