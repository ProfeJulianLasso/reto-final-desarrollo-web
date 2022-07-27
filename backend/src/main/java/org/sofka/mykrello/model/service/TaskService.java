package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private LogService logService;

    @Override
    public List<TaskDomain> findAllTasksById(Integer idBoard) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TaskDomain findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TaskDomain create(TaskDomain task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TaskDomain update(Integer id, TaskDomain task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TaskDomain delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
}
