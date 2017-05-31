/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spminiproject.lab3;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ronald j del Rosario
 */
public class Ungrouped {
    ArrayList ungrouped = new ArrayList<>();
    String description;
    
    int type;
    
    public Ungrouped(){
        ungrouped = null;
    }
    
    public Ungrouped(int t){
//        if(t == 1){
//            ungrouped = new ArrayList<Integer>();
//            type = 1;
//        }
//        else{
            ungrouped = new ArrayList<Float>();
//            type  = 2;
//        }
    }
    
    public void init_Description(String d){
        description = d;
    }
    
    public void display(){
        System.out.println("\n"+description);
        System.out.println("Index \t Value");
        for(int i = 0; i < ungrouped.size(); i++){
            System.out.println(" ["+ (i + 1) +"]:\t"+ ungrouped.get(i));
        }
    }
    
    public void display(String interp){
        display();
        System.out.println("INTERPRETATION: "+ interp);
    }
    
    public void Mean(){
        float sum = 0, average = 0, variance = 0, stdeviation,temp;
        
        for (int i = 0; i < ungrouped.size(); i++){
            sum = sum + (float)ungrouped.get(i);
        }
        
        average = sum / (float)ungrouped.size();
        System.out.println("Mean :" + average);
        
        for (Object ungrouped1 : ungrouped) {
            variance = variance + (((float) ungrouped1 - average) * ((float) ungrouped1 - average));
        }
        variance = variance / ((float)ungrouped.size() - 1);
        System.out.println("Variance(s^2): "+ variance);
        
        stdeviation = (float) Math.sqrt(variance);
        System.out.println("Standard Deviation: "+ stdeviation);
        
    }
    
    public void Median(){
        
        float range, median;
        Collections.sort(ungrouped);
        int mid1, mid2, size = ungrouped.size();
        
        range =  (float)ungrouped.get(size-1) - (float)ungrouped.get(0);
        System.out.println("Range: "+ range);
        
        if(size % 2 == 0){
            mid1 = size / 2;
            mid2 = mid1 + 1;
            median = ((float)ungrouped.get(mid1-1) + (float)ungrouped.get(mid2-1)) / 2;
        }else{
            mid1 = (size + 1)/2;
            median = (float)ungrouped.get(mid1-1);
        }
        System.out.println("Median: "+ median);
    
    }
    
    public void Mode(){
        ArrayList modes;
        int maxCount = 0, modeCount = 0;
        
        if(type == 1)
            modes = new ArrayList<Integer>();
        else
            modes = new ArrayList<Float>();
        
        for(int i = 0; i < ungrouped.size(); i++){
            if(!(modes.contains(this.ungrouped.get(i)))){
                modes.add(ungrouped.get(i));
            }
        }
        int[] countModes = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++){
            countModes[i] = 0;
        }
        
        for(int i = 0; i < modes.size(); i++){
            for(int j = 0; j < ungrouped.size(); j++){
                if(modes.get(i).equals(ungrouped.get(j))){
                    countModes[i]++;
                }
            }
            if(maxCount < countModes[i])
                maxCount = countModes[i];
        }
        
        for(int i = 0; i < countModes.length; i++){
            if(countModes[i] == maxCount)
                modeCount++;
        }
        
        System.out.print("Modes: ");
        if(modeCount == modes.size()){
            System.out.println("no mode");
        }else{
            if(modeCount == 1){
                System.out.println("unimodal");
            }
            else if(modeCount == 2){
                System.out.println("bimodal");
            }
            else{
                System.out.println("multimodal");
            }
            for(int i = 0; i < modes.size(); i++){
                if(countModes[i] == maxCount){
                    System.out.println(modes.get(i));
                }
            }
        }
        
    }
    
    public void EditDatum(int index, int num){
        ungrouped.set(index - 1 , num);
    }
    
    public void EditDatum(int index, float num){
        ungrouped.set(index - 1, num);
    }
    
    public boolean isInteger(float num){
        if(Math.floor(num) == num)
            return true;
        return false;
    }
    
    public boolean isFloating(float num){
        if(Math.floor(num) == num)
            return false;
        return true;
    }
    
}
