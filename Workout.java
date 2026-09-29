// Carter Beasley | Assignment 5 | Workout.java

public class Workout extends TrainingSessions 
{
    // Attributes
    protected String workout;
    protected double miles;

    // Constructor
    public Workout(String startTime, String date, String workout, double miles) 
    {
        super(startTime, date);
        this.workout = workout;
        this.miles = miles;
    }

    // Getters and Setters
    public String getWorkout() 
    {
        return workout;
    }

    public void setWorkout(String workout) 
    {
        this.workout = workout;
    }

    public double getMiles()
    {
        return miles;
    }

    public void setMiles(double miles)
    {
        this.miles = miles;
    }

    @Override
    public String toString() 
    {
        return super.toString() + ", Type: Workout, Workout: " + workout + ", Miles: " + miles;
    }
}