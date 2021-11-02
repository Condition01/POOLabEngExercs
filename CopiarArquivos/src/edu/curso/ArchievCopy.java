package edu.curso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/*Exercício - 4
Faça uma aplicação para copiar arquivos 
textos. Esta aplicação deve perguntar ao 
usuário qual o nome do arquivo de origem 
e o nome do arquivo de destino. 
Utilize o filtro BufferedReader para ler os 
dados do arquivo de origem.
Desafio : Modifique o programa anterior convertendo os 
caracteres lidos abaixo para os respectivos números:
O - 0
I - 1
Z - 2
E - 3
A - 4
S - 5
G - 6
T - 7
B - 8
Gravando o número ao invés da letra no arquivo.*/

public class ArchievCopy {
	public static void main(String[] args) {
		
		List<String> text = new ArrayList<String>();
		File origin = chooseOrigin();
		File destination = chooseDestination();
		text = readFile(origin, text);
		
		printFile(destination, text);
		
		
	}

	public static void printFile(File destination,  List<String> text) {
		try {
			BufferedWriter bfWriter = new BufferedWriter(new FileWriter(destination));
			for(String s: text) {
				bfWriter.write(refactoredLine(s));
			}
			bfWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String refactoredLine(String line) {
		int stop = line.length()-1, i = 0;
		String retorno = "";
	
		while(i <= stop) {
			String append = "";
			append =  getValue(line.charAt(i));
			retorno += append.equals("") ? line.charAt(i) : append;
			i++;
		}
		return retorno;
	}
	
	public static String getValue(char element) {
		int numberArray [] = {0,1,2,3,4,5,6,7,8,9};	
		char characterArray[] = {'O','I','Z','E','A','S','G','T','B'};
		int position = 0;
		for(char letter : characterArray) {
			if(element == letter) {
				return numberArray[position] + "";
			}
			position++;
		}
		return "";
	}

	public static List<String> readFile(File origin, List<String> text) {
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(origin));
			for(String line = bfReader.readLine(); line != null; line = bfReader.readLine()) {
				text.add(line);
			}
			bfReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	

	
	public static File chooseOrigin() {
		String originName = "text1";
		//originName = JOptionPane.showInputDialog("digite o nome do arquivo que deseja acessar no desktop");
		File file = new File("C:/Users//BRUNOFERREIRACARDOSO/desktop/" + originName + ".txt");
		return file;
	}
	
	public static File chooseDestination() {
		String destinationName = "text2";
		//destinationName = JOptionPane.showInputDialog("digite o nome do arquivo que deseja gravar no desktop");
		File file = new File("C:/Users/BRUNOFERREIRACARDOSO/desktop/" + destinationName + ".txt");
		return file;
	}
	
}


