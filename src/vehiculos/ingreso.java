package vehiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ingreso {
    private JTextField Placa;
    private JTextField Marca;
    private JTextField Cilindraje;
    private JTextField Combustible;
    private JTextField Color;
    private JButton Registrar;
    public JPanel jpanel;
    private JButton volverButton;
    private JTextField Propietario;
    private JButton limpiar;
    private JLabel placa;
    private JLabel marca;
    private JLabel cilindraje;
    private JLabel combustible;
    private JLabel color;

    public ingreso() {
        Registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placaText = Placa.getText();
                String marcaText = Marca.getText();
                String cilindrajeText = Cilindraje.getText();
                String combustibleText = Combustible.getText();
                String colorText = Color.getText();
                String propietarioText = Propietario.getText();


                // Validaciión de los campos
                if (placaText.isEmpty() || marcaText.isEmpty() ||
                        cilindrajeText.isEmpty() || combustibleText.isEmpty() || colorText.isEmpty() || propietarioText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                    return;
                }

                //Inserción de la base
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculos", "root", "123456");
                    String sql = "INSERT INTO vehiculo (Placa, Marca, Cilindraje, Combustible, Color, Propietario) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, placaText);
                    pstmt.setString(2, marcaText);
                    pstmt.setDouble(3, Double.parseDouble(cilindrajeText));
                    pstmt.setString(4, combustibleText);
                    pstmt.setString(5, colorText);
                    pstmt.setString(6, propietarioText);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente.");
                    conn.close();
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar el Automovil: " + ex.getMessage());
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Sistema de gestión Automovilistico");
                frame.setContentPane(new form1().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 700);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);

                // Cierra la ventana actual
                ((JFrame) SwingUtilities.getWindowAncestor(volverButton)).dispose();
            }
        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Placa.setText(null);
                Marca.setText(null);
                Cilindraje.setText(null);
                Combustible.setText(null);
                Color.setText(null);
                Propietario.setText(null);
            }
        });
    }
}
