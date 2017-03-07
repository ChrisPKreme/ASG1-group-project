/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umsl;

/**
 *
 * @author crpc3b
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.*;
import org.apache.derby.jdbc.*;


public class eval extends JFrame implements ActionListener, ItemListener
{
    
    public JLabel Q1,Q2,Q3,Q4;
    JLabel showAverage = new JLabel();
    public JComboBox teamComboBox;
    private JPanel teamPanel;
    public JSlider slider1,slider2,slider3,slider4;
    public JButton submitButton, CalcAverage;
    double average;
    String Comments;
    JTextPane CommentBox = new JTextPane();
    private JLabel questionLabel;
    
    private JPanel questionPanel;
    private ButtonGroup questionGroup1;
    private JButton clearButton;
    private JPanel buttonPanel;
    
    //instance variables to hold our data from the gui object to update the database
    String myteamname;
//    String courseName;
    
    // instance variables used to manipulate database
    private Connection myConnection;
    private Statement myStatement;
    private ResultSet myResultSet;
             
   //MAIN METHOD: NOTICE WE TAKE IN THE ARGUMENTS THAT ARE
   //PASSED IN AND INSTANTIATE OUR CLASS WITH THEM
    public static void main(String args[]) throws ClassNotFoundException
    {
     
        String databaseDriver = "org.apache.derby.jdbc.ClientDriver";
  
        String databaseURL = "jdbc:derby://localhost:1527/peer-eval;create=true";
                
         // create new Eval
         eval myeval = new eval(databaseDriver, databaseURL);
         myeval.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    
    }
    
    //CONSTRUCTOR: WE SET UP OUR DATABASE HERE THEN MAKE A CALL
    //TO A FUNCTION CALLED CREATEUSERINTERFACE TO BUILD OUR GUI
    public eval(String databaseDriver, String databaseURL) throws ClassNotFoundException
    {
        // establish connection to database
      try
      {
         // load Sun driver
         Class.forName( databaseDriver );
         //DriverManager.registerDriver(new "org.apache.derby.jdbc.ClientDriver");
         // connect to database
         myConnection = DriverManager.getConnection( databaseURL );

         // create Statement for executing SQL
         myStatement = myConnection.createStatement();
      }
      catch ( SQLException exception )
      {
         exception.printStackTrace();
      }
      //catch ( ClassNotFoundException exception )
     // {
      //   exception.printStackTrace();
      //}

      createUserInterface(); // set up GUI
 
    }
       
    private void createUserInterface()
    {
      // get content pane for attaching GUI components
       
        
      // INSTRUCTOR COMBO BOX SET UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
      // set up Instructor Panel
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Eval");
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        CalcAverage = new JButton("AVG.Score");
        CalcAverage.addActionListener(this);
        teamComboBox = new JComboBox();
        //slider
        slider1 = new JSlider(1, 8, 8);
        slider1.setMajorTickSpacing(1);
        slider1.setPaintTicks(true);
        Hashtable position = new Hashtable();
        slider1.setPaintLabels(true);
        position.put(1, new JLabel("C-"));
        position.put(2, new JLabel("C"));
        position.put(3, new JLabel("C+"));
        position.put(4, new JLabel("B-"));
        position.put(5, new JLabel("B"));
        position.put(6, new JLabel("B+"));
        position.put(7, new JLabel("A-"));
        position.put(8, new JLabel("A"));
        slider1.setLabelTable(position);
        slider2 = new JSlider(1, 8, 8);
        slider3 = new JSlider(1, 8, 8);
        slider4 = new JSlider(1, 8, 8);
        slider2.setMajorTickSpacing(1);
        slider3.setMajorTickSpacing(1);
        slider4.setMajorTickSpacing(1);
        slider2.setPaintLabels(true);
        slider3.setPaintLabels(true);
        slider4.setPaintLabels(true);
        slider2.setLabelTable(position);
        slider3.setLabelTable(position);
        slider4.setLabelTable(position);
             
        Q1 = new JLabel("Technical");
        Q2 = new JLabel("Useful");
        Q3 = new JLabel("Clarity");
        Q4 = new JLabel("Overall");
                        
        Box myBoxLayout = Box.createVerticalBox();
        
        myBoxLayout.add(teamComboBox);
        myBoxLayout.add(Q1);
        myBoxLayout.add(slider1);
        myBoxLayout.add(Q2);
        myBoxLayout.add(slider2);
        myBoxLayout.add(Q3);
        myBoxLayout.add(slider3);
        myBoxLayout.add(Q4);
        myBoxLayout.add(slider4);
       
        JPanel buttonPane = new JPanel();
         
        //buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
        myBoxLayout.add(buttonPane);
        buttonPane.add(submitButton);
        buttonPane.add(clearButton);
        buttonPane.add(CalcAverage);
        buttonPane.add(showAverage);
        myBoxLayout.add(CommentBox);
        
       
        frame.add(myBoxLayout, BorderLayout.NORTH);
       
        frame.setVisible(true);
     
      loadTeams();
      
    }

    //OVERRIDING THIS FUNCTION BECAUSE OUR CLASS IMPLEMENTS THE ACTION LISTENER
    @Override
    public void actionPerformed(ActionEvent event)
    {
        myteamname = (String) teamComboBox.getSelectedItem();
//        courseName = (String)courseComboBox.getSelectedItem();
        if(event.getSource().equals(submitButton))
        {
            updateTeams();
            
        }
         if(event.getSource().equals(clearButton))
                    {
                    slider1.setValue(8);
                    slider2.setValue(8);
                    slider3.setValue(8);
                    slider4.setValue(8);
                    
                    }
         if(event.getSource().equals(CalcAverage))
         {
             average = (double)(slider1.getValue()+slider2.getValue()+slider3.getValue()+slider4.getValue())/4;
             showAverage.setText(String.valueOf(average));
         }
    }
    
    @Override
    public void itemStateChanged(ItemEvent event)
    {
        
      /*  if ( event.getSource() == rb1 && event.getStateChange() == ItemEvent.SELECTED)
        {
            q1 = Integer.parseInt(rb1.getText());
        }
        else if (event.getSource() == rb2 && event.getStateChange() == ItemEvent.SELECTED)
        {
            q1 = Integer.parseInt(rb2.getText());
        }
        else if (event.getSource() == rb3 && event.getStateChange() == ItemEvent.SELECTED) 
        {
           q1 = Integer.parseInt(rb3.getText());
        }
        else if( event.getSource() == rb1 && event.getStateChange() == ItemEvent.DESELECTED)
        {
            JOptionPane.showMessageDialog(null, "Eggs are not supposed to be green.");
        }*/
    }
     private void updateTeams()
   {
      // update balance in database
      try
      {
          //q2=200;
          // Below is an example of creating a SQL statement that updated more than a single field in one statement.
         // String sql = "UPDATE APP.TEAMEVAL SET 1 = " + q1 + "," + "q2 = " + q2 + " WHERE " + "TEAMNAME = " + "'" + myteamname + "'";
          
         // myStatement.executeUpdate(sql);
          Comments = CommentBox.getText();
          //Below are individual statements for updating multiple fields that are easier to write but create more overhead
          //due to the multiple executions it will need to complete the entire update to the record/row
          String sql1 = "UPDATE APP.TEAMS" + " SET TECHNICAL = " + slider1.getValue() + " WHERE " + "TEAMNAME = '" + myteamname + "'";
          String sql2 = "UPDATE APP.TEAMS" + " SET USEFUL = " + slider2.getValue() + " WHERE " + "TEAMNAME = '" + myteamname + "'";
          String sql3 = "UPDATE APP.TEAMS" + " SET CLARITY = " + slider3.getValue() + " WHERE " + "TEAMNAME = '" + myteamname + "'";
          String sql4 = "UPDATE APP.TEAMS" + " SET OVERALL = " + slider4.getValue() + " WHERE " + "TEAMNAME = '" + myteamname + "'";
          String sql5 = "UPDATE APP.TEAMS" + " SET AVERAGE = " + average + " WHERE " + "TEAMNAME = '" + myteamname + "'";
          String sql6 = "UPDATE APP.TEAMS" + " SET COMMENTS = '" + Comments + "' WHERE "+ "TEAMNAME = '" + myteamname + "'"; 
          
          myStatement.executeUpdate(sql1);
          myStatement.executeUpdate(sql2);
          myStatement.executeUpdate(sql3);
          myStatement.executeUpdate(sql4);
          myStatement.executeUpdate(sql5);
          myStatement.executeUpdate(sql6);
      }
      catch ( SQLException exception )
      {
         exception.printStackTrace();
      }

   } // end method updateBalance
    private void loadTeams()
    {
        // get all account numbers from database
      try 
      {
         //myResultSet = myStatement.executeQuery( "SELECT DISTINCT lastname FROM InstEval" );
         myResultSet = myStatement.executeQuery( "SELECT TEAMNAME FROM APP.TEAMS" );
         // add account numbers to accountNumberJComboBox
         while ( myResultSet.next() )
         {
            //instructorComboBox.addItem( myResultSet.getString( "lastname" ) );
            teamComboBox.addItem( myResultSet.getString( "TEAMNAME" ) );
         }

         myResultSet.close(); // close myResultSet

      } // end try

      catch ( SQLException exception )
      {
         System.out.println(exception.getMessage());
      }
    }
    
}

