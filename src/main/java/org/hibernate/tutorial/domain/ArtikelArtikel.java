package org.hibernate.tutorial.domain;

import java.util.HashSet;
import java.util.Set;

public class ArtikelArtikel {
	private Long id = -1L;
	private Artikel parentArtikel;
	private Artikel childArtikel;
	private Set<ArtikelArtikelPreis> preise = new HashSet<ArtikelArtikelPreis>(10);

	public ArtikelArtikel() {
		super();
	}
	public ArtikelArtikel(Artikel parentArtikel, Artikel childArtikel) {
		super();
		this.parentArtikel = parentArtikel;
		this.childArtikel = childArtikel;
	}

	public ArtikelArtikel(Artikel parentArtikel, Artikel childArtikel,
			Set<ArtikelArtikelPreis> preise) {
		super();
		this.parentArtikel = parentArtikel;
		this.childArtikel = childArtikel;
		this.preise = preise;
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
	 * @return the parentArtikel
	 */
	public Artikel getParentArtikel() {
		return parentArtikel;
	}
	/**
	 * @param parentArtikel the parentArtikel to set
	 */
	public void setParentArtikel(Artikel parentArtikel) {
		this.parentArtikel = parentArtikel;
	}
	/**
	 * @return the childArtikel
	 */
	public Artikel getChildArtikel() {
		return childArtikel;
	}
	/**
	 * @param childArtikel the childArtikel to set
	 */
	public void setChildArtikel(Artikel childArtikel) {
		this.childArtikel = childArtikel;
	}
	/**
	 * @return the preise
	 */
	public Set<ArtikelArtikelPreis> getPreise() {
		return preise;
	}
	/**
	 * @param preise the preise to set
	 */
	public void setPreise(Set<ArtikelArtikelPreis> preise) {
		this.preise = preise;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((childArtikel == null) ? 0 : childArtikel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((parentArtikel == null) ? 0 : parentArtikel.hashCode());
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
		ArtikelArtikel other = (ArtikelArtikel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (childArtikel == null) {
			if (other.childArtikel != null)
				return false;
		} else if (!childArtikel.equals(other.childArtikel))
			return false;
		if (parentArtikel == null) {
			if (other.parentArtikel != null)
				return false;
		} else if (!parentArtikel.equals(other.parentArtikel))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArtikelArtikel [id=").append(id)
				.append(", parentArtikel=").append(parentArtikel)
				.append(", childArtikel=").append(childArtikel).append("]");
		return builder.toString();
	}
}
