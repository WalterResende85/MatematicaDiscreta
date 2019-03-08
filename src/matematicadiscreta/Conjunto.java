
package matematicadiscreta;

import java.util.ArrayList;

public class Conjunto {
    ArrayList<Integer> elementos = new ArrayList();
    String identificador;
    
    public Conjunto(String linha) {
        linha = linha.replace(" ","");
        identificador = ""+linha.charAt(0);
        String valor ="";
        for (int i = 0; i < linha.length(); i++) {
            if(Character.isDigit(linha.charAt(i)) || linha.charAt(i)== '-'){
                valor += linha.charAt(i);
            }else if(linha.charAt(i)==',' || linha.charAt(i)=='}'){
                if(!valor.equals("")){
                    elementos.add(Integer.parseInt(valor));
                    valor ="";
                }
            }
        }
    }
    public Conjunto(){
        
    }
    public void imprimeConjunto(){
        System.out.print("{");
        for(int i = 0; i <elementos.size(); i++) {
            System.out.print(elementos.get(i));
            if(i!=elementos.size()-1){
                System.out.print(",");
            }
        }
        System.out.print("}");
    }

    public ArrayList<Integer> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Integer> elementos) {
        this.elementos = elementos;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
   
@Override
    public String toString(){
        return identificador;
    }
}
