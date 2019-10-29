package NGP.code;

import javax.swing.*;

public class Sign_Up_Interface {
    private JTextField PasswordText;
    private JTextField UserText;
    private JTextField RPasswordText;
    private JPanel Sign_UP_Interface;
    private JLabel UserLabel;
    private JLabel PasswordLabel;
    private JLabel RPasswordLabel;
    private JLabel LoLLogo;
    private JButton Enter_Button;
    private JButton notAnUserYetButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign_Up_Interface");
        frame.setContentPane(new Sign_Up_Interface().Sign_UP_Interface);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        LoLLogo = new JLabel( new ImageIcon("../../imagenes/logos/LogoPrincipal.png") );
    }


}
