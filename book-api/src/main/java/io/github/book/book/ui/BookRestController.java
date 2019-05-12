package io.github.book.book.ui;

import io.github.book.book.application.BookService;
import io.github.book.book.application.dto.BookDto;
import io.github.book.book.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookRestController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity read(@PageableDefault Pageable pageable, PagedResourcesAssembler<Book> assembler) {
        Page page = bookService.readBook(pageable);
        PagedResources pagedResources = assembler.toResource(page, e -> getDefaultBookHateOasResource(e));
        return ResponseEntity.ok(pagedResources);
    }

    @PostMapping
    public ResponseEntity read(@RequestBody BookDto bookDto) throws URISyntaxException {
        Resource<Book> resource = getDefaultBookHateOasResource(bookService.saveBook(bookDto));
        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    private Resource<Book> getDefaultBookHateOasResource(Book book) {
        Resource resource = new Resource(book);
        resource.add(linkTo(BookRestController.class).slash(book.getIsbn()).withSelfRel());
        resource.add(linkTo(BookRestController.class).withRel("books"));
        return resource;
    }
}
