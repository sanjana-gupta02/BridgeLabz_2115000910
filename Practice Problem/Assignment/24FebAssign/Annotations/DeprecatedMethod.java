class LegacyAPI{
    @Deprecated(since ="1.8", forRemoval = true)
    void oldFeature(){
        System.out.println("Its an old feature");
    }
    void newFeature(){
        System.out.println("Its an new feature");
    }
}

public class DeprecatedMethod {
    public static void main(String[] args){
        LegacyAPI obj = new LegacyAPI();
        obj.oldFeature();
        obj.newFeature();

    }
}
