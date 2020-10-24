package br.com.bernardo.pontointeligente.model;

import br.com.bernardo.pontointeligente.enums.PerfilEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "funcionario")
@Data
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    @Column(name = "valor_hora",nullable = false)
    private BigDecimal valorHora;
    @Column(name = "qtd_horas_trabalho_dia",nullable = false)
    private Float qtdHorasTrabalhoDia;
    @Column(name = "qtd_horas_almoco",nullable = false)
    private Float qtdHorasAlmoco;
    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;
    @Column(name = "data_criacao",nullable = false)
    private Date dataCriacao;
    @Column(name = "data_atualizacao",nullable = false)
    private Date dataAtualizacao;
    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa empresa;
    @OneToMany(mappedBy = "funcionario",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Lancamento>lancamentos;

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

    @Transient
    public Optional<BigDecimal> getValorHoraOpt(){
        return Optional.ofNullable(valorHora);
    }
    @Transient
    public Optional<Float> getQtdHorasTrabalhoDiaOpt(){
        return Optional.ofNullable(qtdHorasTrabalhoDia);
    }
    @Transient
    public Optional<Float> getQtdHorasAlmocoOpt(){
        return Optional.ofNullable(qtdHorasAlmoco);
    }

}
