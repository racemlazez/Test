package com.projetOpticien.model;

import java.io.Serializable;
import java.time.LocalDate;
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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "t_client")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Include
	private Long id;
	
	private String reference;
	private String cin;
	private String nomPrenom;
	private LocalDate dateNaissance;
	private int age;
	private String email;
	private String adresse;
	private String ville;
	private String pays;
	private String numAssureSocial;
	private String numTel1;
	private String numTel2;
	private Double chiffreAffaire;
	private Double solde;
	private String observations;
	private String matriculeFiscal;
	
	
	@OneToMany(mappedBy="client")
	private List<Vente> ventes;
	
	@ManyToMany
    private Collection<PointVente> pointsVentes;
	
	@ManyToOne
	@JsonIgnore
	private Organisme organisme;
	
	@ManyToOne
	@JsonIgnore
	private Groupe_fam groupe;

}
