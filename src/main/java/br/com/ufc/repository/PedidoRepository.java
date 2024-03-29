package br.com.ufc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	Optional<Pedido> findById(Long id);
	List<Pedido> findByUserCode(Long user_code);
}
