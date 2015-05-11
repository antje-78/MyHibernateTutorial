package org.hibernate.tutorial.web;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.tutorial.domain.Artikel;
import org.hibernate.tutorial.domain.ArtikelArtikel;
import org.hibernate.tutorial.domain.ArtikelArtikelPreis;
import org.hibernate.tutorial.domain.Preis;
import org.hibernate.tutorial.util.HibernateUtil;

import com.google.common.collect.Lists;

public class ArtikelManager {
	private static final Logger LOG = Logger.getLogger(ArtikelManager.class);

	public static void main(String[] args) {
		ArtikelManager mgr = new ArtikelManager();

		mgr.deleteAllArtikels();
		Calendar calendar = Calendar.getInstance(Locale.GERMANY);
		Calendar calendar2 = Calendar.getInstance(Locale.GERMANY);
		calendar2.add(Calendar.MONTH, 1);
		Artikel artikel1 = mgr.createAndStoreArtikel("Artikel 1", "0002", Lists.newArrayList(new Preis(1000L, calendar.getTime()), new Preis(1500L, calendar2.getTime())));
		Artikel artikel2 = mgr.createAndStoreArtikel("Artikel 2", "0003", Lists.newArrayList(new Preis(100L, calendar.getTime()), new Preis(150L, calendar2.getTime())));
		Artikel parentArtikel = mgr.createAndStoreArtikel("Verbund 1", "0001", Lists.<Preis>newArrayList(), Lists.newArrayList(artikel1, artikel2));

		List<Artikel> artikelList = mgr.listArtikels();
		for (int i = 0; i < artikelList.size(); i++) {
			Artikel artikel = artikelList.get(i);
			LOG.info("Artikel: " + artikel.toString());
			List<Preis> preise = artikel.getPreise();
			for (Preis preis : preise) {
				LOG.info("\tPreis: " + preis.toString());
			}
			Set<ArtikelArtikel> childArtikelList = artikel.getChildArtikel();
			for (ArtikelArtikel childArtikel : childArtikelList) {
				LOG.info("\tChild-Artikel:" + childArtikel);
				Set<ArtikelArtikelPreis> childArtikelPreise = childArtikel.getPreise();
				for (ArtikelArtikelPreis artikelArtikelPreis : childArtikelPreise) {
					LOG.info("\t\tPreis: " + artikelArtikelPreis.toString());
				}
			}
		}

		mgr.deleteArtikel(parentArtikel.getId());

		HibernateUtil.getSessionFactory().close();
	}

	private void deleteAllArtikels() {
		List<Artikel> artikels = this.listArtikels();
		for (Artikel artikel : artikels) {
			deleteArtikel(artikel.getId());
		}
	}

	private void deleteArtikel(Long artikelId) {
		LOG.info("Lösche Artikel: " + artikelId);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Artikel artikel2 = (Artikel) session.load(Artikel.class, artikelId);
//		artikel2.getPreise().clear();
//		Set<ArtikelArtikel> childArtikel = artikel2.getChildArtikel();
//		for (Iterator<ArtikelArtikel> iterator = childArtikel.iterator(); iterator.hasNext();) {
//			ArtikelArtikel artikelArtikel = iterator.next();
//			artikelArtikel.getPreise().clear();
//			iterator.remove();
//		}
//		session.saveOrUpdate(artikel2);
		session.delete(artikel2);
		session.getTransaction().commit();
	}

	protected Artikel createAndStoreArtikel(String bezeichnung, String nummer, List<Preis> preise) {
		return this.createAndStoreArtikel(bezeichnung, nummer, preise, Collections.<Artikel>emptyList());
	}

	protected Artikel createAndStoreArtikel(String bezeichnung, String nummer, List<Preis> preise, List<Artikel> childArtikelList) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Artikel artikel = new Artikel(bezeichnung, nummer);
		for (Preis preis : preise) {
			preis.setArtikel(artikel);
			artikel.getPreise().add(preis);
		}
		for (Artikel childArtikel : childArtikelList) {
			List<Preis> preise2 = childArtikel.getPreise();
			Set<ArtikelArtikelPreis> aapreise = new HashSet<ArtikelArtikelPreis>(preise2.size());
			for (Preis preis : preise2) {
				aapreise.add(new ArtikelArtikelPreis(preis.getPreis(), preis.getGueltigAb()));
			}
			ArtikelArtikel artikelArtikel = new ArtikelArtikel(artikel, childArtikel, aapreise);
			artikel.getChildArtikel().add(artikelArtikel);
		}

		session.save(artikel);

		session.getTransaction().commit();

		return artikel;
	}


	protected List<Artikel> listArtikels() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Artikel> result = session.createQuery("from Artikel").list();
		for (Artikel artikel : result) {
			artikel.getPreise().size();
			Set<ArtikelArtikel> childArtikel = artikel.getChildArtikel();
			for (ArtikelArtikel artikelArtikel : childArtikel) {
				artikelArtikel.getPreise().size();
			}
		}
		session.getTransaction().commit();

		return result;
	}

}
