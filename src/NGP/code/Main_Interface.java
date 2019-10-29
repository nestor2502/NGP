package NGP.code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Interface {
    private JPanel Main_Interface;
    private JButton Add_Money_Button;
    private JButton Exit_button;
    private JButton History_button;
    private JLabel LoLLogo;

    public Main_Interface() {
        History_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        Add_Money_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        Exit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        LoLLogo = new JLabel( new ImageIcon("../../imagenes/logos/LogoPrincipal.png") );
    }
}
