package lectures;
import java.util.ArrayList;
import java.util.List;

public class lect {
    public static void main(String[] args){

        List<Integer> avalableDivider = findSimple(100);
        for (Integer integer: avalableDivider){
            System.out.println(integer);
        }  
    }

    public static List<Integer> findAvailableDivider(int number){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < number; i++){
            if (number % i == 0) {
                    result.add(i);
             }
        }
        return result;
    }

    public static List<Integer> findSimple(int max){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i<=max; i++){
            boolean simple = true;
            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    simple = false;
                }
            }
            if (simple){
                    result.add(i);
            } 
        }
        return result;
    }     

    public void reverse(){
        
    }
}
