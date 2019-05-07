package io.github.wotjd243.findbyhint.hint.domain;

        import java.util.Optional;

public interface HintRepository {
    Optional<Hint> findById(final HintId number);
}
