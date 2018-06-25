/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmail.generator;

import java.io.File;
import java.util.Random;

/**
 *
 * @author haleduykhang
 */
public class GmailGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            setDriverProperty();

            for (int i = 2; i <= 100; i++) {
                Generator generator = new Generator();

                String firstname = NameGenerator.generateName();
                String lastname = NameGenerator.generateName();
                
                String username = firstname.toLowerCase() + lastname.toLowerCase();
                Random random = new Random();
                String password = username + "@" + random.nextInt(1000);
                
                System.out.println(username);
                System.out.println(password);
                
                String currentEmail = "haleduykhang@gmail.com";

                generator.generateGmailAccount(username, password, firstname, lastname, currentEmail);
                
                Thread.sleep(100000);
                
                generator.close();
                
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void setDriverProperty() {
        File file = new File("chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    }

}
