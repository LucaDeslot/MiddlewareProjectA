package cvut.fel.service;

import cvut.fel.entity.Author;

public interface AuthorService {
    Author findById(Long id);
}
