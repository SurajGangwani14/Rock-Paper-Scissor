import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Previous extends JFrame {
    Container c;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JPanel contentPane;
    Timer timer;
    int count=0;
	ImageIcon imageIcon,imageIcon1,imageIcon2,imageIcon3;

    public Previous() {
       //JFrame.setDefaultLookAndFeelDecorated(true);
       c=getContentPane();
		c.setLayout(new FlowLayout());
		imageIcon = new ImageIcon("quote1.jpg"); 
       label1 = new JLabel(imageIcon);
       c.add(label1);
	   imageIcon1 = new ImageIcon("quote2.jpg"); 
       label2 = new JLabel(imageIcon1);
       c.add(label2);
       imageIcon2 = new ImageIcon("quote3.jpg"); 
       label3 = new JLabel(imageIcon2);
       c.add(label3);
	   imageIcon3 = new ImageIcon("quote4.jpg"); 
       label4 = new JLabel(imageIcon3);
       c.add(label4);

       //frame.setContentPane(contentPane);
       //frame.pack();
		
       label1.setVisible(false);
       label2.setVisible(false);
       label3.setVisible(false);
       label4.setVisible(false);


       ActionListener action = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          switch(count) {
            case 0:
              label1.setVisible(true);
			System.out.print("1");
              break;
            case 1:
			label1.setVisible(false);
              label2.setVisible(true);
			  System.out.print("1");
              break;
            case 2:
			label1.setVisible(false);
              label2.setVisible(false);
              label3.setVisible(true);
			  System.out.print("1");
              break;
            case 3:
			  label1.setVisible(false);
              label2.setVisible(false);
              label3.setVisible(false);
              label4.setVisible(true);
			  System.out.print("1");
              break;
            case 4:
				System.out.print("last");
              timer.stop();//base criteria
              break;
			 default:
				 Main m = new Main();
				m.setVisible(true);
          }
		  
          count++; 
		  if(count==5)
			{
			  Main m = new Main();
				dispose();
			}
		 
        }
		

      };      
	   setSize(400,300);
	   setPreferredSize(new Dimension(400, 300));
		pack();
	setLocationRelativeTo(null);
       setVisible(true);
       timer = new Timer(4000, action);
       timer.start();
    }
    public static void main(String args[]) {
      Previous p = new Previous();
	  p.setResizable(false);
    }
} 

