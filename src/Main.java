package src;

public class Main {
    public static void main(String[] args) {

        MyLinkedSet<RailCar> set = new MyLinkedSet<>();

        set.add(new RailCar("R1",3){
            public int getPassengers(){return 40;}
            public int getLuggage(){return 0;}
        });

        set.add(new RailCar("R2",2){
            public int getPassengers(){return 0;}
            public int getLuggage(){return 500;}
        });

        System.out.println("Size: "+set.size());
        for(RailCar r: set){
            System.out.println(r);
        }
    }
}
