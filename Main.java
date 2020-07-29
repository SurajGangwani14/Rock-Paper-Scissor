import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.sound.sampled.*;
import java.io.*;


class Main extends JFrame
{
	Container c;
	JLabel lbLogin,lblPass,lglogo,lblbackground;
	JButton btnSign,btnLogin;
	JTextField txtLogin;
	JPasswordField txtPassword;
	AudioFormat audioFormat;
	AudioInputStream audioInputStream;
	SourceDataLine sourceDataLine;
	//StringBuilder name;
	static String name;
	boolean flagss= true;
	ImageIcon imageIcon,background,login,password;
	

	Main()
	{

		c=getContentPane();
		imageIcon = new ImageIcon("login.jpg");
		background = new ImageIcon("background2.jpg");
		login = new ImageIcon("user2.jpg");
		password = new ImageIcon("pass2.jpg");
		
		//c.setBackground(Color.WHITE);
		c.setLayout(null);
		lbLogin = new JLabel(login);
		lblPass = new JLabel(password);
		txtLogin = new JTextField(20);
		txtPassword = new JPasswordField(20);
		btnLogin = new JButton("Login");
		btnSign = new JButton("SignUp");
		lglogo = new JLabel(imageIcon);
		lblbackground = new JLabel("",background,JLabel.CENTER);
		c.add(lblbackground);
		lblbackground.setBounds(0,0,700,500);
		
		
		c.add(lglogo);
		lglogo.setBounds(240,20,120,120);
		lblbackground.add(lbLogin);
		lbLogin.setBounds(200,180,30,30);
		lblbackground.add(txtLogin);
		txtLogin.setBounds(240,180,130,30);
		lblbackground.add(lblPass);
		lblPass.setBounds(200,240,30,30);
		lblbackground.add(txtPassword);
		txtPassword.setBounds(240,240,130,30);
		lblbackground.add(btnLogin);
		btnLogin.setBounds(240,280,130,30);
		lblbackground.add(btnSign);
		btnSign.setBounds(240,320,130,30);
		
		ActionListener a1 = (ae) -> {
			Sign g = new Sign();
			dispose();
		};
		
		btnSign.addActionListener(a1);

		ActionListener a2 = (ae) -> {
			
			String password = txtPassword.getText();
			 name = (txtLogin.getText());
			
			if(txtLogin.getText().length()!=0 && txtPassword.getText().length()!=0 )
			{
				
				new Dbhand().Login(name,password);
				
				
				if ((new Dbhand().check())==true)
				{
					//new Game().setVisible(true);
					System.out.println(flagss);
					playAudio1();
					LabelDelay a = new LabelDelay();
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(new JDialog(),"wrong username and password");
					txtLogin.setText("");
					txtPassword.setText("");
				}
				
			}
			else{
				JOptionPane.showMessageDialog(new JDialog(),"enter username and password");
				}
			
			
		};
		
		
		btnLogin.addActionListener(a2);

		setTitle("Login Page");
		setSize(700,500);
		setPreferredSize(new Dimension(700, 500));
		pack();
		//setResizeable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void except(boolean flagss)
	{
		System.out.print(flagss);
		this.flagss =flagss;

	}
	public String sc()
	{
		System.out.print("m"+name);
		return name;
	}
	
	private void playAudio1() {
    try{
      File soundFile =
                   new File("Appear-KP-1137861048.wav");
      audioInputStream = AudioSystem.
                  getAudioInputStream(soundFile);
      audioFormat = audioInputStream.getFormat();
      System.out.println(audioFormat);

      DataLine.Info dataLineInfo =
                          new DataLine.Info(
                            SourceDataLine.class,
                                    audioFormat);

      sourceDataLine =
             (SourceDataLine)AudioSystem.getLine(
                                   dataLineInfo);

      //Create a thread to play back the data and
      // start it running.  It will run until the
      // end of file, or the Stop button is
      // clicked, whichever occurs first.
      // Because of the data buffers involved,
      // there will normally be a delay between
      // the click on the Stop button and the
      // actual termination of playback.
      new PlayThread1().start();
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end playAudio


//=============================================//
//Inner class to play back the data from the
// audio file.
class PlayThread1 extends Thread{
  byte tempBuffer[] = new byte[10000];

  public void run(){
    try{
      sourceDataLine.open(audioFormat);
      sourceDataLine.start();

      int cnt;
      //Keep looping until the input read method
      // returns -1 for empty stream or the
      // user clicks the Stop button causing
      // stopPlayback to switch from false to
      // true.
      while((cnt = audioInputStream.read(
           tempBuffer,0,tempBuffer.length)) != -1){
        if(cnt > 0){
          //Write data to the internal buffer of
          // the data line where it will be
          // delivered to the speaker.
          sourceDataLine.write(
                             tempBuffer, 0, cnt);
        }//end if
      }//end while
      //Block and wait for internal buffer of the
      // data line to empty.
      sourceDataLine.drain();
      sourceDataLine.close();

      //Prepare to playback another file
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end run
}//end inner class PlayThread
//===================================//
public static void main(String[] args)
{
		
		Main m = new Main();
		m.setResizable(false);
}

}

class Dbhand
{
	static boolean flag;
	int n=0;
	public void signUp(String name,String password)
	{
		Connection con= null;
		try
		{
			System.out.println("loading the driver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver loaded");
			System.out.println("trying to connect");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			System.out.println("connected");
			String sql = "insert into login values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2,password);
			int result = pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),result+"records inserted");
			pst.close();
		}
		catch (SQLException e)
		{
			//JOptionPane.showMessageDialog(new JDialog(),"issues"+e);

		}
		finally{
			try
			{
				System.out.println("trying to close the connection");
				if(con!=null)
				{
					con.close();
					System.out.println("connection closed");
				}
			}
			catch (SQLException e)
			{
				System.out.println("Closing issues"+e);

			}
			

		}
	}
	public void Login(String names,String passwords)
	{
		//int n=0;
		//boolean flag = false;
		Connection con= null;
		try
		{
			System.out.println("loading the driver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver loaded");
			System.out.println("trying to connect");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			System.out.println("connected");
			Statement stmt = con.createStatement();
			String sql = "select * from login";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String id = rs.getString(1);
				String password = rs.getString(2);
				if(passwords.equals(password) && id.equals(names))
				{
					n++;
					flag = true;
					
				}
				


			}
			
			
			/*if(flag==true)
				{
					boolean flagss = false;
					System.out.print(flagss);
					
					new Main().except(flagss);
					rs.close();
					stmt.close();
				}
				else 
				{
					
					JOptionPane.showMessageDialog(new JDialog(),"wrong username and password");
					boolean flagss = true;
					System.out.print(flagss);
					new Main().except(flagss);
					new Game().setVisible(false);
					
					
					
					
					
				}*/
			//JOptionPane.showMessageDialog(new JDialog(),result+"records inserted");
			
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"issues"+e);

		}
		finally{
			try
			{
				System.out.println("trying to close the connection");
				if(con!=null)
				{
					con.close();
					System.out.println("connection closed");
				}
			}
			catch (SQLException e)
			{
				System.out.println("Closing issues"+e);

			}
			

		}
	}
	public boolean check()
	{
		System.out.print(n);
		System.out.print(flag);
		this.flag=flag;
		return flag;
	}
	public void score(int nc,int nt,int nu)
	{

		Connection con= null;
		try
		{
			System.out.println("loading the driver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver loaded");
			System.out.println("trying to connect");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			System.out.println("connected");
			String sql = "insert into score values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			Main m = new Main();
			String name = m.sc();
			System.out.println(name);
			pst.setString(1,name);
			pst.setInt(2,nt);
			pst.setInt(3,nc);
			pst.setInt(4,nu);
			int result = pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),result+"records inserted");
			pst.close();
		}
		catch (SQLException e)
		{
			//JOptionPane.showMessageDialog(new JDialog(),"issues"+e);

		}
		finally{
			try
			{
				System.out.println("trying to close the connection");
				if(con!=null)
				{
					con.close();
					System.out.println("connection closed");
				}
			}
			catch (SQLException e)
			{
				System.out.println("Closing issues"+e);

			}
			

		}
	}
	public String viewScore()
	{
		StringBuffer sb = new StringBuffer();
		Connection con= null;
		try
		{
			System.out.println("loading the driver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver loaded");
			System.out.println("trying to connect");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			System.out.println("connected");
			Statement stmt = con.createStatement();
			String sql = "select * from score";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String name =rs.getString(1);
				int nt = rs.getInt(2);
				int nc = rs.getInt(3);
				int nu = rs.getInt(4);
				sb.append(" name " + name + " nt " + nt +" nc " + nc + " nu " + nu + "\n");
				


			}
			rs.close();
			stmt.close();
			}
		
			/*if(flag==true)
				{
					boolean flagss = false;
					System.out.print(flagss);
					
					new Main().except(flagss);
					rs.close();
					stmt.close();
				}
				else 
				{
					
					JOptionPane.showMessageDialog(new JDialog(),"wrong username and password");
					boolean flagss = true;
					System.out.print(flagss);
					new Main().except(flagss);
					new Game().setVisible(false);
					
					
					
					
					
				}*/
			//JOptionPane.showMessageDialog(new JDialog(),result+"records inserted");
			
		
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"issues"+e);

		}
		finally{
			try
			{
				System.out.println("trying to close the connection");
				if(con!=null)
				{
					con.close();
					System.out.println("connection closed");
				}
			}
			catch (SQLException e)
			{
				System.out.println("Closing issues"+e);
			}
		}
		return sb.toString();
	}
}

