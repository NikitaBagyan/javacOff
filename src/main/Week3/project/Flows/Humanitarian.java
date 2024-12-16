package src.main.Week3.project.Flows;

import src.main.Week3.project.Group;

public class Humanitarian extends Flow {

    public Humanitarian(FlowTypes flowTypes) {
        super(flowTypes);
    }

    @Override
    public void addToFlow(Group group) {
        groups.add(group);
    }
}
