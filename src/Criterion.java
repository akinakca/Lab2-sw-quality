
public class Criterion {
    private String name;
    private double weight;
    private String direction;
    private double minValue;
    private double maxValue;
    private String unit;
    private double measuredValue;

    public Criterion(String name, double weight, String direction, double minValue, double maxValue, String unit) {
        this.name = name;
        this.weight = weight;
        this.direction = direction;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
        this.measuredValue = 0.0;
    }

    public void setMeasuredValue(double measuredValue) {
        this.measuredValue = measuredValue;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public String getUnit() {
        return unit;
    }

    public double getMeasuredValue() {
        return measuredValue;
    }


    public double calculateScore() {
        double range = maxValue - minValue;
        double rawScore;

        if (range == 0) {
            return 3.0;
        }

        if (direction.equalsIgnoreCase("higher")) {
            rawScore = 1 + ((measuredValue - minValue) / range) * 4;
        } else {
            rawScore = 5 - ((measuredValue - minValue) / range) * 4;
        }

        if (rawScore < 1) rawScore = 1;
        if (rawScore > 5) rawScore = 5;

        return Math.round(rawScore * 2) / 2.0;
    }

    @Override
    public String toString() {
        return name + ": " + measuredValue + " " + unit + " -> Score: " + calculateScore() + " (" + direction + " is better)";
    }
}