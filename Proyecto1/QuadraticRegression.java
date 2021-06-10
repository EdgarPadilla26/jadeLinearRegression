package examples.handson;

import java.lang.Math;

public class QuadraticRegression{

    double x[], y[];
    double B0,B1,B2; 
    double Ds;
    

    public QuadraticRegression(double x[], double y[]){
        this.x = x;
        this.y = y;  
        this.B0=0;
        this.B1=0;
        this.B2=0;
        this.Ds=0;
    } 

    void regression(){ 
        
        double xE[] = new double[4];
        double Myx = 0 , Myx2 = 0, sumY=0; 

        for(int i=0; i<this.y.length; i++){
            sumY+=this.y[i];
            xE[0]+=this.x[i];
            Myx2+=Math.pow(this.x[i],2)*this.y[i];
            Myx+=this.x[i]*this.y[i];
            xE[1]+=Math.pow(this.x[i],2);
            xE[2]+=Math.pow(this.x[i],3);
            xE[3]+=Math.pow(this.x[i],4);
        }


        this.Ds=calculaDs(this.y.length, xE);
        this.B1 = this.calculaB1(this.y.length, xE, Myx, Myx2, sumY);
        this.B2 = this.calculaB2(this.y.length, xE, Myx, Myx2, sumY);;
        this.B0 = this.calculaBeta0(this.y.length, sumY, xE);
    };

    double calculaDs(int n, double x[]){
        double DDs = ((n*x[1]*x[3] + x[0]*x[2]*x[1] + x[0]*x[1]*x[2])-(x[1]*x[1]*x[1] + x[2]*x[2]*n + x[0]*x[0]*x[3]));
        return DDs; 
    };

    double calculaB1(int n, double x[], double Myx, double Myx2, double sumY){
        double b1 = (n*Myx2*x[1] + sumY*x[2]*x[0] + x[0]*Myx*x[1])-(x[1]*x[1]*sumY + x[2]*Myx*n + x[0]*x[0]*Myx2);
        return b1/this.Ds;
    };
    double calculaB2(int n, double x[], double Myx, double Myx2, double sumY){
        double b2 = (n*Myx*x[3] + Myx2*x[1]*x[0] + x[1]*sumY*x[2])-(x[1]*x[1]*Myx + x[2]*Myx2*n + x[0]*x[3]*sumY);
        return b2/this.Ds;
    };

    double calculaBeta0(int n, double sumY, double x[]){
        return (sumY-(this.B1*x[1]+this.B2*x[0]))/n;
    };

    double forecastX(double x){
        return (this.B0 + this.B1*Math.pow(x,2) + this.B2*x);
    }

}