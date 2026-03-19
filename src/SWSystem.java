
import java.util.ArrayList;

public class SWSystem {
    private String name;
    private String category;
    private String version;
    private ArrayList<QualityDimension> dimensions;

    public SWSystem(String name, String category, String version) {
        this.name = name;
        this.category = category;
        this.version = version;
        this.dimensions = new ArrayList<>();
    }

    public void addDimension(QualityDimension dimension) {
        dimensions.add(dimension);
    }

    public ArrayList<QualityDimension> getDimensions() {
        return dimensions;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getVersion() {
        return version;
    }


    public double calculateOverallScore() {
        double totalScoreWeight = 0.0;
        double totalWeight = 0.0;

        for (QualityDimension dim : dimensions) {
            double score = dim.calculateDimensionScore();
            totalScoreWeight += score * dim.getWeight();
            totalWeight += dim.getWeight();
        }

        if (totalWeight == 0) return 0.0;
        return totalScoreWeight / totalWeight;
    }


    public QualityDimension findWeakestDimension() {
        QualityDimension weakest = null;
        double lowestScore = Double.MAX_VALUE;

        for (QualityDimension dim : dimensions) {
            double score = dim.calculateDimensionScore();
            if (score < lowestScore) {
                lowestScore = score;
                weakest = dim;
            }
        }
        return weakest;
    }


    public void printReport() {
        System.out.println("=======================================");
        System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
        System.out.println("System: " + name + " v" + version + " (" + category + ")");
        System.out.println("========================================\n");

        for (QualityDimension dim : dimensions) {
            System.out.println("--- " + dim + " ---");
            for (Criterion crit : dim.getCriteria()) {
                System.out.println(crit);
            }
            System.out.println(">> Dimension Score: " + dim.calculateDimensionScore() + "/5 [" + dim.getQualityLabel() + "]");
            System.out.println();
        }

        double overallScore = calculateOverallScore();
        System.out.println("=======================================");
        System.out.println("OVERALL QUALITY SCORE: " + overallScore + "/5 [" + getOverallLabel(overallScore) + "]");
        System.out.println("========================================\n");

        QualityDimension weakest = findWeakestDimension();
        if (weakest != null) {
            double gap = 5.0 - weakest.calculateDimensionScore();
            System.out.println("GAP ANALYSIS (ISO/IEC 25010)");
            System.out.println("=======================================");
            System.out.println("Weakest Characteristic : " + weakest.getName() + " [" + weakest.getIsoCode() + "]");
            System.out.println("Score: " + weakest.calculateDimensionScore() + "/5  |  Gap: " + gap);
            System.out.println("Level: " + weakest.getQualityLabel());
            System.out.println(">> This characteristic requires the most improvement.");
            System.out.println("========================================");
        }
    }

    private String getOverallLabel(double score) {
        if (score >= 4.5) return "Excellent Quality";
        if (score >= 3.5) return "Good Quality";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor Quality";
    }
}