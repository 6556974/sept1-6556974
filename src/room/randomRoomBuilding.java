package room;

public class randomRoomBuilding implements RoomFactory {
    /**
     * 创建房间.
     * @return 返回随机房间.
     */
    @Override
    public GeneralRoom createRoom() {
        int number = 6;
        String description="Oh!You will be transported to a random room.";
        return new randomRoom(number, description);

    }
}