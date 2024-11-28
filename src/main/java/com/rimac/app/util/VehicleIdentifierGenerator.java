package com.rimac.app.util;

import java.util.Random;

public class VehicleIdentifierGenerator {

    private static final Random RANDOM = new Random();

    private static char getRandomLetter() {
        return (char) (65 + RANDOM.nextInt(26));
    }

    private static char getRandomNumber() {
        return (char) (48 + RANDOM.nextInt(10));
    }

    public static String generateLicensePlate(String format) {
        if (format == null) {
            format = "LLL-NNN";
        }
        StringBuilder result = new StringBuilder(format.length());
        for (char c : format.toCharArray()) {
            if (c == 'L') {
                result.append(getRandomLetter());
            } else if (c == 'N') {
                result.append(getRandomNumber());
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String generateLicensePlate() {
        return generateLicensePlate("LLL-NNN");
    }

    public static void main(String[] args) {
        System.out.println("Placa (formato por defecto): " + generateLicensePlate());
        System.out.println("Placa (formato personalizado): " + generateLicensePlate("LL-NNNN"));
    }
}
