package org.hibernate.tutorial.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Artikel implements Serializable {
	private Long id = -1L;
	private String bezeichnung;
	private String nummer;
	List<Preis> preise = new ArrayList<Preis>(10);
	Set<ArtikelArtikel> childArtikel = new HashSet<ArtikelArtikel>(5);

	public Artikel() {
		super();
	}
	public Artikel(String bezeichnung, String nummer) {
		super();
		this.bezeichnung = bezeichnung;
		this.nummer = nummer;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	/**
	 * @return the nummer
	 */
	public String getNummer() {
		return nummer;
	}
	/**
	 * @param nummer the nummer to set
	 */
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	/**
	 * @return the preise
	 */
	public List<Preis> getPreise() {
		return preise;
	}
	/**
	 * @param preise the preise to set
	 */
	public void setPreise(List<Preis> preise) {
		this.preise = preise;
	}

	/**
	 * @return the childArtikel
	 */
	public Set<ArtikelArtikel> getChildArtikel() {
		return childArtikel;
	}
	/**
	 * @param childArtikel the childArtikel to set
	 */
	public void setChildArtikel(Set<ArtikelArtikel> childArtikel) {
		this.childArtikel = childArtikel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Artikel [id=").append(id).append(", bezeichnung=")
				.append(bezeichnung).append(", nummer=").append(nummer)
				.append("]");
		return builder.toString();
	}
}
