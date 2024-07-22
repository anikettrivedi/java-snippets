package multithreading.solutions;

import java.util.List;

public class MultiExecutor {

    List<Runnable> tasks;
    
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    
    public void executeAll() {
        for (Runnable runnable: tasks) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}