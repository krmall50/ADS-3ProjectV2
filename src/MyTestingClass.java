public class MyTestingClass {
    private int id;
    public MyTestingClass(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    @Override
    public int hashCode() {
        return id % 11;
    }

}
