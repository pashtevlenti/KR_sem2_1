package org.example;

public class BroadcastsTime implements Comparable<BroadcastsTime>{
    private String time;

    public BroadcastsTime(String time) {
        this.time = time;
    }

    public byte hour(){
        String[] times = time.split(":");
        return (byte) Integer.parseInt(times[0]);
    }
    public byte minutes(){
        String[] times = time.split(":");
        return (byte) Integer.parseInt(times[1]);
    }
    public boolean after(BroadcastsTime x){
        if (this.compareTo(x) > 0) return true;
        return false;
    }
    public boolean before(BroadcastsTime x){
        if (this.compareTo(x) < 0) return true;
        return false;
    }
    public boolean between(BroadcastsTime t1, BroadcastsTime t2){
        if (((this.compareTo(t1) > 0) && (this.compareTo(t2) < 0)) || ((this.compareTo(t1) > 0) && (this.compareTo(t2) < 0))){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(BroadcastsTime x) {
        if (x.hour() > this.hour()) return 1;
        if (x.hour() == this.hour()){
            if (x.minutes() > this.minutes()) return 1;
            if (x.minutes() == this.minutes()) return 0;
            return -1;
        }
        return -1;
    }
}
