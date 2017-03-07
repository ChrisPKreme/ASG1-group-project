/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infsys3806;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author crpc3b
 */
public class ATM 
{
    private Account[] accntArray = new Account[3];
    int count =0;
   boolean loadacct=false;
    public static void main(String[] args) throws IOException  
    {
        String FirstTime;
        ATM atm1 = new ATM();
        System.out.println("Is this the first time using this ?:enter y for yes or N for no ");
        Scanner sc = new Scanner(System.in);
        FirstTime = sc.nextLine();
        switch(FirstTime)
        {
            case "Y": 
            case "y": atm1.populateAccounts();
                break;
            case "N":     
            case "n": atm1.loadAccounts();
                break;
        }
        
        Account acc1 = new Account();
        //acc1.Menu();
        
    }
    
    public void populateAccounts() throws IOException 
    {
     if(loadacct==false)
     {
         for(int i=0;i<accntArray.length;i++)
      {
         accntArray[i] = new Account();
         accntArray[i].name = count;
         
        count++;
         
      } 
         
         int input;
      do
      {
      System.out.println("Which account would you like to check?(0,1,2)enter 3 to exit");
      Scanner sc = new Scanner(System.in);
      input = sc.nextInt();
      if(input==0||input==1||input==2)
      {
       accntArray[input].Menu();
      }
      else if(input!=3 && (input!=0 && input!=1 && input!=2))
      {
          System.out.println("Invalid input,try again ");
          
      }
      else if(input==3)
      {
          saveAccnts();
      }
      
      }
      while(input!=3);
         
     }
     else
     {
      int input;
      do
      {
      System.out.println("Which account would you like to check?(0,1,2)enter 3 to exit");
      Scanner sc = new Scanner(System.in);
      input = sc.nextInt();
      if(input==0||input==1||input==2)
      {
       accntArray[input].Menu();
      }
      else if(input!=3 && (input!=0 && input!=1 && input!=2))
      {
          System.out.println("Invalid input,try again ");
          
      }
      else if(input==3)
      {
          saveAccnts();
      }
      
      }
      while(input!=3);
     }
    }
    
    public void loadAccounts() throws IOException
    {
        loadacct=true;
        try
        {
         FileInputStream fis = new FileInputStream("file.out");
         ObjectInputStream is=new ObjectInputStream(fis);
         accntArray =(Account[]) is.readObject();
         fis.close();
        
        }
    
    catch (Exception ioe)
    {
         System.out.println(ioe.getMessage());
    }
        populateAccounts();
      /* for(int i=0;i<accntArray.length;i++) 
       {
         accntArray[i] = new Account();  
       }*/
      
    }
    
    public void saveAccnts()
    {
        try
        {
            FileOutputStream outstream = new FileOutputStream("file.out");
            ObjectOutputStream os = new ObjectOutputStream(outstream);
            os.writeObject(accntArray);
            os.flush();
            os.close();
                        
        }
        catch (Exception ioe)
        {
         System.out.println(ioe.getMessage());
                        
        }
        System.out.println("accounts have been saved: ");
        
    }
    
          
}
               
                 
       
       
    
    


