import java.util.ArrayList;
import java.util.Arrays;

public class Gramatica {
    ArrayList<Character> terminais = new ArrayList<>();
    ArrayList<Character> naoTerminais = new ArrayList<>();
    Character simboloInicial;

    Character simboloProducoes;
//TODO ARRAylist com arraylist de strings ou map
    ArrayList<String> producoes = new ArrayList<>();

    public boolean adicionaTerminal(Character t){
        for(int i = 0; i < terminais.size(); i++){
            char temp = terminais.get(i);
            if(temp == Character.toLowerCase(t)){
                return false;
            }
        }
        terminais.add(Character.toLowerCase(t));
        return true;
    }

    public boolean adicionaNaoTerminal(Character n){
        for(int i = 0; i < naoTerminais.size(); i++){
            char temp = naoTerminais.get(i);
            if(temp == Character.toUpperCase(n)){
                return false;
            }
        }
        naoTerminais.add(Character.toUpperCase(n));
        return true;
    }

    public boolean removeTerminal(Character t){
        t = Character.toLowerCase(t);
        return terminais.remove(t);
    }

    public boolean removeNaoTerminal(Character n){
        n = Character.toUpperCase(n);
        return naoTerminais.remove(n);
    }

    public void setSimboloInicial(Character c){
        simboloInicial = c;
    }

    public void setSimboloProducoes(Character c) {
        simboloProducoes = c;
    }

    /**
     * Padrao: nao terminal, ':', opções separadas por '|', ';' separando cada linha.
     * @param gramatica produções a serem adicionadas
     */
    public void adicionaGramatica(String gramatica){
        //TODO
        producoes.clear();
        String[] dados = gramatica.split(";");
        for(String dado : dados){
            producoes.add(dado);
        }
    }

    private boolean testaNaoTerminal(Character n){
        for(int i = 0; i < naoTerminais.size(); i++){
            char test = naoTerminais.get(i);
            if(test == n){
                return true;
            }
        }
        return false;
    }

    public String formalismoGramatica(){
        String formalismo = "G = ({";
        for(int i = 0; i < naoTerminais.size(); i++){
            if(i + 1 != naoTerminais.size()){
                formalismo += naoTerminais.get(i) + ", ";
            } else {
                formalismo += naoTerminais.get(i);
            }
        }
        formalismo += "}, {";
        for(int i = 0; i < terminais.size(); i++){
            if(i + 1 != terminais.size()){
                formalismo += terminais.get(i) + ", ";
            } else {
                formalismo += terminais.get(i) + "}, ";
            }
        }
        formalismo += "}, " + simboloProducoes + ", " + simboloInicial + ")";
        return formalismo;
    }

    public boolean validaGramatica(){
        if(simboloProducoes == null){
            return false;
        }
        for(String linha : producoes){
            if(linha.charAt(1) != ':'){
                return false;
            }
        }
        if(!naoTerminais.contains(simboloInicial)){
            return false;
        }
        if(producoes.get(0).charAt(0) != simboloInicial){
            return false;
        }
        return true;
    }

    /**
     * Regular: a direita pode apenas um terminal seguido de nao terminal ou só um terminal ou vazio
     * Livre de Contexto: apenas um nao terminal a esquerda, a direita não pode vazio
     * @return
     */
    public String tipoGramatica(){
        //TODO

        return "Regular";
    }

    public ArrayList<String> geraSentencas(){
        //TODO
        ArrayList<String> result = new ArrayList<>();
        return result;
    }
}
