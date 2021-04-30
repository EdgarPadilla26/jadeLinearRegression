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

        float Eadvertising = 0, Eadvertising2 = 0, Esales = 0;
        float MadvSales = 0; 
        
        for(int i=0; i<this.advertising.length; i++){
            Eadvertising+=advertising[i];
            Esales+=sales[i];
            Eadvertising2+=Math.pow(advertising[i],2);
            MadvSales+=advertising[i]*sales[i];
        }

        this.B1 = this.calculaBeta1(this.advertising.length, MadvSales, Eadvertising, Esales, Eadvertising2);
        this.B0 = this.calculaBeta0(this.advertising.length, Esales, Eadvertising, this.B1);
    };

    float calculaBeta1(int n, float MadvSales, float sumAdv, float sumSales, float powAdv){
        return (n*MadvSales-sumAdv*sumSales)/(n*powAdv-sumAdv*sumAdv);
    };
    
    float calculaBeta0(int n, float sumSales, float sumAdv, float B1){
        return (sumSales-B1*sumAdv)/n;
    };

    float forecastX(int x){
        return (this.B0 + this.B1*x);
    }

}
