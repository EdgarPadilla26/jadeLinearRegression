package examples.handson;

import java.lang.Math;

public class DataSet{

    /*double X1[] = {41.9,43.4,43.9,44.5,47.3,47.5,47.9,50.2,52.8,53.2,56.7,57,63.5,65.3,71.1,77.0,77.8};
    double X2[] = {29.1,29.3,29.5,29.7,29.9,30.3,30.5,30.7,30.8,30.9,31.5,31.7,31.9,32.0,32.1,32.5,32.9};
    */
    double X1[] = {-3.0,-2.0,-1.0,0.0,1.0,2.0,3.0};
    double X2[] = {7.5,3.0,0.5,1.0,3.0,6.0,14.0};
    double Y[] = {251.3,251.3,248.3,267.5,273.0,276.5,270.3,274.9,285.0,290.0,297.0,302.5,304.5,309.3,321.7,330.7,349.0};
    
    public DataSet(){} 

    double[] getAdv(){
        return this.X1;
    }
    double[] getYear(){
        return this.X2;
    }
    double[] getSales(){
        return this.Y;
    }

}