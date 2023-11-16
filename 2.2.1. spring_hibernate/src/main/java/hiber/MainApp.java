package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Volkswagen Tiguan", 1111)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Kia Rio", 2222)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW M5", 3333)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Hyundai Solaris ", 4444)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }

      System.out.println("\n Car owner : " + userService.getCarOwner("Lada", 2101));

      context.close();
   }
}
