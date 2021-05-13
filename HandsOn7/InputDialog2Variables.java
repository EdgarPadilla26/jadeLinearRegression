package examples.handson;

import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
 
public class InputDialog2Variables extends JFrame{

  public InputDialog2Variables(){
    JButton btn = new JButton("Enviar variable");
    JTextField x1Variable = new JTextField("");
    JTextField x2Variable = new JTextField("");

    btn.setBounds(25,100,150,30);
    x1Variable.setBounds(45, 25, 30, 30);
    x2Variable.setBounds(85, 25, 60, 30);

    btn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){

        //DataSet
        DataSet data = new DataSet();
        
        MultipleLinearRegression obj = new MultipleLinearRegression(data.getAdv(),data.getSales(),data.getYear());
        obj.regression();
        
        try{
            System.out.println("\nIf we calculate with "+ x1Variable.getText() +" X1 & " + x2Variable.getText() + " for X2 this is the result\n");
            System.out.println("Y = " + obj.forecastX(Integer.parseInt(x1Variable.getText()), Integer.parseInt(x2Variable.getText())));
        } catch (Exception x) {
          System.out.println("Al parecer eso no es un numero, intenta de nuevo");
        }
        
      }
    });

    this.add(btn);
    this.add(x1Variable);
    this.add(x2Variable);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  } 
}