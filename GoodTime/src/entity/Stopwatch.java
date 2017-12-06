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

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void stop() {
        if (running) {
            this.stopTime = System.currentTimeMillis();
            this.currentTime = this.currentTime + this.stopTime - this.startTime;
            this.running = false;
        }
    }

    public String getTimeSec()
    {
        long elapsed;
        if (running) {
            elapsed = (System.currentTimeMillis() - this.startTime + this.currentTime) / 1000;
        } else {
            elapsed = this.currentTime / 1000;
        }

        long cur = elapsed;
        int[] res = new int[6];

        int hours = (int)elapsed / 3600;
        int minutes = ((int)elapsed % 3600) / 60;
        int seconds = (int)elapsed % 60;

        format(hours, res, "hours");
        format(minutes, res, "minutes");
        format(seconds, res, "seconds");

        return toString(res);

    }

    private void format(long time, int[] res, String type) {
        int ind1 = 4, ind2 = 5;
        if(type.equals("minutes")) {
            ind1 = 2;
            ind2 = 3;
        }
        else {
            if(type.equals("hours")) {
                ind1 = 0;
                ind2 = 1;
            }
        }

        if(time > 9) {
            res[ind1] = (int)time / 10;
            res[ind2] = (int)time % 10;
        }
        else {
            res[ind2] = (int)time;
        }
    }

    private String toString(int[] res) {
        String r = String.valueOf(res[0]) + String.valueOf(res[1]) + ":";
        r += String.valueOf(res[2]) + String.valueOf(res[3]) + ":";
        r += String.valueOf(res[4]) + String.valueOf(res[5]);
        return r;
    }

}
