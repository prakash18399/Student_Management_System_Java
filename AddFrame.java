import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class AddFrame extends JFrame
{
Container c;
JLabel lblRno, lblName, lblMarks1, lblMarks2, lblMarks3;
JTextField txtRno, txtName, txtMarks1, txtMarks2, txtMarks3;
JButton btnSave, btnBack;

AddFrame()
{
c = getContentPane();
c.setLayout(null);
JLabel background;
	ImageIcon img = new ImageIcon("C:\\Extras\\JavaPracticals\\project1\\bg.jpg");
	background = new JLabel("" ,img , JLabel.CENTER);
	background.setBounds(2,2,800,537);

lblRno = new JLabel("Enter rno:");
txtRno = new JTextField(20);
lblName = new JLabel("Enter Name:");
txtName = new JTextField(20);
lblMarks1 = new JLabel("Enter Physics mark:");
txtMarks1 = new JTextField(20);
lblMarks2 = new JLabel("Enter Chemistry mark:");
txtMarks2 = new JTextField(20);
lblMarks3 = new JLabel("Enter Maths mark:");
txtMarks3 = new JTextField(20);
btnSave = new JButton("Add");
btnBack = new JButton("Back");

//btnAdd.setBounds(x,y,w,h)

lblRno.setBounds(50,30,300,50);
lblRno.setFont(new Font("Times new roman",Font.BOLD,25));
lblRno.setForeground(Color.white);

txtRno.setBounds(300,40,200,30);
txtRno.setFont(new Font("Times new roman",Font.BOLD,20));

lblName.setBounds(50,80,300,50);
lblName.setFont(new Font("Times new roman",Font.BOLD,25));
lblName.setForeground(Color.white);

txtName.setBounds(300,90,200,30);
txtName.setFont(new Font("Times new roman",Font.BOLD,20));

lblMarks1.setBounds(50,130,300,50);
lblMarks1.setFont(new Font("Times new roman",Font.BOLD,25));
lblMarks1.setForeground(Color.white);

txtMarks1.setBounds(300,140,200,30);
txtMarks1.setFont(new Font("Times new roman",Font.BOLD,20));

lblMarks2.setBounds(50,180,300,50);
lblMarks2.setFont(new Font("Times new roman",Font.BOLD,25));
lblMarks2.setForeground(Color.white);

txtMarks2.setBounds(300,190,200,30);
txtMarks2.setFont(new Font("Times new roman",Font.BOLD,20));

lblMarks3.setBounds(50,230,300,50);
lblMarks3.setFont(new Font("Times new roman",Font.BOLD,25));
lblMarks3.setForeground(Color.white);

txtMarks3.setBounds(300,240,200,30);
txtMarks3.setFont(new Font("Times new roman",Font.BOLD,20));

btnSave.setBounds(150,320,100,60);
btnSave.setFont(new Font("Times new roman",Font.BOLD,28));
btnSave.setForeground(Color.black);
btnSave.setBackground(Color.white);

btnBack.setBounds(320,320,100,60);
btnBack.setFont(new Font("Times new roman",Font.BOLD,28));
btnBack.setForeground(Color.black);
btnBack.setBackground(Color.white);

c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);
c.add(lblMarks1);
c.add(txtMarks1);
c.add(lblMarks2);
c.add(txtMarks2);
c.add(lblMarks3);
c.add(txtMarks3);
c.add(btnSave);
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
				JOptionPane.showMessageDialog(c,"Rno cannot be Negative","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else{
			txtRno.setText("");
			txtRno.requestFocus();	
			JOptionPane.showMessageDialog(c,"Invalid rno","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	else{
		txtRno.requestFocus();
		JOptionPane.showMessageDialog(c,"Enter rno","Message",JOptionPane.INFORMATION_MESSAGE);
		return;
	}
//validation for name
		if(!(txtName.getText().isEmpty())){
			if(txtName.getText().matches("^[a-zA-Z]*$")){
				if(txtName.getText().length()<2){
					txtName.setText("");
					txtName.requestFocus();
					JOptionPane.showMessageDialog(c,"Name must be of at least 2 alphabets","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else{
				txtName.setText("");
				txtName.requestFocus();
				JOptionPane.showMessageDialog(c,"Invalid Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else{
				txtName.requestFocus();
				JOptionPane.showMessageDialog(c,"Enter Name","Message",JOptionPane.INFORMATION_MESSAGE);
				return;
		}
//validation for Marks1
		if(!(txtMarks1.getText().isEmpty())){
			if(txtMarks1.getText().matches("0|-?[1-9][0-9]*")){
				if(Integer.parseInt(txtMarks1.getText())<0 || Integer.parseInt(txtMarks1.getText())>100){
					txtMarks1.setText("");
					txtMarks1.requestFocus();
					JOptionPane.showMessageDialog(c,"Marks of Physics must be in the range of 0-100","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else{
				txtMarks1.setText("");
				txtMarks1.requestFocus();
				JOptionPane.showMessageDialog(c,"Invalid Marks:Physics","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else{	
			txtMarks1.requestFocus();
			JOptionPane.showMessageDialog(c,"Enter Physics Marks","Message",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
//validation for Marks2
		if(!(txtMarks2.getText().isEmpty())){
			if(txtMarks2.getText().matches("0|-?[1-9][0-9]*")){
				if(Integer.parseInt(txtMarks2.getText())<0 || Integer.parseInt(txtMarks2.getText())>100){
					txtMarks2.setText("");
					txtMarks2.requestFocus();
					JOptionPane.showMessageDialog(c,"Marks of Chemistry must be in the range of 0-100","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else{
				txtMarks1.setText("");
				txtMarks1.requestFocus();
				JOptionPane.showMessageDialog(c,"Invalid Marks:Chemistry","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else{	
			txtMarks2.requestFocus();
			JOptionPane.showMessageDialog(c,"Enter Chemistry Marks","Message",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
//validation for Marks3
		if(!(txtMarks3.getText().isEmpty())){
			if(txtMarks3.getText().matches("0|-?[1-9][0-9]*")){
				if(Integer.parseInt(txtMarks3.getText())<0 || Integer.parseInt(txtMarks3.getText())>100){
					txtMarks3.setText("");
					txtMarks3.requestFocus();
					JOptionPane.showMessageDialog(c,"Marks of Maths must be in the range of 0-100","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else{
				txtMarks3.setText("");
				txtMarks3.requestFocus();
				JOptionPane.showMessageDialog(c,"Invalid Marks:Maths","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else{	
			txtMarks3.requestFocus();
			JOptionPane.showMessageDialog(c,"Enter Maths Marks","Message",JOptionPane.INFORMATION_MESSAGE);
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
	if(b!=null){
		txtRno.setText("");
		txtRno.requestFocus();
		String msg="Student with rno:"+rno+" already Exists";
		JOptionPane.showMessageDialog(c,msg);
		return;
	}
	String name = txtName.getText();
	int marks1 = Integer.parseInt(txtMarks1.getText());
	int marks2 = Integer.parseInt(txtMarks2.getText());
	int marks3 = Integer.parseInt(txtMarks3.getText());
	
	Student s = new Student(rno, name, marks1, marks2, marks3);
	session.save(s);
	t.commit();
	JOptionPane.showMessageDialog(c,"record added ");
	txtRno.setText("");
	txtRno.requestFocus();
	txtName.setText("");
	txtName.requestFocus();
	txtMarks1.setText("");
	txtMarks1.requestFocus();
	txtMarks2.setText("");
	txtMarks2.requestFocus();
	txtMarks3.setText("");
	txtMarks3.requestFocus();
} catch(Exception e) {
	System.out.println("issue " + e);
	t.rollback();
} finally {
	if (session != null) {
		session.close();
	}
}
};
btnSave.addActionListener(a2);				// save data into database via DbHandler

setTitle("Add Student");
setSize(810,565);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setVisible(true);
}
}