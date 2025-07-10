# 🔐 Criptografia Clássica em Java (GUI + MVC)


## ✨ Funcionalidades

* ## Este projeto implementa quatro algoritmos de criptografia clássica com interface gráfica utilizando **Java Swing** e arquitetura **MVC (Model-View-Controller)**.

  ## Interface gráfica amigável e intuitiva
* Arquitetura limpa com separação clara entre Model, View e Controller
* Suporte a quatro cifras clássicas:

  * Cifra de César
  * Cifra de Vigenère
  * Cifra de Playfair
  * Cifra Rail Fence

---

## 🧠 Como Funciona Cada Cifra

### 1. 🏠 Cifra de César

* Cada letra do texto é deslocada um número fixo de posições no alfabeto.
* Exemplo (chave 3): `A → D`, `B → E`, `C → F`
* Fórmula: `C = (P + k) mod 26`

### 2. 🧬 Cifra de Vigenère

* Usa uma palavra-chave para aplicar múltiplos deslocamentos.
* A chave é repetida até o tamanho do texto.
* Exemplo:

  * Texto: `ATAQUE`
  * Chave: `LEMON`
  * Chave estendida: `LEMONL`

### 3. ⬛ Cifra de Playfair

* Utiliza uma matriz 5x5 com uma chave para cifrar pares de letras.
* Regras:

  * Mesma linha: substitui pela próxima letra da linha
  * Mesma coluna: substitui pela próxima da coluna
  * Caso contrário: forma um retângulo e troca as colunas
* `J` é tratado como `I`

### 4. 🪜 Cifra Rail Fence

* Escreve o texto em forma de zigue-zague com n trilhos.
* Exemplo (3 trilhos):

```
T . . . A . . . C
. E . T . E . O .
. . S . . . . D .
```

* Resultado: `TACETEOSD`

---

## 🖥️ Interface Gráfica

* Escolha do algoritmo
* Entrada de texto e chave
* Botões para **Cifrar** ou **Decifrar**
* Saída em um painel de resultado

---

## 🧱️ Estrutura do Projeto

```
src/
├── controller/
│   └── CriptografiaController.java
├── model/
│   ├── Cesar.java
│   ├── Vigenere.java
│   ├── Playfair.java
│   ├── RailFence.java
│   └── interfaces/
│       └── Criptografia.java
├── view/
│   └── JanelaPrincipal.java
└── Main.java
```

---

## 🚀 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/criptografia-java-gui.git
cd criptografia-java-gui
```

2. Compile e execute:

```bash
javac -d bin src/**/*.java
java -cp bin src.Main
```

Ou abra em uma IDE como **IntelliJ** ou **Eclipse** e execute `Main.java`

---

## 👤 Autor
**Omar Davide Xavier**,
Estudante de Engenharia Informática-
Moçambique

```
