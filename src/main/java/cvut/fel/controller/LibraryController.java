package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.dto.LibraryDTO;
import cvut.fel.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class LibraryController {
    private final LibraryService libraryService;
    private final DTOMapper dtoMapper;

    @Autowired
    public LibraryController(LibraryService libraryService, DTOMapper dtoMapper) {
        this.libraryService = libraryService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/library/{id}")
    public ResponseEntity<LibraryDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.libraryToDto(libraryService.findById(id)));
    }

    public ResponseEntity<LibraryDTO> addBookToLibrary(@PathVariable Long bookID, Long libraryID){
        return ResponseEntity.ok(dtoMapper.libraryToDto(libraryService.addBookToLibrary(bookID, libraryID)));
    }
}
