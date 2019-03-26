
package matematicadiscreta;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof Conjunto){
           for (int i = 0; i < ((Conjunto) obj).elementos.size(); i++) {
              if(!this.elementos.contains(((Conjunto) obj).elementos.get(i))){
                  return false;
              }
           }
           return true;
    }
        return false;
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
