package br.com.crudapi;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Users")
@Table(name="tb_users")
@CrudApi(id="crud1")
public class CrudTest implements Serializable {
	/**
	 * 
	 */
	@CAIgnore
	private static final long serialVersionUID = 1620579860667529599L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.TABLE)
	@CrudPk
	private Long id;
	
	@CrudListColumn(friendlyName="nome")
	private String nome;
	
	@CrudListColumn(friendlyName="endereco")
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}