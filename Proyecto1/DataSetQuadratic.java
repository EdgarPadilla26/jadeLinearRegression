package examples.handson;

import java.lang.Math;

public class DataSetQuadratic{

    double X1[] = {-3.0,-2.0,-1.0,0.0,1.0,2.0,3.0};
    double X2[] = {7.5,3.0,0.5,1.0,3.0,6.0,14.0};
    
    public DataSetQuadratic(){} 

    double[] getX(){
        return this.X1;
    }
    double[] getY(){
        return this.X2;
    }
    
}