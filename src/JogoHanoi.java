class JogoHanoi{

    private Torre[] torre;   // Vetor contendo as 3 torres do jogo
    private int quant_disc;  // Quantidade total de discos

    public JogoHanoi(int value){
        torre = new Torre[3];

        // Cria as três torres
        for(int i = 0; i < 3; i++){
            torre[i] = new Torre();
        }

        quant_disc = value;
    }

    // Inicializa o jogo colocando todos os discos na torre 0
    void setTorre(){
        for(int i = quant_disc; i > 0; i--){
            Disco disco = new Disco(i);
            torre[0].adicionar(disco);
        }
    }

    // Move o disco do topo da torre origem para a torre destino
    void move(int ts,int te){
        if(ts == te){
            throw new RuntimeException("Valores iguais");
        }
        torre[te].adicionar(torre[ts].retirar());
    }

    // Verifica se todos os discos foram movidos para a última torre
    boolean endGame(){
        return (torre[2].getsize() == quant_disc);
    }

    // Limpa todas as torres
    void restart(){
        for(int i = 0; i < 3; i++){
            torre[i].Clear();
        }
    }

    // Exibe graficamente o estado atual das torres
    void exibir(){

        int altura = quant_disc;   // Altura máxima de impressão
        int largura = quant_disc;  // Largura usada para alinhamento

        // Percorre as linhas de cima para baixo
        for(int linha = altura - 1; linha >= 0; linha--){

            // Percorre cada torre
            for(int t = 0; t < 3; t++){

                // Verifica se existe disco nessa posição
                if(linha < torre[t].getsize()){

                    Disco d = torre[t].getPos(linha);
                    int tam = d.getDisco();

                    int espacos = largura - tam;

                    // Centraliza o disco visualmente
                    System.out.print(" ".repeat(espacos));
                    System.out.print("*".repeat(tam));
                    System.out.print(" ".repeat(espacos));

                }else{
                    // Espaço vazio quando não há disco
                    System.out.print(" ".repeat(largura * 2));
                }

                System.out.print("   ");
            }

            System.out.println();
        }

        // Identificação das torres
        System.out.println("T0      T1      T2");
    }
}