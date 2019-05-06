package io.github.book.domain.rent.infra;

import io.github.book.domain.rent.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
