package NGP.code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn_Interface {
    private JButton LogInButton;
    private JButton notAnUserYetButton;
    private JPanel LogInPanel;
    private JTextField UserTextField;
    private JTextField PasswordTextField;
    private JLabel UserLabel;
    private JLabel PasswordLabel;
    private JLabel LoLLogo;


    public LogIn_Interface() {
        notAnUserYetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

            }

        });
        LogInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LogIn_Interface");
        frame.setContentPane(new LogIn_Interface().LogInPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
        LoLLogo = new JLabel( new ImageIcon("../../imagenes/logos/LogoPrincipal.png") );
    }
}
