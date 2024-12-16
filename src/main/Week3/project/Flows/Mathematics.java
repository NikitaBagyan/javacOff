package src.main.Week3.project.Flows;

import src.main.Week3.project.Group;

public class Mathematics extends Flow {

    public Mathematics(FlowTypes flowTypes) {
        super(flowTypes);
    }

    @Override
    public void addToFlow(Group group) {
        groups.add(group);
    }
}
