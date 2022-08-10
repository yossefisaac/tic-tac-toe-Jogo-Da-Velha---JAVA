import javax.swing.JOptionPane;

public class Maquina02 extends Jogador{
	public Maquina02(int jogador){
        super(jogador);
        JOptionPane.showMessageDialog(null, "Jogador 'Computador' nível 2 criado!");
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
            	//linha
            	tentativa[0] = (int)(Math.random() * 9) + 1;
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                //coluna
                tentativa[1] = (int)(Math.random() * 9) + 1;
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}
