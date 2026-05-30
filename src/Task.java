public class Task
{

    private int id;
    private String title;
    private boolean done;

    public Task(int id, String title)
    {
        this.id = id;
        this.title = title;
        done = false;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void markAsDone()
    {
        this.done = true;
    }

    public boolean isDone()
    {
        return done;
    }

    @Override
    public String toString()
    {
        return String.format("ID: [ %d ] | Task: [ %-10s ] | State: [ %s ]",
                id, title, isDone() ? "✓" : "✗");
    }
}
