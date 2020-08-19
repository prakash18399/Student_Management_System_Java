import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class DeleteFrame extends JFrame
{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnDelete, btnBack;

DeleteFrame()
{
c = getContentPane();
c.setLayout(null);
JLabel background;
	ImageIcon img = new ImageIcon("C:\\Extras\\JavaPracticals\\project1\\bg.jpg");
	background = new JLabel("" ,img , JLabel.CENTER);
	background.setBounds(2,2,800,537);
lblRno = new JLabel("Enter rno to Delete:");
txtRno = new JTextField(15);
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");

//btnAdd.setBounds(x,y,w,h)

lblRno.setBounds(230,3,400,150);
txtRno.setBounds(300,130,200,30);
btnDelete.setBounds(280,220,100,50);
btnBack.setBounds(420,220,100,50);

lblRno.setFont(new Font("Times new roman",Font.BOLD,40));
lblRno.setForeground(Color.white);
txtRno.setFont(new Font("Times new roman",Font.BOLD,20));
btnDelete.setFont(new Font("Times new roman",Font.BOLD,20));
btnDelete.setForeground(Color.black);
btnDelete.setBackground(Color.white);
btnBack.setFont(new Font("Times new roman",Font.BOLD,20));
btnBack.setForeground(Color.black);
btnBack.setBackground(Color.white);

c.add(lblRno);
c.add(txtRno);
c.add(btnDelete);
c.add(btnBack);
add(background);

ActionListener a1 = (ae) -> { 
MainFrame af = new MainFrame();
dispose(); 
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> { 
//validation for rno
	if(!(txtRno.getText().isEmpty())){
		if(txtRno.getText().matches("0|-?[1-9][0-9]*")){
			if(Integer.parseInt(txtRno.getText())<0){
				txtRno.setText("");
				txtRno.requestFocus();
				JOptionPane.showMessageDialog(c,"Id cannot be Negative","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else{
			txtRno.setText("");
			txtRno.requestFocus();	
			JOptionPane.showMessageDialog(c,"Invalid Id","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	else{
		txtRno.requestFocus();
		JOptionPane.showMessageDialog(c,"Enter Id","Message",JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory sfact = cfg.buildSessionFactory();
	Session session = null;
	Transaction t = null;
	try {
		session = sfact.openSession();	
		t = session.beginTransaction();
		int rno = Integer.parseInt(txtRno.getText());
		Student b= (Student)session.get(Student.class,rno);
		if(b==null){
			txtRno.setText("");
			txtRno.requestFocus();
			String msg="Student with rno:"+rno+" Does Not Exists";
			JOptionPane.showMessageDialog(c,msg,"Error",JOptionPane.ERROR_MESSAGE);
			return;
		}	
		Student s = (Student)session.get(Student.class, rno);
		session.delete(s);
		t.commit();
		JOptionPane.showMessageDialog(c, "record deleted ","Message",JOptionPane.INFORMATION_MESSAGE);
		txtRno.setText("");
		txtRno.requestFocus();
	}
	 catch(Exception e) {
		JOptionPane.showMessageDialog(c, "issue " + e);
		t.rollback();
	} finally {
		if (session != null) {
			session.close();
		}
	}
};
btnDelete.addActionListener(a2);				// save data into database via DbHandler

setTitle("Delete Student");
setSize(800,580);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setVisible(true);
}
}