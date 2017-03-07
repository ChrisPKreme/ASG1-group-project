/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infsys3806;


import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author crpc3b
 */
public class MyMethods 
{

    Scanner sc = new Scanner(System.in);
       // BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        //String input = br.readinput();

        //StringTokenizer st = new StringTokenizer( line );*/    
    
  public void ProductNoNegatives()
  {
      
      System.out.println("I am ProductNoNegatives "+" ");
      System.out.println(" Please enter a series of numbers,negatives will be ignored");
      String input =sc.nextLine();
      StringTokenizer st = new StringTokenizer(input);
      int product = 1;
      while(st.hasMoreTokens())
      {
          
          int x = Integer.parseInt(st.nextToken());
          if(x>0)
          {
              product = product * x;              
          }
          
      }
   System.out.println("your product is: " + product);
      
  }   
  public void FindTwelve()
  {
      
      
      System.out.println("I am FindTwelve ");
      System.out.println(" I will find the number of 12's in your input of numbers: ");
      String input = sc.nextLine();
      StringTokenizer st = new StringTokenizer(input);
      int counter = 1;
      boolean foundFirstTwelve = false;
      int firstTwelve = 0;
      int LastTwelve=0;
      int NumberofTwelves = 0;
      while(st.hasMoreTokens())
    {
         
      
      int x =Integer.parseInt(st.nextToken());
      if(x==12&&foundFirstTwelve == false)
      { 
         foundFirstTwelve = true;
         firstTwelve = counter;
         NumberofTwelves++;
      }
      else if(x==12&&foundFirstTwelve == true)
      {
          LastTwelve = counter;
          NumberofTwelves++;
      }
      counter ++;
    }
      System.out.println("The number of twelves is: " + NumberofTwelves);
      System.out.println("The first appearance of twelve is index: " + firstTwelve);
      System.out.println("The last appearance of twelve is index: " + LastTwelve);
  }    
  public void MaxMinAvg ()
  {
      System.out.println("I am MaxMinAvg ");
      System.out.println("Please enter a series of numbers and I will find the Max, Min, and Avg. ");
      String input = sc.nextLine();
      StringTokenizer st = new StringTokenizer(input);
      int x = Integer.parseInt(st.nextToken());
      int min=0,max =0,Avg,sum =0,temp=x,count =0;
      
      
      while(st.hasMoreTokens())
      {
       int y = Integer.parseInt(st.nextToken());
          sum +=y;
          
          if(temp<y)
          {
            min = x;
                 
          }
          if(y<temp)
          {
              min = y;
              temp=y;
              
              
          }
          
          if(y>max)
          {
              max=y;
              
          }
          count++;
          
      }
      
      Avg=(sum+temp)/count;
      System.out.println("The Max number is" + " " + max);
      System.out.println("The Min number is: " + " " + min);
      System.out.println("The Average is: " + " " + Avg);
      
  }
  public void Grades ()
  {
      System.out.println("I am Grades ");
      System.out.println("Enter a series of grades(numbers), enter -99 to exit");
      String input = sc.nextLine();
      StringTokenizer st = new StringTokenizer(input);
      int sumA = 0, sumB = 0, sumC = 0, sumD = 0, sumF = 0; 
     
      System.out.println(input);
      
    while(st.hasMoreTokens())
        {
            int num = Integer.parseInt(st.nextToken());
            if(num>=90)
            {
                sumA++;
                System.out.println(num + "      A");
            }
            else if(num >= 80)
            {
                sumB++;
                System.out.println(num + "      B");
            }
            else if(num >= 70)
            {
                sumC++;
                System.out.println(num + "      C");
            }
            else if(num >= 60)
            {
                sumD++;
                System.out.println(num + "      D");
            }
            else
            {
                sumF++;
                System.out.println(num + "      F");
            }
            
        }  
    
             System.out.println("number of A's is: " + sumA);
             System.out.println("number of B's is: " + sumB);
             System.out.println("number of C's is: " + sumC);
             System.out.println("number of D's is: " + sumD);
             System.out.println("number of F's is: " + sumF);
  }
             
  public void Exit ()
  {
      System.out.println("Goodbye ");
      
      
      
      
  }
}

