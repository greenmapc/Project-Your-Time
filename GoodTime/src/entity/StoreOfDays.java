package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreOfDays extends ArrayList<Day> {
    Scanner sc;
    FileWriter writer;

    public StoreOfDays() throws FileNotFoundException {
        sc = new Scanner(new File("src/repository/database"));
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] parse = s.split(" ");
            Day day = new Day();
            day.setDate(parse[0]);
            day.setUsefulTime(parse[1]);
            day.setUselessTime(parse[2]);
            this.add(day);
        }
    }


    public void save() throws IOException {
        writer = new FileWriter(new File("src/repository/database"));
        for (int i = 0; i < this.size(); i++) {
            writer.write(this.get(i).toString() + "\n");
        }
        writer.close();
    }
}
