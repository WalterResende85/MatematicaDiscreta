
package matematicadiscreta;
import java.util.ArrayList;
import java.util.Scanner;
import static matematicadiscreta.Composta.composta;
import static matematicadiscreta.MatematicaDiscreta.classificador;
import static matematicadiscreta.MatematicaDiscreta.igualA;
import static matematicadiscreta.MatematicaDiscreta.maiorQue;
import static matematicadiscreta.MatematicaDiscreta.menorQue;
import static matematicadiscreta.MatematicaDiscreta.quadradoDe;
import static matematicadiscreta.MatematicaDiscreta.raizDe;



public class MenuDois {
    static void menuDois(ArrayList<Conjunto> conjuntos) {
        Scanner ler = new Scanner(System.in);
        int menu = 99;

        do {
            System.out.println("____________________Menu segundo trabalho___________________");
            System.out.println("1  - Relação MAIOR QUE dos conjuntos A e B.");
            System.out.println("2  - Relação MENOR QUE dos conjuntos A e B");
            System.out.println("3  - Relação IGUAL ENTRE dos conjuntos A e B");
            System.out.println("4  - Relação SER O QUADRADO DE dos conjuntos A e B");
            System.out.println("5  - Relação SER RAIZ entre os conjuntos A e B");
            System.out.println("6  - trabalhar com três conjuntos");
            System.out.println("0 - Sair");
            menu = ler.nextInt();

            if (menu == 1) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Conjunto A= " + conjuntos.get(0).elementos + "Conjunto B= " + conjuntos.get(1).elementos);
                System.out.println("Relação MAIOR QUE dos conjuntos A e B. =" + maiorQue(conjuntos));
                System.out.println(classificador(maiorQue(conjuntos), conjuntos));
                System.out.println("---------------------------------------------------------------------------------");
            }
            if (menu == 2) {
                 System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Conjunto A= " + conjuntos.get(0).elementos + "Conjunto B= " + conjuntos.get(1).elementos);
                System.out.println("Relação MENOR QUE dos conjuntos A e B. =" + menorQue(conjuntos));
                System.out.println(classificador(menorQue(conjuntos), conjuntos));
                System.out.println("---------------------------------------------------------------------------------");

            }
            if (menu == 3) {
                 System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Conjunto A= " + conjuntos.get(0).elementos + "Conjunto B= " + conjuntos.get(1).elementos);
                System.out.println("Relação IGUAL A dos conjuntos A e B. =" + igualA(conjuntos));
                System.out.println(classificador(igualA(conjuntos), conjuntos));
                System.out.println("---------------------------------------------------------------------------------");

            }
            if (menu == 4) {
                 System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Conjunto A= " + conjuntos.get(0).elementos + "Conjunto B= " + conjuntos.get(1).elementos);
                 System.out.println("Relação SER O QUADRADO DE entre os conjuntos A e B. =" + quadradoDe(conjuntos));
                System.out.println(classificador(quadradoDe(conjuntos), conjuntos));
                System.out.println("---------------------------------------------------------------------------------");

            }
            if (menu == 5) {
                 System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Conjunto A= " + conjuntos.get(0).elementos + "Conjunto B= " + conjuntos.get(1).elementos);
                  System.out.println("Relação SER A RAIZ QUADRADA DE entre os conjuntos A e B. =" + raizDe(conjuntos));
                System.out.println(classificador(raizDe(conjuntos), conjuntos));
                System.out.println("---------------------------------------------------------------------------------");

            }
            if(menu == 6){
                composta(conjuntos);
            }
        } while (menu != 0);

    }
    
}
