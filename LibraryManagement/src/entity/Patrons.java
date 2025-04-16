package entity;

public class Patrons {
    private int id;
    private String name;

    public Patrons(String name) {
        this.name = name;
    }

    public Patrons(int id,String name){
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public int getId(){return id;}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
