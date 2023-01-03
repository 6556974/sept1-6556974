package room;

import java.util.HashMap;

public class Lab implements RoomFactory{
    /**
     * 创建房间.
     * @return 返回普通房间.
     */
    public GeneralRoom createRoom() {
        int number = 4;
        HashMap<String, Integer> items = new HashMap<>();
        items.put("computer",1);
        items.put("cookie",0);
        String description="in a computing lab";
        return new CommonRoom(items, number, description);
    }
}

