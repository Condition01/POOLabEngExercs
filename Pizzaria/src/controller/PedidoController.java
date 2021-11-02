package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Pizza;

public class PedidoController implements ActionListener{

	private JComboBox<String> comboxBox;
	private JTextArea taModificacoes;
	private JTextField tfPreco;
	private JRadioButton rdbtnPequena, rdbtnMedia, rdbtnGrande;
	private JCheckBox chkbxBordaRecheada;
	
	public PedidoController(JComboBox<String> comboxBox, JTextArea taModificacoes,
			JTextField tfPreco,JRadioButton rdbtnPequena, JRadioButton rdbtnMedia,
			JRadioButton rdbtnGrande, JCheckBox chkbxBordaRecheada) {
		this.comboxBox = comboxBox;
		this.taModificacoes = taModificacoes;
		this.tfPreco = tfPreco;
		this.rdbtnPequena = rdbtnPequena;
		this.rdbtnMedia = rdbtnMedia;
		this.rdbtnGrande = rdbtnGrande;
		this.chkbxBordaRecheada = chkbxBordaRecheada;
	}
	
	public boolean validaTela() { //metodo pra ver se os campos foram preenchidos corretamente
		boolean valide = true;
		if(tfPreco.getText().trim().equals("")) { //metodo trim tira os espaços e o equal ve se esta vazio
			JOptionPane.showMessageDialog(null, "Preencha o valor ", "ERRO", JOptionPane.ERROR_MESSAGE);
			valide = false;
		}
		return valide;
	}
	public void recebePedido() { //vai fazer o pedido e criar o objeto <- usando a classe do model\pizza que recebe as informações do JFrame
		Pizza p = new Pizza();
		p.setBordaRecheada(chkbxBordaRecheada.isSelected()); //se estiver selecionado retorna true ou false;
		p.setModificações(taModificacoes.getText());
		p.setNome(comboxBox.getSelectedItem().toString()); //o iten é object então fazer o to.String porque a variavel da classe recebe uma String
		try { // como o objeto pega umaa string, ele vai tentar a conversão do preço do objeto, se não der, vai mandar um error message pro cara.
			p.setPreço(Double.parseDouble(tfPreco.getText()));
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Preço deve ser numérico com 2 casas decimais", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		String tipo = "";
		if(rdbtnPequena.isSelected()) { //joga o tipo na variavel tipo do objeto criado(class model\pizza)
			tipo = rdbtnPequena.getText();
		}else if(rdbtnMedia.isSelected()) {
			tipo = rdbtnMedia.getText();
		}
		else {
			tipo = rdbtnGrande.getText(); //recebe o texto da caixinha selecionada, funciona pra todos os getText
		}
		p.setTipo(tipo);
		//printa os resultados usando o objeto.
		StringBuffer sb = new StringBuffer();
		sb.append(p.getNome());
		sb.append(" - ");
		sb.append(p.getTipo());
		sb.append("\n");
		sb.append(p.getModificações());
		sb.append("\n");
		if(p.isBordaRecheada()) {
			sb.append("Com Borda Recheada");
			sb.append("\n");
		}
		sb.append("Valor : R$");
		sb.append(p.getPreço());
		JOptionPane.showMessageDialog(null, sb.toString(), "Pedido", JOptionPane.INFORMATION_MESSAGE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean valido = validaTela();
		if(valido) {
			recebePedido();
		}
		
	}

}
