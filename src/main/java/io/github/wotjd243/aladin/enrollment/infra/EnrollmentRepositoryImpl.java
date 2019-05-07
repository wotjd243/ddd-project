package io.github.wotjd243.aladin.enrollment.infra;

import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import io.github.wotjd243.aladin.enrollment.domain.EnrollmentRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EnrollmentRepositoryImpl implements EnrollmentRepository {
    @Override
    public Optional<Enrollment> findById(Long id) {
        return DummyEnrollmentData.get(id);
    }

    @Override
    public void save(Enrollment enrollment) {
        DummyEnrollmentData.put(enrollment);
    }
}
