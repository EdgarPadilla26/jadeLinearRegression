package examples.handson;

import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
 
public class TextFieldEcuacion extends JFrame{

  public boolean cerrar = false;
  public TextFieldEcuacion(){
    JButton btn = new JButton("Enviar variable");
    JTextField ecuacion = new JTextField("");

    

    btn.setBounds(25,100,150,30);
    ecuacion.setBounds(45, 25, 100, 30);

    btn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        DataSet data = new DataSet();

        QuadraticRegression solve = new QuadraticRegression(data.getAdv(),data.getYear());
        solve.regression();
        System.out.println("Ecuacion: " + solve.B1 + " x^2 + " + solve.B2 + " x + " + solve.B0);
        try {
          System.out.println("y = " + solve.forecastX(Integer.parseInt(ecuacion.getText())));
        } catch (Exception err) {
          System.out.println("Al parecer eso no es un numero! Intenta de nuevo");
        }
      }
    });

    this.add(btn);
    this.add(ecuacion);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  } 
}