import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loadStart extends JFrame {
    Container c;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JPanel contentPane;
    Timer timer;
    int count=0;
	ImageIcon imageIcon;
	boolean flagss=false;

    public loadStart() {
       //JFrame.setDefaultLookAndFeelDecorated(true);
       c=getContentPane();
		c.setLayout(new FlowLayout());
		imageIcon = new ImageIcon("startgame.gif"); 
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
			  flagss=true;
			
			  Game m = new Game();
			  //m.getAnim(flagss);
				m.setVisible(true);
				dispose();
			
			}
		 
        }
		

      };      
	   setSize(500,310);
	   setPreferredSize(new Dimension(500, 310));
		pack();
	setLocationRelativeTo(null);
       setVisible(true);
       timer = new Timer(2700, action);
       timer.start();
    }
	
    public static void main(String args[]) {
      loadStart l = new loadStart();
	  l.setResizable(false);
    }
}