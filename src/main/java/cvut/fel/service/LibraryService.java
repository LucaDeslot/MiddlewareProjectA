package cvut.fel.service;

import cvut.fel.entity.Library;

public interface LibraryService {
    Library findById(Long id);
    Library addBookToLibrary(Long bookID, Long libraryID);

}
