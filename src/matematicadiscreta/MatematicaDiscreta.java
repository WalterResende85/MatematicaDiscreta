package matematicadiscreta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MatematicaDiscreta {

    public static void main(String[] args) {
        ArrayList<Conjunto> conjuntos = new ArrayList();
        ArrayList<Elemento> elementos = new ArrayList();

        int c = 0;
        Scanner ler = new Scanner(System.in);

        do {
            c = 0;
            System.out.printf("Informe o nome de arquivo texto:\n");
            String nome = ler.nextLine();

            try {
                FileReader arq = new FileReader(nome);
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
        

    }

    public static String verificador(String a) {
        a.trim();
        if (!Character.isLowerCase(a.charAt(0))) {
            return "Conjunto";
        } else {
            return "elemento";
        }
    }
}
