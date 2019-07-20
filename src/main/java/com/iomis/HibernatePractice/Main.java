package com.iomis.HibernatePractice;



import java.util.List;

public class Main {


    public static void main( String [] args){

       UserService userService = new UserService();
        User user = new User("Victoria",27,"victoria11@gmail.com");
        userService.saveUser(user);
        Auto ferrari = new Auto("Chevrolet", "white");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford Mustang", "dark blue");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        List<User> list = userService.findAllUsers();



    }
}
