package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        HashSet<String> generos = llenarPeliculas();

    }

    private static HashSet<String> llenarPeliculas() throws IOException {

        HashSet<String> generos = new HashSet<String>();

        String[] enlacesPeliculas = {
                "https://es.wikipedia.org/wiki/El_padrino_(película)",
                "https://es.wikipedia.org/wiki/Ciudadano_Kane",
                "https://es.wikipedia.org/wiki/Forrest_Gump_(película)",
                "https://es.wikipedia.org/wiki/Titanic_(película_de_1997)",
                "https://es.wikipedia.org/wiki/El_señor_de_los_anillos:_La_comunidad_del_anillo",
                "https://es.wikipedia.org/wiki/La_La_Land_(película)",
                "https://es.wikipedia.org/wiki/El_rey_león",
                "https://es.wikipedia.org/wiki/Terminator_2:_El_juicio_final",
                "https://es.wikipedia.org/wiki/El_gran_dictador",
                "https://es.wikipedia.org/wiki/Psicosis_(película)",
                "https://es.wikipedia.org/wiki/Regreso_al_futuro",
                "https://es.wikipedia.org/wiki/El_mago_de_Oz_(película)",
                "https://es.wikipedia.org/wiki/La_lista_de_Schindler",
                "https://es.wikipedia.org/wiki/Indiana_Jones_y_los_cazadores_del_arca_perdida",
                "https://es.wikipedia.org/wiki/El_show_de_Truman",
                "https://es.wikipedia.org/wiki/El_club_de_la_pelea",
                "https://es.wikipedia.org/wiki/El_caballero_de_la_noche",
                "https://es.wikipedia.org/wiki/The_Matrix",
                "https://es.wikipedia.org/wiki/Los_siete_samuráis",
                "https://es.wikipedia.org/wiki/Apocalypse_Now",
                "https://es.wikipedia.org/wiki/Blade_Runner",
                "https://es.wikipedia.org/wiki/Rocky_(película)",
                "https://es.wikipedia.org/wiki/El_resplandor_(película)",
                "https://es.wikipedia.org/wiki/E.T._el_extraterrestre",
                "https://es.wikipedia.org/wiki/La_Bella_y_la_Bestia_(película_de_1991)",
                "https://es.wikipedia.org/wiki/Taxi_Driver",
                "https://es.wikipedia.org/wiki/El_apartamento",
                "https://es.wikipedia.org/wiki/The_Silence_of_the_Lambs_(película)",
                "https://es.wikipedia.org/wiki/Star_Wars:_Episodio_IV_-_Una_nueva_esperanza",
                "https://es.wikipedia.org/wiki/Pulp_Fiction",
                "https://es.wikipedia.org/wiki/El_quinto_elemento",
                "https://es.wikipedia.org/wiki/Los_intocables_de_Eliot_Ness",
                "https://es.wikipedia.org/wiki/El_gran_Lebowski",
                "https://es.wikipedia.org/wiki/La_vida_es_bella",
                "https://es.wikipedia.org/wiki/La_naranja_mecánica_(película)",
                "https://es.wikipedia.org/wiki/El_exorcista_(película)",
                "https://es.wikipedia.org/wiki/La_sirenita_(película_de_1989)"};
        Document doc = null;

        try {

            for (int i = 0; i < enlacesPeliculas.length; i++) {
                doc = Jsoup.connect(enlacesPeliculas[i]).get();

                String tituloPelicula = doc.select("h1.firstHeading").text();
                Element imagenPelicula = doc.select("table.infobox img[src~=(?i)\\.(png|jpe?g|gif)]").first();
                String urlImagenPelicula = null;
                if (imagenPelicula != null) {
                    urlImagenPelicula = imagenPelicula.absUrl("src");
                }
                Element argumentoPeliculaElement = doc.getElementById("Argumento");
                String argumentoPelicula = null;
                if (argumentoPeliculaElement != null) {
                    if (argumentoPeliculaElement.parent().nextElementSibling().text().equals("")) {
                        argumentoPelicula = argumentoPeliculaElement.parent().nextElementSibling().select("p").text();
                    } else {
                        argumentoPelicula = argumentoPeliculaElement.parent().nextElementSibling().text();
                    }
                } else if (doc.getElementById("Sinopsis") != null) {
                    argumentoPeliculaElement = doc.getElementById("Sinopsis");
                    if (argumentoPeliculaElement.parent().nextElementSibling().text().equals("")) {
                        argumentoPelicula = argumentoPeliculaElement.parent().nextElementSibling().select("p").text();
                    } else {
                        argumentoPelicula = argumentoPeliculaElement.parent().nextElementSibling().text();
                    }
                } else if (doc.getElementById("Historia") != null) {
                    argumentoPeliculaElement = doc.getElementById("Historia");
                    if (argumentoPeliculaElement.parent().nextElementSibling().text().equals("")) {
                        argumentoPelicula = argumentoPeliculaElement.parent().nextElementSibling().select("p").text();
                    } else {
                        argumentoPelicula = argumentoPeliculaElement.parent().nextElementSibling().text();
                    }
                } else if (doc.getElementById("Trama") != null) {
                    argumentoPeliculaElement = doc.getElementById("Trama");
                    if (argumentoPeliculaElement.parent().nextElementSibling().text().equals("")) {
                        argumentoPelicula = argumentoPeliculaElement.parent().nextElementSibling().select("p").text();
                    } else {
                        argumentoPelicula = argumentoPeliculaElement.parent().nextElementSibling().text();
                    }
                } else {
                    argumentoPelicula = "No hay argumento";
                }
                String duracionPelicula = doc.select("table.infobox tbody tr th:contains(Duración) + td").text();
                List<Genero> generosTemp = new ArrayList<Genero>();
                for (Element genero : doc.select("table.infobox tbody tr th:contains(Género) + td a")) {
                    Genero generoP = new Genero();
                    generoP.setNombre(genero.text());
                    if (consultarGeneroPorNombre(generoP.getNombre()) == null) {

                        insertarGeneros(generoP);

                    } else{
                        generoP = consultarGeneroPorNombre(genero.text());
                    }
                    generos.add(genero.text());
                    generosTemp.add(generoP);
                }

                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(tituloPelicula);
                if (duracionPelicula.length() < 29) {
                    pelicula.setDuracion(duracionPelicula);
                } else {
                    pelicula.setDuracion(duracionPelicula.substring(0, 29));
                }
                pelicula.setImagenPelicula(urlImagenPelicula);
                if (argumentoPelicula.length() < 999) {
                    pelicula.setResumen(argumentoPelicula);
                } else {
                    pelicula.setResumen(argumentoPelicula.substring(0, 999));
                }
                pelicula.setValoracion(new Random().nextInt(10));

                insertarPeliculas(pelicula);
                for (Genero genero : generosTemp) {
                    GenerosPeliculas generosPeliculas = new GenerosPeliculas();
                    generosPeliculas.setIdPelicula(pelicula.getId());
                    generosPeliculas.setIdGenero(genero.getId());
                    insertenGenerosPeliculas(generosPeliculas);
                }
            }

            for (String genero : generos) {
                System.out.println(genero);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return generos;
    }

    public static void insertarPeliculas(Pelicula pelicula) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(pelicula);
        tx.commit();
        session.close();
    }

    public static void insertarGeneros(Genero genero) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(genero);
        tx.commit();
        session.close();
    }

    public static void insertenGenerosPeliculas(GenerosPeliculas generosPeliculas) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(generosPeliculas);
        tx.commit();
        session.close();
    }

    public static Genero consultarGeneroPorNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Genero where nombre = :nombre");
        query.setParameter("nombre", nombre);
        Genero genero = null;
        if (!query.getResultList().isEmpty()) {
            genero = (Genero) query.getSingleResult();
        }
        tx.commit();
        session.close();
        return genero;
    }

}
