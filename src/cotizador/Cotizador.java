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
        //String[] User  = {"JOSVAL","GOKUBLACK","RAMOSMAGIA"};
        //String[] Pass = {"12q34e","123F546Y"};
        String brand;
        int year;
        boolean aditionalShare,loginResult;
        double share;
        loginResult = true;
         int count;
        count = 0;
        
        do{
        count++;
        

        //LLamamos a la funcion
        loginResult = login(loginResult);
                       
        // Validamos la funcion
        if  (loginResult == false){
            JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta");
            
        }else
            
           
        {
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
        
        }while(count < 3);
        JOptionPane.showMessageDialog(null,"Usuario Bloqueado","ERROR",JOptionPane.ERROR_MESSAGE);
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
 public static boolean login (boolean ret){
    boolean retuser,retpass;
    ret = false;
    retuser = false;
    retpass = false;
    String[] User  = {"JOSVAL","GOKUBLACK","RAMOSMAGIA"};
    String[] Pass = {"12q34e","123F546Y"};
    String userval,passval;
   
    
     JTextField loginuser = new JTextField(10); 
     JTextField password = new JTextField(10);
     
     Object[] myPanel = { 
     
     "Usuario:", loginuser, 
     "Contraseña:", password
        };

    // JPanel myPanel = new JPanel(); 
    // myPanel.add(new JLabel("Usuario")); 
    // myPanel.add(loginuser); 
    // myPanel.add(new JLabel("Contraseña")); 
     //myPanel.add(password); 

     JOptionPane.showMessageDialog(null, myPanel,"Identificarse", JOptionPane.QUESTION_MESSAGE); 
     
     //Validamos el usuario y contraseña.
     for (int i= 0; i <3;i++){
         
         userval=enlarge(loginuser.getText());
         System.out.println(userval);
        if (userval.equals(User [i])){
            retuser = true;             
         }
     }    
     for (int j= 0; j <2;j++){
         
         passval=password.getText();
         System.out.println(passval);
        if (passval.equals(Pass [j])){
            retpass = true;             
         }
     }
     if (retuser == true && retpass == true){
             ret = true;

     }
     
    return ret;     
    } 
}