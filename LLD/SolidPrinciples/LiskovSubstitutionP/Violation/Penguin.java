package LLD.SolidPrinciples.LiskovSubstitutionP.Violation;

public class Penguin extends Bird{

    @Override
    void  fly()
    {
        //cannot fly so will throw error
    }
}
