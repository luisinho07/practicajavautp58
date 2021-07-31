package views;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel implements ActionListener {

    public final static String BTN_SALDO = "Consultar Saldo";
    public final static String BTN_CARGAR = "Cargar Saldo";

    private JButton btnSaldo;
    private JButton btnCargar;

    private Interfaz interfaz;
    
    public PanelOpciones(Interfaz i) {
        super();
        setLayout(new GridLayout(1, 2));
        setBorder(new TitledBorder("Opciones"));

        interfaz = i;

        //inicializr las relaciones o atributos
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);

        // modificar las propiedades
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCargar.setActionCommand(BTN_CARGAR);

        btnSaldo.addActionListener(this);
        btnCargar.addActionListener(this);


        // agregar las relaciones o atributos
        add(btnSaldo);
        add(btnCargar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals(BTN_SALDO)) {
            JOptionPane.showMessageDialog(interfaz, "Estás viendo el saldo");
        } else if (e.getActionCommand().equals(btnCargar.getActionCommand())) {
            JOptionPane.showMessageDialog(interfaz, "Vas a recargar", "Recarga Wallet", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
