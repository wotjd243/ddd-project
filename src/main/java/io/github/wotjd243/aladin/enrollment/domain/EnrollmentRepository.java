package io.github.wotjd243.aladin.enrollment.domain;

import java.util.Optional;

public interface EnrollmentRepository {
    Optional<Enrollment> findById(Long id);

    void save(Enrollment enrollment);

}
