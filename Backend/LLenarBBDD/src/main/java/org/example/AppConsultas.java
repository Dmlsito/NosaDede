package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AppConsultas {

    public static void main(String[] args) {

        List<Pelicula> peliculas = consultarPeliculas();
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public static List<Pelicula> consultarPeliculas() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select distinct p from Pelicula p left join fetch p.generosPeliculas gp left join fetch gp.genero g order by p.id");
        List<Pelicula> peliculas = query.getResultList();
        tx.commit();
        session.close();
        return peliculas;
    }
}
