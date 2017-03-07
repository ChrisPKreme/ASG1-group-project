/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infosys3816_project1;

import javax.swing.JOptionPane;

/**
 *
 * @author ajb8c4
 */
public class SalaryEmployee extends Employee implements java.io.Serializable
{
    
    public SalaryEmployee()
    {
        
        setEmpNum(getEmpNum()+1);
        Object[] options = { "Staff", "Executive"};
        salaryType = JOptionPane.showOptionDialog(null, "Select a title" , "Salary Employee", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    }
    
    @Override
    public void computeGross()
    { 
        if (salaryType == 0)
        {
             gross = 50000;
        }
        
        else if(salaryType == 1)
        {
             gross = 100000;
        }

    }
       
}
