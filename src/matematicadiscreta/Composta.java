
package matematicadiscreta;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Scanner;
import static matematicadiscreta.MatematicaDiscreta.classificador;
import static matematicadiscreta.MatematicaDiscreta.funcional;
import static matematicadiscreta.MatematicaDiscreta.igualA;
import static matematicadiscreta.MatematicaDiscreta.maiorQue;
import static matematicadiscreta.MatematicaDiscreta.menorQue;
import static matematicadiscreta.MatematicaDiscreta.produtoCartesiano;
import static matematicadiscreta.MatematicaDiscreta.quadradoDe;
import static matematicadiscreta.MatematicaDiscreta.raizDe;

/**
 *
 * @author Walter
 */
public class Composta {
     static void composta(ArrayList<Conjunto> conjuntos) {
        int menu = 99;
        String opcao1 = null;
        String opcao2 = null;
        do {
            Scanner ler = new Scanner(System.in);

            System.out.println("Escolha a operação desejada para os conjuntos A e B");
            System.out.println("< - para A menor Que B");
            System.out.println("> - para A maior Que B");
            System.out.println("= - para A igual B");
            System.out.println("Q - para A quadrado de B");
            System.out.println("R - para A Raiz quadrada de B");
            opcao1 = ler.next();
            System.out.println("Escolha a operação desejada para os conjuntos B e C");
            System.out.println("< - para B menor Que C");
            System.out.println("> - para B maior Que C");
            System.out.println("= - para B igual C");
            System.out.println("Q - para B quadrado de C");
            System.out.println("R - para B Raiz quadrada de C");
            opcao2 = ler.next();
//___________________________________________________________________________________________________________
//Maior que
//------------------------------------------------------------------------------------------------------------
            if (opcao1.equalsIgnoreCase(">") && opcao2.equalsIgnoreCase(">")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> maiorQueLimpo = limpaString(maiorQue(conjuntos));
                ArrayList<String> maiorQueCLimpo = limpaString(maiorQueC(conjuntos));
                System.out.println("A > B" + maiorQueLimpo + "--- B > C" + maiorQueCLimpo);
                for (int i = 0; i < maiorQueLimpo.size(); i++) {
                    for (int j = 0; j < maiorQueCLimpo.size(); j++) {
                        int posicaoVirgula = maiorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = maiorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(maiorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(maiorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(maiorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(maiorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase(">") && opcao2.equalsIgnoreCase("<")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> maiorQueLimpo = limpaString(maiorQue(conjuntos));
                ArrayList<String> menorQueCLimpo = limpaString(menorQueC(conjuntos));
                System.out.println("A > B" + maiorQueLimpo + "--- B < C" + menorQueCLimpo);
                for (int i = 0; i < maiorQueLimpo.size(); i++) {
                    for (int j = 0; j < menorQueCLimpo.size(); j++) {
                        int posicaoVirgula = maiorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = menorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(maiorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(menorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(maiorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(menorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase(">") && opcao2.equalsIgnoreCase("=")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> maiorQueLimpo = limpaString(maiorQue(conjuntos));
                ArrayList<String> igualAcLimpo = limpaString(igualAc(conjuntos));
                System.out.println("A > B" + maiorQueLimpo + "--- B = C" + igualAcLimpo);
                for (int i = 0; i < maiorQueLimpo.size(); i++) {
                    for (int j = 0; j < igualAcLimpo.size(); j++) {
                        int posicaoVirgula = maiorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = igualAcLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(maiorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(igualAcLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(maiorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(igualAcLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase(">") && opcao2.equalsIgnoreCase("Q")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> maiorQueLimpo = limpaString(maiorQue(conjuntos));
                ArrayList<String> quadradoDeCLimpo = limpaString(quadradoDeC(conjuntos));
                System.out.println("A > B" + maiorQueLimpo + "--- B Q C" + quadradoDeCLimpo);
                for (int i = 0; i < maiorQueLimpo.size(); i++) {
                    for (int j = 0; j < quadradoDeCLimpo.size(); j++) {
                        int posicaoVirgula = maiorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = quadradoDeCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(maiorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(quadradoDeCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(maiorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(quadradoDeCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase(">") && opcao2.equalsIgnoreCase("R")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> maiorQueLimpo = limpaString(maiorQue(conjuntos));
                ArrayList<String> raizDeCLimpo = limpaString(raizDeC(conjuntos));
                System.out.println("A > B" + maiorQueLimpo + "--- B R C" + raizDeCLimpo);
                for (int i = 0; i < maiorQueLimpo.size(); i++) {
                    for (int j = 0; j < raizDeCLimpo.size(); j++) {
                        int posicaoVirgula = maiorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = raizDeCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(maiorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(raizDeCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(maiorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(raizDeCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
//______________________________________________________________________________________________________________________
//Menor que
//----------------------------------------------------------------------------------------------------------------------
            if (opcao1.equalsIgnoreCase("<") && opcao2.equalsIgnoreCase(">")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> menorQueLimpo = limpaString(menorQue(conjuntos));
                ArrayList<String> maiorQueCLimpo = limpaString(maiorQueC(conjuntos));
                System.out.println("A < B" + menorQueLimpo + "--- B > C" + maiorQueCLimpo);
                for (int i = 0; i < menorQueLimpo.size(); i++) {
                    for (int j = 0; j < maiorQueCLimpo.size(); j++) {
                        int posicaoVirgula = menorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = maiorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(menorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(maiorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(menorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(maiorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("<") && opcao2.equalsIgnoreCase("<")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> menorQueLimpo = limpaString(menorQue(conjuntos));
                ArrayList<String> menorQueCLimpo = limpaString(menorQueC(conjuntos));
                System.out.println("A < B" + menorQueLimpo + "--- B < C" + menorQueCLimpo);
                for (int i = 0; i < menorQueLimpo.size(); i++) {
                    for (int j = 0; j < menorQueCLimpo.size(); j++) {
                        int posicaoVirgula = menorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = menorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(menorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(menorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(menorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(menorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }

            if (opcao1.equalsIgnoreCase("<") && opcao2.equalsIgnoreCase("=")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> menorQueLimpo = limpaString(menorQue(conjuntos));
                ArrayList<String> igualAcLimpo = limpaString(igualAc(conjuntos));
                System.out.println("A < B" + menorQueLimpo + "--- B = C" + igualAcLimpo);
                for (int i = 0; i < menorQueLimpo.size(); i++) {
                    for (int j = 0; j < igualAcLimpo.size(); j++) {
                        int posicaoVirgula = menorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = igualAcLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(menorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(igualAcLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(menorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(igualAcLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("<") && opcao2.equalsIgnoreCase("Q")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> menorQueLimpo = limpaString(menorQue(conjuntos));
                ArrayList<String> quadradoDeCLimpo = limpaString(quadradoDeC(conjuntos));
                System.out.println("A < B" + menorQueLimpo + "--- B Q C" + quadradoDeCLimpo);
                for (int i = 0; i < menorQueLimpo.size(); i++) {
                    for (int j = 0; j < quadradoDeCLimpo.size(); j++) {
                        int posicaoVirgula = menorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = quadradoDeCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(menorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(quadradoDeCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(menorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(quadradoDeCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("<") && opcao2.equalsIgnoreCase("R")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> menorQueLimpo = limpaString(menorQue(conjuntos));
                ArrayList<String> raizDeCCLimpo = limpaString(raizDeC(conjuntos));
                System.out.println("A < B" + menorQueLimpo + "--- B R C" + raizDeCCLimpo);
                for (int i = 0; i < menorQueLimpo.size(); i++) {
                    for (int j = 0; j < raizDeCCLimpo.size(); j++) {
                        int posicaoVirgula = menorQueLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = raizDeCCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(menorQueLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(raizDeCCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(menorQueLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(raizDeCCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
//____________________________________________________________________________________________________________________
//IGUAL A
//--------------------------------------------------------------------------------------------------------------------

            if (opcao1.equalsIgnoreCase("=") && opcao2.equalsIgnoreCase(">")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> igualALimpo = limpaString(igualA(conjuntos));
                ArrayList<String> maiorQueCLimpo = limpaString(maiorQueC(conjuntos));
                System.out.println("A = B" + igualALimpo + "--- B > C" + maiorQueCLimpo);
                for (int i = 0; i < igualALimpo.size(); i++) {
                    for (int j = 0; j < maiorQueCLimpo.size(); j++) {
                        int posicaoVirgula = igualALimpo.get(i).indexOf(",");
                        int posicaoVirgulab = maiorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(igualALimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(maiorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(igualALimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(maiorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("=") && opcao2.equalsIgnoreCase("<")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> igualALimpo = limpaString(igualA(conjuntos));
                ArrayList<String> menorQueCLimpo = limpaString(menorQueC(conjuntos));
                System.out.println("A < B" + igualALimpo + "--- B < C" + menorQueCLimpo);
                for (int i = 0; i < igualALimpo.size(); i++) {
                    for (int j = 0; j < menorQueCLimpo.size(); j++) {
                        int posicaoVirgula = igualALimpo.get(i).indexOf(",");
                        int posicaoVirgulab = menorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(igualALimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(menorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(igualALimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(menorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("=") && opcao2.equalsIgnoreCase("=")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> igualALimpo = limpaString(igualA(conjuntos));
                ArrayList<String> igualAcLimpo = limpaString(igualAc(conjuntos));
                System.out.println("A = B" + igualALimpo + "--- B = C" + igualAcLimpo);
                for (int i = 0; i < igualALimpo.size(); i++) {
                    for (int j = 0; j < igualAcLimpo.size(); j++) {
                        int posicaoVirgula = igualALimpo.get(i).indexOf(",");
                        int posicaoVirgulab = igualAcLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(igualALimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(igualAcLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(igualALimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(igualAcLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("=") && opcao2.equalsIgnoreCase("Q")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> igualALimpo = limpaString(igualA(conjuntos));
                ArrayList<String> quadradoDeCLimpo = limpaString(quadradoDeC(conjuntos));
                System.out.println("A = B" + igualALimpo + "--- B Q C" + quadradoDeCLimpo);
                for (int i = 0; i < igualALimpo.size(); i++) {
                    for (int j = 0; j < quadradoDeCLimpo.size(); j++) {
                        int posicaoVirgula = igualALimpo.get(i).indexOf(",");
                        int posicaoVirgulab = quadradoDeCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(igualALimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(quadradoDeCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(igualALimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(quadradoDeCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("=") && opcao2.equalsIgnoreCase("R")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> igualALimpo = limpaString(igualA(conjuntos));
                ArrayList<String> raizDeCCLimpo = limpaString(raizDeC(conjuntos));
                System.out.println("A < B" + igualALimpo + "--- B R C" + raizDeCCLimpo);
                for (int i = 0; i < igualALimpo.size(); i++) {
                    for (int j = 0; j < raizDeCCLimpo.size(); j++) {
                        int posicaoVirgula = igualALimpo.get(i).indexOf(",");
                        int posicaoVirgulab = raizDeCCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(igualALimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(raizDeCCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(igualALimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(raizDeCCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
//_______________________________________________________________________________________________________________________
//Quadrado de
//-----------------------------------------------------------------------------------------------------------------------
            if (opcao1.equalsIgnoreCase("Q") && opcao2.equalsIgnoreCase(">")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> quadradoDeLimpo = limpaString(quadradoDe(conjuntos));
                ArrayList<String> maiorQueCLimpo = limpaString(maiorQueC(conjuntos));
                System.out.println("A Q B" + quadradoDeLimpo + "--- B > C" + maiorQueCLimpo);
                for (int i = 0; i < quadradoDeLimpo.size(); i++) {
                    for (int j = 0; j < maiorQueCLimpo.size(); j++) {
                        int posicaoVirgula = quadradoDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = maiorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(quadradoDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(maiorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(quadradoDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(maiorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("Q") && opcao2.equalsIgnoreCase("<")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> quadradoDeLimpo = limpaString(quadradoDe(conjuntos));
                ArrayList<String> menorQueCLimpo = limpaString(menorQueC(conjuntos));
                System.out.println("A Q B" + quadradoDeLimpo + "--- B < C" + menorQueCLimpo);
                for (int i = 0; i < quadradoDeLimpo.size(); i++) {
                    for (int j = 0; j < menorQueCLimpo.size(); j++) {
                        int posicaoVirgula = quadradoDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = menorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(quadradoDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(menorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(quadradoDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(menorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("Q") && opcao2.equalsIgnoreCase("=")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> quadradoDeLimpo = limpaString(quadradoDe(conjuntos));
                ArrayList<String> igualAcLimpo = limpaString(igualAc(conjuntos));
                System.out.println("A Q B" + quadradoDeLimpo + "--- B = C" + igualAcLimpo);
                for (int i = 0; i < quadradoDeLimpo.size(); i++) {
                    for (int j = 0; j < igualAcLimpo.size(); j++) {
                        int posicaoVirgula = quadradoDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = igualAcLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(quadradoDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(igualAcLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(quadradoDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(igualAcLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("Q") && opcao2.equalsIgnoreCase("Q")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> quadraDeLimpo = limpaString(quadradoDe(conjuntos));
                ArrayList<String> quadradoDeCLimpo = limpaString(quadradoDeC(conjuntos));
                System.out.println("A Q B" + quadraDeLimpo + "--- B Q C" + quadradoDeCLimpo);
                for (int i = 0; i < quadraDeLimpo.size(); i++) {
                    for (int j = 0; j < quadradoDeCLimpo.size(); j++) {
                        int posicaoVirgula = quadraDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = quadradoDeCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(quadraDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(quadradoDeCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(quadraDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(quadradoDeCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("Q") && opcao2.equalsIgnoreCase("R")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> quadraDeLimpo = limpaString(quadradoDe(conjuntos));
                ArrayList<String> raizDeCCLimpo = limpaString(raizDeC(conjuntos));
                System.out.println("A Q B" + quadraDeLimpo + "--- B R C" + raizDeCCLimpo);
                for (int i = 0; i < quadraDeLimpo.size(); i++) {
                    for (int j = 0; j < raizDeCCLimpo.size(); j++) {
                        int posicaoVirgula = quadraDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = raizDeCCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(quadraDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(raizDeCCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(quadraDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(raizDeCCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
//__________________________________________________________________________________________________________________
//Raiz de
//------------------------------------------------------------------------------------------------------------------
            if (opcao1.equalsIgnoreCase("R") && opcao2.equalsIgnoreCase(">")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> raizDeLimpo = limpaString(raizDe(conjuntos));
                ArrayList<String> maiorQueCLimpo = limpaString(maiorQueC(conjuntos));
                System.out.println("A R B" + raizDeLimpo + "--- B > C" + maiorQueCLimpo);
                for (int i = 0; i < raizDeLimpo.size(); i++) {
                    for (int j = 0; j < maiorQueCLimpo.size(); j++) {
                        int posicaoVirgula = raizDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = maiorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(raizDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(maiorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(raizDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(maiorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("R") && opcao2.equalsIgnoreCase("<")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> raizDeLimpo = limpaString(raizDe(conjuntos));
                ArrayList<String> menorQueCLimpo = limpaString(menorQueC(conjuntos));
                System.out.println("A R B" + raizDeLimpo + "--- B < C" + menorQueCLimpo);
                for (int i = 0; i < raizDeLimpo.size(); i++) {
                    for (int j = 0; j < menorQueCLimpo.size(); j++) {
                        int posicaoVirgula = raizDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = menorQueCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(raizDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(menorQueCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(raizDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(menorQueCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("R") && opcao2.equalsIgnoreCase("=")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> raizDeLimpo = limpaString(raizDe(conjuntos));
                ArrayList<String> igualAcLimpo = limpaString(igualAc(conjuntos));
                System.out.println("A R B" + raizDeLimpo + "--- B = C" + igualAcLimpo);
                for (int i = 0; i < raizDeLimpo.size(); i++) {
                    for (int j = 0; j < igualAcLimpo.size(); j++) {
                        int posicaoVirgula = raizDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = igualAcLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(raizDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(igualAcLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(raizDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(igualAcLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("R") && opcao2.equalsIgnoreCase("Q")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> raizDeLimpo = limpaString(raizDe(conjuntos));
                ArrayList<String> quadradoDeCLimpo = limpaString(quadradoDeC(conjuntos));
                System.out.println("A R B" + raizDeLimpo + "--- B Q C" + quadradoDeCLimpo);
                for (int i = 0; i < raizDeLimpo.size(); i++) {
                    for (int j = 0; j < quadradoDeCLimpo.size(); j++) {
                        int posicaoVirgula = raizDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = quadradoDeCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(raizDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(quadradoDeCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(raizDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(quadradoDeCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            if (opcao1.equalsIgnoreCase("R") && opcao2.equalsIgnoreCase("R")) {
                ArrayList<String> composta = new ArrayList();
                ArrayList<String> raizDeLimpo = limpaString(raizDe(conjuntos));
                ArrayList<String> raizDeCCLimpo = limpaString(raizDeC(conjuntos));
                System.out.println("A Q B" + raizDeLimpo + "--- B R C" + raizDeCCLimpo);
                for (int i = 0; i < raizDeLimpo.size(); i++) {
                    for (int j = 0; j < raizDeCCLimpo.size(); j++) {
                        int posicaoVirgula = raizDeLimpo.get(i).indexOf(",");
                        int posicaoVirgulab = raizDeCCLimpo.get(j).indexOf(",");
                        int x = Integer.parseInt(raizDeLimpo.get(i).substring(posicaoVirgula + 1));
                        int y = Integer.parseInt(raizDeCCLimpo.get(j).substring(0, posicaoVirgulab));
                        if (x == y) {
                            int z = Integer.parseInt(raizDeLimpo.get(i).substring(0, posicaoVirgula));
                            int w = Integer.parseInt(raizDeCCLimpo.get(j).substring(posicaoVirgulab + 1));
                            String coletor = "<" + z + "," + w + ">";
                            composta.add(coletor);
                        }
                    }
                }
                System.out.println("AoC" + composta);
                System.out.println(classificador(composta, conjuntos));
            }
            System.out.println("0  - SAIR");
            menu = ler.nextInt();
        } while (menu != 0);

    }

    public static ArrayList<String> maiorQueC(ArrayList<Conjunto> c1) {

        ArrayList<String> cartesiano = produtoCartesiano(c1.get(1), c1.get(2));
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

    public static ArrayList<String> menorQueC(ArrayList<Conjunto> c1) {
        ArrayList<String> cartesiano = produtoCartesiano(c1.get(1), c1.get(2));
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

    public static ArrayList<String> igualAc(ArrayList<Conjunto> c1) {
        ArrayList<String> cartesiano = produtoCartesiano(c1.get(1), c1.get(2));
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

    public static ArrayList<String> quadradoDeC(ArrayList<Conjunto> c1) {
        ArrayList<String> cartesiano = produtoCartesiano(c1.get(1), c1.get(2));
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

    public static ArrayList<String> raizDeC(ArrayList<Conjunto> c1) {
        ArrayList<String> cartesiano = produtoCartesiano(c1.get(1), c1.get(2));
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

    static ArrayList<String> limpaString(ArrayList<String> stringSuja) {
        ArrayList<String> stringLimpa = new ArrayList();
        for (String string : stringSuja) {

            string = string.replaceAll("<", "");
            string = string.replaceAll(">", "");
            int posicaoVirgula = string.indexOf(",");
            int x = Integer.parseInt(string.substring(0, posicaoVirgula));
            int y = Integer.parseInt(string.substring(posicaoVirgula + 1));
            stringLimpa.add(x + "," + y);
        }
        return stringLimpa;
    }
    
}
