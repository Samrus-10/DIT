package sam.rus.rostov.service;

import sam.rus.rostov.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task save(Task task);

    void delete(int id);
}
