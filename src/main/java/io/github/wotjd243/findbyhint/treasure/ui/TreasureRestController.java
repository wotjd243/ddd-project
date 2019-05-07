package io.github.wotjd243.findbyhint.treasure.ui;

import io.github.wotjd243.findbyhint.treasure.application.TreasureService;
import io.github.wotjd243.findbyhint.treasure.infra.DummyTreasureData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreasureRestController {

    final private TreasureService treasureService;

    public TreasureRestController(TreasureService treasureService) {
        this.treasureService = treasureService;
    }

    @GetMapping(value = "/treasure/{id}")
    public boolean isExist(@PathVariable Long id) {
        return treasureService.isExist(id);
    }

}
