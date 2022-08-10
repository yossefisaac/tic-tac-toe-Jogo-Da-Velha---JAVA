import java.util.Scanner;

import javax.swing.JOptionPane;

public class Humano extends Jogador{
    public Scanner entrada = new Scanner(System.in);
    
    
    public Humano(int jogador){
        super(jogador);
        this.jogador = jogador;
        JOptionPane.showMessageDialog(null, "Jogador 'Humano' criado!");
    }
    

	@Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        do{
            do{
            	int linha =Integer.parseInt(JOptionPane.showInputDialog(null, "Linha:"));
                tentativa[0] = linha;
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                	JOptionPane.showMessageDialog(null, "Linha inválida. É 1, 2 ou 3");
                   
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
            	int coluna =Integer.parseInt(JOptionPane.showInputDialog(null, "Coluna:"));
                tentativa[1] = coluna;
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                	JOptionPane.showMessageDialog(null, "Coluna inválida. É 1, 2 ou 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
            	JOptionPane.showMessageDialog(null, "Esse local já foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}	