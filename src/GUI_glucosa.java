import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.time.LocalDate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI_glucosa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
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
		
		ArrayList<String> lista = new ArrayList<String>();
		
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
		
		LocalDate h = LocalDate.now();
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setBounds(123, 105, 86, 22);
		comboBox.setSelectedIndex(h.getDayOfMonth()-1);
		panel1.add(comboBox);
		
		JComboBox<Integer> comboBoxMes = new JComboBox<Integer>();
		comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMes.setBounds(218, 105, 86, 22);
		comboBoxMes.setSelectedIndex(h.getMonthValue()-1);
		panel1.add(comboBoxMes);
		
		JComboBox<String> comboBoxAño = new JComboBox<String>();
		comboBoxAño.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboBoxAño.setBounds(314, 105, 86, 22);
		comboBoxAño.setSelectedItem(String.valueOf(h.getYear()));
		panel1.add(comboBoxAño);
	
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 46, 46, 14);
		panel1.add(lblNombre);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
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
		        String fecha = (String) comboBox.getSelectedItem();
				
		        pacienteNuevo = new paciente (nom, val, fecha);
		        lista.add(pacienteNuevo);
		        */
			}
		});
		btnGuardar.setBounds(120, 196, 89, 23);
		panel1.add(btnGuardar);
		
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
