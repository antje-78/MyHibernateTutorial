package org.hibernate.tutorial.domain;

import java.io.Serializable;
import java.util.Date;

public class ArtikelArtikelPreis implements Serializable {
	private Long id = -1L;
	private Long preis;
	private Date gueltigAb;
	private ArtikelArtikel artikelArtikel;

	public ArtikelArtikelPreis() {
		super();
	}

	public ArtikelArtikelPreis(Long preis, Date gueltigAb) {
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
	 * @return the artikelArtikel
	 */
	public ArtikelArtikel getArtikelArtikel() {
		return artikelArtikel;
	}

	/**
	 * @param artikelArtikel the artikelArtikel to set
	 */
	public void setArtikelArtikel(ArtikelArtikel artikelArtikel) {
		this.artikelArtikel = artikelArtikel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((artikelArtikel == null) ? 0 : artikelArtikel.hashCode());
		result = prime * result
				+ ((gueltigAb == null) ? 0 : gueltigAb.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtikelArtikelPreis other = (ArtikelArtikelPreis) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (artikelArtikel == null) {
			if (other.artikelArtikel != null)
				return false;
		} else if (!artikelArtikel.equals(other.artikelArtikel))
			return false;
		if (gueltigAb == null) {
			if (other.gueltigAb != null)
				return false;
		} else if (!gueltigAb.equals(other.gueltigAb))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Preis [id=").append(id).append(", preis=")
				.append(preis).append(", gueltigAb=").append(gueltigAb)
				.append(", artikel=").append(artikelArtikel).append("]");
		return builder.toString();
	}


}
