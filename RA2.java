
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
        if (escolhaMorse == null || escolhaMorse.trim().isEmpty()) {
            return "";
        }

        String[] palavrasMorse = escolhaMorse.trim().split("\\s+");
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
}


public class RA2 {

    public static void main(String[] args) {
        Arvorebinaria arvore = new Arvorebinaria();

        arvore.Inserir("...", "S");
        arvore.Inserir("---", "O");
        arvore.Inserir("..","I");

        System.out.println(arvore.Buscar("..."));
        System.out.println(arvore.Buscar("---"));
        System.out.println(arvore.Buscar("... --- ..."));
        System.out.println(arvore.Buscar(".."));
    }
}
