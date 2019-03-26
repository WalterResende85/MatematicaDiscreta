package matematicadiscreta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
import static matematicadiscreta.MenuDois.menuDois;
import org.apache.commons.lang3.SerializationUtils;

public class MatematicaDiscreta implements Serializable {

    public static void main(String[] args) {
        ArrayList<Conjunto> conjuntos = new ArrayList();
        ArrayList<Elemento> elementos = new ArrayList();

        int c = 1;
        int menu = 99;
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("Informe o nome de arquivo texto:\n");
            try {
                c = 0;
                String nome = ler.nextLine();
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
            System.out.println("____________________________________________________________");
            System.out.println("____________________________________________________________");
            System.out.println("Escolha uma opção do menu");
            System.out.println("1  - Pertence ou não Pertence.");
            System.out.println("2  - Contido ou igual / Não contido ou igual.");
            System.out.println("3  - Contido propriamente / Não contido propriamente.");
            System.out.println("4  - União.");
            System.out.println("5  - Interseção.");
            System.out.println("6  - Produto cartesiano.");
            System.out.println("7  - Conjunto das partes.");
            System.out.println("8  - MENU DOIS");
            System.out.println("0  - Sair");
            System.out.println("____________________________________________________________");
            System.out.println("____________________________________________________________");
            menu = ler.nextInt();

            if (menu == 1) {
                if (pertenceNaoPertence(conjuntos.get(1), elementos.get(1).conteudo)) {
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
                if (contidoNaoContido(conjuntos.get(0), conjuntos.get(1))) {
                    System.out.println("********************************");
                    System.out.println(conjuntos.get(0) + " Está contido em " + conjuntos.get(1));
                    System.out.println("********************************");
                } else {
                    System.out.println("********************************");
                    System.out.println(conjuntos.get(0) + " Não está contido em " + conjuntos.get(1));
                    System.out.println("********************************");
                }

            }

            if (menu == 3) {
                if (contidoNaoContido(conjuntos.get(0), conjuntos.get(1)) == contidoNaoContido(conjuntos.get(1), conjuntos.get(0))) {
                    System.out.println("********************************");
                    System.out.println(conjuntos.get(0) + " Está apenas contido em " + conjuntos.get(1) + ", mas não contido propriamente");

                    System.out.println("********************************");
                } else if (contidoNaoContido(conjuntos.get(0), conjuntos.get(1)) && conjuntos.get(1).elementos.size() > conjuntos.get(0).elementos.size()) {
                    System.out.println("********************************");
                    System.out.println(conjuntos.get(0) + " Está  contido propriamente " + conjuntos.get(1));
                    System.out.println("********************************");
                }
            }

            if (menu == 4) {
                System.out.println("********************************");
                System.out.print(
                        uniaoDeConjuntos(conjuntos).getIdentificador() + "=");
                uniaoDeConjuntos(conjuntos).imprimeConjunto();
                System.out.println("");
                System.out.println("********************************");

            }
            if (menu == 5) {
                System.out.println("********************************");
                System.out.print(intersecaoDeConjuntos(conjuntos).getIdentificador() + "=");
                intersecaoDeConjuntos(conjuntos).imprimeConjunto();
                System.out.println("");
                System.out.println("********************************");
            }
            if (menu == 6) {
                produtoCartesiano(conjuntos.get(0), conjuntos.get(1));
                reverteCartesiano(conjuntos.get(0), conjuntos.get(1));
            }
            if (menu == 7) {
                conjuntoDasPartes(conjuntos);

            }
            if (menu == 8) {
                menuDois(conjuntos);
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

        for (int i = 0; i < c.getElementos().size(); i++) {
            if (e == c.getElementos().get(i)) {
                pertence = true;
                break;
            }
        }

        return pertence;
    }

    private static boolean contidoNaoContido(Conjunto c1, Conjunto c2) {
        boolean contido = true;
        for (Integer e : c1.elementos) {
            if (!pertenceNaoPertence(c2, e)) {
                contido = false;
                break;
            }
        }
        return contido;
    }

    private static Conjunto uniaoDeConjuntos(ArrayList<Conjunto> c1) {
        Conjunto uniao = new Conjunto();
        for (Conjunto c : c1) {
            for (int e : c.elementos) {
                if (!uniao.elementos.contains(e)) {
                    uniao.elementos.add(e);
                }
            }
        }
        uniao.setIdentificador("Conjunto Uniao");
        return uniao;
    }

    private static Conjunto intersecaoDeConjuntos(ArrayList<Conjunto> c1) {
        boolean controlador = true;

        Conjunto acumulador = new Conjunto();
        acumulador.setIdentificador("Conjunto Intersecao");
        for (Conjunto conjunto : c1) {
            for (int e : conjunto.elementos) {
                controlador = true;
                for (Conjunto conjunto1 : c1) {
                    if (!pertenceNaoPertence(conjunto1, e)) {
                        controlador = false;
                        break;
                    }
                }
                if (controlador) {

                    if (!acumulador.elementos.contains(e)) {
                        acumulador.elementos.add(e);

                    }

                }
            }
        }
        return acumulador;
    }

    public static ArrayList<String> produtoCartesiano(Conjunto c1, Conjunto c2) {
        ArrayList<String> cartesiano = new ArrayList();
        for (Integer a : c1.elementos) {
            for (Integer b : c2.elementos) {
                cartesiano.add("<" + a + "," + b + ">");

            }
        }
        return cartesiano;
    }

    public static void reverteCartesiano(Conjunto c1, Conjunto c2) {
        Scanner ler = new Scanner(System.in);
        ArrayList<String> cartesiano = new ArrayList();
        for (Integer a : c1.elementos) {
            for (Integer b : c2.elementos) {
                cartesiano.add("<" + a + "," + b + ">");

            }
        }

        System.out.println("Gostaria de reverter o Produto de " + c1.getIdentificador() + " com " + c2.getIdentificador());
        System.out.println("S ou N");
        System.out.println("********************************");
        String reverter = ler.next();
        if (reverter.equalsIgnoreCase("s")) {
            Conjunto a = new Conjunto();
            Conjunto b = new Conjunto();
            for (String string : cartesiano) {
                string = string.replaceAll("<", "");
                string = string.replaceAll(">", "");
                int posicaoVirgula = string.indexOf(",");
                int x = Integer.parseInt(string.substring(0, posicaoVirgula));
                int y = Integer.parseInt(string.substring(posicaoVirgula + 1));
                if (!a.elementos.contains(x)) {
                    a.elementos.add(x);
                }
                if (!b.elementos.contains(y)) {
                    b.elementos.add(y);
                }

            }
            System.out.println("********************************");
            System.out.println("Conjunto A " + a.elementos);
            System.out.println("Conjunto B " + b.elementos);
            System.out.println("********************************");
        }

    }

    public static ArrayList<TreeSet<Integer>> conjuntoDasPartes(ArrayList<Conjunto> c1) {
        Scanner ler = new Scanner(System.in);
        Conjunto amostragem = c1.get(1);
        ArrayList<TreeSet<Integer>> conjunto = new ArrayList();
        conjunto.add(new TreeSet());
        for (Integer e : amostragem.elementos) {
            conjunto.add(new TreeSet());
            conjunto.get(conjunto.size() - 1).add(e);

        }
        for (int i = 0; i < amostragem.elementos.size(); i++) {
            ArrayList<TreeSet<Integer>> clonado = SerializationUtils.clone(conjunto);
            for (TreeSet<Integer> combinacao : clonado) {
                TreeSet combinacaoClonado = SerializationUtils.clone(combinacao);
                combinacaoClonado.add(amostragem.elementos.get(i));
                if (!conjunto.contains(combinacaoClonado)) {
                    conjunto.add(combinacaoClonado);
                }
            }

        }
        System.out.println("********************************");
        System.out.println(conjunto);
        System.out.println("********************************");
        System.out.println("Gostaria de reverter o conjunto das partes do conjunto " + c1.get(0) + " ?");
        System.out.println("S ou N");
        System.out.println("********************************");
        String reverter = ler.next();
        if (reverter.equalsIgnoreCase("s")) {
            Conjunto conjuntoRevertido = new Conjunto();
            TreeSet<Integer> ultimoTreeSet = conjunto.get(conjunto.size() - 1);
            int x = ultimoTreeSet.size();
            for (int i = 0; i < x; i++) {
                conjuntoRevertido.elementos.add(ultimoTreeSet.first());
                ultimoTreeSet.remove(ultimoTreeSet.first());
            }
            System.out.println("********************************");
            System.out.println(conjuntoRevertido.elementos);
            System.out.println("********************************");
        }

        return conjunto;
    }

    public static ArrayList<String> maiorQue(ArrayList<Conjunto> c1) {

        ArrayList<String> cartesiano = produtoCartesiano(c1.get(0), c1.get(1));
        ArrayList<String> maiorQue = new ArrayList();
        for (String string : cartesiano) {

            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int x = Integer.parseInt(string.substring(0, posicaoVirgula));
            int y = Integer.parseInt(string.substring(posicaoVirgula + 1));

            if (x > y) {

                maiorQue.add("<" + x + "," + y + ">");
            }

        }
        return maiorQue;
    }

    public static ArrayList<String> menorQue(ArrayList<Conjunto> c1) {
        ArrayList<String> cartesiano = produtoCartesiano(c1.get(0), c1.get(1));
        ArrayList<String> menorQue = new ArrayList();
        for (String string : cartesiano) {

            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int x = Integer.parseInt(string.substring(0, posicaoVirgula));
            int y = Integer.parseInt(string.substring(posicaoVirgula + 1));

            if (x < y) {

                menorQue.add("<" + x + "," + y + ">");
            }

        }

        return menorQue;
    }

    public static ArrayList<String> igualA(ArrayList<Conjunto> c1) {
        ArrayList<String> cartesiano = produtoCartesiano(c1.get(0), c1.get(1));
        ArrayList<String> igualA = new ArrayList();
        for (String string : cartesiano) {

            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int x = Integer.parseInt(string.substring(0, posicaoVirgula));
            int y = Integer.parseInt(string.substring(posicaoVirgula + 1));

            if (x == y) {

                igualA.add("<" + x + "," + y + ">");
            }

        }

        return igualA;
    }

    public static ArrayList<String> quadradoDe(ArrayList<Conjunto> c1) {
        ArrayList<String> cartesiano = produtoCartesiano(c1.get(0), c1.get(1));
        ArrayList<String> quadradoDe = new ArrayList();
        for (String string : cartesiano) {

            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int x = Integer.parseInt(string.substring(0, posicaoVirgula));
            int y = Integer.parseInt(string.substring(posicaoVirgula + 1));

            if (x == pow(y, 2)) {

                quadradoDe.add("<" + x + "," + y + ">");
            }

        }

        return quadradoDe;
    }

    public static ArrayList<String> raizDe(ArrayList<Conjunto> c1) {
        ArrayList<String> cartesiano = produtoCartesiano(c1.get(0), c1.get(1));
        ArrayList<String> raizDe = new ArrayList();
        for (String string : cartesiano) {

            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int x = Integer.parseInt(string.substring(0, posicaoVirgula));
            int y = Integer.parseInt(string.substring(posicaoVirgula + 1));

            if (x == sqrt(y)) {

                raizDe.add("<" + x + "," + y + ">");
            }

        }

        return raizDe;
    }

    public static ArrayList<String> classificador(ArrayList<String> metodo, ArrayList<Conjunto> c1) {
        boolean classificadorFuncional = true;
        boolean classificadorInjetora = true;
        boolean classificadorTotal = true;
        boolean classificadorSobrejetora = true;
        String coletor = null;
        ArrayList<String> string = new ArrayList();
        classificadorFuncional = funcional(metodo);
        classificadorInjetora = injetora(metodo);
        classificadorTotal = total(metodo, c1.get(0));
        classificadorSobrejetora = sobrejetora(metodo, c1.get(1));
        if (classificadorFuncional) {
            coletor = "Funcional";
            string.add(coletor);
        } else if (!classificadorFuncional) {
            coletor = "Não Funcional";
            string.add(coletor);
        }
        if (classificadorInjetora) {
            coletor = "Injetora";
            string.add(coletor);
        } else if (!classificadorInjetora) {
            coletor = "Não Injetora";
            string.add(coletor);
        }
        if (classificadorTotal) {
            coletor = "Total";
            string.add(coletor);
        } else if (!classificadorTotal) {
            coletor = "Não Total";
            string.add(coletor);
        }
        if (classificadorSobrejetora) {
            coletor = "Sobrejetora";
            string.add(coletor);
        } else if (!classificadorSobrejetora) {
            coletor = "Não Sobrejetora";
            string.add(coletor);
        }
        if(classificadorInjetora && classificadorTotal){
            coletor = "Monomorfismo";
            string.add(coletor);
        }
        if(classificadorFuncional && classificadorSobrejetora){
            coletor = "Epimorfismo";
            string.add(coletor);
        }
        if(classificadorInjetora && classificadorTotal && classificadorFuncional && classificadorSobrejetora){
            coletor = "Isomorfismo";
            string.add(coletor);
        }
        return string;
    }

    public static boolean funcional(ArrayList<String> conjunto) {
        boolean funcional = true;
        Conjunto a = new Conjunto();

        for (String string : conjunto) {
            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int x = Integer.parseInt(string.substring(0, posicaoVirgula));
            a.elementos.add(x);

        }
        for (int i = 0; i < a.elementos.size(); i++) {
            int x = a.elementos.get(i);
            for (int j = 0; j < a.elementos.size(); j++) {

                if (a.elementos.get(j) == x && i != j) {
                    funcional = false;
                    break;
                }
            }
            if (!funcional) {
                break;
            }

        }

        return funcional;
    }

    public static boolean injetora(ArrayList<String> conjunto) {
        boolean injetora = true;
        Conjunto a = new Conjunto();
        Conjunto b = new Conjunto();

        for (String string : conjunto) {
            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int y = Integer.parseInt(string.substring(posicaoVirgula + 1));
            b.elementos.add(y);

        }
        for (int i = 0; i < b.elementos.size(); i++) {
            int z = b.elementos.get(i);
            for (int j = 0; j < b.elementos.size(); j++) {
                if (b.elementos.get(j) == z && i != j) {

                    injetora = false;
                    break;
                }
            }
            if (!injetora) {
                break;
            }

        }
        return injetora;
    }

    public static boolean total(ArrayList<String> conjunto, Conjunto original) {
        boolean total = true;
        Conjunto a = new Conjunto();

        for (String string : conjunto) {
            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int x = Integer.parseInt(string.substring(0, posicaoVirgula));
            a.elementos.add(x);
        }
        for (int i = 0; i < a.elementos.size(); i++) {
            if (!pertenceNaoPertence(original, a.elementos.get(i))) {
                total = false;
                break;
            }

        }

        return total;
    }

    public static boolean sobrejetora(ArrayList<String> conjunto, Conjunto original) {
        boolean sobrejetora = true;
        Conjunto b = new Conjunto();
        for (String string : conjunto) {
            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int y = Integer.parseInt(string.substring(posicaoVirgula + 1));
            b.elementos.add(y);
        }
        for (int i = 0; i < b.elementos.size(); i++) {
            if (!pertenceNaoPertence(original, b.elementos.get(i))) {
                sobrejetora = false;
                break;
            }

        }

        return sobrejetora;
    }
}
