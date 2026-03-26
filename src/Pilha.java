public class Pilha<T> {

    private static final int STACK_SIZE = 100;
    private T[] element; // Vetor que armazena os elementos da pilha
    private int top;     // Índice do topo da pilha

    @SuppressWarnings("unchecked") // Ignora aviso de cast genérico
    public Pilha(int len){
        element = (T[]) new Object[len];
        top = -1;
    }

    // Construtor padrão com tamanho fixo
    public Pilha(){
        this(STACK_SIZE);
    }

    // Insere um elemento no topo da pilha
    public void push(T value){
        if (isFull()){
            throw new RuntimeException("Stack is full");
        }
        element[++top] = value;
    }

    // Remove e retorna o elemento do topo
    public T pop(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return element[top--];
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty(){
        return top < 0;
    }

    // Verifica se a pilha está cheia
    public boolean isFull(){
        return top == element.length - 1;
    }

    // Retorna o elemento do topo sem remover
    public T peek(){
        if(top == -1){
            throw new RuntimeException("Stack is empty");
        }
        return element[top];
    }

    // Retorna a quantidade de elementos na pilha
    public int size(){
        return top + 1;
    }

    // Esvazia a pilha
    public void clear(){
        top = -1;
    }

    // Retorna o elemento em uma posição específica
    T getElement(int index){
        if (index >= 0 && index <= top) {
            return element[index];
        }
        throw new IndexOutOfBoundsException("Índice fora dos limites da pilha");
    }
}