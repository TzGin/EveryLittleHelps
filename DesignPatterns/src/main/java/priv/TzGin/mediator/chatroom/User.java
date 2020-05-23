package priv.TzGin.mediator.chatroom;

public class User {

    private String name;
    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg) {
        chatRoom.showMsg(this, msg);
    }
}
