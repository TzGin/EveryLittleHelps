package priv.TzGin.mediator.chatroom;

public class Test {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User userA = new User("A", chatRoom);
        User userB = new User("B", chatRoom);

        userA.sendMessage("hello");
        userB.sendMessage("hi");
    }
}
