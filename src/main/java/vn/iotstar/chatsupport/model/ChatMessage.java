package vn.iotstar.chatsupport.model;

public class ChatMessage {
    public enum Type { CHAT, JOIN, LEAVE, SYSTEM }

    private Type type;
    private String roomId;
    private String from;
    private String content;
    private long timestamp;

    // getter setter
    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
