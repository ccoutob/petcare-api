package br.com.petcare.repository.fornecedor;

import br.com.petcare.model.fornecedor.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
