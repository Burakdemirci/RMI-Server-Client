/**
 *  
 * @author Burak Demirci
 * @id 141044091
 */
package Part2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;

public class ClientGUI {

	private JFrame frame;
	private JTextField City1;
	private JTextField City2;
	private JTextField Distance;
	private static Graph g;
	private static ServerInterface server;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
					Registry registry = LocateRegistry.getRegistry("localhost");
			        server = (ServerInterface) registry.lookup("Server");   
			         g = new Graph(100);
			        
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		City1 = new JTextField();
		City1.setBounds(10, 31, 86, 20);
		frame.getContentPane().add(City1);
		City1.setColumns(10);
		
		City2 = new JTextField();
		City2.setBounds(106, 31, 86, 20);
		frame.getContentPane().add(City2);
		City2.setColumns(10);
		
		Distance = new JTextField();
		Distance.setBounds(202, 31, 86, 20);
		frame.getContentPane().add(Distance);
		Distance.setColumns(10);
		
		
		JLabel lblCity = new JLabel("City 1");
		lblCity.setBounds(24, 11, 46, 14);
		frame.getContentPane().add(lblCity);
		
		JLabel lblCity_1 = new JLabel("City 2");
		lblCity_1.setBounds(127, 11, 46, 14);
		frame.getContentPane().add(lblCity_1);
		
		JLabel lblDistance = new JLabel("Distance");
		lblDistance.setBounds(218, 11, 70, 14);
		frame.getContentPane().add(lblDistance);
		
		JTextArea graphShow = new JTextArea();
		graphShow.setBounds(343, 108, 270, 250);
		frame.getContentPane().add(graphShow);
		
		JLabel lblGraph = new JLabel("GRAPH");
		lblGraph.setBounds(462, 83, 46, 14);
		frame.getContentPane().add(lblGraph);
		
		JTextArea outext = new JTextArea();
		outext.setBounds(10, 140, 293, 218);
		frame.getContentPane().add(outext);
		
		JLabel lblOutput = new JLabel("OUTPUT");
		lblOutput.setBounds(106, 115, 67, 14);
		frame.getContentPane().add(lblOutput);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.addEdge(City1.getText(),City2.getText(),Integer.parseInt(Distance.getText()));
				graphShow.setText(g.toString());
				City1.setText("");
				City2.setText("");
				Distance.setText("");
			}
		});
		btnAdd.setBounds(298, 30, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnMst = new JButton("MST");
		btnMst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					outext.setText("MST:\n"+server.sentGraph(g,"MST"));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMst.setBounds(10, 79, 89, 23);
		frame.getContentPane().add(btnMst);
		

		JButton btnImatrix = new JButton("IMatrix");
		btnImatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					outext.setText("IMatrix:\n"+server.sentGraph(g,"IMatrix"));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnImatrix.setBounds(155, 79, 89, 23);
		frame.getContentPane().add(btnImatrix);
		
	}
}
