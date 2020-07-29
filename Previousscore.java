import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Previousscore  extends JFrame {
    Container c;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JPanel contentPane;
    Timer timer;
    int count=0;
	ImageIcon imageIcon;

    public Previousscore () {
       //JFrame.setDefaultLookAndFeelDecorated(true);
       c=getContentPane();
		c.setLayout(new FlowLayout());
		imageIcon = new ImageIcon("prev_score.gif"); 
       label1 = new JLabel(imageIcon);
       c.add(label1);

       label2 = new JLabel(imageIcon);
       c.add(label2);

       label3 = new JLabel(imageIcon);
       c.add(label3);

       label4 = new JLabel(imageIcon);
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
				 Game m = new Game();
				m.setVisible(true);
          }
		  
          count++; 
		  if(count==4)
			{
			  score m = new score();
				dispose();
			}
		 
        }
		

      };      
	   setSize(600,500);
	   setPreferredSize(new Dimension(600, 500));
		pack();
	setLocationRelativeTo(null);
       setVisible(true);
       timer = new Timer(2000, action);
       timer.start();
    }
    public static void main(String args[]) {
      new Previousscore ();
    }
}
