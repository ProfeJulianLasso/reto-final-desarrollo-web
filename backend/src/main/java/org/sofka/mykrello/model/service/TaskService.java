package org.sofka.mykrello.model.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.sofka.mykrello.model.domain.BoardDomain;
import org.sofka.mykrello.model.domain.ColumnDomain;
import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private LogService logService;

    @Override
    public List<TaskDomain> taskByIdBoard(Integer idBoard) {
        var tarea = taskRepository.findByIdBoard(idBoard);
        return tarea;
    }

    @Override
    @Transactional(readOnly = true)

    public TaskDomain findById(Integer id) {
        // TODO Auto-generated method stub
        Optional<TaskDomain> tarea = taskRepository.findById(id);
        return tarea.isPresent() ? tarea.get() : null;

    }

    @Override
    public TaskDomain create(TaskDomain task) {

        return taskRepository.save(task);
    }

    @Override
    public TaskDomain update(Integer id, TaskDomain task) {

        task.setId(id);

        var a = taskRepository.save(task);
        return a;
    }

    @Override
    public TaskDomain delete(Integer id) {

        try {
            var taskDomain = taskRepository.findById(id);

            taskRepository.deleteById(id);
            return taskDomain.get();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());

            return null;
        }

    }
}
