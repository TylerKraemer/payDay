import java.util.Scanner;

public class Payday {
    public static void main(String[] args) {
        //Welcome Message
        System.out.println("***************************************************");
        System.out.println("                    Payday V1.0"                    );
        System.out.println("***************************************************");

        //create scanner
        Scanner scan = new Scanner(System.in);

        //Ask questions to user
        System.out.println("Enter Name: ");
        String userName = scan.nextLine();
        System.out.println("Enter Hours Worked: ");
        double hoursWorked = scan.nextDouble();
        System.out.println("Enter Hourly Pay Rate: ");
        double hourlyPay = scan.nextDouble();
        System.out.println("Are you a union member (y or n)? ");
        char unionMember = scan.next().charAt(0);
        System.out.println("What Percentage Do You Want To Withhold For Your Medical Savings Account? ");
        double medicalPay = scan.nextDouble();

        //calculations
        double grossPay = hoursWorked * hourlyPay;
        double medicalSubtraction = (medicalPay / 100) * grossPay;
        double incidentPay = Math.random() * 400 - 200;
        double unionFees = (unionMember == 'y') ? (0.05 * grossPay) : 0; //had a difficult time with this line, so I did my own research to figure it out so I know this isn't the exact way we learned it in class.
        // I saw your email and I couldn't quite get the formatting correct for the code to run correctly.
        double finalGrossPay = grossPay - unionFees - medicalSubtraction + incidentPay;

        //Calculate Tax Bracket
        double taxes = 0;
        if (finalGrossPay >= 2500) {
            taxes = 0.25 * finalGrossPay;
        } else if (finalGrossPay >= 1500){
            taxes = 0.15 * finalGrossPay;
        } else if (finalGrossPay >= 500) {
            taxes = 0.10 * finalGrossPay;
        } else {
            taxes = 0.05 * finalGrossPay;
        }

        double payAfterTaxes = finalGrossPay - taxes;

        //print paycheck
        System.out.println("------------PAYCHECK------------");
        System.out.printf("Gross Pay         $     %.2f%n", grossPay);
        System.out.printf("Union Dues        $     %.2f%n", unionFees);
        System.out.printf("Medical Deduction $     %.2f%n", medicalSubtraction);
        System.out.printf("Incident Pay      $     %.2f%n", incidentPay);
        System.out.printf("Taxes             $     %.2f%n", taxes);
        System.out.printf("Net Pay           $     %.2f%n", payAfterTaxes);
        System.out.println("--------------------------------");
        System.out.println("Prepared for " + userName);
        System.out.println("");
        System.out.println("Thank you for using this program.");

    }
}