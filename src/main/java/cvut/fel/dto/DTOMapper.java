package cvut.fel.dto;

import cvut.fel.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOMapper {
    AddressDTO addressToDto(Address byId);
    AuthorDTO authorToDto(Author authorId);
    BookDTO bookToDto(Book bookId);
    LibraryDTO libraryToDto(Library libraryId);
    PublishingHouseDTO publishingHouseToDto(PublishingHouse publishingHouse);

}
