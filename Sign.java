import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;

class Sign extends JFrame 
{
	Container c;
	JLabel lblUser,lblPass,lblRe;
	JTextField txtUser;
	JPasswordField txtPass,txtRe;
	JButton btnLogin,btnBack;
	boolean flag = false;
	Sign()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblUser = new JLabel("Username");
		lblPass = new JLabel("Password");
		lblRe = new JLabel("R-Password");
		txtUser = new JTextField(18);
		txtPass = new JPasswordField(18);
		txtRe = new JPasswordField(18);
		btnLogin = new JButton("Login");
		btnBack = new JButton("Back");
		
		c.add(lblUser);
		c.add(txtUser);
		c.add(lblPass);
		c.add(txtPass);
		c.add(lblRe);
		c.add(txtRe);
		c.add(btnBack);
		c.add(btnLogin);
		
		ActionListener a1 = (ae) -> {
			Main m = new Main();
			dispose();
		};
		btnBack.addActionListener(a1);
		ActionListener a2 = (ae) -> {
			String password = txtPass.getText();
			String name = txtUser.getText();
			if(txtUser.getText().length()!=0 && txtPass.getText().length()!=0 && txtRe.getText().length()!=0)
			{
				new Dbhand().signUp(name,password);
				
					Game m = new Game();
					dispose();
				
			}
			else{
				JOptionPane.showMessageDialog(new JDialog(),"enter username and password");
			}
			

		};
		btnLogin.addActionListener(a2);
		setTitle("Sign Up Page");
		setSize(300,350);
		c.setPreferredSize(new Dimension(300, 350));
		pack();
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void except(boolean flag)
	{
		this.flag = flag;
	}
}
