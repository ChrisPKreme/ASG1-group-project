/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infsys3806;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

//public class Account implements Serializable
/**
 *
 * @author crpc3b
 */
public class Account implements java.io.Serializable
{
    protected boolean dateflag = false;
    public LocalDate date1,date2;
    double balance;
    double rate,ratetime,interest;
    int datediff;
    int name;
    public void deposit()
    {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter deposit amount");
     double input = sc.nextDouble();
     balance = balance +input;   
     System.out.println("Your balance is now: "+ balance);
    }
    public void withdraw() throws IOException
    {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter withdrawal amount");
     double input = sc.nextDouble();
     balance = balance - input;
     if(balance < 0)
     {
      System.out.println(" Over withdrawal, try again: ");
        
         balance = balance + input;  
         Menu();
     }    
     else
     {
         balance = balance;
     }
     System.out.println("Your balance is now: "+ balance);
     
    }
    public void getDate1() throws IOException
    {
        //prompt for date
        if(dateflag== false)
        {
            date1 = LocalDate.now();
            dateflag = true;
        }
        
        //take the input as string
        //use formatter to create parseposition object(SimpleDateFormat)
        //SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        //ParsePosition pos = new ParsePosition(0);
        //Date date = formatter.parse(inputText, pos);
        //return date
        //
                       
    }
    
    public void getDate2()
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter todays' date:(yyyy-MM-dd) ");
       String date2input = sc.next();
       date2 = LocalDate.parse(date2input);
       long temp =ChronoUnit.DAYS.between(date1, date2);
       datediff = (int)temp;
       if(datediff<0)
       {
           System.out.println("No backdating, enter a valid date");
           getDate2();
       } 
    }
    
    
    public void getInterest()
    {
        rate = .10/365;
        ratetime = Math.pow(1+rate, datediff);
        balance*=ratetime;
        date1=date2;
        
    }
    public void CheckBalance()
    {
        NumberFormat currencyformatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Your balance is: "+ currencyformatter.format(balance));
        
    }
    public void Menu() throws IOException
    {
       
        Scanner sc = new Scanner(System.in);
        int input=0;
        while(input!= 4)
        {
            
            System.out.println("1) Deposit");
            System.out.println("2) Withdrawal");
            System.out.println("3) Check Balance");
            System.out.println("4) Exit");        
                   
            input =sc.nextInt();
            if(input ==1)
            {
                getDate1();
                getDate2();
                getInterest();
                deposit();
            }
            else if(input ==2)
            {
                getDate1();
                getDate2();
                getInterest();
                withdraw();
            }   
            else if(input ==3)
            {
                getDate1();
                getDate2();
                getInterest();
                CheckBalance();
                
            }
            else if(input!= 1 && input!= 2 && input!= 3 && input!=4)
            {
                System.out.println("invalid entry, please try again");
                
            }    
            
            
        }
    }
    
    
}
