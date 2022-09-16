import java.util.Scanner;

public class Menu {

    public void executa() {

        String itemDigitado = "";

        while (!itemDigitado.equals("6")) {
            imprimeMenu ();

            Scanner teclado = new Scanner(System.in);
            itemDigitado = teclado.nextLine().trim();

            switch (itemDigitado) {
                case "1":
                    break;

                case "2":
                    break;

                case "3":
                    break;

                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    System.out.println("Fim do programa! Volte sempre! :)");
                    break;
                default:
                    System.out.println("Opção inválida, digite um número entre 1 e 6\n");

            }
        }
    }

    public void imprimeMenu () {

        System.out.println("Bem-vinda(o) ao sistema de gramáticas da PUCRS");
            System.out.println("Digite 1 para adicionar os não terminais");
            System.out.println("Digite 2 para adicionar os terminais");
            System.out.println("Digite 3 para adicionar os não terminais");
            System.out.println("Digite 4 para remover os terminais");
            System.out.println("Digite 5 para remover os não terminais");
            System.out.println("Digite 5 para sair");

    }
}