package br.com.bernardo.pontointeligente.repository;

import br.com.bernardo.pontointeligente.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FuncionarioRepository extends CrudRepository<Funcionario,Long> {

    Funcionario findByCnpj(String cnpj);
    Funcionario findByCpf(String cpf);
    Funcionario findByEmail(String email);
    Funcionario findByCpfOrEmail(String cpf,String email);
}
