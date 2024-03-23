package org.example;

public class Program {
    String channel;
    BroadcastsTime time;
    String name;

    public Program(String channel, BroadcastsTime time, String name) {
        this.channel = channel;
        this.time = time;
        this.name = name;
    }

    public String getChannel() {
        return channel;
    }

    public String getName() {
        return name;
    }

    public BroadcastsTime getTime() {
        return time;
    }
    public String toString() {
        return "" + channel + " " + time + " " + name;
    }
}
