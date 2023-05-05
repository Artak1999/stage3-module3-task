package com.mjc.school;

import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.command.CommandHandler;
import com.mjc.school.controller.commands.CommandFactory;
import com.mjc.school.controller.implementation.AuthorController;
import com.mjc.school.controller.implementation.NewsController;
import com.mjc.school.controller.implementation.TagController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

@Component
public class Menu {
    private CommandFactory commandFactory;

    public Menu(){}
    @Autowired
    public Menu(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void printMenu() {
        for (MenuList menuList : MenuList.values()) {
            System.out.println(menuList.getId() + ") " + menuList.getValues());
        }
    }

    public void printMenuList(){
        Scanner input = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("Enter number: ");
            int number = input.nextInt();
            findMethod(number);
        }
    }

    public void createNews(Scanner scanner) {
        try {
            System.out.print("Enter news title: ");
            String title = scanner.nextLine();
            System.out.print("Enter news content: ");
            String content = scanner.nextLine();
            System.out.print("Enter author id: ");
            long authorId = readId(scanner);
            System.out.println(commandFactory.create(CommandFactory.CREATE_NEWS, title, content, authorId).execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllNews() {
        try {
            List<Object> newsList = Collections.unmodifiableList((List<Object>)commandFactory.create(CommandFactory.GET_ALL_NEWS).execute());
            newsList.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void getNewsById(Scanner scanner) {
        try {
            System.out.print("Enter news id: ");
            long newsId = readId(scanner);
            System.out.println(commandFactory.create(CommandFactory.GET_NEWS_BY_ID, newsId).execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateNews(Scanner scanner) {
        try {
            System.out.print("Enter news id: ");
            long newsId = readId(scanner);
            System.out.print("Enter news title: ");
            String title = scanner.nextLine();
            System.out.print("Enter news content: ");
            String content = scanner.nextLine();
            System.out.print("Enter author id: ");
            long authorId = readId(scanner);
            System.out.println(commandFactory.create(CommandFactory.UPDATE_NEWS, newsId, title, content, authorId).execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteNews(Scanner scanner) {
        try {
            System.out.print("Enter news id: ");
            long newsId = readId(scanner);
            System.out.println(commandFactory.create(CommandFactory.DELETE_NEWS, newsId).execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createAuthor(Scanner scanner) {
        try {
            System.out.print("Enter author name: ");
            String name = scanner.nextLine();
            System.out.println(commandFactory.create(CommandFactory.CREATE_AUTHOR, name).execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllAuthors() {
        try {
            List<Object> authorList = Collections.unmodifiableList((List<Object>) commandFactory.create(CommandFactory.GET_ALL_AUTHORS).execute());
            authorList.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAuthorById(Scanner scanner) {
        try {
            System.out.print("Enter news id: ");
            long authorId = readId(scanner);
            System.out.println(commandFactory.create(CommandFactory.GET_AUTHOR_BY_ID, authorId).execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAuthor(Scanner scanner) {
        try {
            System.out.print("Enter author id: ");
            long authorId = readId(scanner);
            System.out.print("Enter author name: ");
            String authorName = scanner.nextLine();
            System.out.println(commandFactory.create(CommandFactory.UPDATE_AUTHOR, authorId, authorName).execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAuthor(Scanner scanner) {
        try {
            System.out.print("Enter author id: ");
            long authorId = readId(scanner);
            System.out.println(commandFactory.create(CommandFactory.DELETE_AUTHOR, authorId).execute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Optional<Method> findMethod(int number){
        List<Class<?>> controllers = Arrays.asList(AuthorController.class, NewsController.class, TagController.class);
        Optional<Method> method = Optional.empty();
        for (Class<?> o : controllers) {
            method = Stream.of(o.getDeclaredMethods())
                    .filter(a -> a.isAnnotationPresent(CommandHandler.class))
                    .filter(a -> a.getAnnotation(CommandHandler.class).operation() == number)
                    .findFirst();
            if(method.isPresent())
                break;
        }
        return method.stream().filter(a -> a.invoke(controllers, commandFactory.getAllCommands.stream().filter(b -> b == number)));
    }

    public int[] findArgs(){
        Map<Integer,Integer> map = new HashMap<>();
        return new int[0];
    }

    public long readId(Scanner scanner) {
        if (!scanner.hasNextLong()) {
            scanner.nextLine();
            throw new IllegalArgumentException("Id must be an integer");
        }
        long id = scanner.nextLong();
        scanner.nextLine();
        return id;
    }
}
