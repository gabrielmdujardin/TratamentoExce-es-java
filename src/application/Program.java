package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        try {
            System.out.print("Numero do quarto: ");
            int number = sc.nextInt();
            System.out.print("Data de Check-in(dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data de Check-out(dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(checkIn, checkOut, number);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.println("Digite uma nova data para reserva: ");
            System.out.print("Data de Check-in(dd/MM/yyyy):  ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de Check-out(dd/MM/yyyy):  ");
            checkOut = sdf.parse(sc.next());


            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reserva: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Formato de data inválido.");
        }
        catch (DomainException x){
            System.out.println("Erro na reserva: " + x.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado.");
        }
sc.close();
}
}