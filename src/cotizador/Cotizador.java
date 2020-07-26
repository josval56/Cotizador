/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador;
import javax.swing.*;

/**
 *
 * @author Valmore
 */
public class Cotizador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
           
        //Declaracion de Variables
        String [] HighRange;
        String brand;
        int year;
        boolean aditionalShare;
        double share;
        
        //inicializamos la variable para asegurar que no tiene Valor.
        share = 0;
        
        
        //Ingresamos Marca del vehiculo    
        brand = JOptionPane.showInputDialog(null,"Coloque Marca de auto","MARCA",JOptionPane.INFORMATION_MESSAGE);
      
        // Ingresamos el año
        year = Integer.parseInt(JOptionPane.showInputDialog(null,"Coloque el año del auto","AÑO",JOptionPane.INFORMATION_MESSAGE));
        
        //aplicamos la funcion para convertir la variable en mayuscula.
        //Condicion para aplicar la cuota de auto alta gama
        aditionalShare = searchShare(enlarge(brand));
        
        if ( aditionalShare != false){
            
            share = share + 890;
        }
       
        
        // Usamos la funcion de cotizar el auto sobre el año.
        share = share + quote(year);
        
        //Mostramos los resultados con JOption pane
        JOptionPane.showMessageDialog(null, "El  "+ brand+ "   Año:   " +year + "   Cotiza en:  " +share, "COTIZACION",JOptionPane.INFORMATION_MESSAGE);
        
        // TODO code application logic here
    }
    //funcion que se encarga de poner en mayuscula cualquier palabra que recibe
 public static String enlarge (String upper){
     
     upper = upper.toUpperCase();
     return upper;
 }
 //funcion que se encarga de buscar si los autos son de alta gama
 public static boolean  searchShare (String cars){
      
     boolean finalShare;
     finalShare = false;
     String [] HighRange = {"AUDI","BMW","VOLVO"};
     for (int i=0; i < 3; i++){
        if (cars.equals(HighRange [i]))
          {
              finalShare = true; 
          }
        }
     return finalShare;
     
 }
 // funcion para cotizar
 public static double quote (int parameter){
    double quotein;
    quotein = 0;
    if (parameter <= 2020 && parameter >= 2017){
        quotein = 1200;
    }
    if(parameter < 2017 && parameter >= 2011){
        quotein = 950;
    }
    if (parameter < 2011 && parameter >= 2000){
        quotein = 780;
    }
    if(parameter < 2000 && parameter >= 1990){
        quotein = 480;
    }
    if(parameter < 1990){
        quotein = 350;
    }
    return quotein;
 }
}
