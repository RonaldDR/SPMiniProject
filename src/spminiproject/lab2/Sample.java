/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spminiproject.lab2;

import java.util.ArrayList;

//import spminiproject.lab2.chart.Histogram;
import spminiproject.lab2.chart.Histogram2;
import spminiproject.lab2.chart.PieChart;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Ronald j del Rosario
 */
public class Sample {
    String title;
    ArrayList ar;
    
    double[] midpoint;
    int[] count;
    double[] percent;
    String[] str;
    int type;
    int pop;
    
    public Sample(){
        title = "";
        ar = null;
        type = 0;
        pop = 0;
    }
    
    public Sample(int t, String desc){
        if(t == 1 || t == 2 || t == 3 ){
            ar = new ArrayList<String>();
        }
        else if(t == 4){
            ar = new ArrayList<Integer>();
        }
        else{
            ar = new ArrayList<Float>();
        }
        type = t;
        title = desc;
    }
    
    public void display(){
        System.out.println("");
        System.out.println(title);
        for(int i = 0; i < ar.size(); i++){
            if(i % 5 == 0){
                System.out.println("");
            }
            System.out.print("[" + (i+1) + "]: " + ar.get(i) + "\t");
        }
        System.out.println("");
    }
    
    public void displaysummarytable(){
        Scanner input = new Scanner(System.in);
        Collections.sort(ar);
        
        String v = "Values";
        String f = "Percentage";
        ArrayList<String> temp = new ArrayList<>();
        
        for(int i = 0; i < ar.size(); i++){
            if(!(temp.contains(this.ar.get(i)))){
                temp.add((String) ar.get(i));
            }
        }
        
        System.out.println("TITLE: "+title);
        System.out.println("======================");
        System.out.format("%1$10s %2$10s %n", v, f);
        System.out.println("======================");
        
        String[] t1 = new String[temp.size()];
        double[] t2 = new double[temp.size()];
        float ff;
        
        for(int i = 0; i < temp.size(); i++){
            int count = 0;
            
            for(int j = 0; j < ar.size(); j++ ){
                if(temp.get(i).equals(ar.get(j))){
                    count++;
                }
            }
            t1[i] = (String) temp.get(i);
            ff = (count * 100)/ar.size() ;
            t2[i] = ff;
            System.out.println("\t" + temp.get(i)+ "\t"+ ff);
        }
        
        System.out.println("======================");
        System.out.println("\tTotal: 100");
        System.out.println("======================");
        
        System.out.println("");
        for(int i = 0; i < t1.length; i++){
            System.out.print("\t "+ t1[i]);
        }
        System.out.println("");
        for(int i = 0; i < t1.length; i++){
            System.out.print("\t "+ t2[i]);
        }
        System.out.println("");
        this.str = t1;
        this.percent = t2;
    }
    
    public void displaygraph(){
        if(type <= 3){
            PieChart.generateChart(this.str, this.percent, title);
        }
        else{
//            Histogram2 histo = new Histogram2 ("Histogram", , 5 , "wow", "wew");
        }
    }
    
//    public void displayfpdtforfloat(int choice){
//        System.out.println("TITLE: "+ title);
//        int size = ar.size();
//        Collections.sort(ar);
//        
//        float min = (int) ar.get(0);
//        float max = (int) ar.get(ar.size() - 1);
//        
//        float range = max - min ;
//        double m = Math.ceil(1 + (3.322 * Math.log10(size)));
//        double width = (range/m);
//        
//        double[] t1 = new double[(int)m];
//        int[] t2 = new int[(int)m];
//        
//        System.out.println("CLASSES: "+ m);
//        System.out.println("RANGE: " + range);
//        System.out.println("WIDTH: "+ width);
//        
//        System.out.println("================================================================================");
//        System.out.println("\t CL \t TRUE CL \t MIDPOINTS \t FREQ \t % \t CF \t C% ");
//        System.out.println("================================================================================");
//        
//        float tmp = min,tmin = min;
//        int tmax, cf = 0; 
//        double c = 0.0, midpoint, percentage;
//        
//        for(int i = 0; i < m; i++){
//            int count = 0;
//            tmax = (int) (tmin + width - 1) ;
//            
//            for(int j = 0; j < ar.size(); j++){
//                if((int)ar.get(j) >= tmp && (int)ar.get(j) <= tmax ){
//                    count++;
//                }
//            }
//            
//            midpoint = (tmp + tmax) / 2.0;
//            percentage = (double)count  / (double)ar.size()  * 100;
//            
//            cf = cf + count;
//            c = c + percentage;
//            
//            t1[i] =   midpoint;
//            t2[i] = count;
//            
//            String classLimit;
//            String trueClassLimit;
//            
//            if (choice == 1 && i == 0 || (choice == 3 && i == 0)) {
//                classLimit = "<" + tmax;
//                trueClassLimit = "<" + ((double) tmax + 0.05);
//            }else if (choice == 2 && i == (ar.size() - 1) || (choice == 3 && i == (ar.size() - 1))) {
//                classLimit = ">" + tmp + "";
//                trueClassLimit = ">" + ((double) tmp - 0.05);
//            }else{
//                classLimit = "" + tmp + "-" + tmax;
//                trueClassLimit = "" + ((double) tmp - 0.05) + "-" + ((double) tmax + 0.05);
//            }
//            
//            System.out.format("%1$15s %2$17s %3$10.1f %4$5d %5$10.2f%% %6$5d %7$10.3f%% %n", classLimit, trueClassLimit, midpoint, count, percentage, cf, c);
//            tmp = (int) (tmp + width );
//            tmin = (int) (tmin + width );
//        }
//        
//        System.out.println("================================================================================");
//        System.out.println("\t    \t         \t           \t "+ ar.size()+"\t 100 \t  \t  ");
//        System.out.println("================================================================================");
//        
//        this.midpoint = t1;
//        this.count = t2;
////        System.out.println("Generate a histogram(1/0): ");
////        int c1 = input.nextInt();
////        if(c1 == 1){
////            Histogram.generateChart(title, t1, t2);
////        }
//    }
    
    public void displayfpdtforintt(int choice){
        System.out.println("TITLE: "+ title);
        int size = ar.size();
        Collections.sort(ar);
        
        int min = (int) ar.get(0);
        int max = (int) ar.get(size - 1);
        
        int range = max - min;
        double m = Math.ceil(1 + (3.322 * Math.log10(size)));
        double width = Math.ceil(range/m);
        
        double[] info = new double[3];
        double[][] table = new double[(int)m][7];
        info[0] = m; info[1] = range; info[2] = width;
        
        
//        int tmp = min,tmin = min;
//        int tmax, cf = 0; 
//        double c = 0.0, midpoint, percentage;
//        
//        for(int i = 0; i < m; i++){
//            int count = 0;
//            tmax = (int) (tmin + width) - 1;
//            
//            if(tmax == max-1 && i == m-1){
//                tmax = tmax + 1;
//            }
//            
//            for(int j = 0; j < ar.size(); j++){
//                if((int)ar.get(j) >= tmp && (int)ar.get(j) <= tmax ){
//                    count++;
//                }
//            }
//            
//            midpoint = (tmp + tmax) / 2.0;
//            percentage = (double)count  / (double)ar.size()  * 100;
//            
//            cf = cf + count;
//            c = c + percentage;
//            
//            t1[i] =   midpoint;
//            t2[i] = count;
    }
    
    public void displayfpdtforint(int choice){
        System.out.println("TITLE: "+ title);
        int size = ar.size();
        Collections.sort(ar);
        
        int min = (int) ar.get(0);
        int max = (int) ar.get(ar.size() - 1);
        
        int range = max - min;
        double m = Math.ceil(1 + (3.322 * Math.log10(size)));
        double width = Math.ceil(range/m);
        double[] t1 = new double[(int)m];
        int[] t2 = new int[(int)m];
        
        System.out.println("CLASSES: "+ m);
        System.out.println("RANGE: " + range);
        System.out.println("WIDTH: "+ width);
        
        System.out.println("================================================================================");
        System.out.println("\t CL \t TRUE CL \t MIDPOINTS \t FREQ \t % \t CF \t C% ");
        System.out.println("================================================================================");
        
        int tmp = min,tmin = min;
        int tmax, cf = 0; 
        double c = 0.0, midpoint, percentage;
        
        for(int i = 0; i < m; i++){
            int count = 0;
            tmax = (int) (tmin + width) - 1;
            
            if(tmax == max-1 && i == m-1){
                tmax = tmax + 1;
            }
            
            for(int j = 0; j < ar.size(); j++){
                if((int)ar.get(j) >= tmp && (int)ar.get(j) <= tmax ){
                    count++;
                }
            }
            
            midpoint = (tmp + tmax) / 2.0;
            percentage = (double)count  / (double)ar.size()  * 100;
            
            cf = cf + count;
            c = c + percentage;
            
            t1[i] =   midpoint;
            t2[i] = count;
            
            String classLimit;
            String trueClassLimit;
            
            if (choice == 1 && i == 0 || (choice == 3 && i == 0)) {
                classLimit = "<" + tmax;
                trueClassLimit = "<" + ((double) tmax + 0.5);
            }else if (choice == 2 && i == (m - 1) || (choice == 3 && i == (m - 1))) {
                classLimit = ">" + tmp + "";
                trueClassLimit = ">" + ((double) tmp - 0.5);
            }else{
                classLimit = "" + tmp + "-" + tmax;
                trueClassLimit = "" + ((double) tmp - 0.5) + "-" + ((double) tmax + 0.5);
            }
            
            System.out.format("%1$15s %2$17s %3$10.1f %4$5d %5$10.2f%% %6$5d %7$10.3f%% %n", classLimit, trueClassLimit, midpoint, count, percentage, cf, c);
            tmp = (int) (tmp + width );
            tmin = (int) (tmin + width );
        }
        
        System.out.println("================================================================================");
        System.out.println("\t    \t         \t           \t "+ ar.size()+"\t 100 \t  \t  ");
        System.out.println("================================================================================");
        
//        System.out.println("Generate a histogram(1/0): ");
//        int c1 = input.nextInt();
//        if(c1 == 1){
//            Histogram.generateChart(title, t1, t2);
//        }
        this.midpoint = t1;
        this.count = t2;
    }
    
    public boolean isNumericLabel(String str){
        int count = 0;
        for(int i = 0 ; i < str.length(); i++ ){
            if(str.charAt(i) == '.' && count == 0){
                count++;
            }
            else if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }
    
    public boolean isAlphabetic(String str){
        if(str.length()> 1){
            return false;
        }
        for(int i = 0 ; i < str.length(); i++ ){
           if(!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')){
                return false;
            }
        }
        return true;
    }
}
