package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {

    private String [][] workers = {
            {"75020806874", "John", "Smith"},
            {"84070405598", "John", "Doe"},
            {"80010509987", "Jane", "Doe"},
            {"87121508795", "Ann", "Smith"},
            {"74020504789", "Carl", "Larson"}};

    private double [] salaries = {
            4000.00,
            3500.00,
            6800.00,
            2500.00,
            11000.00};

    public String getWorker(int n) {
        if(n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String [][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
