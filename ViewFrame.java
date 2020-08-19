import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

class ViewFrame extends JFrame
{
Container c;
TextArea taData;
JButton btnBack;

ViewFrame()
{
c = getContentPane();
c.setLayout(null);
JLabel background;
	ImageIcon img = new ImageIcon("C:\\Extras\\JavaPracticals\\project1\\bg.jpg");
	background = new JLabel("" ,img , JLabel.CENTER);
	background.setBounds(0,0,800,537);

taData = new TextArea(10,30);
btnBack = new JButton("Back");

//btnAdd.setBounds(x,y,w,h)

taData.setBounds(205,133,400,255);
btnBack.setBounds(317, 420, 170, 60);

taData.setBackground(Color.pink);
btnBack.setFont(new Font("Times new roman",Font.BOLD,30));
btnBack.setForeground(Color.black);
btnBack.setBackground(Color.white);
taData.setFont(new Font("calibri",Font.PLAIN,13));

c.add(taData);
c.add(btnBack);
add(background);

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;

try {
	session = sfact.openSession();

	java.util.List<Student> student = new java.util.ArrayList<>();
	student = session.createQuery("from Student").list();
	String msg ="Rno\tName\t\tPhysics\t\tChemistry\tMaths\n\n";
	for(Student s : student)
		msg += s.getRno() + "\t" + s.getName() + "\t\t" + s.getMarks1() + "\t\t" + s.getMarks2() + "\t\t" + s.getMarks3()+"\n";
	taData.setText(msg);
	
} catch(Exception e) {
	System.out.println("issue " + e);
} finally {
	if (session != null) {
		session.close();
	}
}

ActionListener a1 = (ae) -> { 
MainFrame af = new MainFrame(); 
dispose(); 
};
btnBack.addActionListener(a1);

setTitle("View Student");
setSize(800,540);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setVisible(true);
}
}