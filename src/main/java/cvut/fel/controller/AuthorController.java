package cvut.fel.controller;

import cvut.fel.dto.AuthorDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class AuthorController {
    private final AuthorService authorService;
    private final DTOMapper dtoMapper;

    @Autowired
    public AuthorController(AuthorService authorService, DTOMapper dtoMapper) {
        this.authorService = authorService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<AuthorDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.authorToDto(authorService.findById(id)));
    }
}
