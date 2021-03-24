package Vista.views;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Modelo.vo.AlumnoVO;
import Modelo.vo.CursaVO;
import Modelo.vo.ModuloVO;


public abstract class AlumnosUI {

	private JFrame frame;
	private JTextField nombreTextField;
	private JTextField apellido1TextField;
	private JTextField apellido2TextField;
	private JTextField dniTextField;
	private JLabel lblTelefono;
	private JTextField telefonoTextField;
	private JLabel lblFechaNacimiento;
	private JTextField fechaNacimientoTextField;
	private JTable table;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnEliminar;
	int idModulo;
	private JTextField notaTextField;
	private JLabel lblAnho;
	private JTextField anhoTextField;
	private boolean editando;

	/**
	 * Create the application.
	 */
	public AlumnosUI(int idModulo) {
		this.idModulo = idModulo;
		initialize();
	}

	/**
	 * Muestra el formulario
	 */
	public void show() {
		frame.setVisible(true);
	}

	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(300, 300, 876, 678);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 10, 170, 15);
		frame.getContentPane().add(lblNombre);

		nombreTextField = new JTextField();
		nombreTextField.setBounds(10, 30, 170, 25);
		frame.getContentPane().add(nombreTextField);
		nombreTextField.setColumns(10);

		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(210, 10, 170, 15);
		frame.getContentPane().add(lblPrimerApellido);

		apellido1TextField = new JTextField();
		apellido1TextField .setBounds(210, 30, 170, 25);
		frame.getContentPane().add(apellido1TextField );

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(410, 10, 170, 15);
		frame.getContentPane().add(lblSegundoApellido);

		apellido2TextField  = new JTextField();
		apellido2TextField.setColumns(10);
		apellido2TextField.setBounds(410, 30, 170, 25);
		frame.getContentPane().add(apellido2TextField);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(610, 10, 94, 15);
		frame.getContentPane().add(lblDni);

		dniTextField = new JTextField();
		dniTextField.setBounds(610, 30, 170, 25);
		frame.getContentPane().add(dniTextField);

		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(10, 60, 60, 20);
		frame.getContentPane().add(lblTelefono);

		telefonoTextField = new JTextField();
		telefonoTextField .setBounds(10, 80, 170, 25);
		frame.getContentPane().add(telefonoTextField );
		telefonoTextField .setColumns(10);

		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(210, 60, 170, 20);
		frame.getContentPane().add(lblFechaNacimiento);

		fechaNacimientoTextField= new JTextField();
		fechaNacimientoTextField.setBounds(210, 80, 170, 25);
		frame.getContentPane().add(fechaNacimientoTextField);
		fechaNacimientoTextField.setColumns(10);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(10, 110, 70, 20);
		frame.getContentPane().add(lblNota);
		
		notaTextField = new JTextField();
		notaTextField.setBounds(10, 130, 70, 25);
		frame.getContentPane().add(notaTextField);
		notaTextField.setColumns(10);
		
		lblAnho = new JLabel("A\u00F1o");
		lblAnho.setBounds(100, 110, 70, 20);
		frame.getContentPane().add(lblAnho);
		
		anhoTextField = new JTextField();
		anhoTextField.setBounds(100, 130, 70, 25);
		frame.getContentPane().add(anhoTextField);
		anhoTextField.setColumns(10);

		btnGuardar = new JButton("Añadir");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String nombre= nombreTextField.getText();
				String apellido1 = apellido1TextField.getText();
				String apellido2 = apellido2TextField.getText();
				String dni = dniTextField.getText();
				int telefono = Integer.parseInt(telefonoTextField.getText());
//				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//				Date fechaNacimiento = format.parse(fechaNacimientoTextField.getText());
				double nota= Double.parseDouble(notaTextField.getText());
				int anho= Integer.parseInt(anhoTextField.getText());
				
				int cantidad = 0;
				if (nombre.equals("") || apellido1.equals("") || apellido2.equals("")
						|| dni.equals("") || dniTextField.getText().equals("") || telefonoTextField.getText().equals("")
						 || fechaNacimientoTextField.getText().equals("") || notaTextField.getText().equals("") || anhoTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(btnGuardar, "Campos vacíos");
					return;
				}

				if (nombre.length() > 10) {
					JOptionPane.showMessageDialog(btnGuardar, "El nombre no puede tener más de 20 caracteres");
				}
				if (apellido1.length() > 50) {
					JOptionPane.showMessageDialog(btnGuardar, "El primer apellido no puede tener más de 20 caracteres");
				}
				if (apellido2.length() > 200) {
					JOptionPane.showMessageDialog(btnGuardar, "El segundo apellido no puede tener más de 20 caracteres");
				}
				if (dni.length() > 200) {
					JOptionPane.showMessageDialog(btnGuardar, "El dni no puede tener más de 9 caracteres");
				}

				if (telefonoTextField.getText().equals("0")) {
					System.out.println("Error, el valor del teléfono no puede ser 0.");
					JOptionPane.showMessageDialog(btnGuardar, "El valor del número de teléfono no puede ser 0", "Advertencia",
							0);
					return;
				}
				if (notaTextField.getText().equals("0")) {
					System.out.println("Error, el valor de la nota no puede ser 0.");
					JOptionPane.showMessageDialog(btnGuardar, "El valor de la nota no puede ser 0", "Advertencia", 0);
					return;
				}
//
//				try {
//					cantidad = Integer.parseInt(cantidadTextField.getText());
//					int cifras = 0;// esta variable es el contador de cifras
//					while (cantidad != 0) {// mientras a n le queden cifras
//						cantidad = cantidad / 10;// le quitamos el último dígito
//						cifras++; // sumamos 1 al contador de cifras
//					}
//					if (cifras > 4) {
//						JOptionPane.showMessageDialog(btnGuardar,
//								"El valor de la cantidad no puede tener más de 4 dígitos");
//						return;
//					}
//
//				} catch (NumberFormatException e) {
//					System.out.println("Error, el valor de la cantidad introducido no es un digito.");
//					JOptionPane.showMessageDialog(btnGuardar, "El valor de la cantidad introducido no es un dígito",
//							"Advertencia", 0);
//					return;
//				}
				
				if(dniTextField==null) {
					System.out.println("El campo del dni está vacío.");
				}
				if (editando) { 
					try {
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaNacimiento = format.parse(fechaNacimientoTextField.getText());

						editarAlumno(dniTextField.getText(), nombreTextField.getText(), apellido1TextField.getText(),
								apellido2TextField.getText(), Integer.parseInt(telefonoTextField.getText()), fechaNacimiento);
						editarCursa(anhoTextField.getText(), Float.parseFloat(notaTextField.getText()),
								dniTextField.getText(), idModulo);
						clearFields();
						recargarTabla();
						dniTextField.setEditable(true);

					} catch (NumberFormatException e) {
						System.out.println("Error, el valor introducido no es un dígito.");
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Error, el valor introducido no es válido.");
						e.printStackTrace();
					}
					
				} 
				if(!editando && dniTextField != null) {

					try {
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaNacimiento = format.parse(fechaNacimientoTextField.getText());

						agregarAlumno(dniTextField.getText(), nombreTextField.getText(), apellido1TextField.getText(),
								apellido2TextField.getText(), Integer.parseInt(telefonoTextField.getText()), fechaNacimiento);
						agregarCursa(anhoTextField.getText(), Float.parseFloat(notaTextField.getText()),
								dniTextField.getText(), idModulo);
						clearFields();
						recargarTabla();
						dniTextField.setEditable(true);

					} catch (NumberFormatException e) {
						System.out.println("Error, el valor introducido no es un digito.");
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Error, el valor introducido no es valido.");
						e.printStackTrace();
					}
				} 
			}
		});
		btnGuardar.setBounds(210, 130, 90, 25);
		frame.getContentPane().add(btnGuardar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clearFields();
				dniTextField.setEditable(true);
				editando=false;
			}

		});
		btnLimpiar.setBounds(310, 130, 90, 25);
		frame.getContentPane().add(btnLimpiar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(410,130,90,25);
		btnEliminar.setEnabled(false);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (dniTextField.getText() != null) { 
					int dialogoeliminar = JOptionPane.showConfirmDialog(null,
							"El alumno " + nombreTextField.getText() + " se eliminará de forma permanente", "Eliminar",
							JOptionPane.OK_CANCEL_OPTION);
					if (dialogoeliminar == JOptionPane.OK_OPTION) {
						eliminarAlumno(dniTextField.getText());
						eliminarCursa(idModulo, dniTextField.getText());
						clearFields();
						recargarTabla();
					}
				}
			}
		});
		frame.getContentPane().add(btnEliminar);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 170, 850, 2);
		frame.getContentPane().add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 845, 287);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
	
	      
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEliminar.setEnabled(true);
				btnGuardar.setText("Guardar");
				editando=true;
				dniTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 0));
				dniTextField.setEditable(false);
				nombreTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 1));
				apellido1TextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 2));
				apellido2TextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 3));
				telefonoTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 4));
				fechaNacimientoTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 5));
				notaTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 6));
				anhoTextField.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 7));

			}
		});
		scrollPane.setViewportView(table);
		
		recargarTabla();
		
		

	}

	private void recargarTabla() {
		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("Dni");
		tm.addColumn("Nombre");
		tm.addColumn("Primer Apellido");
		tm.addColumn("Segundo Apellido");
		tm.addColumn("Teléfono");
		tm.addColumn("Fecha Nacimiento");
		tm.addColumn("Nota");
		tm.addColumn("Año");

		for (AlumnoVO alumno : transformarListaVO()) {
			for (CursaVO cursa : listarCursa()) {
				if (alumno.getDni().equals(cursa.getDni()) && idModulo == cursa.getIdModulo()) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					String fechaNacimiento = sdf.format(alumno.getFechaNacimiento());
					tm.addRow(new String[] { alumno.getDni(), alumno.getNombre(), alumno.getApellido1(),
							alumno.getApellido2(), String.valueOf(alumno.getTelefono()), fechaNacimiento, String.valueOf(cursa.getNota()), cursa.getAnho()});
				}
			}

		}

		table.setModel(tm);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}



	private void clearFields() {
		btnEliminar.setEnabled(false);
		btnGuardar.setText("Añadir");
		dniTextField.setText("");
		nombreTextField.setText("");
		apellido1TextField.setText("");
		apellido2TextField.setText("");
		telefonoTextField.setText("");
		fechaNacimientoTextField.setText("");
		notaTextField.setText("");
		anhoTextField.setText("");
		table.clearSelection();
	}

	protected abstract void agregarAlumno(String dni, String nombre, String apellido1, String apellido2, int telefono,
			Date fechaNacimiento);

	
	protected abstract void editarAlumno(String dni, String nombre, String apellido1, String apellido2, int telefono,
			Date fechaNacimiento);

	protected abstract void eliminarAlumno(String dni);
	
	protected abstract void eliminarCursa(int idModulo2, String text);

	protected abstract void agregarCursa(String text, float parseFloat, String text2, int idModulo2);

	protected abstract void editarCursa(String text, float parseFloat, String text2, int idModulo2);
	
	protected abstract List<AlumnoVO> transformarListaVO();
	protected abstract List<CursaVO> listarCursa();
}
