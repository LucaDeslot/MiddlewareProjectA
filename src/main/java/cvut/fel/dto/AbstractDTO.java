package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDTO implements Cloneable{

    private Long id;
    //private String name;

    public AbstractDTO() {
    }

    public AbstractDTO(AbstractDTO dto) {
        id = dto.getId();
        //name = dto.getName();
    }

    protected abstract AbstractDTO clone();
}
