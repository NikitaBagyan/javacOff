package src.main.Week3.project.Flows;

import src.main.Week3.project.Group;

import java.util.ArrayList;
import java.util.List;

public abstract class Flow {

    FlowTypes flowTypes;
    List<Group> groups = new ArrayList<>();

    public Flow(FlowTypes flowTypes) {
        this.flowTypes = flowTypes;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public abstract void addToFlow(Group group);
}
