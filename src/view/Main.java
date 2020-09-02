package view;
import controller.ProcessosOs;
import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		ProcessosOs Processos = new ProcessosOs();	
		Processos.lerProcessos(Processos.retornaOs());
		Processos.finalProcessoNome(JOptionPane.showInputDialog("Digite o nome do processo para ser exclu�do"), Processos.retornaOs());
		Processos.finalProcessoPID(JOptionPane.showInputDialog("Digite o PID do processo para ser exclu�do"), Processos.retornaOs());
	}

}
