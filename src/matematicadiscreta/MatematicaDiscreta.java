package matematicadiscreta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MatematicaDiscreta {

    public static void main(String[] args) {
        ArrayList<String> linhas = new ArrayList();
        
        int c=0;
        Scanner ler = new Scanner(System.in);

        do {
            c=0;
            System.out.printf("Informe o nome de arquivo texto:\n");
            String nome = ler.nextLine();

            System.out.printf("\nConteúdo do arquivo texto:\n");
            try {
                FileReader arq = new FileReader(nome);
                BufferedReader lerArq = new BufferedReader(arq);

                String linha = lerArq.readLine(); // lê a primeira linha
                linhas.add(linha);
                while (linha != null) {
                    System.out.printf("%s\n", linha);

                    linha = lerArq.readLine(); // lê da segunda até a última linha
                    linhas.add(linha);
                }

                arq.close();
            } catch (IOException e) {
                
            
                c = 1;
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                        e.getMessage());
            }

            System.out.println("=====");
            System.out.println("========================");
            for (String a : linhas) {
                System.out.println(a);

            }

        }while(c==1);
        
        
     
}
}