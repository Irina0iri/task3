package Lesson3.Task3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.UUID;

public class Task {
    Random randomNumber = new Random();
    String taskName;
    int taskId;

    static int numberOfTask;
    int executionTime;


    public Task() {
    }

    public void run () throws InterruptedException {
        Thread.sleep(executionTime);
    }

    Integer generateId (){
        UUID id = UUID.randomUUID();
        return id.hashCode();
    }

    void init () {
        taskId = generateId();
        taskName = "task" + taskId;
        executionTime =  randomNumber.nextInt(20);
        numberOfTask++;
        System.out.println("init Done"  + taskId + "%% " + taskName + "----" + executionTime + "-----" +numberOfTask);
    }

    void destroy () {
        System.out.println("destroy");
    }

    @Override
    public String toString() {
        return "Task{" +
                "randomNumber=" + randomNumber +
                ", taskName='" + taskName + '\'' +
                ", taskId=" + taskId +
                ", executionTime=" + executionTime +
                '}';
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Lesson3/Task3/applicationContext.xml");

        Task task1 = context.getBean("beanTask", Task.class);
//        System.out.println(task1);
        Task task2 = context.getBean("beanTask", Task.class);
        Task task3 = context.getBean("beanTask", Task.class);

//        context.getBean("destroyer", Task.class);
//        context.getBean("destroyer", Task.class);
//        context.getBean("destroyer", Task.class);


        context.close();
    }
}
