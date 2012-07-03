package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import sistema.Sistema;
import beans.ItemStock;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UpdateStockRodamiento extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel10;
	private JTextField tbEst;
	private JTextField tbUltima;
	private JTextField tbMarca;
	private JTextField tbPV;
	private JTextField tbPC;
	private JTextField tbCantidad;
	private JTextField tbSufijo;
	private JTextField tbOrigen;
	private JTextField jTextField4;
	private JButton jButton1;
	private JTextField tbCodigo;
	private JTextField tbNroSerie;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel55;
	private JTextField nroItemStock;
	private JButton btEliminar;	
	private JLabel jlb1;
	private JLabel jlb2;	
	private JPanel tbStep1;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UpdateStockRodamiento inst = new UpdateStockRodamiento();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private static UpdateStockRodamiento instancia;
	
	public static UpdateStockRodamiento getInstancia()
	{
		if (instancia == null)
			instancia = new UpdateStockRodamiento();
		return instancia;
	}		
	
	public UpdateStockRodamiento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			tbStep1 = new JPanel();
			getContentPane().add(tbStep1);
			//tbStep1.setLayout(tbStep1Layout);
			tbStep1.setBounds(12, 12, 486, 477);
			tbStep1.setLayout(null);			
			
			getContentPane().setLayout(null);
			{
				jLabel55 = new JLabel();
				tbStep1.add(jLabel55);
				jLabel55.setText("Nro Item de Stock");
				jLabel55.setBounds(40, 49, 138, 16);
			}
			{
				nroItemStock = new JTextField();
				tbStep1.add(nroItemStock);
				nroItemStock.setBounds(178, 46, 132, 23);
			}
			{
				btEliminar = new JButton();
				tbStep1.add(btEliminar);
				btEliminar.setText("Buscar");
				btEliminar.setBounds(249, 100, 57, 23);
				btEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						ItemStock i = Sistema.getSistema().ItemStock_Modificacion_Inicio(Integer.parseInt(nroItemStock.getText()));
						if(i != null){
							step1(i);
						}
					}
				});						
			}
			pack();			
			this.setSize(486, 477);
			step0();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void step0(){
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();			
			this.setSize(486, 477);
			//step1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void step1(ItemStock i){
		try {
			tbStep1.setVisible(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Codigo");
				jLabel1.setBounds(36, 67, 39, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Marca");
				jLabel2.setBounds(36, 106, 33, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Numero Serie");
				jLabel3.setBounds(36, 30, 72, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Origen");
				jLabel4.setBounds(36, 139, 36, 16);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Sufijo");
				jLabel5.setBounds(37, 176, 30, 16);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Cantidad");
				jLabel6.setBounds(36, 208, 48, 16);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Precio Compra");
				jLabel7.setBounds(37, 245, 123, 16);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("Precio Venta");
				jLabel8.setBounds(37, 280, 123, 16);
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("Ultima Actualizacion");
				jLabel9.setBounds(37, 318, 123, 16);
			}
			
			{
				jlb1 = new JLabel();
				getContentPane().add(jlb1);
				jlb1.setText(String.valueOf(i.getId()));
				jlb1.setBounds(37, 318, 123, 16);
				jlb1.setVisible(false);
			}			
			{
				jlb2 = new JLabel();
				getContentPane().add(jlb2);
				jlb2.setText(String.valueOf(i.getRodamiento().getId()));
				jlb2.setBounds(37, 318, 123, 16);
				jlb2.setVisible(false);
			}				
			
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Guardar");
				jButton1.setBounds(340, 391, 56, 23);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						Date d = null;
						try {
							d = df.parse(tbUltima.getText());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Boolean i = Sistema.getSistema().ItemStock_Modificacion_Confirmacion(Integer.parseInt(jlb2.getText()), tbCodigo.getText(), tbMarca.getText(), tbNroSerie.getText(), tbOrigen.getText(), tbSufijo.getText(), Integer.parseInt(jlb1.getText()), Integer.parseInt(tbCantidad.getText()), tbEst.getText(), Float.parseFloat(tbPC.getText()), Float.parseFloat(tbPV.getText()), d);	
						if(i){
							cerrar();
						}
					}
				});						
			}
			{
				tbNroSerie = new JTextField();
				getContentPane().add(tbNroSerie);
				tbNroSerie.setText(i.getRodamiento().getNroSerie());
				tbNroSerie.setBounds(199, 27, 193, 23);
			}
			{
				tbCodigo = new JTextField();
				getContentPane().add(tbCodigo);
				tbCodigo.setText(i.getRodamiento().getCodigo());
				tbCodigo.setBounds(200, 67, 193, 23);
			}

			{
				tbOrigen = new JTextField();
				getContentPane().add(tbOrigen);
				tbOrigen.setText(i.getRodamiento().getOrigen());					
				tbOrigen.setBounds(200, 136, 193, 23);
			}
			{
				tbSufijo = new JTextField();
				getContentPane().add(tbSufijo);
				tbSufijo.setText(i.getRodamiento().getSufijo());					
				tbSufijo.setBounds(199, 173, 193, 23);
			}
			{
				tbCantidad = new JTextField();
				getContentPane().add(tbCantidad);
				tbCantidad.setText(String.valueOf(i.getCantidad()));						
				tbCantidad.setBounds(200, 205, 193, 23);
			}
			{
				tbPC = new JTextField();
				getContentPane().add(tbPC);
				tbPC.setText(String.valueOf(i.getPrecioCosto()));						
				tbPC.setBounds(199, 242, 193, 23);
			}
			{
				tbPV = new JTextField();
				getContentPane().add(tbPV);
				tbPV.setText(String.valueOf(i.getPrecioVenta()));				
				tbPV.setBounds(200, 277, 193, 23);
			}
			{
				tbMarca = new JTextField();
				getContentPane().add(tbMarca);
				tbMarca.setText(i.getRodamiento().getMarca());					
				tbMarca.setBounds(199, 101, 193, 23);
			}
			{
				tbUltima = new JTextField();
				getContentPane().add(tbUltima);
				tbUltima.setText(i.getUltimaActualizacion().toString());						
				tbUltima.setBounds(200, 312, 193, 23);
			}
			{
				tbEst = new JTextField();
				getContentPane().add(tbEst);
				tbEst.setText(i.getEstado());					
				tbEst.setBounds(200, 353, 193, 23);
			}
			{
				jLabel10 = new JLabel();
				getContentPane().add(jLabel10);
				jLabel10.setText("Estado");
				jLabel10.setBounds(37, 357, 123, 16);
			}
			pack();
			this.setSize(486, 477);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void step2(){
		
	}
	
	private void cerrar(){
		instancia = null;
		this.dispose();
	}

}
