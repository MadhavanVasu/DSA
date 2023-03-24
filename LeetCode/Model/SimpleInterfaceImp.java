package Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleInterfaceImp {

    public static void main(String[] args) {
        SimpleInterface impl = (n) -> {
            long fact = 1;
            for(int i=1;i<=n;i++)
                fact*=i;
            return fact;
        };
        System.out.println(impl.fact(5));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> cubes = list.stream().map(i -> i*i*i).
                collect(Collectors.toList());





    }

}
