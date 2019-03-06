package matematicadiscreta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MatematicaDiscreta {

    public static void main(String[] args) {
        ArrayList<Conjunto> conjuntos = new ArrayList();
        ArrayList<Elemento> elementos = new ArrayList();

        int c = 0;
        int menu = 99;
        Scanner ler = new Scanner(System.in);

        do {
            c = 0;
            System.out.printf("Informe o nome de arquivo texto:\n");
            String nome = ler.nextLine();

            try {
                FileReader arq = new FileReader(nome + ".txt");
                BufferedReader lerArq = new BufferedReader(arq);

                String linha = lerArq.readLine(); // lê a primeira linha

                while (linha != null) {
                    if (verificador(linha).equalsIgnoreCase("Conjunto")) {
                        conjuntos.add(new Conjunto(linha));
                    } else {
                        elementos.add(new Elemento(linha));
                    }
                    linha = lerArq.readLine(); // lê da segunda até a última linha

                }

                arq.close();
            } catch (IOException e) {

                c = 1;
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                        e.getMessage());
            }

        } while (c == 1);

        do {
            System.out.println("");
            System.out.println("Escolha uma opção do menu");
            System.out.println("1  - Pertence ou não Pertence.");
            System.out.println("2  - Contido ou igual / Não contido ou igual.");
            System.out.println("3  - Contido propriamente / Não contido propriamente.");
            System.out.println("4  - União.");
            System.out.println("5  - Interseção.");
            System.out.println("6  - Produto cartesiano.");
            System.out.println("7 - Conjunto das partes.");
            System.out.println("0  - Sair");
            menu = ler.nextInt();

            if (menu == 1) {
                if (pertenceNaoPertence(conjuntos.get(0), elementos.get(0).conteudo)) {
                    System.out.println("********************************");
                    System.out.println("Pertence");
                    System.out.println("********************************");
                } else {
                    System.out.println("********************************");
                    System.out.println("Não Pertence");
                    System.out.println("********************************");
                }
            }

            if (menu == 2) {
                if(contidoNaocontido(conjuntos.get(0), conjuntos.get(1))){
                    System.out.println("Está contido");
                }else{
                    System.out.println("Não está contido");
                }
                
            }

            if (menu == 3) {

            }

            if (menu == 4) {

            }
            if (menu == 5) {

            }
            if (menu == 6) {

            }
            if (menu == 7) {

            }

        } while (menu != 0);
    }

    public static String verificador(String a) {
        a.trim();
        if (!Character.isLowerCase(a.charAt(0))) {
            return "Conjunto";
        } else {
            return "elemento";
        }
    }

    private static boolean pertenceNaoPertence(Conjunto c, Integer e) {
        boolean pertence = false;
        for (int i = 0; i <= c.getElementos().size(); i++) {
            if (e == i) {
                pertence = true;
                break;
            }
        }

        return pertence;
    }

    private static boolean contidoNaocontido(Conjunto c1, Conjunto c2) {
        boolean contido = true;
        for (Integer e : c1.elementos) {
            if (!pertenceNaoPertence(c2, e)) {
                contido = false;
                break;
            }
        }
        return contido;
        /*for (int i = 0; i < c1.elementos.size(); i++) {
            contido = false;
            for (int j = 0; j < c2.elementos.size(); j++) {
                if (c1.elementos.get(i) == c2.elementos.get(j)) {
                    contido = true;
                }
            }
            if (!contido) {
                break;
            }
        }
        if (contido) {
            System.out.println("Está contido");
        } else {
            System.out.println("não está contido");
        }
         */

    }

}
