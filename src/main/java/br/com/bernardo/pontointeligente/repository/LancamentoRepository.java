package br.com.bernardo.pontointeligente.repository;

import br.com.bernardo.pontointeligente.model.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "LancamentoRepository.findByFuncionarioId",query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id =:funacionarioId")
})
public interface LancamentoRepository extends JpaRepository<Lancamento,Long> {

    List<Lancamento> findByFuncionardioId(@Param("funcionardioId")Long funcionarioId);

    Page<Lancamento> findByFuncionarioId(@Param("funcionardioId")Long funcionarioId, Pageable pageable);
}
