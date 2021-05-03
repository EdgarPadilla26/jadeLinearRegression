package examples.handson;

import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
 
public class InputDialog extends JFrame{

  public InputDialog(){
    JButton btn = new JButton("Enviar variable");
    JTextField xVariable = new JTextField("");

    btn.setBounds(25,100,150,30);
    xVariable.setBounds(70, 25, 60, 30);

    btn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){

        int adv[] = {23,26,30,34,43,48,52,57,58};
        int sales[] = {651,762,856,1063,1190,1298,1421,1440,1518};

        LinearRegression obj = new LinearRegression(adv,sales);
        
        obj.regression();

        System.out.println("\n This is the Linear Regression Formula with dataSet \n");
        System.out.println("\nSales= " + obj.B0 + " + " + obj.B1 +"Advertising\n");
        
        try {
          System.out.println("\nIf Benneton invests "+ xVariable.getText() +" MD in advertisings this is the result\n");
          System.out.println("Sales= " +  obj.forecastX(Integer.parseInt(xVariable.getText())));//2041.5057 
        } catch (Exception x) {
          System.out.println("Al parecer eso no es un numero, intenta de nuevo");
        }
        
      }
    });

    this.add(btn);
    this.add(xVariable);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  } 
}
