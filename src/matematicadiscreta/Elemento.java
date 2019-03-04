
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getConteudo() {
        return conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }
    
    @Override
    public String toString(){
        return identificador;
    }
    
}
