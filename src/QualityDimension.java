
import java.util.ArrayList;

public class QualityDimension {
    private String name;
    private String isoCode;
    private double weight;
    private ArrayList<Criterion> criteriaList;

    public QualityDimension(String name, String isoCode, double weight) {
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;
        this.criteriaList = new ArrayList<>();
    }

    public void addCriterion(Criterion criterion) {
        criteriaList.add(criterion);
    }

    public ArrayList<Criterion> getCriteria() {
        return criteriaList;
    }

    public String getName() {
        return name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public double getWeight() {
        return weight;
    }


    public double calculateDimensionScore() {
        double totalScoreWeight = 0.0;
        double totalWeight = 0.0;

        for (Criterion crit : criteriaList) {
            double score = crit.calculateScore();
            totalScoreWeight += score * crit.getWeight();
            totalWeight += crit.getWeight();
        }

        if (totalWeight == 0) return 0.0;
        return totalScoreWeight / totalWeight;
    }


    public String getQualityLabel() {
        double score = calculateDimensionScore();
        if (score >= 4.5) return "Excellent Quality";
        if (score >= 3.5) return "Good Quality";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor Quality";
    }

    @Override
    public String toString() {
        return name + " [" + isoCode + "] (Weight: " + weight + ")";
    }
}