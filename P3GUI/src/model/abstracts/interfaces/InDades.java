package model.abstracts.interfaces;

import java.util.ArrayList;

import model.Article;
import model.abstracts.Client;
import model.abstracts.Comanda;
import vista.MercatException;

/**
 *
 * @author dortiz
 */
public interface InDades {

    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException;

    public ArrayList<Article> recuperaArticles();

    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException;

    public ArrayList<Client> recuperaClients();

    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException;

    public void esborrarComanda(int position) throws MercatException;

    public ArrayList<Comanda> recuperaComandes();

    public ArrayList<Comanda> recuperaComandesUrgents();
}
