package job;

public interface JobQueue {

    void enqueue(Job job) throws InterruptedException;

    Job dequeue() throws InterruptedException;
}
