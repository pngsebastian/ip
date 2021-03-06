package duke.ui;

import duke.exceptions.DukeException;
import duke.tasks.Task;
import duke.tasks.TaskList;

import java.util.ArrayList;

/**
 * class DukeResponses
 * @author Png Zheng Jie, Sebastian
 * Description: A class to represent all of Duke's responses to the user inputs
 */
public class DukeResponses {
    /**
     * showWelcome: show welcome message to user
     * @return welcome message
     */
    public String showWelcome() {
        return "Hello! I'm Duke\n" + "What can I do for you?";
    }

    /**
     * showGoodbye: show goodbye message to user
     * @return goodbye message
     */
    public String showGoodbye() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * showError: show error message to user
     * @param e a DukeException
     * @return error message
     */
    public String showError(DukeException e) {
        assert e != null : "Error should not be null";
        return e.getMessage();
    }

    /**
     * showCommands: show list of available commands that Duke recognises to user
     * @return list of available commands
     */
    public String showCommands() {
        return "List of recognised user commands:\n"
                + "  1. todo - adds a todo (E.g. todo borrow book)\n"
                + "  2. deadline - adds a deadline (E.g. deadline return book /by 2021-02-04)\n"
                + "  3. event - adds an event (E.g. event project meeting /at 2021-03-05)\n"
                + "  4. delete - removes a task from the lists of task (E.g. delete 2)\n"
                + "  5. done - marks a task as done in the list of tasks (E.g. done 2)\n"
                + "  6. find - finds and displays tasks that matches the input keyword (E.g. find book)\n"
                + "  7. list - displays the list of tasks\n"
                + "  8. help - displays the list of commands that Duke recognises\n"
                + "  9. bye - terminates Duke";
    }

    /**
     * showAddTask: show to user that task is successfully added to the TaskList
     * @param task task to be added into the TaskList
     * @param tasks list of Task
     * @return add task success message
     */
    public String showAddTask(Task task, TaskList tasks) {
        assert task != null : "task should not be null";
        int numOfTasks = tasks.getSize();
        return"Got it. I've added this task:\n" + "  " + task + "\n" + "Now you have " +
                    numOfTasks + (numOfTasks <= 1 ? " task" : " tasks") + " in the list.";
    }

    /**
     * showDeleteTask: show to user that task is successfully deleted from the TaskList
     * @param task task to be deleted from the TaskList
     * @param tasks list of Task
     * @return delete task success message
     */
    public String showDeleteTask(Task task, TaskList tasks) {
        assert task != null : "task should not be null";
        int numOfTasks = tasks.getSize();
        return "Noted. I've removed this task:\n" + "  " + task + "\n" + "Now you have " + numOfTasks +
                    " tasks in the list.";
    }

    /**
     * showCompleteTask: show to user that task is successfully marked as completed in the TaskList
     * @param task task to be marked as completed in the TaskList
     * @return complete task success message
     */
    public String showCompleteTask(Task task) {
        assert task != null : "task should not be null";
        return "Nice! I've marked this task as done:\n" + "  " + task;
    }

    /**
     * showTaskList: show to user the entire TaskList
     * @param tasks list of Task
     * @param taskType
     * @return list of tasks
     */
    public String showTaskList(ArrayList<Task> tasks, String taskType) {
        if (tasks.size() <= 0) {
            return "There are no " + taskType + "tasks at the moment.";
        } else {
            int counter = 1;
            String listHeader = "Here are the " + taskType + "tasks in your list:\n";
            StringBuilder outputList = new StringBuilder();
            outputList.append(listHeader);

            for (Task task : tasks) {
                String t = "  " + counter + ". " + task + "\n";
                outputList.append(t);
                counter++;
            }
            return outputList.toString();
        }
    }
}
