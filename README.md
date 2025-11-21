# TimeMaster - Sistema de Agenda de Compromissos
## 📋 Descrição do Projeto

O TimeMaster é um gerenciador inteligente de compromissos desenvolvido em Java que utiliza estruturas de dados avançadas e conceitos de Programação Orientada a Objetos para oferecer uma gestão eficiente de agenda pessoal e profissional.

## 🎯 Funcionalidades Principais

###    ✅ Cadastro, edição, busca e remoção de compromissos

###    ⚠️ Detecção de conflitos de horário na agenda

###    📊 Classificação de compromissos pessoais e profissionais

###    🔍 Busca eficiente usando Árvore Binária de Busca (ABB)

###    📈 Ordenação por data, prioridade e categoria usando HeapSort

###    🏷️ Sistema de prioridades para organização inteligente

## 🏗️ Estrutura do Domínio

### Classes Principais

    Compromisso (Classe Base)

        CompromissoPessoal (Subclasse)

        CompromissoProfissional (Subclasse)

### Regras de Negócio

    ❌ Data não pode ser no passado

    ❌ Não é permitido registrar dois compromissos no mesmo horário

    ✅ Validações com NegocioException

## 🛠️ Tecnologias e Conceitos Aplicados
### Estruturas de Dados

    Árvore Binária de Busca (ABB) por horário (LocalDateTime)

    HeapSort para ordenação múltipla

    HashMap para repositório genérico

### POO Avançada

    Herança e Polimorfismo

    Interfaces (Repositorio<T>, Ordenacao<T>, Arvore<K,V>)

    Classe Genérica RepositorioHash<T>

    Tratamento de Exceções personalizadas

### Recursos Java

    Annotations personalizadas (@InfoAutor)

    Reflection para leitura de metadados

    Generics para type safety

    Collections Framework

## 📁 Estrutura do Projeto

        src/
        ├── model/
        │   ├── Compromisso.java
        │   ├── CompromissoPessoal.java
        │   ├── CompromissoProfissional.java
        │   └── enums/
        │       ├── Prioridade.java
        │       └── Categoria.java
        ├── repository/
        │   ├── Repositorio.java
        │   ├── RepositorioHash.java
        │   └── Arvore.java
        ├── service/
        │   ├── AgendaService.java
        │   ├── OrdenacaoService.java
        │   └── NegocioException.java
        ├── annotation/
        │   └── InfoAutor.java
        └── main/
            └── Main.java

## 🚀 Como Compilar e Executar

### Pré-requisitos

Java JDK 11 ou superior

IDE Java (Eclipse, IntelliJ, VS Code) ou terminal

### Compilação via Terminal

    # Navegar até o diretório src
    cd src

    # Compilar todos os arquivos Java
    javac -d ../bin main/Main.java

    # Executar a aplicação
    java -cp ../bin main.Main
## Execução em IDE

Importe o projeto na sua IDE

Configure o JDK 11+

Execute a classe Main.java no pacote main

### 📊 Casos de Uso Demonstrados

### O sistema demonstra:

CRUD Completo - Create, Read, Update, Delete

Inserção na Árvore e travessia em-ordem

Ordenação com HeapSort por múltiplos critérios

Tratamento de Exceções com mensagens amigáveis

Leitura de Annotations via Reflection

Detecção de Conflitos de horário

## ⚙️ Funcionalidades Técnicas
### Árvore Binária de Busca

Inserção ordenada por LocalDateTime

Busca eficiente O(log n) em cenário balanceado

Travessia em-ordem para listagem ordenada

### Algoritmo HeapSort

Ordenação por data, prioridade e categoria

Implementação com Comparator

Complexidade O(n log n)

### Sistema de Exceções

NegocioException para regras de domínio

Try-catch no Main com feedback ao usuário

Validações em tempo de execução

## 🎨 Annotation Personalizada

    @InfoAutor

        Aplicada em Compromisso e RepositorioHash

        Contém nome do autor e data de criação

        Lida via Reflection no startup

## 📝 Exemplo de Uso

    // Criar compromisso profissional
    Compromisso reuniao = new CompromissoProfissional(
        "Reunião de Projeto",
        LocalDateTime.of(2025, 11, 20, 14, 0),
        Prioridade.ALTA,
        "Sala 101"
    );

    // Adicionar à agenda
    agendaService.adicionarCompromisso(reuniao);

    // Listar compromissos ordenados
    List<Compromisso> ordenados = ordenacaoService.ordenarPorData();

## 🗓️ Cronograma de Desenvolvimento

    Data	Checkpoint
    16/10	Annotations: criar @InfoAutor
    21/10	Reflexão: ler @InfoAutor no Main
    23/10	Depuração e ajustes de exceções
    28/10	Profiling: medir tempo de ordenação
    04/11	Árvore ABB funcional
    06/11	Integração do algoritmo de ordenação
    11/11	Revisão final e organização
    18/11	Roteirização dos casos de uso
    25/11	Refinamento final
    27/11	Entrega do projeto

## 👥 Autores

Projeto desenvolvido como trabalho final de Linguagem de Programação 2, implementando os conceitos aprendidos durante o curso.

##### ⚠️ Nota: Este projeto é acadêmico e desenvolvido para fins educacionais, demonstrando a aplicação prática de estruturas de dados e conceitos avançados de POO em Java.
