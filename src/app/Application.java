package app;

import model.entities.Contract;
import model.entities.Installment;
import model.services.InstallmentService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println(" -> DADOS DO CONTRATO");

        System.out.print("Número do contrato: ");
        int number = scanner.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Valor do contrato: ");
        double value = scanner.nextDouble();

        Contract contract = new Contract(number, date, value);

        System.out.print("Número de parcelas: ");
        int numberOfContractInstallments = scanner.nextInt();

        InstallmentService service = new InstallmentService(new PaypalService());

        service.installmentOfTheContract(contract, numberOfContractInstallments);

        System.out.println(" -> PARCELAMENTO - CONTRATO " + contract.getNumber());
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        scanner.close();

    }
}
