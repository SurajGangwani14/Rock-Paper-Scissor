import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random.*;

class Game extends JFrame 
{
	Container c;
	JRadioButton ncRock,ncPaper,ncScissor,nuRock,nuPaper,nuScissor;
	JLabel lblncRock,lblncPaper,lblncScissor,lblnuRock,lblnuPaper,lblnuScissor,lblComp,lblUser,jtncmp,jlblres,label1,lblOption;
	ImageIcon imageIcon;
	ButtonGroup bg1,bg2;
	JButton play,playanother,signout,viewscore;
	String comp="";
	ImageIcon imageicon;
	int nt=0,nc=0,nu=0;
	static boolean flag;
	boolean flagss=false;
	boolean flagsss=false;
	Timer timer;
	int count=0;
	Game()
	{
		c=getContentPane();
		c.setLayout(null);
		//c.setLayout(new FlowLayout());
		/*lblncRock = new JLabel("Rock");
		lblncPaper = new JLabel("Paper");
		lblncScissor = new JLabel("Scissor");
		lblnuRock = new JLabel("Rock");
		lblnuPaper = new JLabel("Paper");
		lblnuScissor = new JLabel("Scissor");*/
		//imageIcon = new ImageIcon("start.png");
		imageIcon = new ImageIcon("game1.jpg"); 
		label1 = new JLabel(imageIcon);
        lblOption = new JLabel("Please Select an Option");
		lblComp = new JLabel("Computer");
		ncRock = new JRadioButton("Rock");
		ncPaper = new JRadioButton("Paper");
		ncScissor = new JRadioButton("Scissor");
		lblUser = new JLabel("User");
		nuRock = new JRadioButton("Rock");
		nuPaper = new JRadioButton("Paper");
		nuScissor = new JRadioButton("Scissor");
		play = new JButton("play");
		playanother = new JButton("Play another game");
		signout = new JButton("Sign Out");
		viewscore = new JButton("previous score");
		jlblres = new JLabel("");
		bg1 = new ButtonGroup();
		bg2 = new ButtonGroup();
		c.setBackground(Color.WHITE);
		lblOption.setBounds(50,10,250,20);
		//label1.setBounds(50,10,250,200);
		c.add(lblOption);
		c.add(label1);
		jtncmp = new JLabel("");
		
		//c.add(ncRock);
		//c.add(lblncPaper);
		//c.add(ncPaper);
		//c.add(lblncScissor);
		//c.add(ncScissor);
		c.add(lblUser);
		//c.add(lblnuRock);
		c.add(nuRock);
		nuRock.setBounds(50,40,70,20);
		//c.add(lblnuPaper);
		c.add(nuPaper);
		nuPaper.setBounds(140,40,70,20);
		//c.add(lblnuScissor);
		c.add(nuScissor);
		nuScissor.setBounds(230,40,70,20);
		
		c.add(lblComp);
		lblComp.setBounds(50,70,100,20);
		c.add(jtncmp);
		jtncmp.setBounds(140,100,150,20);
		//if(nuRock.isSelected()||nuPaper.isSelected()||nuScissor.isSelected())
		c.add(play);
		play.setBounds(140,130,130,30);
		c.add(playanother);
		playanother.setBounds(140,200,150,30);
		c.add(signout);
		signout.setBounds(140,250,130,30);
		c.add(jlblres);
		jlblres.setBounds(140,160,200,30);
		c.add(viewscore);
		viewscore.setBounds(140,300,130,30);
		c.add(label1);
		label1.setVisible(false);
		bg2.add(nuRock);
		bg2.add(nuPaper);
		bg2.add(nuScissor);
		

		
		ActionListener a1 = (ae) -> {
			flag = true;
			System.out.print(flag);
			
		};
		
		
		
		ActionListener a2 = (ae) -> {
			count++;
		
		if(count==1)
		{
			System.out.println("work");
			flagsss=true;
			
			int r = (int)(Math.random()*3);
			if(r==0)		comp+="ROCK";
			else if(r==1)	comp+="PAPER";
			else			comp+="SCISSOR";
			jtncmp.setText(comp);
			nuRock.setActionCommand("ROCK");
			nuPaper.setActionCommand("PAPER");
			nuScissor.setActionCommand("SCISSOR");
			String m= bg2.getSelection().getActionCommand();
			System.out.print(m);
			System.out.print(comp);
			if(comp.equals(m))
			{
				nt++;
				jlblres.setText("tie");
			}
			
			else if(comp.equals("PAPER") && m.equals("ROCK"))
			{
				nc++;
				jlblres.setText("Sry u lost better luck next time");
			}
			else if(comp.equals("SCISSOR") && m.equals("PAPER"))
			{
				nc++;
				jlblres.setText("Sry u lost better luck next time");
			}
			else if(comp.equals("SCISSOR") && m.equals("ROCK"))
			{
				nu++;
				jlblres.setText("u won");
			}
			else if(comp.equals("ROCK") && m.equals("PAPER"))
			{
				nu++;
				jlblres.setText("u won");
			}
			else if(comp.equals("PAPER") && m.equals("SCISSOR"))
			{
				nu++;
				jlblres.setText("u won");
			}
			else if(comp.equals("ROCK") && m.equals("SCISSOR"))
			{
				nc++;
				
				jlblres.setText("Sry u lost better luck next time");
			}
		}
		else{
			JOptionPane.showMessageDialog(new JDialog(),"plz select an option");
		}
			
		};
		
		ActionListener a3 = (ae) -> {
			jlblres.setText("");
			jtncmp.setText("");
			comp="";
			bg2.clearSelection();
			count=0;
		};
		
		ActionListener a4 = (ae) -> {
				count=0;
				if(flag){
				new Dbhand().score(nt,nc,nu);
				//Main m = new Main();
				dispose();
				System.out.println("!=flags");
				}
				else{
					
				Main m = new Main();
				dispose();
				}
				
			
		};
		ActionListener a5 = (ae) -> {
			Previousscore s = new Previousscore();
			dispose();
		};
		nuRock.addActionListener(a1);
		nuPaper.addActionListener(a1);
		nuScissor.addActionListener(a1);
		
		viewscore.addActionListener(a5);
		signout.addActionListener(a4);
		
		//if(nuRock.isSelected()||nuPaper.isSelected()||nuScissor.isSelected())
		/*if(flag==true)
		{
			System.out.println("true");*/
		playanother.addActionListener(a3);
	
			play.addActionListener(a2);
		
	
		setTitle("Game");
		setSize(500,450);
		setPreferredSize(new Dimension(500, 400));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
       
	}
}
	