package model.exeptions;

import java.io.Serial;

public class DomainExepction extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DomainExepction(String msg){
        super(msg);
    }
}
