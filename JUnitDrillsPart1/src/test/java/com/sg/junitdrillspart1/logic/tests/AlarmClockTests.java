/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.junitdrillspart1.logic.tests;

import com.sg.junitdrillspart1.logic.AlarmClock;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class AlarmClockTests {

    AlarmClock myAlarm = new AlarmClock();
    
@Test
    public void testAlarmClock() {
        String time;
        time = myAlarm.alarmClock(1, false); // alarmClock(1, false) → "7:00"
        assertEquals("7:00", time);

        time = myAlarm.alarmClock(5, false); // alarmClock(5, false) → "7:00"
        assertEquals("7:00", time);
        
        time = myAlarm.alarmClock(0, false); // alarmClock(0, false) → "10:00"
        assertEquals("10:00", time);
    }
}
