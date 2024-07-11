package vehiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 {
    public JButton buscar;
    public JButton registrar;
    public JPanel mainPanel;
    private JButton finalizar;

    public form1() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bienvenido");
                JFrame frame = new JFrame("Bienvenido");
                frame.setContentPane(new busqueda().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                // Cierra la ventana actual
                ((JFrame) SwingUtilities.getWindowAncestor(buscar)).dispose();
            }
        });
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Bienvenido");
                frame.setContentPane(new ingreso().jpanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                // Cierra la ventana actual
                ((JFrame) SwingUtilities.getWindowAncestor(registrar)).dispose();
            }
        });
        finalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}