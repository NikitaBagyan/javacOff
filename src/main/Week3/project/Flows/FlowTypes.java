package src.main.Week3.project.Flows;

public enum FlowTypes {

    HUMANITARIAN("Humanitarian"),
    MATH("Math");


    private final String flowType;

    FlowTypes(String type) {
        this.flowType = type;
    }

    public String getType() {
        return flowType;
    }

    @Override
    public String toString() {
        return flowType;
    }
}

