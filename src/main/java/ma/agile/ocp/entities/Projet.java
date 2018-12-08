package ma.agile.ocp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Le nom du projet doit être renseigner")
	private String nom;
	@NotBlank(message = "La reference projet doit être renseigner")
	@Size(min=4, max=5, message = "Svp utiliser 4 ou 5 caracteres")
	@Column(updatable = false, unique = true)
	private String reference;
	@NotBlank(message = "Merci de faire une breve description")
	private String description;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date dateDebut;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date dateFin;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date createdAt;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updatedAt;
	
	public Projet() {
	}
	
	@PrePersist
	public void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate(){
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
