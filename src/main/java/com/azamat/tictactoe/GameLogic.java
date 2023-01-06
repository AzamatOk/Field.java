package com.azamat.tictactoe;


import java.util.Scanner;

public class GameLogic {
    private final Scanner scanner = new Scanner(System.in);
    private final Field field = new Field();

    private final String FIRST_USER = "X";
    private final String SECOND_USER = "O";

    private String WINNER = " ";

    public void startGame() {
        while (checkWinner() != "s") {

            Integer firstUserInput = 0;
            Integer secondUserInput = 0;
            field.showField();
            do {
                System.out.print("Ходят Х!");
                WINNER = "X";
                firstUserInput = getFirstUserInput();
            }while (FreeCell(firstUserInput));
            field.setItem(firstUserInput, FIRST_USER);
            field.showField();
            checkWinner();
            if (checkWinner() == "s")
            {
                System.out.print("Игра окончена! Победили " + WINNER + "!");
                break;
            }
            do {
                System.out.print("Ходят О!");
                WINNER = "O";
                secondUserInput = getSecondUserInput();
            }while (FreeCell(secondUserInput));
            field.setItem(secondUserInput, SECOND_USER);
            checkWinner();
            if (checkWinner() == "s")
            {
                System.out.print("Игра окончена! Победили " + WINNER + "!");
                break;
            }
        }
    }

    private Integer getFirstUserInput() {
        System.out.println("Enter data: ");
        int userInput = 0;
        while (!validateInput(userInput) ) {
            userInput = scanner.nextInt();
        }
        return scanner.nextInt()-1;
    }

    private Integer getSecondUserInput() {
        System.out.println("Enter data: ");
        int userInput = 0;
        while (!validateInput(userInput)) {
            userInput = scanner.nextInt();
        }
        return scanner.nextInt()-1;
    }

    private String checkWinner() {
        if (field.getStorage()[0] == field.getStorage()[1] && field.getStorage()[0] == field.getStorage()[2] && field.getStorage()[0] != "-" ||
                field.getStorage()[3] == field.getStorage()[4] && field.getStorage()[3] == field.getStorage()[5] && field.getStorage()[3] != "-" ||
                field.getStorage()[6] == field.getStorage()[7] && field.getStorage()[6] == field.getStorage()[8] && field.getStorage()[6] != "-" ||
                field.getStorage()[0] == field.getStorage()[3] && field.getStorage()[0] == field.getStorage()[6] && field.getStorage()[0] != "-" ||
                field.getStorage()[1] == field.getStorage()[4] && field.getStorage()[1] == field.getStorage()[7] && field.getStorage()[1] != "-" ||
                field.getStorage()[2] == field.getStorage()[5] && field.getStorage()[1] == field.getStorage()[8] && field.getStorage()[2] != "-" ||
                field.getStorage()[0] == field.getStorage()[4] && field.getStorage()[0] == field.getStorage()[8] && field.getStorage()[0] != "-" ||
                field.getStorage()[2] == field.getStorage()[4] && field.getStorage()[2] == field.getStorage()[6] && field.getStorage()[2] != "-")
        {
            return "s";
        }
        return null;
    }

    private boolean validateInput(Integer input) {
        if (input > 8 || input < 0 )
        {
            return false;
        }
    return true;
    }

    private boolean FreeCell(Integer cell)
    {
        if (field.getStorage()[cell] != "-") {
            return true;
        }
        return false;
    }
}
