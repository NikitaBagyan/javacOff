package src.main.Week3.project.UI;

import src.main.Week3.project.Audience;
import src.main.Week3.project.Types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudienceManagerImpl implements AudienceManager {
    private final List<Audience> audiences = new ArrayList<>();
    private final List<Types> audienceTypes = Arrays.asList(Types.values());

    @Override
    public void addAudience(String roomNumber, int typeIndex) {
        Types type = audienceTypes.get(typeIndex - 1);
        Audience audience = new Audience(type, roomNumber);
        audiences.add(audience);
        System.out.println("Аудитория добавлена: " + audience);
    }

    @Override
    public List<Audience> getAudiences() {
        return audiences;
    }

    @Override
    public List<Types> getAudienceTypes() {
        return audienceTypes;
    }
}
