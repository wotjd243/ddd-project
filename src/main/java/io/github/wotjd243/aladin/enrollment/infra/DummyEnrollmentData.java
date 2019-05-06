package io.github.wotjd243.aladin.enrollment.infra;

import io.github.wotjd243.aladin.enrollment.domain.Enrollment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DummyEnrollmentData {

    private static final Map<Long, Enrollment> enrollmentGroup = new HashMap<>();


    public static Enrollment put(Enrollment enrollment) {
        return enrollmentGroup.put(enrollment.getId(), enrollment);
    }

    public static Optional<Enrollment> get(Long id) {
        return Optional.of(enrollmentGroup.get(id));
    }
}
