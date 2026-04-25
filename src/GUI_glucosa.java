import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI_glucosa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	ArrayList<paciente> lista = new ArrayList<paciente>();
	public class paciente {
		String nombre;
		int valor;
		String fecha;
		
		paciente (String nombre, int valor, String fecha){
			this.nombre=nombre;
			this.valor=valor;
			this.fecha=fecha;
			
		}
	
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_glucosa frame = new GUI_glucosa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_glucosa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(Color.LIGHT_GRAY);
		toolBar.setFloatable(false);
		toolBar.setToolTipText("");
		toolBar.setBounds(10, 0, 459, 36);
		contentPane.add(toolBar);
		toolBar.addSeparator();
		
		JPanel panelglucosa = new JPanel();
		panelglucosa.setBounds(10, 38, 459, 349);
		contentPane.add(panelglucosa);
		panelglucosa.setLayout(new CardLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		panelglucosa.add(panel1, "registro");
		panel1.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(123, 43, 86, 20);
		panel1.add(textField);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(30, 76, 71, 14);
		panel1.add(lblValor);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 74, 86, 20);
		panel1.add(textField_1);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(30, 109, 71, 14);
		panel1.add(lblFecha);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(123, 105, 86, 22);
		panel1.add(comboBox);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 46, 46, 14);
		panel1.add(lblNombre);
		
		JButton btnGuardar = new JButton("Guardar");

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debes ingresar el nombre");
		            return;
				}
				
				if (textField_1.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debes ingresar el valor de la glucosa");
		            return;
				}
				
				try {
		        	int va = 0;
		            va = Integer.parseInt(textField_1.getText());
		        } catch (NumberFormatException cm) {
		            JOptionPane.showMessageDialog(null, "Error: El campo 'Valor' debe ser un número (sin letras ni espacios)"
		            ,"error",JOptionPane.ERROR_MESSAGE);
		            textField_1.setText("");
		            return; 
		        }
		        
		        paciente pacienteNuevo;		        
		        String nom = textField.getText();
		        int val = Integer.parseInt(textField_1.getText());
		        
		        String dia = String.valueOf(comboBox.getSelectedItem());
		        String mes = String.valueOf(comboBoxMes.getSelectedItem());
		        String año = String.valueOf(comboBoxAño.getSelectedItem());
		        String fecha = dia+"/"+mes+"/"+año;
		        
		        pacienteNuevo = new paciente (nom, val, fecha);
		        lista.add(pacienteNuevo);
		        
		        textField.setText("");
		        textField_1.setText("");
		        JOptionPane.showMessageDialog(null, "Registro completado");
			}
		});
		btnGuardar.setBounds(120, 196, 89, 23);
		panel1.add(btnGuardar);
		
		JLabel lblmg = new JLabel("mg/dL");
		lblmg.setBounds(215, 80, 46, 14);
		panel1.add(lblmg);
		

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panelglucosa.getLayout());
				cl.show(panelglucosa, "registro");
			}
		});
		
		toolBar.add(btnRegistrar);
		toolBar.addSeparator();
		
	}
}
