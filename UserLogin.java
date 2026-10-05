import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JCheckBox rememberMe;
    JCheckBox notifications;

    UserLogin() {

        setTitle("User Login");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        // Password
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Preferences
        add(new JLabel("Preferences:"));

        JPanel panel = new JPanel();

        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        panel.add(rememberMe);
        panel.add(notifications);

        add(panel);

        // Login Button
        JButton loginButton = new JButton("Login");

        add(new JLabel(""));
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("admin123")) {

                    String preferences = "";

                    if (rememberMe.isSelected()) {
                        preferences += "Remember Me ";
                    }

                    if (notifications.isSelected()) {
                        preferences += "Receive Notifications";
                    }

                    JOptionPane.showMessageDialog(
                        UserLogin.this,
                        "Login Successful!\nUsername: " + username +
                        "\nPreferences: " + preferences,
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                } else {

                    JOptionPane.showMessageDialog(
                        UserLogin.this,
                        "Invalid Username or Password!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}
