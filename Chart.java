import javax.swing.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class Chart extends JFrame {
Container c ;
public Chart() {
c = getContentPane();
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sfact = cfg.buildSessionFactory();
Session session = null;
Transaction t = null;

try {
	session = sfact.openSession();
	java.util.List<Student> studentlist = new java.util.ArrayList<>();
	studentlist = session.createQuery("from Student order by rno").list();
	DefaultCategoryDataset d1  = new DefaultCategoryDataset();
	for(Student b: studentlist){
		int id = b.getRno();
		String name =b.getName();
		int m1 = b.getMarks1();
		int m2 = b.getMarks2();
		int m3 = b.getMarks3();
		d1.addValue(m1,name,"Phy");
		d1.addValue(m2,name,"Chem");
		d1.addValue(m3,name,"Maths");	
	}
	JFreeChart chart = ChartFactory.createBarChart("Student's Performance","Subjects","Marks",d1,PlotOrientation.VERTICAL,true,false,false);
	ChartPanel panel = new ChartPanel(chart);
	setContentPane(panel);
}
catch(Exception e){
	JOptionPane.showMessageDialog(c,e,"Issue",JOptionPane.ERROR_MESSAGE);
}
finally{
	if(session != null){
		session.close();
	}
}
setTitle("Mark Sheet");
setSize(800, 400);
setLocationRelativeTo(null);
setVisible(true);
}
};

