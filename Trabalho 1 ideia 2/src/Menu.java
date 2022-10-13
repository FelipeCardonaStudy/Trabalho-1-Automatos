import java.util.Scanner;

public class Menu {

    Gramatica gramatica = new Gramatica();

    public void executa() {

        String itemDigitado = "";

        while (!itemDigitado.equals("9")) {
            imprimeMenu ();

            Scanner teclado = new Scanner(System.in);
            itemDigitado = teclado.nextLine().trim();
            String tempStr;

            switch (itemDigitado) {
                case "1":
                    System.out.println("Por favor, digite o não terminal que deseja adicionar.");
                    tempStr = teclado.nextLine();
                    adicionaNaoTerminal(tempStr);
                    break;

                case "2":
                    System.out.println("Por favor, digite o terminal que deseja adicionar.");
                    tempStr = teclado.nextLine();
                    adicionaTerminal(tempStr);
                    break;

                case "3":
                    System.out.println("Por favor, digite o símbolo do conjunto de produções.");
                    tempStr = teclado.nextLine();
                    adicionaSimboloProducoes(tempStr);
                    break;

                case "4":
                    System.out.println("Por favor, digite o símbolo de início de produções.");
                    tempStr = teclado.nextLine();
                    adicionaSimboloInicioProducoes(tempStr);
                    break;

                case "5":
                    System.out.println("Por favor, digite o conjunto de produções que engloba a gramática.");
                    tempStr = teclado.nextLine();
                    gramatica.alteraGramatica(tempStr);
                    System.out.println("Produções alteradas.");
                    break;

                case "6":
                    System.out.println("Por favor, digite o não terminal que deseja remover.");
                    tempStr = teclado.nextLine();
                    removeNaoTerminal(tempStr);
                    break;

                case "7":
                    System.out.println("Por favor, digite o terminal que deseja remover.");
                    tempStr = teclado.nextLine();
                    removeTerminal(tempStr);
                    break;

                case "8":
                    System.out.println("Por favor, digite a quantidade de sentenças exemplo que deseja.");
                    System.out.print("Quantidade: ");
                    String quantidadeStr = teclado.nextLine();
                    try{
                        int quantidade = Integer.parseInt(quantidadeStr);
                        testaGramatica(quantidade);
                    }catch (Exception e){
                        System.out.println("Erro! A entrada não é um número.");
                    }
                    break;

                case "9":
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida, digite um número entre 1 e 9\n");
                    break;
            }
        }
    }

    public void imprimeMenu () {

        System.out.println("\nBem-vinda(o) ao sistema de gramáticas da PUCRS");
        System.out.println("(1) Adicionar não terminal");
        System.out.println("(2) Adicionar terminal");
        System.out.println("(3) Alterar símbolo de conjunto de produções");
        System.out.println("(4) Alterar símbolo de início de produções");
        System.out.println("(5) Alterar conjunto de produções da gramática");
        System.out.println("(6) Remover não terminal");
        System.out.println("(7) Remover terminal");
        System.out.println("(8) Testar gramática");
        System.out.println("(9) Sair do programa");
        System.out.print("Escolha: ");
    }

    public void adicionaNaoTerminal(String tempStr){
        if(tempStr.length() > 1){
            System.out.println("Apenas um caractere é permitido por entrada.");
            return;
        }
        char temp = tempStr.charAt(0);
        if(Character.isLowerCase(temp)){
            System.out.println("Apenas letras maiúsculas podem ser não terminais.");
            return;
        }
        if(gramatica.adicionaNaoTerminal(temp)){
            System.out.println("Não terminal adicionado com sucesso.");
            return;
        }
        System.out.println("Erro. Não terminal já adicionado.");
    }

    public void adicionaTerminal(String tempStr){
        if(tempStr.length() > 1){
            System.out.println("Apenas um caractere é permitido por entrada.");
            return;
        }
        char temp = tempStr.charAt(0);
        if(Character.isUpperCase(temp)){
            System.out.println("Apenas letras minúsculas podem ser terminais.");
            return;
        }
        if(gramatica.adicionaTerminal(temp)){
            System.out.println("Terminal adicionado com sucesso.");
            return;
        }
        System.out.println("Erro. Terminal já adicionado.");
    }

    public void adicionaSimboloProducoes(String tempStr){
        if(tempStr.length() > 1){
            System.out.println("Apenas um caractere é permitido por entrada.");
            return;
        }
        gramatica.setSimboloProducoes(tempStr.charAt(0));
        System.out.println("Símbolo de produções alterado com sucesso.");
    }

    public void adicionaSimboloInicioProducoes(String tempStr){
        if(tempStr.length() > 1){
            System.out.println("Apenas um caractere é permitido por entrada.");
            return;
        }
        if(Character.isUpperCase(tempStr.charAt(0))){
            gramatica.setSimboloInicial(tempStr.charAt(0));
            System.out.println("Símbolo de início de produções alterado com sucesso.");
            return;
        }
        System.out.println("O símbolo de início de produções deve ser uma letra maiúscula.");
    }

    public void removeNaoTerminal(String tempStr){
        if(tempStr.length() > 1){
            System.out.println("Apenas um caractere é permitido por entrada.");
            return;
        }
        char temp = tempStr.charAt(0);
        if(gramatica.removeNaoTerminal(temp)){
            System.out.println("Não terminal removido com sucesso.");
            return;
        }
        System.out.println("O não terminal digitado não foi encontrado no sistema.");
    }

    public void removeTerminal(String tempStr){
        if(tempStr.length() > 1){
            System.out.println("Apenas um caractere é permitido por entrada.");
            return;
        }
        char temp = tempStr.charAt(0);
        if(gramatica.removeTerminal(temp)){
            System.out.println("Terminal removido com sucesso.");
            return;
        }
        System.out.println("O terminal digitado não foi encontrado no sistema.");
    }

    public void testaGramatica(int quantidadeSentencas){
        if(!gramatica.validaGramatica()){
            System.out.println("A gramática é inválida.");
            return;
        } else {
            System.out.println("A gramática é válida.");
        }
        System.out.println("Formalismo que representa a gramática: " + gramatica.formalismoGramatica());
        System.out.println("A gramática é " + gramatica.tipoGramatica());
        System.out.println(gramatica.geraSentencas(quantidadeSentencas));
    }
}