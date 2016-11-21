package ua.com.e2k;

import javax.persistence.*;

/**
 * Created by User on 16.11.2016.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(
                name="findAllFrom",
                query="SELECT menu FROM Menu menu WHERE menu.price > :from"
        ),
        @NamedQuery(
                name="findAllTo",
                query="SELECT menu FROM Menu menu WHERE menu.price < :to"
        ),
        @NamedQuery(
                name="findAllFromTo",
                query="SELECT menu FROM Menu menu WHERE menu.price BETWEEN :from AND :to"
        ),
        @NamedQuery(
                name="findAllDiscount",
                query="SELECT menu FROM Menu menu WHERE menu.discount = :discount"
        ),




})




public class Menu {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    private int weight;
    private boolean discount;

    public Menu() {
    }



    public Menu(String name, int price, int weight, boolean discount) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", discount=" + discount +
                '}';
    }
}
