public class Tabuleiro {
    private int[][] matriz= new int[3][3]; 
    
    public void zerarMatriz(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                matriz[linha][coluna]=0;
    }
    
    public Tabuleiro(){
        zerarMatriz();
    }  
    
    public void exibirMatriz(){
        System.out.println();
        for(int linha=0 ; linha<3 ; linha++){
        
            for(int coluna=0 ; coluna<3 ; coluna++){
                
                if(matriz[linha][coluna]==-1){
                    System.out.print(" X ");
                }
                if(matriz[linha][coluna]==1){
                    System.out.print(" O ");
                }
                if(matriz[linha][coluna]==0){
                    System.out.print("   ");
                }
                
                if(coluna==0 || coluna==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }

    public int getPosicao(int[] tentativa){
        return matriz[tentativa[0]][tentativa[1]];
    }

    
    public void setPosicao(int[] tentativa, int jogador){  
        if(jogador == 1)
            matriz[tentativa[0]][tentativa[1]] = -1;
        else
            matriz[tentativa[0]][tentativa[1]] = 1;
        
        exibirMatriz();
    }

    public int checaLinhas(){
        for(int linha=0 ; linha<3 ; linha++){

            if( (matriz[linha][0] + matriz[linha][1] + matriz[linha][2]) == -3)
                return -1;
            if( (matriz[linha][0] + matriz[linha][1] + matriz[linha][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checaColunas(){
        for(int coluna=0 ; coluna<3 ; coluna++){

            if( (matriz[0][coluna] + matriz[1][coluna] + matriz[2][coluna]) == -3)
                return -1;
            if( (matriz[0][coluna] + matriz[1][coluna] + matriz[2][coluna]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checaDiagonais(){
        if( (matriz[0][0] + matriz[1][1] + matriz[2][2]) == -3)
            return -1;
        if( (matriz[0][0] + matriz[1][1] + matriz[2][2]) == 3)
            return 1;
        if( (matriz[0][2] + matriz[1][1] + matriz[2][0]) == -3)
            return -1;
        if( (matriz[0][2] + matriz[1][1] + matriz[2][0]) == 3)
            return 1;
        
        return 0;
    }

    public boolean matrizCompleto(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                if( matriz[linha][coluna]==0 )
                    return false;
        return true;
    }
}