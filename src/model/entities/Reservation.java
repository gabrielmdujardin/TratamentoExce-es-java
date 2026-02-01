package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Date checkOut, Date checkIn, Integer roomNumber) {
        this.checkOut = checkOut;
        this.checkIn = checkIn;
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
    }
    public String updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if (checkIn.before(now)|| checkOut.before(now)){
            return "Erro na reserva, as datas de reserva precisam ser futuras.";
        }
        if (!checkOut.after(checkIn)) {
            return "Erro na reserva, a data de Check-out precisa ser depois da data de Check-in.";

        }
        this.checkIn =checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString(){
        return "Quarto "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                +"Noites";

    }

}
