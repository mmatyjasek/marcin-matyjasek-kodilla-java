package com.kodilla.rps;

import org.junit.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;


public class RpsTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.\n");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @After
    public void afterEveryTest() {

        System.out.println("\n");
    }

    @Test
    public void testReturnNoOfRounds() {
        //Given
        NumberOfRounds numberOfRounds = new NumberOfRounds();

        //when
        ByteArrayInputStream in = new ByteArrayInputStream("10".getBytes());
        System.setIn(in);
        int result1 = numberOfRounds.defineNoOfRounds();

        in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        int result2 = numberOfRounds.defineNoOfRounds();

        in = new ByteArrayInputStream("100".getBytes());
        System.setIn(in);
        int result3 = numberOfRounds.defineNoOfRounds();
        System.setIn(System.in);

        //Then
        Assert.assertEquals(10, result1 );
        Assert.assertEquals(3, result2 );
        Assert.assertEquals(20, result3 );
    }

    @Test
    public void testReturnGameModeNumber() {
        //Given
        GameModePick gameModePick = new GameModePick();

        //when
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        int result = gameModePick.selectGameMode();

        System.setIn(System.in);

        //Then
        Assert.assertEquals(2, result );
    }

    @Test
    public void testReturnFigureNumber() {
        //Given
        FigurePick figurePick = new FigurePick();

        //when
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        int result = figurePick.pickYourFigure();

        System.setIn(System.in);

        //Then
        Assert.assertEquals(1, result );
    }

    @Test
    public void testFigureDrawerProbability50() {
        //Given
        FigureDrawer figureDrawer = new FigureDrawer();
        final List<Integer> list = new ArrayList<>();
        int i;
        //When
        for(i=0; i<100000; i++){
            list.add(figureDrawer.generator(50,0));
        }
        double percentOf2 = (double)list.stream().filter(s -> s==1).count()/list.size()*100;
        double percentOf1 = (double)list.stream().filter(s -> s==0).count()/list.size()*100;
        double percentOf3 = (double)list.stream().filter(s -> s==2).count()/list.size()*100;
        long others = list.stream().filter(s -> s<0 || s>2).count();

        //Then
        Assert.assertEquals(0, others);
        Assert.assertEquals(50, percentOf2,2);
        Assert.assertEquals(25, percentOf1,2);
        Assert.assertEquals(25, percentOf3,2);
    }

    @Test
    public void testComputersDrawForGameMode1() {
        //Given
        ComputersDraw computersDraw = new ComputersDraw();
        final List<Integer> list = new ArrayList<>();
        int i;
        //When
        for(i=0; i<100000; i++){
            list.add(computersDraw.drawsComputersFigureNo(1,0));
        }
        double percentOf2 = (double)list.stream().filter(s -> s==1).count()/list.size()*100;
        double percentOf1 = (double)list.stream().filter(s -> s==0).count()/list.size()*100;
        double percentOf3 = (double)list.stream().filter(s -> s==2).count()/list.size()*100;
        long others = list.stream().filter(s -> s<0 || s>2).count();

        //Then
        Assert.assertEquals(0, others);
        Assert.assertEquals(50, percentOf2,2);
        Assert.assertEquals(25, percentOf1,2);
        Assert.assertEquals(25, percentOf3,2);
    }

    @Test
    public void testComputersDrawForGameMode2() {
        //Given
        ComputersDraw computersDraw = new ComputersDraw();
        final List<Integer> list = new ArrayList<>();
        int i;
        //When
        for(i=0; i<100000; i++){
            list.add(computersDraw.drawsComputersFigureNo(2,0));
        }
        double percentOf2 = (double)list.stream().filter(s -> s==1).count()/list.size()*100;
        double percentOf1 = (double)list.stream().filter(s -> s==0).count()/list.size()*100;
        double percentOf3 = (double)list.stream().filter(s -> s==2).count()/list.size()*100;
        long others = list.stream().filter(s -> s<0 || s>2).count();

        //Then
        Assert.assertEquals(0, others);
        Assert.assertEquals(30, percentOf2,2);
        Assert.assertEquals(35, percentOf1,2);
        Assert.assertEquals(35, percentOf3,2);
    }

    @Test
    public void testComputersDrawForGameMode3() {
        //Given
        ComputersDraw computersDraw = new ComputersDraw();
        final List<Integer> list = new ArrayList<>();
        int i;
        //When
        for(i=0; i<100000; i++){
            list.add(computersDraw.drawsComputersFigureNo(3,0));
        }
        double percentOf2 = (double)list.stream().filter(s -> s==1).count()/list.size()*100;
        double percentOf1 = (double)list.stream().filter(s -> s==0).count()/list.size()*100;
        double percentOf3 = (double)list.stream().filter(s -> s==2).count()/list.size()*100;
        long others = list.stream().filter(s -> s<0 || s>2).count();

        //Then
        Assert.assertEquals(0, others);
        Assert.assertEquals(20, percentOf2,2);
        Assert.assertEquals(40, percentOf1,2);
        Assert.assertEquals(40, percentOf3,2);
    }

    @Test
    public void testValidateWinner(){
        //Given
        Validator validator = new Validator();
        //When

        int result1 = validator.validate(0,0);
        int result2 = validator.validate(0,1);
        int result3 = validator.validate(0,2);
        int result4 = validator.validate(1,0);
        int result5 = validator.validate(1,1);
        int result6 = validator.validate(1,2);
        int result7 = validator.validate(2,0);
        int result8 = validator.validate(2,1);
        int result9 = validator.validate(2,2);

        //Then
        Assert.assertEquals(0, result1);
        Assert.assertEquals(1, result2);
        Assert.assertEquals(2, result3);
        Assert.assertEquals(2, result4);
        Assert.assertEquals(0, result5);
        Assert.assertEquals(1, result6);
        Assert.assertEquals(1, result7);
        Assert.assertEquals(2, result8);
        Assert.assertEquals(0, result9);
    }

    @Test
    public void testIsCorrectFigureForPlayersInput(){
        //Given
        FigurePick figurePick = new FigurePick();
        FiguresList figuresList = new FiguresList();
        Figure nozyce = new Figure("Nożyce");
        Figure papier = new Figure("Papier");
        Figure kamien = new Figure("Kamień");

        //when
        List<Figure> list = figuresList.getFigures();

        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        int resultFigureNo  = figurePick.pickYourFigure();
        Figure resultFigure = figurePick.returnFigure(resultFigureNo,list);

        in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        int resultFigureNo2  = figurePick.pickYourFigure();
        Figure resultFigure2 = figurePick.returnFigure(resultFigureNo2, list);
        System.setIn(System.in);

        in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        int resultFigureNo3  = figurePick.pickYourFigure();
        Figure resultFigure3 = figurePick.returnFigure(resultFigureNo3, list);
        System.setIn(System.in);

        //Then
        Assert.assertEquals(nozyce, resultFigure);
        Assert.assertEquals(papier, resultFigure2);
        Assert.assertEquals(kamien, resultFigure3);
    }

    @Test
    public void testFinishGame(){
        //Given
        PlayAgainOrFinish playAgainOrFinish = new PlayAgainOrFinish();

        //when
        ByteArrayInputStream in = new ByteArrayInputStream("x".getBytes());
        System.setIn(in);
        System.setIn(System.in);

        //Then
        Assert.assertTrue(playAgainOrFinish.decide());
    }

    @Test
    public void testPlayAgain(){
        //Given
        PlayAgainOrFinish playAgainOrFinish = new PlayAgainOrFinish();

        //when
        ByteArrayInputStream in = new ByteArrayInputStream("n".getBytes());
        System.setIn(in);
        System.setIn(System.in);

        //Then
        Assert.assertFalse(playAgainOrFinish.decide());
    }

}
