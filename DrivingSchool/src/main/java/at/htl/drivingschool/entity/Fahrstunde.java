package at.htl.drivingschool.entity;


import javax.persistence.*;

@Entity
@Table(name="FAHRSTUNDE")
@NamedQueries(
        @NamedQuery(
                name = "Fahrstunde.findAll",
                query = "select f from Fahrstunde f"
        )
)
public class Fahrstunde {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    private int amount;

    public Fahrstunde() {

    }

    public Fahrstunde(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName () {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s", id, name, amount);
    }
}
