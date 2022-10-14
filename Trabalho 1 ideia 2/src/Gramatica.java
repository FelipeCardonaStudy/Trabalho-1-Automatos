import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class Gramatica {
    Random random = new Random();
    ArrayList<Character> terminais = new ArrayList<>();
    ArrayList<Character> naoTerminais = new ArrayList<>();
    Character simboloInicial;

    Character simboloProducoes;

    ArrayList<String> producoesList = new ArrayList<>();
    HashMap<Character, List<String>> producoes = new HashMap<>();

    /**
     * Adiciona um terminal na lista de terminais
     * @param t caractere terminal a ser adicionado
     * @return true caso adicione, false caso não adicione
     */
    public boolean adicionaTerminal(Character t){
        for(char temp : terminais) {
            if (temp == Character.toLowerCase(t)) {
                return false;
            }
        }
        terminais.add(Character.toLowerCase(t));
        return true;
    }

    /**
     * Adiciona um não terminal na lista de não terminais
     * @param n caractere não terminal a ser adicionado
     * @return true caso adicione, false caso não adicione
     */
    public boolean adicionaNaoTerminal(Character n){
        for(char temp : naoTerminais) {
            if (temp == Character.toUpperCase(n)) {
                return false;
            }
        }
        naoTerminais.add(Character.toUpperCase(n));
        return true;
    }

    /**
     * Remove um terminal da lista de terminais
     * @param t caractere terminal a ser removido
     * @return true caso remova, falso caso não tenha o caractere fornecido
     */
    public boolean removeTerminal(Character t){
        t = Character.toLowerCase(t);
        return terminais.remove(t);
    }

    /**
     * Remove um não terminal da lista de não terminais
     * @param n caractere não terminal a ser removido
     * @return true caso remova, falso caso não tenha o caractere fornecido
     */
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
     * Altera a gramatica armazenada no sistema
     * @param gramatica novas produções a serem armazenadas
     */
    public void alteraGramatica(String gramatica){
        producoes.clear();
        producoesList.clear();
        String[] dados = gramatica.split(";");
        Collections.addAll(producoesList, dados);
        for(String dado : dados){
            String[] informacoes = dado.split(":");
            List<String> transformacoes = Arrays.stream(informacoes[1].split("\\|")).toList();

            producoes.put(informacoes[0].charAt(0), transformacoes);
        }
    }

    /**
     * Gera uma String com o formalismo da gramática
     * @return formalismo da gramática
     */
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
                formalismo += terminais.get(i);
            }
        }
        formalismo += "}, " + simboloProducoes + ", " + simboloInicial + ")";
        return formalismo;
    }

    /**
     * Valida a gramática inserida no sistema
     * @return true caso seja válida, false caso seja inválida
     */
    public boolean validaGramatica(){
        if(simboloProducoes == null){
            return false;
        }
        if(simboloInicial == null){
            return false;
        }
        for(String linha : producoesList){
            if(linha.charAt(1) != ':'){
                return false;
            }
        }
        for(String linha : producoesList){
            if(!isNaoTerminal(linha.charAt(0))){
                return false;
            }
        }
        for(String linha : producoesList){
            for(int i = 0; i < linha.length(); i++){
                if(!isTerminal(linha.charAt(i))){
                    return false;
                }
            }
        }
        if(!naoTerminais.contains(simboloInicial)){
            return false;
        }
        if(producoesList.get(0).charAt(0) != simboloInicial){
            return false;
        }
        return true;
    }

    /**
     * Determina o tipo da gramática no sistema, podendo ser regular, livre de contexto ou nenhuma das duas
     * @return o tipo da gramática
     */
    public String tipoGramatica(){
        List<String> lista = producoes.get(simboloInicial);
        if(hasEmpty(lista)){
            if(isRegular(lista)){
                return "regular";
            }
            return "nem regular, nem livre de contexto.";
        }
        if(isRegular(lista)){
            return "regular";
        }
        return "livre de contexto";
    }

    /**
     * Gera exemplos de sentença a partir da gramática no sistema
     * @param quantidadeSentencas quantidade de sentenças a serem geradas
     * @return uma lista com todas sentenças geradas
     */
    public ArrayList<String> geraSentencas(int quantidadeSentencas){
        ArrayList<String> answer = new ArrayList<>();
        List<String> lista = producoes.get(simboloInicial);
        for(int i = 0; i < quantidadeSentencas; i++){
            String result = lista.get(random.nextInt(lista.size()));
            answer.add(geraSentencaNaoTerminal(result));
        }
        return answer;
    }

    /**
     * Método recursivo de geração de sentenças
     * @param result String inicial
     * @return String final
     */
    private String geraSentencaNaoTerminal(String result){
        String answer = result;
        for(int i = 0; i < result.length(); i ++){
            if(Character.isUpperCase(result.charAt(i))){
                answer = result.replaceFirst(String.valueOf(result.charAt(i)), producoes.get(result.charAt(i)).get(random.nextInt(producoes.get(result.charAt(i)).size())));
                answer = geraSentencaNaoTerminal(answer);
            }
        }
        return answer;
    }

    /**
     * Verifica se a produção contém o símbolo de vazio
     * @param lista produção a ser verificada
     * @return true caso contenha, false caso não contenha
     */
    private boolean hasEmpty(List<String> lista){
        for(String dado : lista){
            if(dado.equals("0")){
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se a produção é regular
     * @param lista produção a ser verificada
     * @return true caso seja regular, false caso não seja
     */
   public boolean isRegular(List<String> lista){
        for(String dado : lista){
            if(dado.length() > 2){
                return false;
            }
            if(dado.length() == 1){
                if(Character.isUpperCase(dado.charAt(0))){
                    return false;
                }
            }
            else if(Character.isUpperCase(dado.charAt(0)) || Character.isLowerCase(dado.charAt(1))){
                return false;
            }
        }
        return true;
   }

   public boolean isNaoTerminal(Character nT){
       for(Character test : naoTerminais){
           if(test == nT){
               return true;
           }
       }
       return false;
   }

   public boolean isTerminal(Character t){
       for(Character test : naoTerminais){
           if(test == t){
               return true;
           }
       }
       return false;
   }
}
