/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umsl;

import java.util.Scanner;



/**
 *
 * @author crpc3b
 */
public class HoursandWages 
{
    
    public static void main(String[] args) 
          
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hours and Wages assignment");
        double hours;
        double rate;
        double overtime;
        double wage;
        
        System.out.println("please enter hours worked: ");
        hours = scan.nextDouble();
        System.out.println("hours worked is " + hours);
        
        System.out.println("Please enter pay rate: ");
                rate = scan.nextDouble();
                System.out.println("rate is: "+ rate);
         if(hours>40)
         {overtime = (hours-40)*(rate*1.5);
        System.out.println("Overtime is: "+overtime);
        wage = rate*40 + overtime;
        System.out.println("wages earned is: "+"$"+ wage);
         }
        else
         {overtime = 0;
        wage = rate*hours;
                System.out.println("wages earned is: "+wage);
         }
    }
                
    
    
    
    
    
    
}
