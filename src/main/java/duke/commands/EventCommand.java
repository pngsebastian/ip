package duke.commands;

import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.Event;
import duke.tasks.TaskList;
import duke.tasks.Task;
import duke.ui.DukeResponses;

/**
 * class EventCommand
 * @author Png Zheng Jie, Sebastian
 * Description: A class to represent an executable command that corresponds to the user input "event"
 */
public class EventCommand extends Command{
    private String eventDescription;
    private String period;

    /**
     * Constructor: creates a new EventCommand
     * @param eventDescription description of Event
     * @param period period of Event
     */
    public EventCommand(String eventDescription, String period) {
        this.eventDescription = eventDescription;
        this.period = period;
    }

    /**
     * execute: executes the command
     * @param tasks the list of tasks
     * @param dukeResponses
     * @param storage
     * @return add event success message, or
     *         an error message
     */
    public String execute(TaskList tasks, DukeResponses dukeResponses, Storage storage) {
        try {
            Task event = new Event(eventDescription, period);
            tasks.addTask(event);
            storage.saveFile(tasks.getTaskList());
            return dukeResponses.showAddTask(event, tasks);
        } catch (DukeException e) {
            return dukeResponses.showError(e);
        }
    }
}
