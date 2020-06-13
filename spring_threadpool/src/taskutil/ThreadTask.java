package taskutil;

import org.springframework.core.task.TaskExecutor;



public class ThreadTask {
	
    private TaskExecutor taskExecutor;
    public TaskExecutor getTaskExecutor() {
	    return taskExecutor;
	}
	
	public void setTaskExecutor(TaskExecutor taskExecutor) {
	    this.taskExecutor = taskExecutor;
	}
	
	public void printMessages(Runnable r,int i) {
	        taskExecutor.execute(r);
	        System.out.println("add Thread："+i);
	}
}

