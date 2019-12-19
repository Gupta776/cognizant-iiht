package com.cognizant.companyservice.model;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="company")
public class Company {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cp_id")
	private int id;
	
	@NotNull
	@Column(name="cp_code")
	private Long companyCode;
	
	@NotNull
	@Column(name="cp_name")
	private String name;
	
	@NotNull
	@Column(name="cp_turnover")
	private Long turnover;
	
	@NotNull
	@Column(name="cp_ceo")
	private String ceo;
	@NotNull
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "bm_cp_id")
	private List<BoardOfDirectors> boardOfDirectorsList;
	@NotNull
	@Column(name="cp_listed")
	private boolean listed;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="cp_se_id")
	private Sector sector;
	
	@NotNull
	@Column(name="cp_brief")
	private String aboutCompany;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "company_stock",
			joinColumns = @JoinColumn(name = "cs_cp_id"),
			inverseJoinColumns = @JoinColumn(name="cs_ex_id"))
	private List<StockExchange> stockExchanges;
	
	
	
	public Company() {super();}

	

	public Company(@NotNull int id, @NotNull Long companyCode, @NotNull String name, @NotNull Long turnover,
			@NotNull String ceo, @NotNull boolean listed, @NotNull Sector sector, @NotNull String aboutCompany,
			@NotNull List<BoardOfDirectors> boardOfDirectorsList) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.listed = listed;
		this.sector = sector;
		this.aboutCompany = aboutCompany;
		this.boardOfDirectorsList = boardOfDirectorsList;
	}



	public Company(@NotNull int id, @NotNull Long companyCode, @NotNull String name, @NotNull Long turnover,
			@NotNull String ceo, @NotNull List<BoardOfDirectors> boardOfDirectorsList, @NotNull boolean listed,
			@NotNull Sector sector, @NotNull String aboutCompany, List<StockExchange> stockExchangeList) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectorsList = boardOfDirectorsList;
		this.listed = listed;
		this.sector = sector;
		this.aboutCompany = aboutCompany;
		this.stockExchanges = stockExchangeList;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	public Long getTurnover() {
		return turnover;
	}

	public void setTurnover(Long turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

//	public String getBoardOfDirectors() {
//		return boardOfDirectors;
//	}
//
//	public void setBoardOfDirectors(String boardOfDirectors) {
//		this.boardOfDirectors = boardOfDirectors;
//	}

	public boolean isListed() {
		return listed;
	}

	public void setListed(boolean listed) {
		this.listed = listed;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	public List<BoardOfDirectors> getBoardOfDirectorsList() {
		return boardOfDirectorsList;
	}

	public void setBoardOfDirectorsList(List<BoardOfDirectors> boardOfDirectorsList) {
		this.boardOfDirectorsList = boardOfDirectorsList;
	}

	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}

	public void setStockExchanges(List<StockExchange> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyCode=" + companyCode + ", name=" + name + ", turnover=" + turnover
				+ ", ceo=" + ceo + ", listed=" + listed + ", sector=" + sector + ", aboutCompany=" + aboutCompany
				+ ", boardOfDirectorsList=" + boardOfDirectorsList + ", stockExchanges=" + stockExchanges + "]";
	}

//	@Override
//	public String toString() {
//		return "Company [id=" + id + ", companyCode=" + companyCode + ", name=" + name + ", turnover=" + turnover
//				+ ", ceo=" + ceo  + ", listed=" + "sector  = "+sector+ listed + ", aboutCompany="
//				+ aboutCompany + "]";
//	} 
	
	
	
	
}
