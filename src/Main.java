import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<SWSystem>> systemMap = SWSystemData.getAllSystems();

        ArrayList<SWSystem> webSystems = systemMap.get("Web");

        SWSystem targetSystem = webSystems.get(0);

        targetSystem.getDimensions().get(0).getCriteria().get(0).setMeasuredValue(94.0);
        targetSystem.getDimensions().get(0).getCriteria().get(1).setMeasuredValue(91.0);

        targetSystem.getDimensions().get(1).getCriteria().get(0).setMeasuredValue(99.2);
        targetSystem.getDimensions().get(1).getCriteria().get(1).setMeasuredValue(2.1);

        targetSystem.getDimensions().get(2).getCriteria().get(0).setMeasuredValue(220.0);
        targetSystem.getDimensions().get(2).getCriteria().get(1).setMeasuredValue(38.0);

        targetSystem.getDimensions().get(3).getCriteria().get(0).setMeasuredValue(72.0);
        targetSystem.getDimensions().get(3).getCriteria().get(1).setMeasuredValue(8.5);

        targetSystem.printReport();
    }
}