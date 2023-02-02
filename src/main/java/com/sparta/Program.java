package com.sparta;

public class Program {
    public static void main(String[] args) {
        int timeOfDay = 21;
        // short-curcuiting operation
        String result = greeting(timeOfDay);
        System.out.println(result);
    }

    public static String greeting(int timeOfDay) {
        String greeting;
        if (timeOfDay >= 5 && timeOfDay < 12) {
            greeting = "Good morning!";
        }
        else if (timeOfDay >= 12 && timeOfDay < 18) {
            greeting = "Good afternoon!";
        }
        else if (timeOfDay >= 18 && timeOfDay < 24){
            greeting = "Good evening!";
        }
        else if ((timeOfDay >= 0 && timeOfDay < 5) || timeOfDay == 24)  {
            greeting = "Past midnight!";
        }
        else {
            greeting = "Invalid number entered," +
                    " please enter a number from 0 up to 24";
        }
        return greeting;
    }

}
