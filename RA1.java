class Fila {
    int primeiro;
    int ultimo;
    int []dados;
    int capacidade_atual;
    int tamanho;

    public Fila(int tamanho){
        this.tamanho = tamanho;
        this.primeiro = 0;
        this.ultimo = -1;
        this.capacidade_atual = 0;
        this.dados = new int[tamanho];
    }

    public static boolean Cheia(Fila x){
        if(x.tamanho == x.capacidade_atual){
            return true;
        }else{
            return false;
        }
    }

    public static boolean Vazia(Fila x){
        if(x.capacidade_atual == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void Inserir(Fila x, int y){
        if (Cheia(x)) {
            System.out.println("Esta cheio");

        }else {
            x.ultimo = x.ultimo + 1;
            if(x.ultimo == x.tamanho){
                x.ultimo = 0;
            }
            x.dados[x.ultimo] = y;
            x.capacidade_atual = x.capacidade_atual + 1;
            System.out.println("Inserido: " + y);

        }
    }

    public static void Remover(Fila x){
        if(Vazia(x)){
            System.out.println("Não há nenhum item a remover");
        }else{
            int valorRemovido = x.dados[x.primeiro];
            x.primeiro = x.primeiro + 1;
            if(x.primeiro == x.tamanho){
                x.primeiro = 0;
            }
            x.capacidade_atual = x.capacidade_atual - 1;
            System.out.println("Valor removido: " + valorRemovido);
        }
    }


    void imprime(Fila x) {
        if (Vazia(x)) {
            System.out.println("Fila vazia.");
        } else {
            System.out.print("Fila (do primeiro para o ultimo): ");
            int indice = primeiro;
            int contador = 0;
            while (contador < capacidade_atual) {
                System.out.print(dados[indice] + " ");
                indice = indice + 1;

                if (indice == tamanho) {
                    indice = 0;
                }
                contador = contador + 1;
            }
            System.out.println();
        }
    }
    public static int Primeiro(Fila x){
        return x.dados[x.primeiro];
    }

    public static int Ultimo(Fila x){
        return x.dados[x.ultimo];
    }

    public static Fila Merge(Fila x, Fila y) {
        Fila R = new Fila(x.capacidade_atual + y.capacidade_atual);

        while(!Vazia(x) && !Vazia(y)){
            if(Primeiro(x) <= Primeiro(y)){
                Inserir(R,Primeiro(x));
                Remover(x);
            }else{
                Inserir(R,Primeiro(y));
                Remover(y);
            }
        }
        while (!Vazia(x)) {
            Inserir(R, Primeiro(x));
            Remover(x);
        }
        while (!Vazia(y)) {
            Inserir(R, Primeiro(y));
            Remover(y);
        }
        return R;
    }
}

public class RA1 {
    public static void main(String[] args) {
        Fila A = new Fila(4);
        Fila B = new Fila(5);

        Fila.Inserir(A, 12);
        Fila.Inserir(A, 35);
        Fila.Inserir(A, 52);
        Fila.Inserir(A, 64);

        Fila.Inserir(B, 5);
        Fila.Inserir(B, 15);
        Fila.Inserir(B, 23);
        Fila.Inserir(B, 55);
        Fila.Inserir(B, 75);

        System.out.println("Fila A");
        A.imprime(A);
        System.out.println();
        System.out.println("Fila B");
        B.imprime(B);
        System.out.println();
        System.out.println("Fila C");
        System.out.println();

        Fila C = Fila.Merge(A, B);

        System.out.println("        ↓");
        System.out.println();
        System.out.println("Fila A");
        A.imprime(A);
        System.out.println();
        System.out.println("Fila B");
        B.imprime(B);
        System.out.println();
        System.out.println("Fila C");
        C.imprime(C);
    }
}
