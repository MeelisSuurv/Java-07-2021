package ee.mihkel;


//extends = inheritance
public class Reptile extends Animal implements ProjectObject {
    private int familyCount;
    private static int breedCount;
    private String originCountry;

    //short  32,767
    //int 2147483647

    public Reptile(int age, String name, String originCountry) {
        super(10000, age, name);
        this.originCountry = originCountry;
        this.familyCount = 1;
        breedCount = 1;
        //this.familyCount = Integer.MAX_VALUE;
        //suurendades max väärtust teeb ringi peale

    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public int getFamilyCount() {
        return familyCount;
    }

    public void increaseFamilyCount() {
        this.familyCount++;
    }

    public static int getBreedCount() {
        return breedCount;
    }

    public static void increaseBreedCount() {
        Reptile.breedCount++;
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "originCountry='" + originCountry + '\'' +
                '}';
    }
}
