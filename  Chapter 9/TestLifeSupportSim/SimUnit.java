import java.util.ArrayList;

public class SimUnit {
    String botType;
    SimUnit (String type){
        botType=type;
        System.out.println("A " + botType + " sim unit with a power of " + powerUse() + " has been created.");
    }

    int powerUse(){
        if ("Retention".equals(botType)){
            return 2;
        } else {
            return 4;
        }
    }
}
