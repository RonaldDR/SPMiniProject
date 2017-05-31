/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spminiproject.lab2;

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
        Sample s = new Sample();
        Scanner input = new Scanner(System.in);
        int choice = 0, s_type = 0, n = 0;
        float ftmp = 0;
        int itmp = 0;
        String temp ="" ;
        String desc = "";
        
        do{
            System.out.println("\n\nSummarizing and Presenting Data\n");
            System.out.println("1. Categorical");
            System.out.println("2. Numerical");
            System.out.println("3. Quit\n\n");
            
            do{
                try{
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    
                    if(choice <= 0 || choice >= 4){
                        throw new Exception();
                    }
                }catch(Exception e){
                    System.out.println("You entered an invalid input. Please try again");
                    choice = -1;
                }
                
                input.nextLine();
                
            }while(choice <=  0 || choice >= 4);
            
            if(choice < 3){
                System.out.print("Enter a brief title for the data: " );
                desc = input.nextLine();
                
                do{
                    try{
                        System.out.print("\nNo. of Data? ");
                        n = input.nextInt();
                        
                        if(n <= 2){
                            throw new Exception();
                        }
                    }catch(Exception e){
                        System.out.println("You entered an invalid input. Please try again.");
                        n = -1;
                    }
                    input.nextLine();
                }while(n == -1);
                
                s.pop = n;
                
                if(choice == 1){
                    System.out.println("Categorical");
                    
                    do{
                        try{
                            System.out.print("numerical(1), alphabetic(2), string(3)? ");
                            s_type = input.nextInt();
                        }catch(Exception e){
                            System.out.println("You entered an invalid input. Please try again.");
                            s_type = 0;
                        }
                        input.nextLine();
                    }while(s_type <= 0 || s_type >= 4);
                }
                
                else if(choice == 2){
                    System.out.println("Numeric");
                    
                    do{
                        try{
                            System.out.print("integer(4) or float(5)? ");
                            s_type = input.nextInt();
                        }catch(Exception e){
                            System.out.println("You entered an invalid input. Please try again.");
                            s_type = 0;
                        }
                        input.nextLine();
                    }while(s_type <= 3 || s_type >= 6 );
                }
                
                s = new Sample(s_type, desc);
                
                if(s_type == 1){
                    System.out.println("Categorical: numerical label");
                    for(int i = 0; i < n; i++){
                        do{
                            try{
                                System.out.print("Sample "+ (i + 1) + ": ");
                                temp = input.next();
                                temp = temp.toLowerCase();
                                if(s.isNumericLabel(temp) == false){
                                    throw new Exception();
                                }
                            }catch(Exception e){
                                System.out.println("You entered an invalid input. Please try again.");
                                temp = "a";
                            }
                        }while(temp == "a");
                        s.ar.add(temp);
                    }
                }
                
                else if(s_type == 2){
                    System.out.println("Categorical: alphabetic");
                    for(int i = 0; i < n; i++){
                        do{
                            try{
                                System.out.print("Sample "+ (i + 1) + ": ");
                                temp = input.next();
                                temp = temp.toLowerCase();
                                if(s.isAlphabetic(temp) == false){
                                    throw new Exception();
                                }
                            }catch(Exception e){
                                System.out.println("You entered an invalid input. Please try again.");
                                temp = ">";
                            }
                        }while(temp == ">");
                        
                        s.ar.add(temp);
                    }
                }
                
                else if( s_type == 3){
                    System.out.println("Categorical: string");
                    for(int i = 0; i < n; i++){
                        do{
                            try{
                                System.out.print("Sample "+ (i + 1) + ": ");
                                temp = input.next();
                                temp = temp.toLowerCase();
                            }catch(Exception e){
                                System.out.println("You entered an invalid input. Please try again.");
                                temp = "+";
                            }
                        
                        }while(temp == "+");
                        
                        s.ar.add(temp);
                    }
                }
                else if(s_type == 4){
                    System.out.println("Numerical: integer");
                    for(int i = 0; i < n; i++){
                        do{
                            try{
                                System.out.print("Sample "+ (i + 1) + ": ");
                                itmp = input.nextInt();
                            }catch(Exception e){
                                System.out.println("You entered an invalid input. Please try again. ");
                                itmp = -100;
                            }
                            input.nextLine();
                        }while(itmp == -100);
                        
                        s.ar.add(itmp);
                    }
                }
                
                else if(s_type == 5){
                    System.out.println("Numerical: float");
                    for(int i = 0; i < n; i++){
                        do{
                            try{
                                System.out.print("Sample "+ (i + 1) + ": ");
                                ftmp = input.nextFloat();
                            }catch(Exception e){
                                System.out.println("You entered an invalid input. Please try again. ");
                                ftmp = -100;
                            }
                            input.nextLine();
                
                        }while(ftmp == -100);
                        
                        s.ar.add(ftmp);            
                    }        
                }
                
                s.display();
        
        
                if(s_type <= 3){
                    s.displaysummarytable();
                }
        
                else if( s_type == 4){
                    int c2 = 0;
                    s.displayfpdtforint(c2);
            
            
                    do{                
                        try{                    
                            System.out.print("Do you want to collapse the 1st class limits(1), the last class limits(2) or both(3)? ");                    
                            c2 = input.nextInt();                    
                            if(c2 < 0 || c2 > 3){                        
                                throw new Exception();                    
                            }                
                        }catch(Exception e){                    
                            System.out.println("You entered an invalid input. Please try again.");                    
                            c2 = -1;                
                        }                
                        input.nextLine();            
                    }while(c2 == -1);
                    
                    s.displayfpdtforint(c2);
                }
        
                else{
                    int c2 = 0;
//                    s.displayfpdtforfloat(c2);
                    
                    do{
                        try{
                            System.out.print("Do you want to collapse the 1st class limits(1), the last class limits(2) or both(3)? ");
                            c2 = input.nextInt();
                            
                            if(c2 < 0 || c2 > 3){
                                throw new Exception();
                            }
                        }catch(Exception e){
                            System.out.println("You entered an invalid input. Please try again.");
                            c2 = -1;
                        }
                        input.nextLine();
                    }while(c2 == -1);
                    
//                    s.displayfpdtforfloat(c2);
                } 
                int c3;
                
                
                do{
                    try{
                        System.out.print("Do you want to display the graph for the table?(0/1) ");
                        c3 = input.nextInt();
                        if(c3 < 0 || c3 >1){
                            throw new Exception();
                        }
                        if(c3 == 1){
                            s.displaygraph();
                        }
                        
                    }catch(Exception e){
                        System.out.println("You entered an invalid input");
                        c3 = -1;
                    }
                    input.nextLine();
                }while(c3 == -1 || c3 == 1);
                
                
            }
        }while(choice != 3);
    
    }
    
}
