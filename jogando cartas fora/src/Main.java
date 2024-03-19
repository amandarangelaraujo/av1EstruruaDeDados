import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while(true){

            int N = sc.nextInt();

            if (N==0){
                break;
            }

        //criando a lista com as cartas
            List<Integer> cartas = new ArrayList<>();
            StringBuilder descartadas = new StringBuilder();



        //adicionando as cartas na lista
            for(int i=1; i<=N;i++){
                cartas.add(i);
            }
        descartadas.append("Discarded cards: ");
        //manipulando as cartas
            while(cartas.size()>=2){
                if(cartas.size()==2){
                    descartadas.append(cartas.remove(0));
                    
                }else{
                    descartadas.append(cartas.remove(0)+", ");
                }
                cartas.add(cartas.size()-1, cartas.remove(0));
            }

            
            
            System.out.println(descartadas);
            System.out.println("Remaining card: " + cartas.get(0));
            
        }
    }
        

}





