import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.StringBuilder;

public class Storage {
    private static final String FILE_NAME = "duke.txt";
    private TaskManager tasks;

    public Storage(TaskManager tasks) {
        this.tasks = tasks;
    }
    public void read() {
        try {
            FileReader reader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String taskString;
            taskString = bufferedReader.readLine();
            while(taskString!=null) {
                String[] taskArray = taskString.split("\\|");
                for (String s : taskArray) {
                    System.out.println(s);
                }
                this.tasks.addTask(taskArray);
                taskString = bufferedReader.readLine();
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("No existing file found. Creating...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Task task: tasks.getTasks()) {
            sb.append(task.toFileString());
            sb.append('\n');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        FileWriter writer = new FileWriter(FILE_NAME);
        writer.write(sb.toString());
        writer.close();
    }
}
