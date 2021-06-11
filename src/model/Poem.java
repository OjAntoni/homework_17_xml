package model;

public class Poem {
    private static String lastname;
    private static String firstname;
    private static String yearOfBirth;
    private static String yearOfDeath;
    private static String title;
    private static String nationality;
    private static StringBuilder poem = new StringBuilder();

    public static String getLastname() {
        return lastname;
    }

    public static void setLastname(String lastname) {
        Poem.lastname = lastname;
    }

    public static String getFirstname() {
        return firstname;
    }

    public static void setFirstname(String firstname) {
        Poem.firstname = firstname;
    }

    public static String getYearOfBirth() {
        return yearOfBirth;
    }

    public static void setYearOfBirth(String yearOfBirth) {
        Poem.yearOfBirth = yearOfBirth;
    }

    public static String getYearOfDeath() {
        return yearOfDeath;
    }

    public static void setYearOfDeath(String yearOfDeath) {
        Poem.yearOfDeath = yearOfDeath;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Poem.title = title;
    }

    public static String getNationality() {
        return nationality;
    }

    public static void setNationality(String nationality) {
        Poem.nationality = nationality;
    }

    public static StringBuilder getPoem() {
        return poem;
    }

    public static void addToPoem(String line) {
        Poem.poem.append(line);
    }

    @Override
    public String toString() {
        return title+" "+yearOfDeath + " " + yearOfBirth + " " + firstname;
    }
}
