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
        if (running) {
            this.stopTime = System.currentTimeMillis();
            this.currentTime = this.currentTime + this.stopTime - this.startTime;
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

        return format(elapsed);
    }

    private String format(long sec) {
        long hours = sec / 3600;
        long min = (sec % 3600) / 60;
        long s = sec % 60;
        StringBuilder f = new StringBuilder();
        f.append(hours);
        f.append(":");
        f.append(min);
        f.append(":");
        f.append(s);
        String result = f.toString();
        return result;
    }

}
