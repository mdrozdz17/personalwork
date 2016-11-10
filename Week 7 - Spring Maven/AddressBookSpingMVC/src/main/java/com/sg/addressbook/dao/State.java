/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public enum State {
    
    AL ("AL - Alabama"),
    AK ("AK - Alaska"),
    AZ ("AZ - Arizona"),
    AR ("AR - Arkansas"),
    CA ("CA - California"),
    CO ("CO - Colorado"),
    CT ("CT - Connecticut"),
    DE ("DE - Delaware"),
    FL ("FL - Florida"),
    GA ("GA - Georgia"),
    HI ("HI - Hawaii"),
    ID ("ID - Idaho"),
    IL ("IL - Illinois"),
    IN ("IN - Indiana"),
    IA ("IA - Iowa"),
    KS ("KS - Kansas"),
    KY ("KY - Kentucky"),
    LA ("LA - Louisiana"),
    ME ("ME - Maine"),
    MD ("MD - Maryland"),
    MA ("MA - Massachusetts"),
    MI ("MI - Michigan"),
    MN ("MN - Minnesota"),
    MS ("MS - Mississippi"),
    MO ("MO - Missouri"),
    MT ("MT - Montana"),
    NE ("NE - Nebraska"),
    NV ("NV - Nevada"),
    NH ("NH - New Hampshire"),
    NJ ("NJ - New Jersey"),
    NM ("NM - New Mexico"),
    NY ("NY - New York"),
    NC ("NC - North Carolina"),
    ND ("ND - North Dakota"),
    OH ("OH - Ohio"),
    OK ("OK - Oklahoma"),
    OR ("OR - Oregon"),
    PA ("PA - Pennsylvania"),
    RI ("RI - Rhode Island"),
    SC ("SC - South Carolina"),
    SD ("SD - South Dakota"),
    TN ("TN - Tennessee"),
    TX ("TX - Texas"),
    UT ("UT - Utah"),
    VT ("VT - Vermont"),
    VA ("VA - Virginia"),
    WA ("WA - Washington"),
    WV ("WV - West Virginia"),
    WI ("WI - Wisconsin");


    /**
     * The state's name.
     */
    private final String name;
    
private State(String s) {
    name = s;
}

public String getName() {
    return name;
}

}

