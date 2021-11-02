package edu.curso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LeitorDeNomes {
	private String text = "";
	
	public void escritorDeElementos() {
		String caminho = "text3";// JOptionPane.showInputDialog("Digite o caminho desejado para gravar o arquivo");
		File file = new File("C:/Users//BRUNOFERREIRACARDOSO/desktop/" + caminho + ".txt");
		while(!this.text.equals("sair")) {
			Scanner sc = new Scanner(System.in); 
			this.text = sc.next();
			if(!this.text.equals("sair")) {
				try {
					this.text += "\n";
					FileWriter fWrite = new FileWriter(file, true);
					fWrite.write(this.text);
					fWrite.close();
					this.text = "";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}	
	}

}
