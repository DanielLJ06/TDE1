# TDE 2 — Resolução de Problemas Estruturados em Computação

Dois exercícios em **Java** desenvolvidos por Daniel Langner Jager e Isabelle Duarte Santos para o **TDE 2** da disciplina de **Resolução de Problemas Estruturados em Computação**.

Os exercícios exploram duas estruturas de dados fundamentais, implementadas do zero, sem coleções prontas do Java:

| Arquivo                | Estrutura      | Problema resolvido                                                      |
| ---------------------- | -------------- | ----------------------------------------------------------------------- |
| [`RA1.java`](RA1.java) | Fila circular  | Intercalar (_merge_) duas filas ordenadas em uma terceira fila ordenada |
| [`RA2.java`](RA2.java) | Árvore binária | Decodificar mensagens em código Morse                                   |

## RA1

### Descrição

Implementação de uma **fila circular** baseada em vetor de tamanho fixo. Os índices `primeiro` e `ultimo` voltam para a posição `0` ao alcançar o fim do vetor, reaproveitando o espaço liberado pelas remoções.

Sobre essa fila, o programa implementa a operação `Merge`, que recebe duas filas **já ordenadas de forma crescente** e produz uma terceira fila também ordenada, comparando sempre os elementos da frente de cada uma.

### Operações da classe `Fila`

| Método                   | Descrição                                                    |
| ------------------------ | ------------------------------------------------------------ |
| `Fila(int tamanho)`      | Cria uma fila com a capacidade informada                     |
| `Cheia(Fila x)`          | Retorna `true` se a fila está cheia                          |
| `Vazia(Fila x)`          | Retorna `true` se a fila está vazia                          |
| `Inserir(Fila x, int y)` | Insere `y` no final da fila (avisa se estiver cheia)         |
| `Remover(Fila x)`        | Remove o elemento da frente da fila (avisa se estiver vazia) |
| `Primeiro(Fila x)`       | Retorna o elemento da frente, sem removê-lo                  |
| `Ultimo(Fila x)`         | Retorna o último elemento inserido, sem removê-lo            |
| `imprime(Fila x)`        | Imprime a fila do primeiro para o último elemento            |
| `Merge(Fila x, Fila y)`  | Intercala duas filas ordenadas em uma nova fila ordenada     |

### Como o `Merge` funciona

1. Cria uma fila `R` com capacidade igual à soma dos elementos das duas filas.
2. Enquanto **nenhuma** das filas estiver vazia, compara `Primeiro(x)` com `Primeiro(y)`, insere o menor em `R` e o remove da fila de origem.
3. Quando uma das filas esvazia, os elementos restantes da outra são transferidos para `R`.

### Exemplo do `main`

O `Merge` **consome** as filas de entrada: ao final, `A` e `B` ficam vazias e todos os elementos estão em `C`.

- Fila `A` (capacidade 4): `12 35 52 64`
- Fila `B` (capacidade 5): `5 15 23 55 75`
- Fila `C` (resultado do `Merge`): `5 12 15 23 35 52 55 64 75`

### Como executar

```bash
javac RA1.java
java RA1
```

---

## RA2

### Descrição

Programa que usa uma **árvore binária** para decodificar código Morse. Cada símbolo do código define o caminho a seguir na árvore:

- `.` (ponto) → desce para o filho da **esquerda**
- `-` (traço) → desce para o filho da **direita**

Cada letra ou dígito é armazenado no nó alcançado ao percorrer o caminho correspondente ao seu código. Nós intermediários que não representam nenhum caractere ficam com valor `null`.

```
                 (raiz)
                /      \
              E          T
             / \        / \
            I   A      N   M
           ...        ...
```

A árvore é preenchida com o alfabeto de **A a Z** e os dígitos de **0 a 9**.

### Classes

| Classe          | Responsabilidade                                                                |
| --------------- | ------------------------------------------------------------------------------- |
| `Node`          | Nó da árvore: guarda a letra e as referências para os filhos esquerdo e direito |
| `Arvorebinaria` | Gerencia a árvore, com inserção, busca (decodificação) e percurso em pré-ordem  |
| `RA2`           | Classe principal: monta a árvore, lê o código do usuário e exibe o resultado    |

### Métodos principais de `Arvorebinaria`

| Método                                | Descrição                                                                           |
| ------------------------------------- | ----------------------------------------------------------------------------------- |
| `Inserir(String morse, String letra)` | Percorre/cria o caminho do código Morse e grava a letra no nó final                 |
| `Buscar(String escolhaMorse)`         | Decodifica uma sequência de códigos separados por espaço e retorna o texto          |
| `imprimirPreOrdem()`                  | Imprime os caracteres da árvore em percurso **pré-ordem** (raiz, esquerda, direita) |

### Tratamento de erros

A busca retorna uma mensagem de erro quando:

- `"Não existe nó"` — o caminho do código leva a um ramo que não existe na árvore;
- `"Não existe a Letra"` — o caminho existe, mas o nó não representa nenhum caractere.

### Como usar

Digite o código Morse separando **cada letra por um espaço**.

```
Digite o codigo Morse (separe as letras com espaço): ... --- ...
Mensagem decodificada: SOS
```

Depois da decodificação, o programa também imprime todos os caracteres da árvore em pré-ordem.

### Como executar

```bash
javac RA2.java
java RA2
```

---

## Estrutura do repositório

```
.
├── RA1.java   # Fila circular + Merge de filas ordenadas
├── RA2.java   # Árvore binária para decodificar código Morse
└── README.md
```

## Conceitos praticados

- Filas circulares implementadas com vetor
- Algoritmo de intercalação (_merge_) de listas ordenadas
- Árvores binárias e percurso em pré-ordem
- Recursão
- Manipulação de strings e leitura de entrada com `Scanner`
- Encapsulamento (atributos privados, _getters_ e _setters_)
