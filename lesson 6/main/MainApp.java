package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JLabel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import action.listener.ExitActionListener;

public class MainApp {

	public static void main(String[] args) 
	{
		JFrame win = new JFrame("Swing");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(400,400);
		//win.setExtendedState(win.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		win.setLocationRelativeTo(null);
		
		//GridLayout
		JPanel panel1 = new JPanel(new GridLayout(1, 2));
		panel1.setBackground(new Color(255,255,0));
		win.add(panel1, BorderLayout.NORTH);
		
		JButton btn1 = new JButton("Button1");
		JLabel sum=new JLabel();
		
		
		//FlowLayout
		JPanel panel2 = new JPanel(new FlowLayout());//JPanel panel1 = new JPanel();
		panel2.setBackground(Color.RED);
		win.add(panel2, BorderLayout.WEST);
		panel2.add(btn1);
		
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));//JPanel panel1 = new JPanel();
		panel4.setBackground(Color.yellow);
		win.add(panel4/*, BorderLayout.EAST*/);
		//panel4.setPreferredSize(new Dimension(250, 50));
		panel4.add(sum);
		
		//No Layout
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(Color.BLUE);
		panel3.setPreferredSize(new Dimension(500, 40));
		win.add(panel3, BorderLayout.SOUTH);
		
		JButton btn5 = new JButton("Exit");
		btn5.setBounds(10, 10, 100, 20);
		panel3.add(btn5);
		btn5.addActionListener(new ExitActionListener());
		/*btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});*/
		JTextField jt1 = new JTextField(10);
		String[] Base = { "2", "10", "16"};
		JComboBox Base1 = new JComboBox(Base);
		panel1.add(jt1);
		panel1.add(Base1);
		btn1.addActionListener(new ActionListener()
		{
			int num;
			public void actionPerformed(ActionEvent e)
			{
				try {
				if(Base1.getSelectedIndex()==0)
				{
					num=Integer.parseInt(jt1.getText(),Integer.parseInt(Base1.getSelectedItem().toString()));
					sum.setText(Integer.toString(num));
				
				}
				if(Base1.getSelectedIndex()==1)
				{
					num=Integer.parseInt(jt1.getText(),Integer.parseInt(Base1.getSelectedItem().toString()));
					sum.setText(Integer.toString(num));
				
				}
				if(Base1.getSelectedIndex()==2)
				{
					num=Integer.parseInt(jt1.getText(),Integer.parseInt(Base1.getSelectedItem().toString()));
					sum.setText(Integer.toString(num));
				
				}
				}catch(Exception err) {sum.setText(err.toString());}
			}
		});
		win.pack();
		
		//win.show();
		win.setVisible(true);
		
		
		
		
	}
	
	

}
