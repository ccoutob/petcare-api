package br.com.petcare.repository.petshop;

import br.com.petcare.model.petshop.Petshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetshopRepository extends JpaRepository<Petshop, Long> {
}
