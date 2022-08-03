package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String departament;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultpasswordLenght = 10;
    private String alternateEmail;
    private String companySuffix = "tcscompany.com";

    //criando o construtor que recebe primeiro nome e segundo nome 

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName =  lastName;
        System.out.println("Email Created " + this.firstName + " " + this.lastName);

            // chama o metodo para departamento
        this.departament =  setDepartment();
        System.out.println("Departament:" + this.departament);

            //metodo que retorna uma password (senha) randomica
            this.password = randomPassword (defaultpasswordLenght);
            System.out.println("your password is: " + this.password);

            //misturar elementos para gerar email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + departament+ "."  + companySuffix;
        System.out.println("Your email is: " + email);

    }
    //perguntar para departamento 
    private String setDepartment(){
        System.out.println("Enter the departament\n2 for Developement\n3 for Accounting\n0 for none\nEnter departament code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){ return "Sales"; }
        else if (depChoice == 2){return "dev";}
        else if (depChoice == 3){return "accounting";}
        else {return " ";}
    }
    // gerar senha randomica

    private String randomPassword( int lenght){
        String passwordSet = "ABDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
        char [] password = new char [lenght];
        for ( int i= 0; i<lenght; i++ ){
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
           System.out.println(rand);
           System.out.println(passwordSet.charAt(rand));
        }

        return new String(password);
    }

    // set a capacidade do email 
    public void SetMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;

    }
    // set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    // mudar senha
    public void changePassword(String password){
        this.password = password;
    }
    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAlternativeEmail(){return alternateEmail;}
    public String getPassword() {return password; }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
            "\nCOMPANY EMAIL: " + email + 
            "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
