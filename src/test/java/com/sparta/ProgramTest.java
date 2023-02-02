package com.sparta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    @Test
    @DisplayName("My first test")
    public void firstTest() {
        Assertions.assertTrue(5 == 5);
    }

    @Test
    @DisplayName("Given a time of 21, greeting return Good Evening")
    public void given21_Greeting_ReturnsGoodEvening(){
        int time = 21;
        String expectedGreeting = "Good evening!";
        String result = Program.greeting(time);
        Assertions.assertEquals(expectedGreeting, result);
    }

    @Test
    @DisplayName("Given a time of 12, greeting return Good morning")
    public void given12_Greeting_ReturnGoodMorning(){
        int time = 12;
        String expectedGreeting = "Good afternoon!";
        String result = Program.greeting(time);
        Assertions.assertEquals(expectedGreeting, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 8, 11})
    @DisplayName("Given a time between 5 and 12, " +
            "greeting returns good morning")
    public void GivenTimeBetween5And12_Greeting_ReturnsGoodMorning(int time){
        String expected = "Good morning!";
        String result = Program.greeting(time);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 14, 19})
    @DisplayName("Given a time not between 5 and 12, " +
            "greeting does not return good morning")
    public void GivenTimeNotBetween5And12_Greeting_ReturnsNotGoodMorning(int time){
        String notExpected = "Good morning!";
        String result = Program.greeting(time);
        Assertions.assertNotEquals(notExpected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 13, 15, 17})
    @DisplayName("Given a time between 12pm and 6pm, " +
            " greeting returns good afternoon")
    public void GivenTimeBetween12And18_Greeting_ReturnsGoodAfternoon(int time){
        String expected = "Good afternoon!";
        String result = Program.greeting(time);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 19, 21, 11})
    @DisplayName("Given a time not between 12pm and 6pm, " +
            " greeting does not return good afternoon")
    public void GivenTimeNotBetween12And18_Greeting_ReturnsGoodAfternoon(int time){
        String notExpected = "Good afternoon!";
        String result = Program.greeting(time);
        Assertions.assertNotEquals(notExpected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 19, 21, 23})
    @DisplayName("Given a time between 6pm and 12am, " +
            " greeting returns good evening")
    public void GivenTimeBetween18And24_Greeting_ReturnsGoodEvening(int time){
        String expected = "Good evening!";
        String result = Program.greeting(time);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 7, 12, 27})
    @DisplayName("Given a time not between 6pm and 12am, " +
            " greeting does not return good evening")
    public void GivenTimeNotBetween18And24_Greeting_ReturnsGoodEvening(int time) {
        String notExpected = "Good evening!";
        String result = Program.greeting(time);
        Assertions.assertNotEquals(notExpected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 3, 4})
    @DisplayName("Given a time between 12am and 5am, " +
            " greeting returns it is past midnight")
    public void GivenTimeBetween0And5_Greeting_ReturnsPastMidnight(int time) {
        String expected = "Past midnight!";
        String result = Program.greeting(time);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 12, 18, 27})
    @DisplayName("Given a time not between 12am and 5am, " +
            " greeting does not return it is past midnight")
    public void GivenTimeNotBetween0And5_Greeting_ReturnsPastMidnight(int time) {
        String notExpected = "Past midnight!";
        String result = Program.greeting(time);
        Assertions.assertNotEquals(notExpected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 90, 3432})
    @DisplayName("Given an invalid number, " +
            " greeting returns invalid number")
    public void GivenInvalidTime_ReturnsInvalidNumber(int time) {
        String expected = "Invalid number entered," +
                " please enter a number from 0 up to 24";
        String result = Program.greeting(time);
        Assertions.assertEquals(expected, result);
    }
}