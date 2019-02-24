package betterandbetter.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(unique=true, nullable=false)
	private String email;
	private Integer level;
	private Integer rank;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ROLE", 
    	joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")}, 
    	inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private Set<Role> roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
