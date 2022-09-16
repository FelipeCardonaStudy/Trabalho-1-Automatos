import java.util.ArrayList;

public class NaoTerminais {
    private ArrayList<Character> naoTerminais = new ArrayList<>();

    public boolean adicionaNaoTerminal(Character c){
        for(int i = 0; i < naoTerminais.size(); i++){
            Character ch = naoTerminais.get(i);
            if(ch.equals(c)){
                return false;
            }
        }
        naoTerminais.add(c);
        return true;
    }

    public Character getNaoTerminais(int index){
        return naoTerminais.get(index);
    }
}
