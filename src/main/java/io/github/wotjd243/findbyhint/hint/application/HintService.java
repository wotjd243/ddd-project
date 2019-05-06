package io.github.wotjd243.findbyhint.hint.application;

import org.springframework.stereotype.Service;

@Service
public class HintService {
    private HintService hintService;

    public HintService(final HintService hintService) {
        this.hintService = hintService;
    }
}
