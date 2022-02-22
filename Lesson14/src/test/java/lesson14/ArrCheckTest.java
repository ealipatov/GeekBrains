package lesson14;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrCheckTest {

    int[] arrForTest, passResTest;
    int[] arrForTest1;
    int[] arrForTest2, passResTest2;

    @Before
    public void initArr(){

        arrForTest = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 4, 7, 5, 6, 3, 2, 1};
        passResTest = new int[]{7, 5, 6, 3, 2, 1};

        arrForTest1 = new int[]{1, 2, 3, 9, 5, 6, 7, 8, 9, 7, 5, 6, 3, 2, 1};

        arrForTest2 = new int[]{4, 4, 4, 4, 4, 4};
        passResTest2 = new int[]{};
    }

    @Test
    public void arrCheckFourTest1(){

        int[] resTest = ArrCheck.arrFindFour(arrForTest);
        Assert.assertArrayEquals(resTest, passResTest);
        System.out.println("");
        Task14.printArrInt(arrForTest);
        Task14.printArrInt(resTest);
    }

    @Test
    public void arrCheckFourTest2() {

        Assert.assertThrows(RuntimeException.class, () -> {
            int[] resTest = ArrCheck.arrFindFour(arrForTest1);
        });
        System.out.println("");
        System.out.println("Тест проверяет выбрасывается ли исключение. Тест пасс.");

    }

    @Test
    public void arrCheckFourTest3(){

        int[] resTest = ArrCheck.arrFindFour(arrForTest2);
        Assert.assertArrayEquals(resTest, passResTest2);
        System.out.println("");
        Task14.printArrInt(arrForTest2);
        Task14.printArrInt(resTest);
    }


    @Test
    public void arrCheckOneOrFourTest1(){

        int[] massForTest = {1,1,4,4,1,1};

        boolean resTest = ArrCheck.arrCheckOneOrFour(massForTest);
        System.out.println(resTest);
        Assert.assertTrue(resTest);
        System.out.println("");

    }

    @Test
    public void arrCheckOneOrFourTest2(){

        int[] massForTest2 = {1,1,1,1,1,1};

        boolean resTest = ArrCheck.arrCheckOneOrFour(massForTest2);
        System.out.println(resTest);
        Assert.assertFalse(resTest);
        System.out.println("");
    }

    @Test
    public void arrCheckOneOrFourTest3(){

        int[] massForTest3 = {4,4,4,4,4,4};

        boolean resTest = ArrCheck.arrCheckOneOrFour(massForTest3);

        System.out.println(resTest);
        Assert.assertFalse(resTest);
        System.out.println("");
    }

    @Test
    public void arrCheckOneOrFourTest4(){

        int[] massForTest4 = {1,1,4,4,1,3};

        boolean resTest = ArrCheck.arrCheckOneOrFour(massForTest4);
        System.out.println(resTest);
        Assert.assertFalse(resTest);
        System.out.println("");
    }

}
