package chapater2;

public class Classroom {
    private String roomid;
    private int capacity;

    public Classroom(String roomid, int capacity) {
        this.roomid = roomid;
        this.capacity = capacity;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
