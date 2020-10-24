package br.com.bernardo.pontointeligente.model;

import br.com.bernardo.pontointeligente.enums.TipoEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lancamento")
@Data
public class Lancamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    private String descricao;
    private String localizacao;
    @Column(name = "data_criacao",nullable = false)
    private Date dataCriacao;
    @Column(name = "data_atualizacao",nullable = false)
    private Date dataAtualizacao;
    @Enumerated(EnumType.STRING)
    private TipoEnum tipo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    @PreUpdate
    public void preUpdate(){
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist(){
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

}
