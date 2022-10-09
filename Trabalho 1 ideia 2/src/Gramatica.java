import java.util.ArrayList;
import java.util.Arrays;

public class Gramatica {
    ArrayList<Character> terminais = new ArrayList<>();
    ArrayList<Character> naoTerminais = new ArrayList<>();
    Character simboloInicial;
    ArrayList<String> gramatica = new ArrayList<>();

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

    public Character getSimboloInicial(){
        return simboloInicial;
    }

    public boolean adicionaGramatica(String gramatica){
        String separadorDeCampo = ";";
        String separadorIdentificador = ":";

        ArrayList<String> producaoFinal = new ArrayList<>();
        ArrayList<String> linhas = new ArrayList<>(Arrays.asList(separadorDeCampo));

        if(simboloInicial == null || gramatica.charAt(0) != simboloInicial){
            return false;
        }

        for(int i = 0; i < linhas.size(); i++){
            String testa = linhas.get(i);
            if(!testaNaoTerminal(testa.charAt(0)) || testa.charAt(1) != ':'){
                return false;
            }
            
        }

        return true;
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
}
