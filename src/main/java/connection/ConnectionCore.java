package connection;

import java.util.List;

import command.CommandInterpreter;
import communication.MailVerificationThread;
import interfaces.IEmailEventListener;
import utils.Email;

public class ConnectionCore {
    public static void main(String[] args) {
        MailVerificationThread mail = new MailVerificationThread();
        mail.setEmailEventListener(new IEmailEventListener() {
            @Override
            public void onReceiveEmailEvent(List<Email> emails){
                for(Email email : emails){
                    System.out.println("Este es el email" + email);
                    String emailFrom = email.getFrom();
                    String emailSubject = email.getSubject();
                    String response = CommandInterpreter.interpret(emailSubject);
                    System.out.println(response);
                }
            }
        });

        Thread thread = new Thread(mail);
        thread.setName("Mail Verification Thread");
        thread.start();
    }
}
