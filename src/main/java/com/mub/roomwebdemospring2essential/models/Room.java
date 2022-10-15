package com.mub.roomwebdemospring2essential.models;

import javax.persistence.*;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long roomId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROOM_NUMBER")
    private String roomNumb;
    @Column(name = "BED_INFO")
    private String bedInfo;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumb() {
        return roomNumb;
    }

    public void setRoomNumb(String roomNumb) {
        this.roomNumb = roomNumb;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", roomNumb='" + roomNumb + '\'' +
                ", bedInfo='" + bedInfo + '\'' +
                '}';
    }
}
