/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spminiproject.lab1;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 *
 * @author Ronald j del Rosario
 */
public class Stat {
    public static void start(){
        
        
        JFrame parent = new JFrame();
        Sample s = new Sample();
        
        int repeat = 0;
        int choice = 0;
        int population = 0;
        int type = 0;
        int value = 0;
        
        float[] num;
        char[] ch;
        
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("\nBasic Sampling Methods");
            System.out.println("1. Simple Random ");
            System.out.println("2. Systematic Random");
            System.out.println("3. Stratified ");
            System.out.println("4. Quit \n\n");
            //System.out.print("Enter the sampling method of your choice: ");
            
//            do{
//                try{
            //        choice = input.nextInt();
            //        if(choice < 1 || choice > 4){
            //            throw new Exception();
            //        }
//                }catch(Exception e){
//                   System.out.println("You entered an invalid input. Please try again");
//                    System.out.print("> ");
//                    choice = -1;
//                }
//                input.nextLine();
            //}while(choice == -1);
            String[] choices = { "Simple Random", "Systematic Random", "Stratified", "Quit"};
            
            do{
                try{
                    String menu = (String) JOptionPane.showInputDialog(null, "Choose now...",
                            "Basic Sampling Methods", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                        // default
                                                                        // icon
                            choices, // Array of choices
                            choices[1]); // Initial choice
//                    System.out.println(menu);
                    
                    if(menu == "Simple Random"){
                        choice = 1;
                    }
                    else if(menu == "Systematic Random"){
                        choice = 2;
                    }
                    else if(menu =="Stratified"){
                        choice = 3;
                    }
                    else if(menu ==  "Quit"){
                        choice = 4;
                    }
                    else{
                        throw new Exception();
                    }
                }
                catch(Exception e){
                   System.out.println("You entered an invalid input. Please try again");
                    choice = -1;
                }
            }while(choice == -1);
            
            if(choice >= 1 && choice <= 3 && repeat == 0){

                try{
                    JOptionPane.showMessageDialog(parent, "Enter the population size.");
                }catch(Exception e){
                    
                }
                System.out.println(choices[choice-1]);
                System.out.print("Population size: ");
                do{
                    try{
                        population = input.nextInt();
                       
                        if(population < 25){
                            //System.out.println("The minimum number of the target population is 25.\nPlease try again.");
                            
                            JOptionPane.showMessageDialog(parent, "The minimum number of target population is 25. Try again.");
                            
                            System.out.print("> ");
                            population = -1;
                        }
                    }catch(Exception e){
                        System.out.println("You entered an invalid input. Please try again");
                        System.out.print("> ");
                        population = -1;
                    }
                    input.nextLine();
                }while(population == -1);
                
                //JOptionPane.showMessageDialog(parent, "Which one would you prefer: numeric(1) or alphabetical(2)?");
                //System.out.print("\nWhich one would you prefer: numeric(1) or alphabetical(2)? ");
                String[] buttons = { "Numeric","Alphabetical"};

                
                
                do{
                    int reply2 = JOptionPane.showOptionDialog(null, "Which one would you prefer?", "Confirmation",
                    JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);
                    try{
                        type = reply2;
                        if(type < 0 || type > 1){
                            throw new Exception();
                        }
                    }catch(Exception e){
                        System.out.println("You entered an invalid input. Please try again");
                        System.out.print("> ");
                        type = -1;
                    }
                    //input.nextLine();
                }while(type == -1);

                if(type == 0){
                    s = new Sample(1);
                }
                else if(type == 1){
                    s = new Sample(2);
                }
                num = new float[population];
                ch = new char[population];
                
                System.out.println(buttons[type]);
                
                if(type == 0){
                    for(int i = 0; i < population; i++){
                        System.out.print("Sample "+ (i + 1) + ": ");
                        
                        do{
                            try{
                                num[i] = input.nextFloat();
                            }catch(Exception e){
                                System.out.println("You entered an invalid input. Please try again");
                                System.out.print("> ");
                                num[i] = -100;
                            }
                            input.nextLine();
                        }while(num[i] == -100);
                        
                    }
                    s.Sample(num,population);
                }
                else if(type ==1){
                    for (int i = 0; i < population; i++) {
                        System.out.print("Sample " + (i + 1) + ": ");
                        
                        do{
                            try{
                                ch[i] = input.next().toLowerCase().charAt(0);
                                
                                if(ch[i] >= '0' && ch[i] <= '9'){
                                    throw new Exception();
                                }
                            }catch(Exception e){
                                System.out.println("You entered an invalid input. Please try again");
                                System.out.print("> ");
                            }
                            input.nextLine();
                        }while(ch[i] >= '0' && ch[i] <= '9');
                        
                    }
                    s.Sample(ch, population);
                }
                s.display();
                
                //System.out.print("\nPress any key to continue...");
                //input.nextLine();
                try{
                    JOptionPane.showMessageDialog(parent, "Click okay to continue...");
                }catch(Exception e){}
                
            }
            

            switch(choice){
                case 1:
                    try{
                        JOptionPane.showMessageDialog(parent, "SIMPLE RANDOM SAMPLING");
                    }catch(Exception e){}
                    System.out.println("\nSIMPLE RANDOM SAMPLING");
                    try{
                        JOptionPane.showMessageDialog(parent, "Enter the number of samples you would like to use");
                    }catch(Exception e){ }
                    System.out.print("\nHow many would you use? ");
                    
                    do{
                        try{
                            value = input.nextInt();
                            if(value < 2 || value >= population){
                                throw new Exception();
                            }
                        }catch(Exception e){
                            System.out.println("You entered an invalid input. Please try again");
                            System.out.print("> ");
                            value = 0;
                        }
                        input.nextLine();
                    }while(value == 0);
                    
                    s.random(s.size, value);
                    break;
                case 2:
                    try{
                        JOptionPane.showMessageDialog(parent, "SYSTEMATIC RANDOM SAMPLING");
                    }catch(Exception e){ }
                    System.out.println("\nSYSTEMATIC RANDOM SAMPLING");
                    try{
                        JOptionPane.showMessageDialog(parent, "Enter the number of samples you would like to use");
                    }catch(Exception e){}
                    System.out.print("\nHow many would you use? ");
                    
                    do{
                        try{
                            value = input.nextInt();
                            if(value < 2 || value >= population){
                                throw new Exception();
                            }
                        }catch(Exception e){
                            System.out.println("You entered an invalid input. Please try again");
                            System.out.print("> ");
                            value = 0;
                        }
                        input.nextLine();
                    }while(value == 0);
                    
                    s.systematic(s.size, value);
                    break;
                case 3:
                    try{
                        JOptionPane.showMessageDialog(parent, "STRATIFIED SAMPLING");
                    }catch(Exception e){ }
                    System.out.println("\nSTRATIFIED SAMPLING");
                    System.out.println(s.size);
                    s.stratifyall(s.size);
                    try{
                        JOptionPane.showMessageDialog(parent, "Enter the percentage of the sample that you would like to use");
                    }catch(Exception e){ }
                    System.out.print("\nIn what percentage of the sample would you use? ");
                    
                    do{
                        try{
                            value = input.nextInt();
                            if(value < 1 || value >= 100){
                                throw new Exception();
                            }
                        }catch(Exception e){
                            System.out.println("You entered an invalid input. Please try again");
                            System.out.print("> ");
                            value = 0;
                        }
                        input.nextLine();
                    }while(value == 0);
                    
                    s.stratify(s.size,(float)value);
                    break;
                case 4:
                    System.out.println("\nSuccessfully quit the program ...");
                    try{
                        JOptionPane.showMessageDialog(parent, "Successfully quit the program ...");
                    }catch(Exception e){ }
                    input.nextLine();
                    break;
                    
                default:
                    try{
                        JOptionPane.showMessageDialog(parent, "You entered an invalid input.");
                    }catch(Exception e){}
                    break;
            }
            
            if(choice >= 1 && choice <= 3){
                //System.out.print("\nDo you want to use the same data?(0 for no, 1 for yes)");
                String[] buttons = { "No","Yes"};
                
                do{
                    int reply1 = JOptionPane.showOptionDialog(null, "Do you want to use the same data?", "Confirmation",
                            JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);
                    try{
                        repeat = reply1;
                        if(repeat < 0 || repeat > 1){
                            throw new Exception();
                        }
                    }catch(Exception e){
                        //System.out.println("You entered an invalid input. Please try again");
                        try{
                            JOptionPane.showMessageDialog(parent, "You entered an invalid input. Please try again.");
                        }catch(Exception j){ }
                        System.out.print("> ");
                        repeat = -1; 
                    }
                    //input.nextLine();
                }while(repeat == -1);
            }
            
        }while(choice != 4);
       
    }
}
