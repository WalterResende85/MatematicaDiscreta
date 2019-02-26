
package matematicadiscreta;

public class Elemento {
    String identificador;
    Integer conteudo;

    public Elemento(String linha) {
        linha = linha.replace(" ","");
        identificador = ""+linha.charAt(0);
        int posicao = linha.indexOf("=")+1;
        conteudo = Integer.parseInt(linha.substring(posicao));
    }
    @Override
    public String toString(){
        return identificador;
    }
    
}
