/**
 * RoomFactory接口为房间工厂.
 *
 * @author Dian Tu
 * @version 1.0
 */
package room;

public interface RoomFactory {
    /**
     * 创建房间.
     */
    public abstract GeneralRoom createRoom();
}
