/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infsys3806;

import java.util.Scanner;

/**
 *
 * @author crpc3b
 */
public class RunMyMethods 
{
public static void main(String[] args)
{
 RunMyMethods rmm = new RunMyMethods ();
 rmm.menu();
 
}    
public void menu()
{
 Scanner sc = new Scanner(System.in); 
 MyMethods mm = new MyMethods ();
 int input = 0;   
 while (input !=5)
 {
     System.out.println("1) Product no negatives");
     System.out.println("2) Find Twelves");
     System.out.println("3) Max, Min, Avg");
     System.out.println("4) Grades");
     System.out.println("5) Exit"); 
     input = sc.nextInt();
     
     switch(input)
     {
         case 1: 
        {  
             mm.ProductNoNegatives();
             break;
        }
          case 2:    
        {      mm.FindTwelve();
                break;
        }
          case 3:
          {
              mm.MaxMinAvg();
                break;
          }
    
          case 4:
          {
              mm.Grades();
                break;
          }
          
          case 5:
          {
              mm.Exit();
                break;
          }    
          
          //default:
          //{
              //System.out.println("Invalid entry, please try again");
                
                        
          //}    
}
}
} 
}
