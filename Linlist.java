/*The following code has been implemented by using JCF(Java Collection FrameWork) and 

 GUI(Graphical User Interface) in Java
 
 Data Structure used :- Linked List
 
 Total 7 main components are being used from Java Swing 
 JTextField    - 1
 JRadioButton  - 2 (STACK),(QUEUE)
 JButtons      - 4 (PUSH),(POP),(ADD),(DELETE)
 
=> when the program starts , random digits are stored in the Linked List of max size 10 .

=> When Stack radio button is selected push/pop buttons gets enables and add/delete buttons get 
   disabled and push button inserts an random number from left and pop buttons remove the last
   entered number. Following LIFO.
   
=> When Queue radio button is selected add/delete buttons gets enables and  push/pop buttons get 
   disabled and add button inserts an random number from left end and delete buttons remove the last
   entered number. Following FIFO .
 
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Linlist implements ActionListener
{
    JFrame frame;
    JButton b1,b2,b3,b4;
    JTextField t1;
    JRadioButton r1,r2;
    LinkedList <Integer> l1 = new LinkedList<Integer>();
    Random rand = new Random();
    int a,count=9,count1=count+1;
    String t=String.valueOf(count1);
    String s=null;
    
    Linlist()
    {
    	//Frame
        frame = new JFrame("Stack/Queue");
        
        //TextField
        t1 = new JTextField();
        
        //Button
        b1 = new JButton("PUSH");
        b2 = new JButton("POP");
        b3 = new JButton("ADD");
        b4 = new JButton("DELETE");
        
        //RadioButtom
        r1 = new JRadioButton("STACK");
        r2= new JRadioButton("QUEUE");
        
        //Panel
        JPanel n = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3= new JPanel ();
        
        //Panel Layout
        p1.setLayout(new GridLayout(2,1));
        p2.setLayout(new GridLayout(2,2));
        
        //Adding Components to Panel and ButtonGroup
        ButtonGroup b = new ButtonGroup();
        b.add(r1);b.add(r2);
        p1.add(t1);
        n.add(r1);n.add(r2);
        p1.add(n);
        p2.add(b1);p2.add(b2);p2.add(b3);p2.add(b4);
        
        t1.setPreferredSize(new Dimension (400, 50));
        t1.setEditable(false);
        
        //Font
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        t1.setFont(font);
        t1.setHorizontalAlignment(JTextField.CENTER);

        
        //Buttons 
        b1.setEnabled(false);
		b2.setEnabled(false);
        b3.setEnabled(false); 
		b4.setEnabled(false);
		
        //Action Listener
        r1.addActionListener(this);
        r2.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        //Generating 10 random numbers and storing then in Linked List
        for(int i= 0;i<10;i++)
        {
        	a = rand.nextInt(50);
        	l1.add(a);
        }
        for(int i= 0;i<10;i++)
        {
        	a=l1.get(i);
        	String temp=String.valueOf(a);
        	if(s==null)
        	{
        		s=temp;
        	}
        	else
        	{
        		s=temp+"<"+s;
        	}
        	System.out.println(s);
        	t1.setText(s);
        }
        
        frame.add((p1));frame.add(p2);
        frame.setLayout(new GridLayout(2,1));
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    	

    }
    public void actionPerformed(ActionEvent e){  
    	
    	Object obj = e.getSource();
        Object obj1 =e.getActionCommand();
        
        
        
        try
        {
        
    	if(r1.isSelected()){    
    		b1.setEnabled(true);
    		b2.setEnabled(true);
    		b3.setEnabled(false); 
    		b4.setEnabled(false);
    	}    
    	
    	if(r2.isSelected()){   
    		   
    		b1.setEnabled(false);
    		b2.setEnabled(false);
    		b3.setEnabled(true); 
    		b4.setEnabled(true);
    		
    	}
    	//Insertion i.e (Push and Add)
    	if(e.getSource()==b1 || e.getSource()==b3)
    	{
    		if(l1.size()<10)
    		{
    		a = rand.nextInt(50);
        	l1.add(a);
        	String temp=String.valueOf(a);
        	if(s.isBlank())s=temp;
        	else s=temp+"<"+s;
        	count++;/////////////////////////////////////////////////////////////////////////////////////////////
        	t1.setText(s);
    		}
    		else
    		{
    			if(obj1.equals("PUSH"))JOptionPane.showMessageDialog(null,"<OverFlow> POP  element");
    			else JOptionPane.showMessageDialog(null,"<OverFlow> DELETE element");
    		}
        	
    	}
    	//Pop operation
    	if(e.getSource()==b2 )
    	{
    		if(l1.size()>0)
    		{
    			l1.remove(count);//FIRST TO LAST
    			count--;////////////////////////////////////////////////////////////////////////
    			int m=s.indexOf("<")+1;
    			if(count!=-1)s=s.substring(m);
    			else s="";
    			t1.setText(s);
    			
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null,"<UnderFlow> PUSH element");
    		}
    	}
    	//Delete Operation
    	if(e.getSource()==b4)
    	{
    		if(l1.size()>0)
    		{
    			int i=0;
    			l1.remove((l1.size()-1)-count);
    			int m= s.lastIndexOf("<");
    			if(count==0) s=" ";
    			else s=s.substring(0,m);
            	i++;
    			count--;////////////////////////////////////////////////////////////////////////
    				t1.setText(s);	
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null,"<UnderFlow> ADD element");
    		}
    	}
        }catch(Exception a) {
        	System.out.println("Exception Occurred");
        }
    	
    	}    
    
    public static void main(String[] args)
    {
        new Linlist();
    }
    
}
