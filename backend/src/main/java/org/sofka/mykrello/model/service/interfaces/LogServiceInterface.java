package org.sofka.mykrello.model.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sofka.mykrello.model.domain.LogDomain;

public interface LogServiceInterface {
    public List<LogDomain> findAll();
<<<<<<< HEAD
    public LogDomain create(LogDomain log);

    public void delete(Integer id);

=======
    public Optional<LogDomain> findById(Integer id);
    public LogDomain create(LogDomain log);
    public void delete(Integer id);
>>>>>>> main
}
