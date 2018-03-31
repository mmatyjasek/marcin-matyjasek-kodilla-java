package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SeconfChallenge seconfChallenge = new SeconfChallenge();

        try{

            System.out.println(seconfChallenge.probablyIWillThrowException(0,1.5));
        }catch(Exception e){
            System.out.println("Problem while executing method! " + e);
        }finally {
            System.out.println("Attempt complete");
        }
    }
}
