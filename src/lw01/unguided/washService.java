public abstract class washService implements Billable {
    private final String id;
    private final int days;

    public washService(String id, int days){
        if (days <= 0) {
            throw new IllegalArgumentException("");
        }
        this.id = id;
        this.days = days;

    }
       public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if (units <= 0 && units >= 10) {
            throw new IllegalArgumentException("copies must be positive");
        }
        return units * calculateCharge();
    }

    public String label(){
        return "Service";

    }
   public final String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }


    
}
