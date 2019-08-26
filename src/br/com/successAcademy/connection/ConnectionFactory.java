package br.com.successAcademy.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("successAcademy");
	public static EntityManagerFactory emf_leitura = Persistence.createEntityManagerFactory("successAcademy_leitura");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static EntityManager getEntityManagerLeitura() {
		return emf_leitura.createEntityManager();
	}
}
