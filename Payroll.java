/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infosys3816_project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ajb8c4
 */
public class Payroll 
{
    int EmpNum, addEmp, makeEmp, pickEmp;
    public static ArrayList<Employee> employeeList = new ArrayList<>();
    
    public static void main(String[] Args) throws FileNotFoundException, UnsupportedEncodingException
    {
        int loadOldEmps = 1;
        Payroll pr = new Payroll();
        boolean fileExists = new File("payroll.out").isFile();

        if (fileExists == true)
        {
            loadOldEmps = JOptionPane.showConfirmDialog(null, "Load Previous Accounts?", "Load Previous Accounts?", JOptionPane.YES_NO_OPTION);
            if(loadOldEmps == 0)
            {
                pr.loadEmp();
                pr.pickEmployee();           
            }     
        }
        
        if(loadOldEmps == 1)
        {
            pr.populateEmployees();
            pr.pickEmployee();
        }

        
        pr.saveEmp();
        
    }
    
    public void populateEmployees()
    {
         

         JOptionPane.showMessageDialog(null, "Create First Employees", "Create Employees", JOptionPane.INFORMATION_MESSAGE);
         employeeList.add(new HourlyEmployee());
        
         employeeList.add(new SalaryEmployee());
         
         employeeList.add(new CommissionEmployee());
         
         /*
         addEmp = JOptionPane.showConfirmDialog(null, "Do you want to create another Employee?", "Create Employees", JOptionPane.YES_NO_OPTION);
         
         while(addEmp == 0)
         {
             Object[] options = { "Hourly Employee", "Salary Employee", "Commission Employee"};
             makeEmp = JOptionPane.showOptionDialog(null, "Select the type of employee to create." , 
            "Create Employees", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

             if(makeEmp == 0)
             {
             employeeList.add(new HourlyEmployee());
             }
             if(makeEmp == 1)
             {
             employeeList.add(new SalaryEmployee());
             }
             if(makeEmp == 2)
             {
             employeeList.add(new CommissionEmployee());
             }
             
             addEmp = JOptionPane.showConfirmDialog(null, "Do you want to create another Employee?", "Create Employees", JOptionPane.YES_NO_OPTION);
         }
                 
             */
    }
    
    public void pickEmployee() throws FileNotFoundException, UnsupportedEncodingException
    {
        do{
        String pickEmpString = JOptionPane.showInputDialog(null, "Select an employee number(0 and up) you wish to use or -99 to save and exit", "Pick Employee", JOptionPane.QUESTION_MESSAGE);
        
        pickEmp = Integer.parseInt(pickEmpString);
        
        if(pickEmp != -99 )
        {
            employeeList.get(pickEmp).menu();
        }
        
        }while(pickEmp != -99);
    }
    
    
        public void saveEmp()
    {
        try
        {
            FileOutputStream FOS = new FileOutputStream("payroll.out");
            ObjectOutputStream oos = new ObjectOutputStream(FOS);
          
            oos.writeObject(employeeList);
            oos.flush();
            oos.close();
            
            PrintWriter writer = new PrintWriter("PayrollText1.txt" , "UTF-8");
            writer.println("Hours: " + employeeList.get(0).hours);
            writer.println("Rate: " + employeeList.get(0).rate);
            writer.println("Gross: " + employeeList.get(0).gross);
            writer.println("Net: " + employeeList.get(0).net);
            writer.println("Net%: " + employeeList.get(0).net_percent + "%");
            
            PrintWriter writer2 = new PrintWriter("PayrollText2.txt" , "UTF-8");
            writer2.println("Hours: " + employeeList.get(1).hours);
            writer2.println("Rate: " + employeeList.get(1).rate);
            writer2.println("Gross: " + employeeList.get(1).gross);
            writer2.println("Net: " + employeeList.get(1).net);
            writer2.println("Net%: " + employeeList.get(1).net_percent + "%");
            
            PrintWriter writer3 = new PrintWriter("PayrollText3.txt" , "UTF-8");
            writer3.println("Hours: " + employeeList.get(2).hours);
            writer3.println("Rate: " + employeeList.get(2).rate);
            writer3.println("Gross: " + employeeList.get(2).gross);
            writer3.println("Net: " + employeeList.get(2).net);
            writer3.println("Net%: " + employeeList.get(2).net_percent + "%");
            
            writer.close();
            

        
        }catch (Throwable e){System.out.println(e);}
    }

    public void loadEmp()
    {
        try
        {
                FileInputStream FIS = new FileInputStream("payroll.out");
                ObjectInputStream ois = new ObjectInputStream(FIS);
                employeeList = (ArrayList<Employee>)ois.readObject();
                ois.close();
        }catch (Throwable e){System.out.println(e);}
    }

}
