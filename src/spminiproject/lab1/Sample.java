/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spminiproject.lab1;

import java.util.ArrayList;

/**
 *
 * @author Ronald j del Rosario
 */
public class Sample{
    ArrayList ar;
    int size;
    int type;

    public Sample() {
        this.ar = new ArrayList<>();
        size = 0;
        type = 0;
    }
    public Sample(int c){
        if(c == 1){
            this.ar = new ArrayList<Float>();
            type = 1;
        }
        if(c == 2){
            this.ar = new ArrayList<Character>();
            type = 2;
        }
        size = 0;
    }
    
    public void Sample(float[] arr, int size) {
        for(int i = 0; i< size; i++){
            ar.add(arr[i]);
        }
        this.size = ar.size();
    }
    
    public void Sample(char[] arr, int size) {
        for(int i = 0; i< size; i++){
            ar.add(arr[i]);
        }
        this.size = ar.size();
    }
    
    public void display() {
        System.out.println("\nSAMPLE FRAME");
        for(int i = 0; i<this.size; i++){
            if(i%5 == 0){
                System.out.println("\n");
            }
            System.out.print( "["+(i + 1) + "]: "+ ar.get(i)+ " \t");
        }
        System.out.println("\n");
    }
    
    public void random(int pop, int value){
        int randval;
        int[] arr = new int[pop];
        
        for(int i = 0; i < pop; i++){
            arr[i] = 0;
        }
        
        for(int i = 0; i < value ; i++){
            if (i % 5 == 0) {
                System.out.println();
            }
            do{
                randval = (int)(Math.random() * pop);
            }while(arr[randval] == 1);
            arr[randval] = 1;
            
            System.out.print("\t[" + (randval + 1) + "]:" + this.ar.get(randval));
        }
        System.out.println("");
    }
    public void systematic(int pop, int value){
        int randpool = (int) Math.floor(pop / value);
        int randval = (int) (Math.random()*randpool);
//        System.out.println("randpool: "+ randpool+"\trandval: "+ randval);
        
        for(int i = 0; i < value; i++){
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print("[" + (randval + 1) + "]:" + this.ar.get(randval) + "\t");
            randval += randpool;
        }
        System.out.println("\n");
    }
    
    public void stratifyall(int pop){
        ArrayList temp = new ArrayList<>();
        if(this.type == 1 ){
            temp = new ArrayList<Integer>();
        }
        else if(this.type == 2){
            temp = new ArrayList<Character>();
        }
        
        for(int i = 0; i < pop; i++ ){
            if(!(temp.contains(this.ar.get(i)))){
                temp.add(ar.get(i));
            }
        }
        
        
        for(int i=0; i < temp.size(); i++){
            System.out.println("\nStratum "+ (i + 1));
            for(int j = 0; j < this.ar.size(); j++){
                if(temp.get(i).equals(this.ar.get(j))){
                    System.out.print("[" + (j+1) + "]: "+ this.ar.get(j)+"\t" );
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void stratify(int pop, float value){
        ArrayList temp = new ArrayList<>();
        ArrayList ctr = new ArrayList<Integer>();
        int tempctr = 0;
        int randval =0;
        float percentage = value / 100;
        
        if(this.type == 1 ){
            temp = new ArrayList<Integer>();
        }
        else if(this.type == 2){
            temp = new ArrayList<Character>();
        }
        
        for(int i = 0; i < pop; i++ ){
            if(!(temp.contains(this.ar.get(i)))){
                temp.add(ar.get(i));
            }
        }
        int[] arrSamp = new int[this.ar.size()];
        
        for(int i = 0; i < temp.size(); i++){
            arrSamp[i] = 0;
        }
        
        for(int i = 0; i < temp.size(); i++){
            int count = 0;
            
            for(int j = 0; j < this.ar.size(); j++){
                if(temp.get(i).equals(this.ar.get(j))){
                    count++;
                }
            }
            arrSamp[i] = count;
        }
        
        for(int i = 0; i < temp.size(); i++){
            int count = 0;
            ctr = new ArrayList<Float>();
            int sam = (int) Math.ceil(percentage * (float) arrSamp[i]);
            System.out.println("\nStratum "+temp.get(i)+ "(n = "+sam+")");
            
            for(int j = 0; j < this.ar.size(); j++){
                if(temp.get(i).equals(this.ar.get(j)) && count < sam){
                    ctr.add(j);
                    System.out.print("[" + (j+1) + "]: "+ this.ar.get(j)+"\t" );
                    count++;
                }
            }
            
            
            
            System.out.println("");
        }

        System.out.println("");
    }
}
