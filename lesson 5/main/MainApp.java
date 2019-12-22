package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		panel1.add(btn1);
		
		JButton btn2 = new JButton("Button2");
		panel1.add(btn2);
		
		//FlowLayout
		JPanel panel2 = new JPanel(new FlowLayout());//JPanel panel1 = new JPanel();
		panel2.setBackground(Color.RED);
		win.add(panel2, BorderLayout.WEST);
		
		JButton btn3 = new JButton("Button3");
		panel2.add(btn3);
		
		JButton btn4 = new JButton("Button4");
		panel2.add(btn4);
		
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
		JLabel jl=new JLabel();
		JPanel jp=new JPanel();
		jp.setBackground(new Color(255,255,0));
		win.add(jp, BorderLayout.EAST);
		jp.setPreferredSize(new Dimension(200, 2));
		JButton jb = new JButton("click me");
		jp.add(jb);
		JTextField jt = new JTextField(15);
		jp.add(jt);
		jb.addActionListener(new ActionListener()
		{
			String input;
			public void actionPerformed(ActionEvent e)
			{
				
				try {
					input="http://www."+jt.getText()+".com";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(input));
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				//jl.setText(input);
			}
		});
		jp.add(jl);
		//win.pack();
		
		//win.show();
		win.setVisible(true);
	}

}
