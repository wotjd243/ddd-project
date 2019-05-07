package io.github.book.rent.infra;

import io.github.book.rent.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
