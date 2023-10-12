package com.projetOpticien.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_vente")
public class Vente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Include
	private Long id;
	
	private Double remiseVente;
	private Double totaleVente;
	private String numFicheManuelle;
	

	@ManyToOne
	@JsonIgnore
	private Client client;
	
	
	@ManyToMany
    private Collection<Verre> verres;
	
	
	@ManyToMany
    private Collection<Cadre> cadres;
	
	@ManyToMany
    private Collection<PointVente> pointsVentes;
	
	
	@OneToMany(mappedBy="vente")
	private List<Visite> visites;
	
	

}
