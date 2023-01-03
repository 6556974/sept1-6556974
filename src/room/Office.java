package room;

import java.util.HashMap;

public class Office implements RoomFactory {
    /**
     * 创建房间.
     * @return 返回普通房间.
     */
    public GeneralRoom createRoom() {
        int number = 5;
        HashMap<String, Integer> items = new HashMap<>();
        items.put("book",1);
        String description="in the computing admin office";
        return new CommonRoom(items, number, description);
    }
}
