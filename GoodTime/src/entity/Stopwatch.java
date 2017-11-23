package entity;


public class Stopwatch {

    private long startTime = 0;
    private long stopTime = 0;
    private long currentTime = 0;
    private boolean running = false;

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        if(running) {
            this.stopTime = System.currentTimeMillis();
            this.currentTime = this.currentTime + this.stopTime-this.startTime;
            this.running = false;
        }
    }

    public String getTimeSec() {
        long elapsed;
        if (running) {
            elapsed = (System.currentTimeMillis() - this.startTime + this.currentTime) / 1000;
        } else {
            elapsed = (this.stopTime - this.startTime + this.currentTime) / 1000;
        }
        return Long.toString(elapsed);
    }

}
