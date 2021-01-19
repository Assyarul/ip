public abstract class AbstractTaskFactory {

    protected abstract Task createTask(String parameters);

    public Task getTask(String parameters) {
        return this.createTask(parameters);
    }

}