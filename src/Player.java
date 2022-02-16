/**
 * Player.java
 *
 * Player from the most recent test. This class is just to test out the methods
 *
 * @author axu5 <github.com/axu5>
 * @version 16.02.2022
 */
public class Player {
  /**
   * (1) Set instance variables according to UML diagram
   */
  private String name;
  private int age;
  private boolean injured;
  private final int DAYS = 7;
  private int[] nScores;

  /**
   * (3) Write one constructor that initializes the name and age of the player and
   * set
   * the number of scores for all days of the week to zero.
   */
  public Player(String name, int age) {
    this.name = name;
    this.age = age;
    this.nScores = new int[this.DAYS];
  }

  /**
   * (4) Write an accessor that retrieves the information whether the player is
   * injured or not.
   */
  public boolean getInjured() {
    return this.injured;
  }

  /**
   * (6) class needs a setInjured mutator method
   */
  public void setInjured(boolean injured) {
    this.injured = injured;
  }

  /**
   * (5) Write a method setScoreDay() that inputs the value of the score made on a
   * specific day (day is given as an integer)
   */
  public void setScoreDay(int score, int dayIdx) {
    this.nScores[dayIdx % this.DAYS] = score;
  }

  /**
   * (6)
   * 
   * a) Create an object of the class Player with "Garcia" as the name and an age
   * of 25. After that set his weekly scores to the following values: {20, 13, 7,
   * 22, 10, 0, 10}
   * 
   * b) Create an object of the class Player with "Martinez" as the name and an
   * age of 21. He was injured on Wednesday and did not play after that. Add that
   * information and set his weekly scores to the following values: {30, 15, 2, 0,
   * 0, 0, 0}
   */
  public static void main(String _args) {
    var garcia = new Player("Garcia", 25);
    int[] scores = { 30, 13, 7, 22, 10, 0, 10 };
    for (int i = 0; i < scores.length; ++i)
      garcia.setScoreDay(scores[i], i);

    var martinez = new Player("Martinez", 21);
    int[] mScores = { 30, 15, 2 };
    for (int i = 0; i < 7; ++i)
      martinez.setScoreDay(i < mScores.length ? mScores[i] : 0, i);

    martinez.setInjured(true);
  }

  /**
   * (7) Create a method showTotalScores() that returns whether the player is
   * injured or not, if the player is not injured it calculates and displays the
   * total amount of scores made by the player in that week.
   */
  public boolean showTotalScores() {
    if (this.injured)
      return this.injured;

    int total = 0;
    for (int i = 0; i < this.DAYS; ++i)
      total += this.nScores[i];

    System.out.println(this.name + " (" + this.age + ") scored a total of " + total + " point(s)");
    return this.injured;
  }
}