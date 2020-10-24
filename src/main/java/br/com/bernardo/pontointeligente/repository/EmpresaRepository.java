package br.com.bernardo.pontointeligente.repository;

import br.com.bernardo.pontointeligente.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    Empresa findByCnpj(String cnpj);

}
