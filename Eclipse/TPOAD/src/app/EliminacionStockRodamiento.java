package app;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
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
public class EliminacionStockRodamiento extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField nroItemStock;
	private JButton btEliminar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EliminacionStockRodamiento inst = new EliminacionStockRodamiento();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private static EliminacionStockRodamiento instancia;
	
	public static EliminacionStockRodamiento getInstancia()
	{
		if (instancia == null)
			instancia = new EliminacionStockRodamiento();
		return instancia;
	}		
	
	public EliminacionStockRodamiento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nro Item de Stock");
				jLabel1.setBounds(40, 49, 138, 16);
			}
			{
				nroItemStock = new JTextField();
				getContentPane().add(nroItemStock);
				nroItemStock.setBounds(178, 46, 132, 23);
			}
			{
				btEliminar = new JButton();
				getContentPane().add(btEliminar);
				btEliminar.setText("Eliminar");
				btEliminar.setBounds(251, 100, 57, 23);
				btEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						ItemStock i = Sistema.getSistema().ItemStock_Eliminacion_Inicio(Integer.parseInt(nroItemStock.getText()));
						if(i != null){
							Boolean b = Sistema.getSistema().ItemStock_Eliminacion_Confirmacion(Integer.parseInt(nroItemStock.getText()));
							if(b){
								cerrar();
							}
						}
					}
				});						
			}
			pack();
			this.setSize(405, 346);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cerrar(){
		instancia = null;
		this.dispose();
	}	

}
