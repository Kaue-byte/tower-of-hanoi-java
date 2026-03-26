class Torre{
    private Pilha<Disco> pilha;


    public Torre(){
        pilha = new Pilha();
    }
    
    Disco retirar(){
        if (Empty()){
            throw new RuntimeException("Torre vazia");
        }
        return pilha.pop();
    }
    void adicionar(Disco disco){
        if(!Empty() && disco.getDisco() > pilha.peek().getDisco()){
            throw new RuntimeException("Disco invalido");
        }
        pilha.push(disco);
    }
    
    int getsize(){
        return pilha.size();
    }
    
    boolean Empty(){
        return (pilha.size() == 0);
    }
    
    Disco getPos(int index){
        return pilha.getElement(index);
    }

    void Clear(){
        pilha.clear();
    }
    
}