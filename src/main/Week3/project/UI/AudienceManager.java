package src.main.Week3.project.UI;

import src.main.Week3.project.Audience;
import src.main.Week3.project.Types;

import java.util.List;

public interface AudienceManager {
    void addAudience(String roomNumber, int typeIndex);
    List<Audience> getAudiences();
    List<Types> getAudienceTypes();
}
