package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PedidoController;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class TelaPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPreco;
	private JComboBox<String>comboBox;
	private JTextArea textModificacoes;
	private JRadioButton rdbtnPequena;
	private JRadioButton rdbtnMedia;
	private JRadioButton rdbtnGrande;
	private JCheckBox chckbxBordaRecheada;
	private JButton btnEmitir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //tread que inicializa o frame
			public void run() {
				try {
					TelaPedido frame = new TelaPedido();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPedido() { //construtor
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPizzas = new JLabel("Pizzas");
		lblPizzas.setBounds(10, 11, 46, 14);
		contentPane.add(lblPizzas);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(66, 8, 448, 20);
		contentPane.add(comboBox);
		
		comboBox.addItem("Muçarela");
		comboBox.addItem("Calabresa");
		comboBox.addItem("Napolitana");
		
		JLabel lblModificaes = new JLabel("Modifica\u00E7\u00F5es");
		lblModificaes.setBounds(10, 51, 86, 14);
		contentPane.add(lblModificaes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 76, 504, 87);
		contentPane.add(scrollPane);
		
		textModificacoes = new JTextArea();
		scrollPane.setViewportView(textModificacoes);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(10, 180, 46, 14);
		contentPane.add(lblPreo);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(62, 177, 86, 20);
		contentPane.add(tfPreco);
		tfPreco.setColumns(10);
		
		rdbtnPequena = new JRadioButton("PeqSuena");
		rdbtnPequena.setBounds(10, 214, 109, 23);
		contentPane.add(rdbtnPequena);
		
		rdbtnMedia = new JRadioButton("M\u00E9dia");
		rdbtnMedia.setBounds(10, 240, 109, 23);
		contentPane.add(rdbtnMedia);
		
		rdbtnGrande = new JRadioButton("Grande");
		rdbtnGrande.setBounds(10, 266, 109, 23);
		contentPane.add(rdbtnGrande);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnPequena);
		bg.add(rdbtnMedia);
		bg.add(rdbtnGrande);
		rdbtnGrande.setSelected(true);
		
		chckbxBordaRecheada = new JCheckBox("Borda Recheada");
		chckbxBordaRecheada.setBounds(10, 293, 109, 23);
		contentPane.add(chckbxBordaRecheada);
		
		btnEmitir = new JButton("Emitir");
		btnEmitir.setBounds(340, 227, 89, 23);
		contentPane.add(btnEmitir);
		
		PedidoController pedController = new PedidoController(comboBox, textModificacoes, 
				tfPreco, rdbtnPequena, rdbtnMedia, rdbtnGrande, chckbxBordaRecheada);
		btnEmitir.addActionListener(pedController);
	}
}
