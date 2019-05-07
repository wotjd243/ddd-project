package io.github.wotjd243.findbyhint.treasure.infra;

import io.github.wotjd243.findbyhint.treasure.domain.Treasure;
import io.github.wotjd243.findbyhint.treasure.domain.TreasureRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyTreasureRepository implements TreasureRepository {

    @Override
    public Optional<Treasure> findById(final Long id) {
        return Optional.ofNullable(DummyTreasureData.get(id));
    }
}
