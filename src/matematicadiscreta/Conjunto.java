/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        System.out.println("{");
        for(int i = 0; i <elementos.size(); i++) {
            System.out.println(elementos.get(i));
            if(i!=elementos.size()-1){
                System.out.println(",");
            }
        }
        System.out.println("}");
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
