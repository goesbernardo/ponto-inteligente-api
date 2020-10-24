package br.com.bernardo.pontointeligente.service.impl;

import br.com.bernardo.pontointeligente.model.Empresa;

import java.util.Optional;

public interface EmpresaService {

    Optional<Empresa> buscarPorCnpj(String cnpj);

    Empresa persistir(Empresa empresa);
}
