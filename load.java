
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class load extends JFrame implements Runnable{
	Container c;
	JLabel label;
	ImageIcon imageIcon;

	load()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		setTitle("JLabel Test");
		imageIcon = new ImageIcon("load.gif"); 
		label = new JLabel(imageIcon);
		c.add(label);
		c.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e)
			{
					try
					{
						TimeUnit.SECONDS.sleep(5);
					}
					catch (Exception e1)
					{
					}
					
					System.out.println("h");
					run();
					System.out.print("h");
					Game m = new Game();
					dispose();
			}              
        });
		
		 setTitle("Load");
		setSize(300,350);
		setPreferredSize(new Dimension(300, 350));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void run()
	{
		try
		{
			Thread.sleep(15);
		}
		catch (Exception e)
		{
		}
	}
  public static void main(String[] args) {
	  load l = new load();
	  l.setResizable(false);
  }
}