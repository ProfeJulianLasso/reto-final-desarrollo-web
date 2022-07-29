package org.sofka.mykrello.model.service;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnService implements ColumnInterface {


    @Autowired
    private ColumnRepository columnRepository;

    @Override
    public List<ColumnDomain> findAll() {
        return columnRepository.findAll();
    }

    @Override
    public ColumnDomain findById(Integer id) {
        return null;
    }

    @Override
    public ColumnDomain create(ColumnDomain task) {
        return null;
    }

    @Override
    public ColumnDomain update(ColumnDomain task) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
