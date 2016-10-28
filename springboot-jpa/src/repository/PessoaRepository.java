package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import entity.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {
	List<Pessoa> findByName(String nome);
}
