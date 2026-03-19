
import java.util.ArrayList;
import java.util.HashMap;

public class SWSystemData {

    public static HashMap<String, ArrayList<SWSystem>> getAllSystems() {
        HashMap<String, ArrayList<SWSystem>> map = new HashMap<>();

        ArrayList<SWSystem> webList = new ArrayList<>();
        webList.add(createECommercePlatform());
        webList.add(createBankingPortal());
        map.put("Web", webList);

        ArrayList<SWSystem> mobileList = new ArrayList<>();
        mobileList.add(createHealthApp());
        map.put("Mobile", mobileList);

        return map;
    }

    private static SWSystem createECommercePlatform() {
        SWSystem s = new SWSystem("ShopSphere", "Web", "3.2.1");

        QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 25);
        funcSuit.addCriterion(new Criterion("Functional Completeness Ratio", 50, "higher", 0, 100, "%"));
        funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));
        s.addDimension(funcSuit);

        QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 25);
        reliability.addCriterion(new Criterion("Availability Ratio", 50, "higher", 95, 100, "%"));
        reliability.addCriterion(new Criterion("Defect Density", 50, "lower", 0, 20, "defect/KLOC"));
        s.addDimension(reliability);

        QualityDimension performance = new QualityDimension("Performance Efficiency", "QC.PE", 25);
        performance.addCriterion(new Criterion("Response Time", 50, "lower", 0, 500, "ms"));
        performance.addCriterion(new Criterion("CPU Utilisation Ratio", 50, "lower", 0, 100, "%"));
        s.addDimension(performance);

        QualityDimension maintainability = new QualityDimension("Maintainability", "QC.MA", 25);
        maintainability.addCriterion(new Criterion("Test Coverage Ratio", 50, "higher", 0, 100, "%"));
        maintainability.addCriterion(new Criterion("Cyclomatic Complexity (avg)", 50, "lower", 0, 20, "score"));
        s.addDimension(maintainability);

        return s;
    }

    private static SWSystem createBankingPortal() {
        SWSystem s = new SWSystem("SecureBank", "Web", "1.0.0");

        QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 25);
        funcSuit.addCriterion(new Criterion("Functional Completeness Ratio", 50, "higher", 0, 100, "%"));
        funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));
        s.addDimension(funcSuit);

        QualityDimension security = new QualityDimension("Security", "QC.SE", 25);
        security.addCriterion(new Criterion("Security Test Coverage", 50, "higher", 0, 100, "%"));
        security.addCriterion(new Criterion("Vulnerability Count", 50, "lower", 0, 10, "count"));
        s.addDimension(security);

        QualityDimension usability = new QualityDimension("Usability", "QC.US", 25);
        usability.addCriterion(new Criterion("Task Completion Rate", 50, "higher", 0, 100, "%"));
        usability.addCriterion(new Criterion("User Error Rate", 50, "lower", 0, 5, "%"));
        s.addDimension(usability);

        QualityDimension portability = new QualityDimension("Portability", "QC.PO", 25);
        portability.addCriterion(new Criterion("Installability", 50, "higher", 0, 100, "%"));
        portability.addCriterion(new Criterion("Replaceability", 50, "higher", 0, 100, "%"));
        s.addDimension(portability);

        return s;
    }

    private static SWSystem createHealthApp() {
        SWSystem s = new SWSystem("HealthTrack", "Mobile", "2.4.0");

        QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 25);
        funcSuit.addCriterion(new Criterion("Functional Completeness Ratio", 50, "higher", 0, 100, "%"));
        funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));
        s.addDimension(funcSuit);

        QualityDimension performance = new QualityDimension("Performance Efficiency", "QC.PE", 25);
        performance.addCriterion(new Criterion("Throughput", 50, "higher", 0, 100, "req/s"));
        performance.addCriterion(new Criterion("MTBF (Mean Time Between Failures)", 50, "higher", 100, 1000, "hours"));
        s.addDimension(performance);

        QualityDimension usability = new QualityDimension("Usability", "QC.US", 25);
        usability.addCriterion(new Criterion("Task Completion Rate", 50, "higher", 0, 100, "%"));
        usability.addCriterion(new Criterion("User Error Rate", 50, "lower", 0, 5, "%"));
        s.addDimension(usability);

        QualityDimension maintainability = new QualityDimension("Maintainability", "QC.MA", 25);
        maintainability.addCriterion(new Criterion("Test Coverage Ratio", 50, "higher", 0, 100, "%"));
        maintainability.addCriterion(new Criterion("Cyclomatic Complexity (avg)", 50, "lower", 0, 20, "score"));
        s.addDimension(maintainability);

        return s;
    }
}