import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginFrame extends JFrame 
{
Container c;
JLabel lblUser,lblPass;
JButton btnLogin;
final JTextField txtUser,txtPass;

LoginFrame() 
{
c = getContentPane();
c.setLayout(null);
//c.setLayout(new FlowLayout());
	JLabel background;
	ImageIcon img = new ImageIcon("C:\\Extras\\JavaPracticals\\project1\\bg.jpg");
	background = new JLabel("" ,img , JLabel.CENTER);
	background.setBounds(2,2,800,537);

lblUser = new JLabel("Username:");
txtUser = new JTextField(20);
lblPass = new JLabel("Password:");
txtPass = new JPasswordField(20);
btnLogin = new JButton("LOGIN");

lblUser.setBounds(240,70,300,50);
lblUser.setFont(new Font("Times new roman",Font.BOLD,25));
lblUser.setForeground(Color.white);

txtUser.setBounds(360,80,200,30);
txtUser.setFont(new Font("Times new roman",Font.BOLD,20));

lblPass.setBounds(240,120,300,50);
lblPass.setFont(new Font("Times new roman",Font.BOLD,25));
lblPass.setForeground(Color.white);

txtPass.setBounds(360,130,200,30);
txtPass.setFont(new Font("Times new roman",Font.BOLD,20));

btnLogin.setBounds(330,210,140,50);
btnLogin.setFont(new Font("Times new roman",Font.BOLD,25));
btnLogin.setForeground(Color.black);
btnLogin.setBackground(Color.white);

c.add(lblUser);
c.add(txtUser);
c.add(lblPass);
c.add(txtPass);
c.add(btnLogin);
add(background);

ActionListener a1 = (ae) -> {

String username = txtUser.getText();
String password = txtPass.getText();

if(username.equals("system") && password.equals("abc123")) {
	MainFrame m = new MainFrame();
	dispose();
}
else {
	JOptionPane.showMessageDialog(c,"Incorrect username or password","Error",JOptionPane.ERROR_MESSAGE);
	txtUser.setText("");
	txtPass.setText("");
	txtUser.requestFocus();
}
};
btnLogin.addActionListener(a1);

setTitle("Login");
setSize(810,565);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setVisible(true);
}
}































 