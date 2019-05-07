package io.github.wotjd243.findbyhint.treasure.domain;

import java.util.Optional;

public interface TreasureRepository {

    Optional<Treasure> findById(final Long id);



}
