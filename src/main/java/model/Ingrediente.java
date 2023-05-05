package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente")
    private Long id;

    @Column(name = "nome_ingrediente", nullable = false)
    private String nomeIngrediente;

    @ManyToMany(mappedBy = "ingredientes")
    private Set<Pizza> pizzas = new HashSet<>();

    public Ingrediente() {
    }

    public Ingrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Set<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeIngrediente, that.nomeIngrediente) && Objects.equals(pizzas, that.pizzas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeIngrediente);
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                " nomeIngrediente: " + nomeIngrediente + "\n";
    }
}
