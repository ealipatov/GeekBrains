package Game_OX;

import java.util.Random;
import java.util.Scanner;

public class Game_XO {

    private static Random random = new Random();
    private static final int SIZE = 3;            // Размер игрового поля
    private static char[][] map;            // Игровое поле (массив)

    private static final char DOT_X = 'X';        // Крестик
    private static final char DOT_O = 'O';        // Нолик
    private static final char DOT_EMPTY = '●';    // Пустое поле
    private static final boolean SILLY_MODE = true;

    private static Scanner scanner = new Scanner(System.in);


    // Инициализация игрового поля
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i ++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //Вывод игрового поля на экран
    private static void printMap() {
        for(int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }System.out.println();
        for(int i =0; i < SIZE; i++){
            System.out.print((i+1) + " ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }System.out.println();
        } System.out.println();
    }

    // Ход игрока
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки через пробел (X Y)");
            y = scanner.nextInt() - 1; // Считывание номера строки
            x = scanner.nextInt() - 1; // Считывание номера столбца
        }while(!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    //Ход компьютера
    private static void computerTurn(){
        int x = -1;
        int y = -1;
        if(SILLY_MODE){
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while(!isCellValid(x, y));
        }else{
            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    //Проверить клектки по напрвлаениям

                }
            }
        } System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[y][x] = DOT_O;
    }


    // Проверка корректности хода
    public static boolean isCellValid(int x, int y){
        boolean result = true;
        // проверка правильности координаты
        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
            // проверка заполненности ячейки
        } if(map[y][x] != DOT_EMPTY){
            result = false;
        } return result;
    }

    // Проверка окончания игры
    public static boolean isEndGame(char playerSymbol) {
        boolean result = false;
        printMap();
        if(checkWin(playerSymbol)){
            System.out.println("Победили " + playerSymbol);
            result = true;
        }
        if(isMapFull()){
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    // Проверка заполненности поля
    public static boolean isMapFull() {
        boolean result = true;
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if(map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return result;
    }

    //Проверка победы
    private static boolean checkWin(char playerSymbol) {
        boolean result = false;
        if(
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol))
        {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        initMap();
        printMap();

        while(true){
            humanTurn();        //Ход человека
            if(isEndGame(DOT_X)){
                break;
            }


            computerTurn();     //Ход компьютера
            if(isEndGame(DOT_O)){
                break;
            }
        }
        System.out.println("Игра законцена!");
    }


}
