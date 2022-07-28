package org.sofka.mykrello.model.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskServiceInterface {

    Logger log = Logger.getLogger("Logger");

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LogService logService;

    @Override
    public List<TaskDomain> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskDomain findById(Integer id) {
        Optional<TaskDomain> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public TaskDomain create(TaskDomain task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskDomain update(TaskDomain task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

}
