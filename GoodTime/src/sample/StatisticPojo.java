package sample;

public class StatisticPojo {
    private String dayColumn;
    private String usefulTimeColumn;
    private String uselesslTimeColumn;

    public StatisticPojo(String dayColumn, String usefulTimeColumn, String uselesslTimeColumn) {
        this.dayColumn = dayColumn;
        this.usefulTimeColumn = usefulTimeColumn;
        this.uselesslTimeColumn = uselesslTimeColumn;
    }


    public String getDayColumn() {
        return dayColumn;
    }

    public void setDayColumn(String dayColumn) {
        this.dayColumn = dayColumn;
    }

    public String getUsefulTimeColumn() {
        return usefulTimeColumn;
    }

    public void setUsefulTimeColumn(String usefulTimeColumn) {
        this.usefulTimeColumn = usefulTimeColumn;
    }

    public String getUselesslTimeColumn() {
        return uselesslTimeColumn;
    }

    public void setUselesslTimeColumn(String uselesslTimeColumn) {
        this.uselesslTimeColumn = uselesslTimeColumn;
    }

    public StatisticPojo() {
    }

}