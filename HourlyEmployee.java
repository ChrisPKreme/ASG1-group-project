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
public class HourlyEmployee extends Employee implements java.io.Serializable
{
    
    public HourlyEmployee()
    {        
        String hoursString = JOptionPane.showInputDialog(null, "Enter number of hours", "Hourly Employee", JOptionPane.QUESTION_MESSAGE);
        String rateString = JOptionPane.showInputDialog(null, "Enter hourly rate", "Hourly Employee", JOptionPane.QUESTION_MESSAGE);
        hours = Float.parseFloat(hoursString);
        rate = Float.parseFloat(rateString);

    }
    
    @Override
    public void computeGross()
    {
        if (hours > 40)
        {
            gross = (rate*40) + (rate * 1.5f * (hours - 40));
        }
        
        else
        {
            gross=rate*hours;

        }
    }
    
}
