<h1 align="center"> Trabalho 1 - Linguagens, Autômatos e Computação! </h1>

# Índice

- [Descrição](#Descrição)
- [Planejamento](#Planejamento)
- [Tecnologias](#Tecnologias)
- [Estrutura das Branches](#EstruturadasBranches)
- [Padrão de Commits](#PadrãodeCommits)
- [Regras de Uso](#RegrasdeUso)
- [Implementação do Código](#ImplementaçãodoCódigo)


## Descrição
- Nomes: Breno Ferro, Felipe Cardona, Guilherme Silva e Maria Luísa Souto 
- Professora: Profa. Dra. Andréa Aparecida Konzen
- Matéria: Linguagens, Autômatos e Computação
- Repositório do trabalho: https://github.com/FelipeRavaCardona/Trabalho-1-Automatos 


## Planejamento
- Fazer um readme com as informações de como o programa deverá ser utilizado
- Fazer a classe menu para incluir a gramática e dispor os resultados (terminais e não terminais) 
- Fazer uma classe gramática com duas arraylist (uma não terminais e outra terminais)
- Dentro da classe gramática, vamos criar os métodos para testar a gramática

## Tecnologias
Java

## Estrutura das Branches


Tipos: feature, fix
tipo/descricao-separada-por-hifen

Exemplo:

```bash
git checkout -m feature/adicionar-menu
```

## Padrão de Commits
Nós usamos o padrão definido pela conversão de commits.

feature

Exemplo:
```bash
git commit -m "feature: adicionado o menu na aplicação"
```

## Regras de Uso
Para a utilização e funcionalidade correta do aplicativo, deve ser seguido um padrão de gramática, sendo ele:
"Não terminal" seguido de ":" seguido das variacões do não terminal separadas por "|", separar cada produção por ";", sempre sem nenhum espaço entre os inputs.
Para identificar o símbolo de vazio, é necessário utilizar o número "0".

Exemplo:
S:aA|bA;A:aA|bA|a|b

## Implementação do Código
Para a implementação do código, foi necessária a criação de duas classes além da main, uma para o menu textual e outra para a lógica do sistema.
A lógica do sistema foi feita guardando os terminais e não terminais em listas, o símbolo de produções e o de inicio de produção como caracteres, e as produções como um Map, sendo um não terminal a key e suas derivações uma lista de values.
Para o formalismo foi feita uma String de todos os dados salvos no sistema e a mesma é apresentada ao usuário.
Para ver se a gramática era válida, foi testado se terminais e não terminais que não foram declarados eram usados na produção, se as regras de uso foram obedecidas, se o símbolo de produções e de início de produção foram inseridos, se o símbolo de início de produção é um não terminal e se as produções começam com o símbolo de início de produção.
Para indicar o tipo da gramática, foi testado se havia a derivação de vazio após o símbolo de início de produção e se ela obedecia as regras de uma gramática regular. Caso obedecesse, seria definida como uma gramática regular, caso não, seria definida como uma gramática livre de contexto.
Por último foi feito a criação de exemplos a partir da gramática inserida. Para isso, o usuário deve escolher uma quantidade de exemplos a serem criados. Como resolução foi feito um método recursivo que pegaria as derivações dos não terminais e sortearia um deles, concatenando em uma String. Após isso se percorria a String e verificava se havia um não terminal, caso houvesse, o processo se repitiria. Como é feito um processo randômico, exemplos iguais podem ser gerados.
