package aplicacao;

import model.Ingrediente;
import model.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Pizza pizza1 = new Pizza();
        pizza1.setNomePizza("Pizza Margherita");
        Pizza pizza2 = new Pizza();
        pizza2.setNomePizza("Pizza Quatro Queijos");

        Ingrediente ingrediente1 = new Ingrediente("Molho de Tomate");
        Ingrediente ingrediente2 = new Ingrediente("Mussarela");
        Ingrediente ingrediente3 = new Ingrediente("Manjericão");
        Ingrediente ingrediente4 = new Ingrediente("Azeite de Oliva");
        Ingrediente ingrediente5 = new Ingrediente("Parmesão");
        Ingrediente ingrediente6 = new Ingrediente("Gorgonzola");

        pizza1.getIngredientes().add(ingrediente1);
        pizza1.getIngredientes().add(ingrediente2);
        pizza1.getIngredientes().add(ingrediente3);
        pizza1.getIngredientes().add(ingrediente4);

        pizza2.getIngredientes().add(ingrediente1);
        pizza2.getIngredientes().add(ingrediente2);
        pizza2.getIngredientes().add(ingrediente5);
        pizza2.getIngredientes().add(ingrediente6);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizza");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        em.persist(ingrediente1);
//        em.persist(ingrediente2);
//        em.persist(ingrediente3);
//        em.persist(ingrediente4);
//        em.persist(ingrediente5);
//        em.persist(ingrediente6);
//
//        em.persist(pizza1);
//        em.persist(pizza2);

//        List<Pizza> pizzas = em.createQuery("SELECT v FROM Pizza v").getResultList();
//        pizzas.forEach(System.out::println);

        Pizza pizza = em.find(Pizza.class, 1L);
        System.out.println(pizza);

        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
