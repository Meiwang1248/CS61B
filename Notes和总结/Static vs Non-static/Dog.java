public class Dog {
    //static variable and static method should be accessed using a class, not an instance, though it can
    //be accessed using an instance, but we should try to avoid that.
    //non-static variable and method can only be accessed with an instance.
    public int weightInPounds;
    //static variable that all objects share
    public static String binomen = "Canis Familiaris";

    //constructor method
    public Dog(int w){
        weightInPounds = w;
    }
    //make a noise method
    public void makeNoise(){
        if (weightInPounds < 10){
            System.out.println("yip!");
        } else if (weightInPounds <30) {
            System.out.println("bark!");
        } else {
            System.out.println("woooof!");
        }
    }
    //static method enables Dog to do the judging
    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        } else {
            return d2;
        }
    }
    public Dog maxDog(Dog d2) {
        if (this.weightInPounds > d2.weightInPounds) {
            return this;
        } else {
            return d2;
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog(15);
        Dog d2 = new Dog(100);
        //These two lines of code will return the same result, where the judge is Dog in the first line
        // and the judge is d in the second line
        Dog bigger = Dog.maxDog(d,d2);
        Dog bigger2 = d.maxDog(d2);
        bigger.makeNoise();
        bigger2.makeNoise();

        //try out static variable, but the next two lines are not very good, because a class name should be used
        //when accessing a static variable
        System.out.println(d.binomen);
        System.out.println(d2.binomen);
        // Use class name! What is the scientific name of all dogs, not just a specific dog.
        System.out.println(Dog.binomen);

    }
}
