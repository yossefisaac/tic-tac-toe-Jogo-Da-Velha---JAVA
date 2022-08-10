import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);
    private boolean jogador1H = false;
    private boolean jogador2H = false;
        
    public Jogo(){
        tabuleiro = new Tabuleiro();
        iniciarJogadores();
        while( Jogar() );
        
    }
    
    public void iniciarJogadores(){
    	JOptionPane.showMessageDialog(null, "Quem vai ser o Jogador 1 ?");
    	int escolherJogador1 = escolherJogador();
    	
        if(escolherJogador1 == 1) {
        	this.jogador1 = new Humano(1);
        	String nome1 = JOptionPane.showInputDialog("Digite seu nome:");
        	jogador1.setNome(nome1);
        	jogador1H = true;
        }else if(escolherJogador1 == 2)
        	this.jogador1 = new Maquina(1);
        
        else
        	this.jogador1 = new Maquina02(1);
        
         
        
        JOptionPane.showMessageDialog(null, "Quem vai ser o Jogador 2 ?");
        int escolherJogador2 = escolherJogador();
                
        if(escolherJogador2 == 1) {
        	this.jogador2 = new Humano(2);
        	String nome2 = JOptionPane.showInputDialog("Digite seu nome:");
        	jogador2.setNome(nome2);
        	jogador2H = true;
        }else if(escolherJogador2 == 2)
        	this.jogador2 = new Maquina(2);
        else
            this.jogador2 = new Maquina02(2);
        
    }
    
    public int escolherJogador(){
        int opcao=0;
        
        do{
        	opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Humano\n2. Computador nível 1\n3. Computador nível 2\nOpção:"));
            if(opcao != 1 && opcao != 2 && opcao != 3)
            	JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente");
        }while(opcao != 1 && opcao != 2 && opcao != 3);
        
        return opcao;
    }
    
    public boolean Jogar(){
    	
        if(ganhou() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nRodada "+rodada);
         
            if(vez()==1 && jogador1H == true) {
            	JOptionPane.showMessageDialog(null, "É a vez do jogador " + jogador1.getNome());
            	
            	jogador1.jogar(tabuleiro);
            }else if(vez == 1) {
            	System.out.println("É a vez do jogador " + vez() );
            	jogador1.jogar(tabuleiro);
            }else if(vez()!=1 && jogador2H == true) {
            	JOptionPane.showMessageDialog(null, "É a vez do jogador " + jogador2.getNome());
            	jogador2.jogar(tabuleiro);
            }
                  
            else {
            	System.out.println("É a vez do jogador " + vez() );
            	jogador2.jogar(tabuleiro);
            }
            
            if(tabuleiro.matrizCompleto() && ganhou() != -1 && ganhou() != 1){
            	JOptionPane.showMessageDialog(null, "Tabuleiro Completo. Jogo empatado");

                return false;
            }
            vez++;
            rodada++;

            return true;
        } else{
            if(ganhou() == -1 && jogador1H == true) {
            	JOptionPane.showMessageDialog(null, "Jogador "+ jogador1.getNome() +"  ganhou!");
            }else if(ganhou() == -1) {
            	JOptionPane.showMessageDialog(null, "Jogador 1 ganhou!");
            }
            else if (ganhou() != -1 && jogador2H == true) {
            	JOptionPane.showMessageDialog(null, "Jogador "+ jogador2.getNome() +"  ganhou!");
            }
            else {
            	JOptionPane.showMessageDialog(null, "Jogador 2 ganhou!");
            }
            
            return false;
        }
    }
    
    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int ganhou(){
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;
    }   
    
}