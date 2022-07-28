package cvut.fel.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String errorCode;
    private final String errorDesc;

    public NotFoundException(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public NotFoundException(String errorCode) {
        this.errorCode = errorCode;
        this.errorDesc = null;
    }
}
