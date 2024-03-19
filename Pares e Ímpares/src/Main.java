import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List listaPar = new ArrayList<Integer>();
        List listaImpar = new ArrayList<Integer>();

        //COMPUTANDO OS VALORES
        for(int i = 0; i<N; i++){
            int a = sc.nextInt();
            if(a%2==0){
                listaPar.add(a);
            }
            else{
                listaImpar.add(a);
            }
        }

        Collections.sort(listaPar);
        Collections.sort(listaImpar, Collections.reverseOrder());
        listaPar.addAll(listaImpar);
        for (int i = 0; i<listaPar.size();i++){
            System.out.println(listaPar.get(i));
        }
        
    }

}