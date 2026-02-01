package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int number = sc.nextInt();
        System.out.print("Data de Check-in(dd/MM/yyyy");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de Check-out(dd/MM/yyyy");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Erro na reserva, sua data de Check-out é posterior a sua data de Check-in.");

        }
        else {
            Reservation reservation = new Reservation(checkIn,checkOut,number);
            System.out.println("Reserva: "+ reservation);

            System.out.println();
            System.out.println("Digite uma nova data para reserva: ");
            System.out.print("Data de Check-in(dd/MM/yyyy): ");
            Date checkInn = sdf.parse(sc.next());
            System.out.print("Data de Check-out(dd/MM/yyyy");
            Date checkOutt = sdf.parse(sc.next());


              String error = reservation.updateDates(checkIn, checkOut);
              if (error!= null) {
                  System.out.println("Erro na reserva: " + error);
              }
              else {
                System.out.println("Reserva: "+ reservation);
            }
        }

        sc.close();
    }
}