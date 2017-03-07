/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infosys3816_project1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ajb8c4
 */
public class Employee
{
    /*********************
	     Attributes
	*********************/
	float rate=30.0f;
	float taxrate=0.2f;
	float hours=45;
	float gross=0.0f;
	float tax=0.0f;
	float net=0.0f;
	float net_percent=0.0f;
        float itemsSold, itemPrice;
        float salaryType;
        int empNum;

	//End Attributes
        
        /********************
	     Constructors
	********************/
        public Employee()
        {
            
        }
        	
	/********************
	     Methods
	********************/
        public void menu() throws FileNotFoundException, UnsupportedEncodingException
        {
            //Employee emp = new Employee();
            int menuInt;
            do{
            
            Object[] options = { "Calculate Gross Pay", "Calculate Tax", "Calculate Net Pay", "Calculate Net Percent", "Display Employee", "Exit"};
            menuInt = JOptionPane.showOptionDialog(null, "Select a function" , "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            switch (menuInt) {
                case 0:
                    computeGross();
                    break;
                case 1:
                    computeTax();
                    break;
                case 2:
                    computeNet();
                    break;
                case 3:
                    computeNetperc();
                    break;                   
                case 4:
                    displayEmployee();
                    break;
                case 5:
                    return;
            }
            }while(menuInt != 6);
            
        }
         
	public void computeGross()
        { 
		gross=rate*hours;
	}

	protected void computeTax() 
        { 
		tax=gross*taxrate;
	}

	protected void computeNet()
 { 
		net=gross-tax;
	}

	protected void computeNetperc() 
{ 
		net_percent=(net/gross)*100;
	}
	
	protected void displayEmployee() throws FileNotFoundException, UnsupportedEncodingException 
        {
            JOptionPane.showMessageDialog(null, "Hours: " + new Float(hours) + "\nRate: " + new Float(rate) + "\nGross: " + new Float(gross)
                    + "\nNet: " + new Float(net) + "\nNet%: " + new Float(net_percent) + "", "Display Employee", JOptionPane.INFORMATION_MESSAGE);
           
            PrintWriter writer = new PrintWriter("PayrollText.txt" + empNum, "UTF-8");
            writer.println("Hours: " + hours);
            writer.println("Rate: " + rate);
            writer.println("Gross: " + gross);
            writer.println("Net: " + net);
            writer.println("Net%: " + net_percent + "%");
            writer.close();

	}

    /**
     * @return the empNum
     */
    public int getEmpNum() {
        return empNum;
    }

    /**
     * @param empNum the empNum to set
     */
    public int setEmpNum(int empNum) {
        this.empNum = empNum;
        return empNum;
    }

} 	
