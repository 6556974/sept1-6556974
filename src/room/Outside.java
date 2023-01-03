package room;

import java.util.HashMap;

public class Outside implements RoomFactory{
    /**
     * 创建房间.
     * @return 返回随机房间.
     */
    @Override
    public GeneralRoom createRoom() {
        int number = 1;
        HashMap<String, Integer> items = new HashMap<>();
        String description="outside the main entrance of the university";
        return new CommonRoom(items, number, description);
    }
}