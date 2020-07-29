import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class score extends JFrame
{
	Container c;
	TextArea taData;
	JButton btnBack;
	ImageIcon view;
	JLabel lblbackground;

	score()
	{
		c = getContentPane();
		c.setLayout(null);
		taData = new TextArea(5, 20);
		taData.setEditable(false);
		taData.setFocusable(false);
		btnBack = new JButton("Back");
		view = new ImageIcon("viewscore.jpg");
		lblbackground = new JLabel("",view,JLabel.CENTER);
		c.add(lblbackground);
		lblbackground.setBounds(0,0,640,480);

		lblbackground.add(taData);
		taData.setBounds(50,35,200,200);
		lblbackground.add(btnBack);
		btnBack.setBounds(250,35,100,30);
		String data = new Dbhand().viewScore();
		taData.setText(data);

		ActionListener a1 = (ae) -> {
		Game m = new Game();
		dispose();
		};
		btnBack.addActionListener(a1);

		setTitle(" View Employee ");
		setSize(640, 480);
		setPreferredSize(new Dimension(640, 480));
		pack();
		//setResizeable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}