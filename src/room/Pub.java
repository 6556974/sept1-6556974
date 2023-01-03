package room;

import java.util.HashMap;

public class Pub implements RoomFactory {
    public GeneralRoom createRoom() {
        int number = 3;
        HashMap<String, Integer> items = new HashMap<>();
        items.put("wine",1);
        String description="in the campus pub";
        return new CommonRoom(items, number, description);
    }
}
