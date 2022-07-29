package org.sofka.mykrello.model.service;

import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnForBoardInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnForBoardService implements ColumnForBoardInterface {

    @Autowired
    private ColumnForBoardRepository columnForBoardRepository;

    @Override
    public List<ColumnForBoardDomain> findAll() {
        return columnForBoardRepository.findAll();
    }

    public List<ColumnForBoardDomain> findAllByBoardId(Integer id){

        // Omite por ahora
        return null;

    }

    @Override
    public ColumnForBoardDomain findById(Integer id) {
        return null;
    }

    @Override
    public ColumnForBoardDomain create(ColumnForBoardDomain task) {
        return null;
    }

    @Override
    public ColumnForBoardDomain update(ColumnForBoardDomain task) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
