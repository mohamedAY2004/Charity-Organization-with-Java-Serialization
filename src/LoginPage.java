import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener
{
    JFrame frame=new JFrame("Login Page");
    JButton loginButton=new JButton("Login");
    JButton resetButton=new JButton("Reset");
    JTextField userIdField=new JTextField();
    JPasswordField userpasswordField =new JPasswordField();
    JLabel userIDlabel=new JLabel("userID: ");
    JLabel userPasswordlabel =new JLabel("password: ");
    JLabel messageLabel=new JLabel();
    HashMap<String,String> loginInfo;
    LoginPage (HashMap<String,String> loginInfo)
    {
        this.loginInfo=loginInfo;
        userIDlabel.setBounds(50,100,75,25);
        userPasswordlabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIdField.setBounds(125,100,200,25);
        userpasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        resetButton.setBounds(225,200,100,25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);


        frame.add(userIDlabel);
        frame.add(userPasswordlabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userpasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==resetButton){
        userIdField.setText("");
        userpasswordField.setText("");
        return;
    }
    if(e.getSource()==loginButton)
    {
        String id=userIdField.getText();
        String password=String.valueOf(userpasswordField.getPassword());
        if(loginInfo.containsKey(id))
        {
            if(loginInfo.get(id).equals(password))
            {
                frame.dispose();
                new LaunchPage();
            }else
            {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong password");

            }
        }else
        {
            messageLabel.setForeground(Color.red);
            messageLabel.setText("username not found");

        }
    }
    }
}
