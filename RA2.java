import java.util.Scanner;

class Node {
    private String letra;
    private Node esquerda;
    private Node direita;

    public Node(String letra) {
        this.letra = letra;
        this.esquerda = null;
        this.direita = null;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }
}

class Arvorebinaria {
    private Node raiz;

    public Arvorebinaria() {
        raiz = new Node(null);
    }

    public void Inserir(String morse, String letra) {
        Node atual = raiz;

        for (int i = 0; i < morse.length(); i++) {
            char simbolo = morse.charAt(i);

            if (simbolo == '.') {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new Node(null));
                }
                atual = atual.getEsquerda();

            } else if (simbolo == '-') {
                if (atual.getDireita() == null) {
                    atual.setDireita(new Node(null));
                }
                atual = atual.getDireita();
            }
        }

        atual.setLetra(letra);
    }

    public String Buscar(String escolhaMorse) {
        String[] palavrasMorse = escolhaMorse.split(" ");
        String resultado = "";

        for (int i = 0; i < palavrasMorse.length; i++) {
            Node atual = raiz;

            for (int j = 0; j < palavrasMorse[i].length(); j++) {
                char simbolo = palavrasMorse[i].charAt(j);

                if (simbolo == '.') {
                    atual = atual.getEsquerda();
                } else if (simbolo == '-') {
                    atual = atual.getDireita();
                }

                if (atual == null) {
                    return "Não existe nó";
                }
            }

            if (atual.getLetra() == null) {
                return "Não existe a Letra";
            }

            resultado = resultado + atual.getLetra();
        }

        return resultado;
    }


    public void preOrdem(Node atual) {
        if (atual != null) {
            if (atual.getLetra() != null) {
                System.out.print(atual.getLetra() + " ");
            }
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void imprimirPreOrdem() {
        preOrdem(raiz);
        System.out.println();
    }
}

public class RA2 {

    public static void main(String[] args) {
        Arvorebinaria arvore = new Arvorebinaria();

        Scanner scanner = new Scanner(System.in);



        arvore.Inserir(".-", "A");
        arvore.Inserir("-...", "B");
        arvore.Inserir("-.-.", "C");
        arvore.Inserir("-..", "D");
        arvore.Inserir(".", "E");
        arvore.Inserir("..-.", "F");
        arvore.Inserir("--.", "G");
        arvore.Inserir("....", "H");
        arvore.Inserir("..", "I");
        arvore.Inserir(".---", "J");
        arvore.Inserir("-.-", "K");
        arvore.Inserir(".-..", "L");
        arvore.Inserir("--", "M");
        arvore.Inserir("-.", "N");
        arvore.Inserir("---", "O");
        arvore.Inserir(".--.", "P");
        arvore.Inserir("--.-", "Q");
        arvore.Inserir(".-.", "R");
        arvore.Inserir("...", "S");
        arvore.Inserir("-", "T");
        arvore.Inserir("..-", "U");
        arvore.Inserir("...-", "V");
        arvore.Inserir(".--", "W");
        arvore.Inserir("-..-", "X");
        arvore.Inserir("-.--", "Y");
        arvore.Inserir("--..", "Z");

        arvore.Inserir("-----", "0");
        arvore.Inserir(".----", "1");
        arvore.Inserir("..---", "2");
        arvore.Inserir("...--", "3");
        arvore.Inserir("....-", "4");
        arvore.Inserir(".....", "5");
        arvore.Inserir("-....", "6");
        arvore.Inserir("--...", "7");
        arvore.Inserir("---..", "8");
        arvore.Inserir("----.", "9");

        System.out.print("Digite o codigo Morse (separe as letras com espaço): ");
        String codigo = scanner.nextLine();
        String texto = arvore.Buscar(codigo);
        System.out.println("Mensagem decodificada: " + texto);
        scanner.close();


        arvore.imprimirPreOrdem();
    }
}
