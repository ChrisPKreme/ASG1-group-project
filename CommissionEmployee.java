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
public class CommissionEmployee extends Employee implements java.io.Serializable
{

    public CommissionEmployee()
    {   
        String itemsSoldString = JOptionPane.showInputDialog(null, "Input number of items sold", "Commisssion Employee", JOptionPane.QUESTION_MESSAGE);
        String itemPriceString = JOptionPane.showInputDialog(null, "Input price of sold item", "Commisssion Employee", JOptionPane.QUESTION_MESSAGE);
        itemsSold = Float.parseFloat(itemsSoldString);
        itemPrice = Float.parseFloat(itemPriceString);
    }
    
    @Override
    public void computeGross()
    { 
        gross = (itemsSold * itemPrice) / 2;
     
    }
    
}
