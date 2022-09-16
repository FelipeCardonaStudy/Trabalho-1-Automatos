import java.util.ArrayList;

public class Terminais {

    private ArrayList<Character> terminais = new ArrayList<>();

    public boolean adicionaTerminal(Character c){
        for(int i = 0; i < terminais.size(); i++){
            Character ch = terminais.get(i);
            if(ch.equals(c)){
                return false;
            }
        }
        terminais.add(c);
        return true;
    }

    public Character getTerminais(int index){
        return terminais.get(index);
    }
}
