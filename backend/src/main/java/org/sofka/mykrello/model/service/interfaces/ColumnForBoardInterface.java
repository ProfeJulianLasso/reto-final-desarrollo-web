package org.sofka.mykrello.model.service.interfaces;

import org.sofka.mykrello.model.domain.ColumnForBoardDomain;

import java.util.List;

public interface ColumnForBoardInterface {

    public List<ColumnForBoardDomain> findAll();
    public ColumnForBoardDomain findById(Integer id);
    public ColumnForBoardDomain create(ColumnForBoardDomain task);
    public ColumnForBoardDomain update(ColumnForBoardDomain task);
    public void delete(Integer id);

}
