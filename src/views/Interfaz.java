package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Interfaz extends JFrame {

    private PanelOpciones nuevoPanel;

    public Interfaz() {
        super();
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wallet");
        setLayout(new BorderLayout());

        nuevoPanel = new PanelOpciones(this);

        add(nuevoPanel, BorderLayout.SOUTH);
    }

    public static void main1(String[] args) {
        Interfaz vistaPrincipal = new Interfaz();
        vistaPrincipal.setVisible(true);
    }
}