package by.ealipatov.lesson04;

import java.util.Random;
import java.util.Scanner;

public class Task04 {

    static final char DOT_X = 'X';
    static final char DOT_0 = 'O';
    static final char DOT_EMPTY = '●';
    static char map[][];
    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();
    static final int sizeMap = 5;  // Размерность игрового поля
    static final int winCount = 4; // Размерность победной комбинации
    static final boolean SILLY_MODE = true; // Режим "глупого" компьютера.


    /**
     * Создаем игровое поле - двумерный массив определенного размера.
     */
    static void initMap(){
        map = new char[sizeMap][sizeMap];
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Выводим на консоль игровое поле.
     */
    static void printMap(){
        System.out.print("+");
        for (int i = 0; i < sizeMap * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }
        System.out.println();
        for(int i = 0; i < sizeMap; i++){
            System.out.print(i + 1 + "|");
            for (int j = 0; j < sizeMap; j++){
                System.out.print(map[i][j] + "|");
            }
            System.out.println();
        }

    }

    /**
     * Запрашиваем ход игрока, проверяем правильность хода.
     */
     static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки через пробел (X Y)");
            y = scanner.nextInt() - 1; // Считывание номера строки
            x = scanner.nextInt() - 1; // Считывание номера столбца
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;

    }

    /**
     * Делаем ход компьютером.
     * SILLY_MODE = true - режим "глупого компьютера" - координата хода выбирается рандомно
     * SILLY_MODE = false - режим "умного компьютера" - координата выбирается на основе алгоритма.
     */
    static void computerTurn(){
        int x = -1;
        int y = -1;
        if(SILLY_MODE){
            do {
                x = random.nextInt(sizeMap);
                y = random.nextInt(sizeMap);
            } while(!isCellValid(x, y));
            System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
            map[y][x] = DOT_0;
        }
        //TODO:  Разработать режим "Умного компьютера".
        //К сожалению не хватило времени разработать алгоритм "умного" компьютера.
        /*
        else{
            checkTurnX();
            checkTurnY();
                do {
                    x = random.nextInt(sizeMap);
                    y = random.nextInt(sizeMap);
                } while(!isCellValid(x, y));
                System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
                map[y][x] = DOT_0;
            }

        }

    }
    static void checkTurnX (){
        int i, j, c;
        for (i = 0; i < sizeMap; i++){
            for (j = 0; j < sizeMap; j++){

                for( int x = i; x < sizeMap; x++){
                    c = winCount - 1;
                    for (int y = j; y < (j + winCount) && y < sizeMap; y++){
                        if(map[x][y] == DOT_X){
                            c--;
                            if(c == 0 && map[x][y+1] == DOT_EMPTY){
                            //return x, y;
                                map[x][y+1] = DOT_0;

                            }
                        }
                    }
                }
            }
        }

    }
    static void checkTurnY () {
        int i, j, c;
        for (i = 0; i < sizeMap; i++){
            for (j = 0; j < sizeMap; j++){

                for( int y = j; y < sizeMap; y++){
                    c = winCount-1;
                    for (int x = i; x < (i + winCount) && x < sizeMap; x++){
                        if(map[x][y] == DOT_X){
                            c--;
                            if(c == 0 && map[x+1][y] == DOT_EMPTY){
                                map[x+1][y] = DOT_0;

                                //   return x, y;
                            }
                        }
                    }
                }
            }
        }
        */
    }

    /**
     * Проверяем корректность хода игрока или компьютера.
     * Сначала проверяем правильность ввода координаты хода.
     * Затем проверяем не занята ли данная ячейка.
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y){
        boolean result = true;
        // проверка правильности координаты
        if(x < 0 || x >= sizeMap || y < 0 || y >= sizeMap) {
            result = false;
            // проверка заполненности ячейки
        } if(map[y][x] != DOT_EMPTY){
            result = false;
        } return result;
    }

    /**
     * Проверка заполненности поля
     * @return
     */
    static boolean isMapFull() {
        boolean result = true;
        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return result;
    }


    /**
     * Проверяем не является ли ход победным
     * @param playerSymbol - символ игрока сделавшего ход
     * @return
     */
    static boolean isEndGame(char playerSymbol) {
        boolean result = false;
        printMap();
        if(checkWinV2(playerSymbol)){
            System.out.println("Победили " + playerSymbol);
            result = true;
        }
        if(isMapFull()){
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    /**
     * Проверка победной комбинации для игрового поля 3х3
     * TODO: Сделать универсальную проверку для разных размеров полей.
     * @param playerSymbol - проверяемый символ.
     * @return
     */
    static boolean checkWin(char playerSymbol) {
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

    /**
     * Проверка выигрышной ситуации при заданном глобальном параметре winCount
     * (количество символов в ряд для победы).
     * @param playerSymbol - передаваемый символ для проверки.
     * @return
     */
    static  boolean checkWinV2(char playerSymbol){
        // Проверка победных комбинаций по горизонтали
        if(checkX(playerSymbol)){
            return true;
        // Проверка победных комбинаций по вертикали
        } else if (checkY(playerSymbol)) {
            return true;
        // Проверка победных комбинаций по диагонали 1
        } else if (checkDiag1(playerSymbol)){
            return true;
        // Проверка победных комбинаций по диагонали 2
        } else if (checkDiag2(playerSymbol)){
            return true;
        //Если победных комбинаций нет, возвращаем false
        } else return false;

    }

    /**
     * Проверяем каждую ячейку игрового поля на победную комбинацию по горизонтали.
     * @param playerSymbol - проверяемый символ.
     * @return
     */
    static boolean checkX (char playerSymbol){
        boolean w = false;
        int i, j, c;
        for (i = 0; i < sizeMap; i++){
            for (j = 0; j < sizeMap; j++){

                for( int x = i; x < sizeMap; x++){
                    c = winCount;
                    for (int y = j; y < (j + winCount) && y < sizeMap; y++){
                        if(map[x][y] == playerSymbol){
                        c--;
                        if(c == 0){
                         w = true;
                        }
                        }
                    }
                }
            }
        }
        return w;
    }
    /**
     * Проверяем каждую ячейку игрового поля на победную комбинацию по вертикали.
     * @param playerSymbol - проверяемый символ.
     * @return
     */
    static boolean checkY (char playerSymbol){
        boolean w = false;
        int i, j, c;
        for (i = 0; i < sizeMap; i++){
            for (j = 0; j < sizeMap; j++){

                for( int y = j; y < sizeMap; y++){
                    c = winCount;
                    for (int x = i; x < (i + winCount) && x < sizeMap; x++){
                        if(map[x][y] == playerSymbol){
                            c--;
                            if(c == 0){
                                w = true;
                            }
                        }
                    }
                }
            }
        }
        return w;
    }
    /**
     * Проверяем каждую ячейку игрового поля на победную комбинацию по диагонали 1.
     * @param playerSymbol - проверяемый символ.
     * @return
     */
    static boolean checkDiag1 (char playerSymbol){
        boolean w = false;
        int i, j, c;
        for (i = 0; i < sizeMap; i++){
            for (j = 0; j < sizeMap; j++){
                c = winCount;
                for( int x = i, y = j; x < sizeMap && y < sizeMap && x < (i + winCount) && y < (j + winCount); x++, y++){
                    //c = winCount;
                    if(map[x][y] == playerSymbol){
                            c--;
                            if(c == 0){
                                w = true;
                            }
                        }
                    }
                }
            }
        return w;
    }

    /**
     * Проверяем каждую ячейку игрового поля на победную комбинацию по диагонали 2.
     * @param playerSymbol - проверяемый символ.
     * @return
     */
    static boolean checkDiag2 (char playerSymbol){
        boolean w = false;
        int i, j, c;
        for (i = (sizeMap -1); i > 0; i--){
            for (j = 0; j < sizeMap; j++){
                c = winCount;
                for( int x = i, y = j; x >= 0 && y < sizeMap && y < (j + winCount); x--, y++){
                     if(map[x][y] == playerSymbol){
                        c--;
                        if(c == 0){
                            w = true;
                        }
                    }
                }
            }
        }
        return w;
    }



    public static void main(String[] args) {
        while (true){
            initMap();
            printMap();

            while(true){
                humanTurn();        //Ход человека
                if(isEndGame(DOT_X)){
                    break;
                }
                computerTurn();     //Ход компьютера
                if(isEndGame(DOT_0)){
                    break;
                }
            }
            System.out.println("Игра законцена!");
            System.out.println();
            System.out.println("Желаете сыграть еще раз? (Да - Y)");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }

    }




}

