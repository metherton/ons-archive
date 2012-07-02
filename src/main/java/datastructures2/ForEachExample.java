package datastructures2;
import static datastructures2.ListModule.emptyList;
import static datastructures2.ListModule.list;

import datastructures2.ListModule.List;
import functions.Function1Void;
public class ForEachExample {
    public static void main(String[] args) {
        argsToList(args).foreach(new Function1Void<String>() {
            public void apply(String arg) {
                System.out.println("You entered: "+arg);
            }
        });
    }
    private static List<String> argsToList(String[] args) {
        List<String> result = emptyList();
        for (String arg: args) {
            result = list(arg, result);
        }
        return result;
    }
}