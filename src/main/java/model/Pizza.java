package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza")
    private Long id;

    @Column(name = "nome_pizza", nullable = false)
    private String nomePizza;

    @ManyToMany
    @JoinTable(name = "pizza_ingrediente",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private Set<Ingrediente> ingredientes = new HashSet<>();

    public Pizza() {
    }

    public Pizza(String nomePizza, Set<Ingrediente> ingredientes) {
        this.nomePizza = nomePizza;
        this.ingredientes = ingredientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePizza() {
        return nomePizza;
    }

    public void setNomePizza(String nomePizza) {
        this.nomePizza = nomePizza;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id) && Objects.equals(nomePizza, pizza.nomePizza) && Objects.equals(ingredientes, pizza.ingredientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomePizza, ingredientes);
    }

    @Override
    public String toString() {
        return "\n\nid: " + id +
                "\nnomePizza='" + nomePizza +
                "\ningredientes: \n" + ingredientes;
    }
}
