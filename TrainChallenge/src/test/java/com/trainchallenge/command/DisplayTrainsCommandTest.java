// package com.trainchallenge.command;

// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;


// import java.io.ByteArrayOutputStream;
// import java.io.PrintStream;
// import java.util.ArrayList;
// import java.util.List;

// import com.trainchallenge.entities.Bogie;

// import com.trainchallenge.services.TrainService;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.DisplayName;
// public class DisplayTrainsCommandTest {
//     private final PrintStream standardOut = System.out;
//     private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    

//     @Mock
//     TrainService trainServiceMock;

//     @InjectMocks
//     DisplayTrainsCommand displaytrainsCommand;

//     @BeforeEach
//     public void setUp() {
//         System.setOut(new PrintStream(outputStreamCaptor));
//     }

//     @Test
//     @DisplayName("Should print the two trains Name along with their Bogies list")
//     public void execute_ShouldPrintBogieListForEachTrain(){

//         String stationCodes[]= {"SLM","BLR","KRN","HYB","SLM","NGP","ITJ"};
//         List<Bogie> bogies= new ArrayList<>();
//         for(String code:stationCodes){
//             Bogie bogie= new Bogie(code, null, "TRAIN_A", 0.0);
//             bogies.add(bogie);
//         }
//         //Train firstTrain= new Train("TRAIN_A", 0, bogies, null, TrainStatus.ARRIVAL);
//         for(Bogie bogie: bogies){
//             bogie.setTrainName("TRAIN_B");
//         }
//         // Train secondTrain = new Train("TRAIN_B",0,bogies,null,TrainStatus.ARRIVAL);
//         // when(trainServiceMock.getTrain("TRAIN_A")).thenReturn(firstTrain);
//         // when(trainServiceMock.getTrain("TRAIN_B")).thenReturn(secondTrain);

//         // String expectedOutput="TRAIN_A ENGINE SLM BLR KRN HYB SLM NGP ITJ\n"+
//         // "TRAIN_B ENGINE SLM BLR KRN HYB SLM NGP ITJ";
//         // displaytrainsCommand.execute(Arrays.asList("TRAIN_A","TRAIN_B"));
//         // Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());


//     }
//     @AfterEach
//     public void tearDown() {

//         System.setOut(standardOut);

//     }
// }