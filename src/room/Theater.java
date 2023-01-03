package room;

import java.util.HashMap;

public class Theater implements RoomFactory {
    public GeneralRoom createRoom() {
        int number = 5;
        HashMap<String, Integer> items = new HashMap<>();
        items.put("stage",100);
        items.put("doll",1);
        String description="in a lecture theater";
        return new CommonRoom(items, number, description);
    }
}
