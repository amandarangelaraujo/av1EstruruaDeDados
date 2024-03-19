import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        sc.nextLine();
        List<List<String>> listaListas = new ArrayList<>();

        for(int i = 0; i<N; i++){
            String compras = sc.nextLine();
            listaListas.add(criarListaOrdenada(compras));
        }
        listaListas.
        for (List<String> listadelistas: listaListas ){
            for(String item: listadelistas){
                System.out.print(item + " ");
            }
            System.out.println();
            
        }
    }
    public static List<String> dropDuplicates(List<String> lista){
        Set<String> set = new HashSet<>(lista);
        return new ArrayList<>(set);
    }

    public static List<String> criarListaOrdenada(String compras){
        String[] elementos = compras.split(" ");
        List <String> listaValentina = new ArrayList<>();
        for (String elemento: elementos){
            listaValentina.add(elemento.toLowerCase());
        }
        listaValentina = dropDuplicates(listaValentina);
        Collections.sort(listaValentina);        
        return listaValentina;
    }
}