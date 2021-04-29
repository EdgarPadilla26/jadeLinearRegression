package examples.handson;

import java.lang.Math;

public class LinearRegression{

    int advertising[];
    int sales[];
    float B0,B1; 

    public LinearRegression(int advertising[], int sales[]){
        this.advertising =  advertising; 
        this.sales = sales;
        this.B0=0;
        this.B1=0;
    } 

    void regression(){ 

        float Eadvertising = 0, Eadvertising2 = 0, Esales = 0, Esales2 = 0;
        float MadvSales = 0; 
        
        for(int i=0; i<this.advertising.length; i++){
            Eadvertising+=advertising[i];
            Esales+=sales[i];
            Eadvertising2+=Math.pow(advertising[i],2);
            Esales2+=Math.pow(sales[i],2);
            MadvSales+=advertising[i]*sales[i];
        }

        this.B1 = this.calculaBeta1(this.advertising.length, MadvSales, Eadvertising, Esales, Eadvertising2);
        this.B0 = this.calculaBeta0(this.advertising.length, Esales, Eadvertising, this.B1);
    };

    float calculaBeta1(int n, float MadvSales, float sumAdv, float sumSales, float powAdv){
        float B1 = 0;
        B1 = (n*MadvSales-sumAdv*sumSales)/(n*powAdv-sumAdv*sumAdv);
        return B1;
    };
    
    float calculaBeta0(int n, float sumSales, float sumAdv, float B1){
        float B0 = 0;
        B0 = (sumSales-B1*sumAdv)/n;
        return B0;
    };

}

