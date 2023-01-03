package room;


public class randomRoomBuilding implements RoomFactory {
    /**
     * @return
     */
    @Override
    public GeneralRoom createRoom() {
        int number = 6;
        String description="Oh!You will be transported to a random room.";
        return new randomRoom(number, description);

    }
}