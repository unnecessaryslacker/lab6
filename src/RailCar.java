package src;

public abstract class RailCar {
    protected String id;
    protected int comfort;

    public RailCar(String id,int comfort){
        this.id=id;
        this.comfort=comfort;
    }

    public String getId(){return id;}
    public int getComfort(){return comfort;}

    public abstract int getPassengers();
    public abstract int getLuggage();

    @Override
    public String toString(){
        return getClass().getSimpleName()+"("+id+")";
    }
}
