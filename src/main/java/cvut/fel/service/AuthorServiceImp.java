package cvut.fel.service;

import cvut.fel.entity.Author;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorServiceImp implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findById(Long id){
        if (id == null)
            throw new FieldMissingException();
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("AUTHOR NOT FOUND"));
    }
}
