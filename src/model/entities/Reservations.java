package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservations {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservations(Date checkIn, Date checkOut, Integer roomNumber) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }


    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public String  updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)){
            return "Error in reservation: Reservation dates for updates must be future dates";
        }
        if (!checkOut.after(checkIn)){
            return "Check-out date must be after check-in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }
    @Override
    public String toString(){
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}