package io.github.book.collected.ui;

import io.github.book.collected.application.CollectedBookService;
import io.github.book.collected.application.dto.CollectedBookDto;
import io.github.book.collected.domain.CollectedBook;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class CollectedBookRestController {
    private final CollectedBookService collectedBookService;

    @GetMapping("collected-book")
    public ResponseEntity collectedBookList() {
        return ResponseEntity.ok(collectedBookService.getRentAvailableCollectedBook());
    }

    @PostMapping("collected-book")
    public ResponseEntity save(@RequestBody CollectedBookDto collectedBookDto) throws URISyntaxException {
        Resource<CollectedBook> resource = getDefaultCollectedBookHateOasResource(collectedBookService.saveCollectedBook(collectedBookDto));
        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    private Resource<CollectedBook> getDefaultCollectedBookHateOasResource(CollectedBook collectedBook) {
        Resource resource = new Resource(collectedBook);
        resource.add(linkTo(CollectedBookRestController.class).slash(collectedBook.getCollectedBookId()).withSelfRel());
        resource.add(linkTo(CollectedBookRestController.class).withRel("collectedBooks"));
        return resource;
    }
}
