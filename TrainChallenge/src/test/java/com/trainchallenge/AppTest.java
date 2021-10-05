package com.trainchallenge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


class AppTest {

   private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    
    @Test
    @DisplayName("Integration Test") 
   void integrationTestOne() {
      
      String arguments="src/main/resources/input";
      App.run(Arrays.asList(arguments));

      String expectedOutput="ARRIVAL TRAIN_A ENGINE HYB NGP ITJ\n"+
      "ARRIVAL TRAIN_B ENGINE NJP PTA\n"+
      "DEPARTURE TRAIN_AB ENGINE ENGINE NJP PTA ITJ NGP";
        //Assert
       Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

   }

   @AfterEach
    public void tearDown() {

        System.setOut(standardOut);

    }


}
