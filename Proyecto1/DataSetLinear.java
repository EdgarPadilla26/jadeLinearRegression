package examples.handson;

import java.lang.Math;

public class DataSetLinear{

    double X1[] = {23,26,30,34,43,48,52,57,58};
    double X2[] = {651,762,856,1063,1190,1298,1421,1440,1518};
    
    public DataSetLinear(){} 

    double[] getAdv(){
        return this.X1;
    }
    double[] getYear(){
        return this.X2;
    }

}