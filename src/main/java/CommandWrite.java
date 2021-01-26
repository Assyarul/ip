import java.io.IOException;

public class CommandWrite implements ICommand{
    private ICommand decoratedCommand;
    private Storage storage;
    private TaskList taskList;

    public CommandWrite(ICommand decoratedCommand,Storage storage){
        this.storage = storage;
        this.decoratedCommand = decoratedCommand;
    }

    public void execute(String parameters){
        try {
            decoratedCommand.execute(parameters);
            storage.write();
        } catch (IOException e) {
            System.out.println("Error: Unable to write to file");
        }
    }
}