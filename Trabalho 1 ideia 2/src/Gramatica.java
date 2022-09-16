import java.util.ArrayList;

public class Gramatica {
    ArrayList<Character> terminais = new ArrayList<>();
    ArrayList<Character> naoTerminais = new ArrayList<>();
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

}
