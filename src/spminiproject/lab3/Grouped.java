/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spminiproject.lab3;

/**
 *
 * @author Ronald j del Rosario
 */
public class Grouped {
    public float[][] data;
    float totalfreq,totalfxM, totalfxM2;
    String desc;
    
    
    public Grouped(int len){
        data = new float[len][6];
        desc = "";
        totalfreq = 0 ;
        totalfxM = 0;
        totalfxM2 = 0;
    }
    
    public void display(String interp){
        display();
        System.out.println("INTERPRETATION: "+ interp);
    }
    
    public void display(){
        
        float freqtotal = 0;
        float fXmtotal = 0;
        float fXm2total = 0;
        System.out.println("GROUPED: "+ desc);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|   LC   |   UC   |   F   |   M   |   FxM   |   FxM2   |");
        for (int i = 0; i < data.length; i++) {
            System.out.print("|   " );
//                    "   |   " + data[i][1] + 
//                  "   |   " + data[i][2] + 
//                  "   |   " + data[i][3] + 
//                  "   |   " + data[i][4] + 
//                  "   |   " + data[i][5] + "   |");
          if(data[i][0] == -1)
              System.out.print("---");
          else
              System.out.print(data[i][0]);
          
          System.out.print("   |   ");
          
          if(data[i][1] == -1)
              System.out.print("---");
          else
              System.out.print(data[i][1]);
          
          System.out.print("   |   "+ data[i][2]+ "   |   ");
          
          if(data[i][3] == -1)
              System.out.print("---");
          else
              System.out.print(data[i][3]);
          
          System.out.print("   |   ");
          
          if(data[i][4] == -1)
              System.out.print("---");
          else
              System.out.print(data[i][4]);
          
          System.out.print("   |   ");
          
          if(data[i][5] == -1)
              System.out.print("---");
          else
              System.out.print(data[i][5]);
          
          System.out.println("");
          
          freqtotal = freqtotal + data[i][2];        
          fXmtotal = fXmtotal + data[i][4]; 
          fXm2total  = fXm2total + data[i][5];
        }
        if(data[0][0] == -1 || data[data.length -1][1] == -1){
            fXmtotal = 0;
            fXm2total = 0;
        }
        totalfreq = freqtotal;
        totalfxM = fXmtotal;
        totalfxM2 = fXm2total;
        System.out.println("|--------|--------|--------|--------|--------|--------|");
        System.out.println("|        |        |n = "+ freqtotal+"|--------|t = "+fXmtotal+"|"+fXm2total+"|");
        
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
    
    
    
    public void Mean(int OorC){
        float mean, var, std;
        if(OorC == 2){
            mean = this.totalfxM / this.totalfreq;
            var = ((this.totalfreq * this.totalfxM2) - (this.totalfxM * this.totalfxM)) / (this.totalfreq * (this.totalfreq - 1));
            std = (float) Math.sqrt(var);
            System.out.println("Mean: "+ mean);
            System.out.println("Variance: "+ var);
            System.out.println("Standard Deviation: "+ std);
        }
        else{
            System.out.println("Mean cannot be computed. \n The variance and the standard deviation cannot be computed also.");
        }
    }
    
    public void Median(){
        System.out.println("Median cannot be computed.");
    }
    
    public void getMode() {
    
        double tmp = max();
        int modal = 0;
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][2] == tmp) {
                modal++;
            }
        }
        
        System.out.println("Modes:");
        if(modal == data.length){
            System.out.println("no modes");
        }
        else{
            if(modal == 1){
                System.out.println("unimodal");
            }
            else if(modal == 2){
                System.out.println("bimodal");
            }
            else{
                System.out.println("multimodal");
            }
            
            for (int i = 0; i < data.length; i++) {
                if (data[i][2] ==  tmp) {
                    if(data[i][0] == -1)
                        System.out.println("<" + data[i][1]);
                    else if(data[i][1] == -1)
                        System.out.println(data[i][0] + "<");                       
                    else
                        System.out.println(data[i][0] + "-" + data[i][1]);
                }
            }
        }
        
    }
    
    public double max() {
        double max = 0;
        for (int i = 0; i < data.length; i++) {
            if (max < data[i][2]) {
                max = data[i][2];
            }
        }
        return max;
    }
}
