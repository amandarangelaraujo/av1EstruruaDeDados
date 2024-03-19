import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> listaPokemons = new ArrayList<>();
        //151 pokemons disponíveis
        for(int i = 0; i<N; i++){
            listaPokemons.add(sc.next().toLowerCase());
        }
        int faltam = 151 - dropDuplicates(listaPokemons);
        System.out.printf("Falta (m) %d pomekon (s). \n",faltam );
        
        
       
    }
    public static int dropDuplicates(List<String> lista){
        Set<String> set = new HashSet<>(lista);
        return new ArrayList<>(set).size();
    }
}