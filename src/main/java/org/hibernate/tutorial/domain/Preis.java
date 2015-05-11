package org.hibernate.tutorial.domain;

import java.io.Serializable;
import java.util.Date;

public class Preis implements Serializable {
	private Long id = -1L;
	private Long preis;
	private Date gueltigAb;
	private Artikel artikel;

	public Preis() {
		super();
	}

	public Preis(Long preis, Date gueltigAb) {
		super();
		this.preis = preis;
		this.gueltigAb = gueltigAb;
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
	 * @return the preis
	 */
	public Long getPreis() {
		return preis;
	}

	/**
	 * @param preis the preis to set
	 */
	public void setPreis(Long preis) {
		this.preis = preis;
	}

	/**
	 * @return the gueltigAb
	 */
	public Date getGueltigAb() {
		return gueltigAb;
	}

	/**
	 * @param gueltigAb the gueltigAb to set
	 */
	public void setGueltigAb(Date gueltigAb) {
		this.gueltigAb = gueltigAb;
	}

	/**
	 * @return the artikel
	 */
	public Artikel getArtikel() {
		return artikel;
	}

	/**
	 * @param artikel the artikel to set
	 */
	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Preis [id=").append(id).append(", preis=")
				.append(preis).append(", gueltigAb=").append(gueltigAb)
				.append(", artikel=").append(artikel).append("]");
		return builder.toString();
	}


}
