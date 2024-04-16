package model.exeptions;

public class DomainExepction extends RuntimeException {
    private static final long serialVersuinUID = 1L;

    public DomainExepction(String msg){
        super(msg);
    }
}
