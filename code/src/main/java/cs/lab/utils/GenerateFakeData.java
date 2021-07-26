package cs.lab.utils;

import java.util.Random;

public class GenerateFakeData {
    public static Random randGenerator = new Random();
    public static int generateVacunados() {
        return randGenerator.nextInt(1000);
    }

    public static int generateVacunadosCompletos() {
        return randGenerator.nextInt(500);
    }
}
