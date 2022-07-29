package org.sofka.mykrello.model.service.interfaces;

import org.sofka.mykrello.model.domain.ColumnDomain;
import java.util.List;

public interface ColumnInterface {

    public List<ColumnDomain> findAll();
    public ColumnDomain findById(Integer id);
    public ColumnDomain create(ColumnDomain task);
    public ColumnDomain update(ColumnDomain task);
    public void delete(Integer id);

}
