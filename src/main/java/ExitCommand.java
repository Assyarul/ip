public class ExitCommand implements ICommand {
    private TaskManager tasks;

    public ExitCommand(TaskManager tasks) {
        this.tasks = tasks;
    }

    @Override
    public void execute(String parameters) {
        tasks.setExited();
        System.out.println("Bye. Hope to see you again soon!");
    }
}