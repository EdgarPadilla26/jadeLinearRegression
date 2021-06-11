package examples.handson;

import java.lang.Math;

public class MultipleLinearRegression{

    double advertising[];
    double sales[];
    double year[];
    double B0,B1,B2; 
    double Ds;

    public MultipleLinearRegression(double advertising[], double sales[], double year[]){
        this.advertising =  advertising; 
        this.sales = sales;
        this.year = year;
        this.B0=0;
        this.B1=0;
        this.B2=0;
        this.Ds=0;
    } 

    void regression(){ 

        double Eadvertising = 0, Eadvertising2 = 0, Esales = 0;
        double Eyear = 0, Eyear2=0;  
        double MadvSales = 0, MyearSales = 0, Madvyear = 0; 
            
        for(int i=0; i<this.advertising.length; i++){
            Eadvertising+=advertising[i];
            Eyear+=year[i];
            Esales+=sales[i];
            Eadvertising2+=Math.pow(advertising[i],2);
            Eyear2+=Math.pow(year[i],2);
            MadvSales+=advertising[i]*sales[i];
            Madvyear+=advertising[i]*year[i];
            MyearSales+=year[i]*sales[i];
        }


        this.Ds=calculaDs(this.advertising.length, Eadvertising2, Eyear2, Eadvertising, Madvyear, Eyear);
        this.B1 = this.calculaBeta1(this.advertising.length, MadvSales, Eadvertising, Esales, Eadvertising2, Eyear2, MyearSales, Eyear, Madvyear);
        this.B2 = this.calculaBeta2(this.advertising.length, Eadvertising2, MyearSales, Eadvertising, MadvSales, Eyear, Madvyear, Esales);
        this.B0 = this.calculaBeta0(this.advertising.length, Esales, Eadvertising, Eyear);
    };

    double calculaDs(int n, double powAdv, double powYear, double sumAdv, double Madvyear, double sumYear){
        double DDs = (n*powAdv*powYear+(2*(sumAdv*Madvyear*sumYear)))-(Math.pow(sumYear,2)*powAdv+n*Math.pow(Madvyear,2)+powYear*Math.pow(sumAdv,2)); 
        return DDs;
    };

    double calculaBeta1(int n, double MadvSales, double sumAdv, double sumSales, double powAdv, double powYear, double MyearSales, double sumYear, double Madvyear){
        double DB1 = (n*MadvSales*powYear+sumAdv*MyearSales*sumYear+sumSales*Madvyear*sumYear)-(MadvSales*Math.pow(sumYear,2)+Madvyear*MyearSales*n+sumSales*sumAdv*powYear);
        return DB1/this.Ds;
    };

    double calculaBeta2(int n, double powAdv, double MyearSales, double sumAdv, double MadvSales, double sumYear, double Madvyear, double sumSales){
        double DB2 = (n*powAdv*MyearSales+sumAdv*MadvSales*sumYear+sumAdv*Madvyear*sumSales)-(sumSales*powAdv*sumYear+MadvSales*Madvyear*n+Math.pow(sumAdv,2)*MyearSales);
        return DB2/this.Ds;
    };

    double calculaBeta0(int n, double sumSales, double sumAdv, double sumYear){
        return (sumSales-(this.B1*sumAdv+this.B2*sumYear))/n;
    };

    double forecastX(int x1, int x2){
        return (this.B0 + this.B1*x1 + this.B2*x2);
    }

}