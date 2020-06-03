package com.boaspraticas.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.boaspraticas.domain.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
