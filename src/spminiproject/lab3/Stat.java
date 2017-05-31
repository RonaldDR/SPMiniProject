/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spminiproject.lab3;

import java.util.Scanner;

/**
 *
 * @author Ronald j del Rosario
 */
public class Stat {

    /**
     * @param args the command line arguments
     */
    public static void start() {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        
        int choice, type, pop, int_datum;
        float float_datum;
        String desc;
        Ungrouped test = new Ungrouped();
        
        //do{
            new cmsc105lab3GUI().setVisible(true);
//            System.out.println("Descriptive Statistics");
//            System.out.println("1. Ungrouped Data");
//            System.out.println("2. Grouped Data");
//            System.out.println("3. Quit\n");
//
//           System.out.print("Enter your choice: ");
//            choice = input.nextInt();
//           input.nextLine();
//
//            System.out.print("Enter description: ");
//            desc = input.nextLine();
//
//            System.out.print    ("Enter type of data(1 for integer /2 for float): ");
//            type = input.nextInt();
//
//
//
//            switch(choice){
//
//                case 1:
//                    System.out.print("Enter number of data: ");
//                    pop  = input.nextInt();
//
//                    test = new Ungrouped(type);
//                    test.init_Description(desc);
//
//                    System.out.println("UNGROUPED: " + desc+"\n");
//                    for(int i = 0; i < pop; i++){
//                        System.out.print("Sample "+ (i+1) + ": ");
//                        float_datum = input.nextFloat();
//                        test.ungrouped.add(float_datum);
//                    }
//                    test.display();
//                    int choice2 = 0,index2 = 0;
//                    do{
//                        System.out.print("Edit(1) or Continue(2):  ");
//                        choice2 = input.nextInt();
//
//                        if(choice2 == 1){
//                            System.out.print("Enter index(1 - "+pop+ " ):");
//                            index2 = input.nextInt();
//                            System.out.print("Enter value: ");
//
//                            float_datum = input.nextFloat();
//                            test.EditDatum(index2, float_datum);
//
//                            test.display();
//                        }
//                        else if(choice2 != 2){
//                            System.out.println("Wrong input.");
//                        }
//                    }while(choice2 != 2);
//
//                    int choice3 = 0;
//
//                    System.out.println("\n Measures of Central Tendency");
//                    System.out.println("1. Mean");
//                    System.out.println("2. Median");
//                    System.out.println("3. Mode");
//                    System.out.println("4. all");
//                    System.out.print("Enter the number of what you want to display: ");
//
//                    choice3 = input.nextInt();
//                    if(choice3 == 1){
//                        test.Mean();
//                    }
//                    else if(choice3 == 2){
//                        test.Median();
//                    }
//                    else if(choice3 == 3){
//                        test.Mode();
//                    }
//                    else if(choice3 == 4){
//                        test.Mean();
//                        test.Median();
//                        test.Mode();
//                    }
//                    break;
//
//                case 2:
//
//                    int intervalnum = 0,OpenorClose = 0, w_interval = 0;
//                    System.out.print("No. of class intervals: ");
//                    intervalnum = input.nextInt();
//
//                    Grouped test1 = new Grouped(intervalnum);
//
//                    System.out.print("Open-ended(1) or Close-ended(2): ");
//                    OpenorClose = input.nextInt();
//
//                    if(OpenorClose == 1){
//                        System.out.print("first(1), last interval(2) or both(3): ");
//                        w_interval = input.nextInt();
//                    }
//
//                    for(int i = 0; i < test1.data.length; i++){
//                        if( (w_interval == 1 || w_interval ==3) && i == 0){
//                            System.out.println("Interval "+ (i+1) +" " );
//                            System.out.println("LCL: -- ");
//                            test1.data[i][0] = -1;
//                            System.out.print("UCL: ");
//                            test1.data[i][1] = input.nextFloat();
//                            System.out.print("Frequency: ");
//                            test1.data[i][2] = input.nextFloat();
//                            test1.data[i][3] = -1;
//                            test1.data[i][4] = -1;
//                            test1.data[i][5] = -1;
//                        }
//
//                        else if( (w_interval == 2 || w_interval == 3)&& i == (test1.data.length-1) ){
//
//                            System.out.print("Interval "+ (i+1) +" " );
//                            System.out.print("LCL: ");
//                            test1.data[i][0] = input.nextFloat();
//                            System.out.println("UCL: --");
//                            test1.data[i][1] = -1;
//                            System.out.print("Frequency: ");
//                            test1.data[i][2] = input.nextFloat();
//                            test1.data[i][3] = -1;
//                            test1.data[i][4] = -1;
//                            test1.data[i][5] = -1;
//                        }
//                        else{
//                            System.out.println("Interval "+ (i+1) +" " );
//                            System.out.print("LCL: ");
//                            test1.data[i][0] = input.nextFloat();
//                            System.out.print("UCL: ");
//                            test1.data[i][1] = input.nextFloat();
//                            System.out.print("Frequency: ");
//                            test1.data[i][2] = input.nextFloat();
//                            test1.data[i][3] = (test1.data[i][0] + test1.data[i][1]) / 2;
//                            test1.data[i][4] = test1.data[i][2] * test1.data[i][3];
//                            test1.data[i][5] = test1.data[i][4] * test1.data[i][3];
//                        }
//                    }
//
//                    int choice4 = 0,index4 = 0,w_interval2= 0;
//
//                    do{
//                        System.out.print("Edit(1) or Continue(2):  ");
//                        choice4 = input.nextInt();
//
//                        if(choice4 == 1){
//                            System.out.print("At what interval: ");
//                            w_interval2 = input.nextInt();
//
//                            if(w_interval2 == 1 && (w_interval == 1 || w_interval == 3)){
//
//                                System.out.println("Interval "+ w_interval2 +" " );                            
//                                System.out.println("LCL: -- ");                            
//                                test1.data[w_interval2 -1][0] = -1;                            
//                                System.out.print("UCL: ");                            
//                                test1.data[w_interval2-1][1] = input.nextFloat();                     
//                                System.out.print("Frequency: ");                            
//                                test1.data[w_interval2-1][2] = input.nextFloat();                            
//                                test1.data[w_interval2-1][3] = -1;                            
//                                test1.data[w_interval2-1][4] = -1;                            
//                                test1.data[w_interval2-1][5] = -1;                            
//                            }
//
//                            else if(w_interval2 == test1.data.length && (w_interval == 1 || w_interval == 3)){
//
//                                System.out.print("Interval "+ w_interval2 +" " );                            
//                                System.out.print("LCL: ");                            
//                                test1.data[w_interval2 -1][0] = input.nextFloat();                            
//                                System.out.println("UCL: --");                            
//                                test1.data[w_interval2 -1][1] = -1;                            
//                                System.out.print("Frequency: ");                            
//                                test1.data[w_interval2 -1][2] = input.nextFloat();                            
//                                test1.data[w_interval2 -1][3] = -1;                            
//                                test1.data[w_interval2 -1][4] = -1;                     
//                                test1.data[w_interval2 -1][5] = -1;
//
//                            }
//                            else{
//                                System.out.println("Interval "+ w_interval2 +" " );
//                                System.out.print("LCL: ");
//                                test1.data[w_interval2-1][0] = input.nextFloat();
//                                System.out.print("UCL: ");                                
//                                test1.data[w_interval2-1][1] = input.nextFloat();                            
//                                System.out.print("Frequency: ");                            
//                                test1.data[w_interval2-1][2] = input.nextFloat();                            
//                                test1.data[w_interval2-1][3] = (test1.data[w_interval2-1][0] + test1.data[w_interval2-1][1]) / 2;                            
//                                test1.data[w_interval2-1][4] = test1.data[w_interval2-1][2] * test1.data[w_interval2-1][3];                            
//                                test1.data[w_interval2-1][5] = test1.data[w_interval2-1][4] * test1.data[w_interval2-1][3];
//
//                            }
//
//                        }
//                        else if(choice4 != 2){                           
//                            System.out.println("Wrong input.");                        
//                        }                    
//                    }while(choice4 != 2);                   
//
//                    test1.display();
//
//                    int choice5 = 0;
//
//                    System.out.println("\n Measures of Central Tendency");
//                    System.out.println("1. Mean");
//                    System.out.println("2. Median");
//                    System.out.println("3. Mode");
//                    System.out.println("4. all");
//                    System.out.print("Enter the number of what you want to display: ");
//
//                    choice5 = input.nextInt();
//                    if(choice5 == 1){
//                        test1.Mean(OpenorClose);
//                    }
//                    else if(choice5 == 2){
//                        test1.Median();
//                    }
//                    else if(choice5 == 3){
//                        test1.getMode();
//                    }
//                    else if(choice5 == 4){
//                        test1.Mean(OpenorClose);
//                        test1.Median();
//                        test1.getMode();
//                    }
//                    break;
//                default:
//                    break;
//            }
        //}while(choice != 3);
    }
    
}
